/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package benchmarking.evaluation;

import benchmarking.SequenceBenchmark;
import benchmarking.SequenceBenchmark.Task;
import benchmarking.SequenceBenchmark.TaskResult;
import core.util.IO;
import core.util.JSON;
import core.util.Msc;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import plotting.Plotter;

/**
 *
 * @author helfrich
 */
public class SequenceBenchmarkSpeedEvaluationCompareFirst {
    public static void main(String[] args) {
//        File benchmark_output = new File(IO.BENCHMARK_FOLDER, "tmp");
        File benchmark_output = new File(IO.BENCHMARK_FOLDER, "20230216_single_sequence_speed");
        
        HashMap<String, ArrayList<File>> compare = new HashMap<>();
        
        File[] listFiles = benchmark_output.listFiles();
        
        for (final File f: listFiles) {
            if (!f.isDirectory()) continue;
            if (!f.getName().contains("Sequence")) continue;
            
            String setting_abr = f.getName().substring(0, 2);
            
            File result_file = new File(f, "result.json");
            if (!result_file.exists()) continue;
            if (!compare.containsKey(setting_abr)) compare.put(setting_abr, new ArrayList<>());
            compare.get(setting_abr).add(f);
        }
        
        XYSeriesCollection dataset = new XYSeriesCollection();
            
        File folder = new File(benchmark_output, "AllSpeed");
        folder.mkdirs();
        
        for (String setting_abr : compare.keySet()) {
            
            System.out.println("");
            System.out.println(setting_abr +": " + compare.get(setting_abr).size() + " folders");
            
            
                
            // get base simulator speed
            File baseFile = null;
            for (File f: compare.get(setting_abr)) {
                if (f.getName().contains("Sequence_SSA")) baseFile = f;
            }
            if (baseFile == null) {
                System.out.println("Didn't find base file for " + setting_abr);
                continue;
            }
            // load json results
            SequenceBenchmark.TaskSequenceResult[] taskSequenceResult_base_repeated = JSON.getGson().fromJson(
                    IO.getContentOfFile(new File(baseFile, "result.json")), 
                    SequenceBenchmark.TaskSequenceResult[].class
            );
            
            // get average computation time for each task with base simulator
            int nr_of_tasks = taskSequenceResult_base_repeated[0].number_of_tasks();
            double[] avg_comp_times_in_s_of_base_simulator = new double[nr_of_tasks];
            for (int task_i = 0; task_i < nr_of_tasks; task_i++) {
                double comp_time_sum_in_s = 0;
                int repeats_in_sum = 0;
                for (int repeat_i = 0; repeat_i < taskSequenceResult_base_repeated.length; repeat_i++) {
                    TaskResult taskResult = taskSequenceResult_base_repeated[repeat_i].without_reset[task_i];
                    if (taskResult != null) {
                        comp_time_sum_in_s += taskResult.getFinalSnapshot().avg_comp_time_in_s();
                        repeats_in_sum++;
                    }
                }
                if (repeats_in_sum > 0) avg_comp_times_in_s_of_base_simulator[task_i] = comp_time_sum_in_s / repeats_in_sum;
            }
            
            System.out.println("average time for base (" + baseFile.getName() + "):" + Arrays.toString(avg_comp_times_in_s_of_base_simulator));
            
            for (File f : compare.get(setting_abr)) {
                
                if (f.getName().equals(baseFile.getName())) continue;
                
                System.out.println("");
                System.out.println(f.getName());
                
                XYSeries series_without_resets = new XYSeries(f.getName());
                
                boolean without_resets_is_not_empty = false;
                
                // load json results
                SequenceBenchmark.TaskSequenceResult[] taskSequenceResult_repeated = JSON.getGson().fromJson(
                        IO.getContentOfFile(new File(f, "result.json")), 
                        SequenceBenchmark.TaskSequenceResult[].class
                );
                
                double speedup = 0;
                
                for (int task_i = 0; task_i < 1; task_i++) {
                    if (taskSequenceResult_repeated[0].without_reset[task_i] == null) break;
                    Task task = taskSequenceResult_repeated[0].without_reset[task_i].task;
                    for (int simulation_i = 0; simulation_i < task.sims; simulation_i++) {
                        double sum = 0;
                        int summed = 0;
                        for (int repeat_i = 0; repeat_i < taskSequenceResult_repeated.length; repeat_i++) {
                            TaskResult taskResult = taskSequenceResult_repeated[repeat_i].without_reset[task_i];
                            if (taskResult == null || simulation_i >= taskResult.getFinalSnapshot().numberOfResults()) continue;
                            sum += taskResult.getFinalSnapshot().avg_comp_time_in_s(simulation_i);
                            summed++;
                        }
                        
                        if (summed > 0) {
                            if (simulation_i % 100 != 0 && !Msc.isPowerOf(simulation_i, 2) && simulation_i != task.sims-1) continue;
                            double average =  sum / summed;
                            speedup = avg_comp_times_in_s_of_base_simulator[task_i] / average;
                            series_without_resets.add(simulation_i + 1, speedup);
                            without_resets_is_not_empty = true;
                        }
                    }
                }
                if (without_resets_is_not_empty) dataset.addSeries(series_without_resets);
                System.out.println("final speedup for " + f.getName() + ": " + IO.significantFigures(speedup));
                
            }
        }
            
        JFreeChart chart = ChartFactory.createXYLineChart("comp. time",
                "#sims", "speedup", dataset);

        Plotter.betterColors(chart);
        Plotter.saveAsPNG(chart, new File(folder, "comparison.png"));
    }
}
