/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Domain;

import Logic.CombatSystem;
import javax.swing.DefaultListModel;

/**
 *
 * @author eduar
 */
public class RobotsPorEquipo extends javax.swing.JFrame {

    CombatSystem pSystem;
    MainMenu menu;
    public RobotsPorEquipo(CombatSystem pSystem, MainMenu menu) {
        initComponents();
        this.pSystem = pSystem;
        this.menu = menu;
        pSystem.getRobotStatisctics();
        boxTeams.addItem("");
        for (String team : pSystem.getTeamsList())
        {
            boxTeams.addItem(team);
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

        buttonRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaRobots = new javax.swing.JList<>();
        boxTeams = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonRegresar.setText("Regresar");
        buttonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegresarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaRobots);

        boxTeams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTeamsActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione equipo");

        jLabel2.setText("Robots del equipo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(boxTeams, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(buttonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxTeams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(buttonRegresar)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegresarActionPerformed
        setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_buttonRegresarActionPerformed

    private void boxTeamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTeamsActionPerformed
        DefaultListModel<String> list = new DefaultListModel<>();
        listaRobots.setModel(list);
        if(!boxTeams.getSelectedItem().equals(""))
        {
            for(HumanRobot robot : pSystem.getHumanRobotList())
            {
                if(robot.getTeam().equals(boxTeams.getSelectedItem()))
                {
                    list.addElement(robot.getInfo());
                }
            }
            listaRobots.setModel(list);
        }
    }//GEN-LAST:event_boxTeamsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxTeams;
    private javax.swing.JButton buttonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaRobots;
    // End of variables declaration//GEN-END:variables
}
