package gui.simulator;

import benchmarking.simulatorconfiguration.ODEConfig;
import java.awt.Desktop;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author Martin
 */
public class ODESimulatorPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form HybridSimulatorPanel
     * @param initial
     */
    public ODESimulatorPanel(ODEConfig initial) {
        initComponents();
        
        setODEConfig(initial);
    }
    
    public final void setODEConfig(ODEConfig conf) {
        texfieldMinStep.setText(conf.getMinStep() + "");
        texfieldMaxStep.setText(conf.getMaxStep() + "");
        texfieldAbsTolerance.setText(conf.getScalAbsoluteTolerance() + "");
        texfieldRelTolerance.setText(conf.getScalRelativeTolerance() + "");
    }
    
    public ODEConfig getODEConfig() {
        return new ODEConfig()
                .setMinStep(Double.parseDouble(texfieldMinStep.getText()))
                .setMaxStep(Double.parseDouble(texfieldMaxStep.getText()))
                .setScalAbsoluteTolerance(Double.parseDouble(texfieldAbsTolerance.getText()))
                .setScalRelativeTolerance(Double.parseDouble(texfieldRelTolerance.getText()));
    }
    
    private void changeValue(javax.swing.JTextField t) {
        String input = JOptionPane.showInputDialog(this, "Enter the new value:", t.getText());
        if (input != null) {
            try {
                double d = Double.parseDouble(input);
                if (d <= 0) d = 1.0E-20;
                if (d == Double.NaN) d = 1;
                if (d == Double.POSITIVE_INFINITY) d = 1.0E20;
                t.setText("" + d);
                System.out.println("" + d);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Could not parse double value '" + input + "'.");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labeltMinStep = new javax.swing.JLabel();
        buttonHelp = new javax.swing.JButton();
        texfieldMinStep = new javax.swing.JTextField();
        labeTop = new javax.swing.JLabel();
        buttonMinStep = new javax.swing.JButton();
        labeltMaxStep = new javax.swing.JLabel();
        texfieldMaxStep = new javax.swing.JTextField();
        buttonMaxStep = new javax.swing.JButton();
        labeltAbsTolerance = new javax.swing.JLabel();
        texfieldAbsTolerance = new javax.swing.JTextField();
        buttonAbsTolerance = new javax.swing.JButton();
        labeltRelTolerance = new javax.swing.JLabel();
        texfieldRelTolerance = new javax.swing.JTextField();
        buttonRelTolerance = new javax.swing.JButton();

        labeltMinStep.setText("MinStep:");

        buttonHelp.setText("Help");
        buttonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHelpActionPerformed(evt);
            }
        });

        texfieldMinStep.setEditable(false);
        texfieldMinStep.setText("1.0E-12");
        texfieldMinStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texfieldMinStepActionPerformed(evt);
            }
        });

        labeTop.setText("DormandPrince54Integrator by Apache commons.");

        buttonMinStep.setText("Change");
        buttonMinStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMinStepActionPerformed(evt);
            }
        });

        labeltMaxStep.setText("MaxStep:");

        texfieldMaxStep.setEditable(false);
        texfieldMaxStep.setText("100");
        texfieldMaxStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texfieldMaxStepActionPerformed(evt);
            }
        });

        buttonMaxStep.setText("Change");
        buttonMaxStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMaxStepActionPerformed(evt);
            }
        });

        labeltAbsTolerance.setText("AbsoluteTolerance:");

        texfieldAbsTolerance.setEditable(false);
        texfieldAbsTolerance.setText("1.0E-3");
        texfieldAbsTolerance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texfieldAbsToleranceActionPerformed(evt);
            }
        });

        buttonAbsTolerance.setText("Change");
        buttonAbsTolerance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAbsToleranceActionPerformed(evt);
            }
        });

        labeltRelTolerance.setText("RelativeTolerance:");

        texfieldRelTolerance.setEditable(false);
        texfieldRelTolerance.setText("1.0E-8");
        texfieldRelTolerance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texfieldRelToleranceActionPerformed(evt);
            }
        });

        buttonRelTolerance.setText("Change");
        buttonRelTolerance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRelToleranceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labeltAbsTolerance)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texfieldRelTolerance, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(texfieldAbsTolerance)))
                            .addComponent(labeltRelTolerance)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labeltMaxStep)
                                    .addComponent(labeltMinStep))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(texfieldMinStep, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(texfieldMaxStep))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonAbsTolerance, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonMaxStep, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRelTolerance, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonMinStep, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labeTop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonHelp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeTop)
                    .addComponent(buttonHelp))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltMinStep)
                    .addComponent(texfieldMinStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMinStep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltMaxStep)
                    .addComponent(texfieldMaxStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMaxStep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltAbsTolerance)
                    .addComponent(texfieldAbsTolerance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAbsTolerance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltRelTolerance)
                    .addComponent(texfieldRelTolerance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRelTolerance))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHelpActionPerformed
        String url = "https://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/org/apache/commons/math3/ode/nonstiff/DormandPrince54Integrator.html";
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please see: \n\n" + url);
        }
    }//GEN-LAST:event_buttonHelpActionPerformed

    private void buttonMinStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMinStepActionPerformed
        changeValue(texfieldMinStep);
    }//GEN-LAST:event_buttonMinStepActionPerformed

    private void texfieldMinStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texfieldMinStepActionPerformed
        
    }//GEN-LAST:event_texfieldMinStepActionPerformed

    private void texfieldMaxStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texfieldMaxStepActionPerformed
        
    }//GEN-LAST:event_texfieldMaxStepActionPerformed

    private void buttonMaxStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMaxStepActionPerformed
        changeValue(texfieldMaxStep);
    }//GEN-LAST:event_buttonMaxStepActionPerformed

    private void texfieldAbsToleranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texfieldAbsToleranceActionPerformed
        
    }//GEN-LAST:event_texfieldAbsToleranceActionPerformed

    private void buttonAbsToleranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAbsToleranceActionPerformed
        
    }//GEN-LAST:event_buttonAbsToleranceActionPerformed

    private void texfieldRelToleranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texfieldRelToleranceActionPerformed
        changeValue(texfieldAbsTolerance);
    }//GEN-LAST:event_texfieldRelToleranceActionPerformed

    private void buttonRelToleranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRelToleranceActionPerformed
        changeValue(texfieldRelTolerance);
    }//GEN-LAST:event_buttonRelToleranceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbsTolerance;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonMaxStep;
    private javax.swing.JButton buttonMinStep;
    private javax.swing.JButton buttonRelTolerance;
    private javax.swing.JLabel labeTop;
    private javax.swing.JLabel labeltAbsTolerance;
    private javax.swing.JLabel labeltMaxStep;
    private javax.swing.JLabel labeltMinStep;
    private javax.swing.JLabel labeltRelTolerance;
    private javax.swing.JTextField texfieldAbsTolerance;
    private javax.swing.JTextField texfieldMaxStep;
    private javax.swing.JTextField texfieldMinStep;
    private javax.swing.JTextField texfieldRelTolerance;
    // End of variables declaration//GEN-END:variables
}