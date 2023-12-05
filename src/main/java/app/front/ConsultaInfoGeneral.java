
package app.front;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ConsultaInfoGeneral extends javax.swing.JFrame {

    public ConsultaInfoGeneral() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        tb_InfoGeneral.setDefaultEditor(Object.class, null);
        rellenarTablaGeneral();   
    }


    public void rellenarTablaGeneral() {
        ArrayList<String> clasificaciones = app.back.Metodos.getClasificaciones();
        
        DefaultTableModel model = (DefaultTableModel) tb_InfoGeneral.getModel();
        model.setRowCount(0); // Clear the table before filling it
        for (String clasificacion : clasificaciones) {
            String[] datos = clasificacion.split(";");
            model.addRow(datos);
        }
    }
            
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gbtn_EG = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txt_ConsultarInfo = new javax.swing.JLabel();
        rbtn_General = new javax.swing.JRadioButton();
        tabla = new javax.swing.JScrollPane();
        tb_InfoGeneral = new javax.swing.JTable();
        rbtn_Equipo = new javax.swing.JRadioButton();
        btn_Atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 209, 165));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ConsultarInfo.setFont(new java.awt.Font("NSimSun", 1, 36)); // NOI18N
        txt_ConsultarInfo.setText("Consultar Información");
        jPanel1.add(txt_ConsultarInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 43, -1, 37));

        gbtn_EG.add(rbtn_General);
        rbtn_General.setFont(new java.awt.Font("NSimSun", 1, 24)); // NOI18N
        rbtn_General.setSelected(true);
        rbtn_General.setText("General");
        rbtn_General.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_GeneralActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 120, -1, -1));

        tb_InfoGeneral.setFont(new java.awt.Font("NSimSun", 0, 18)); // NOI18N
        tb_InfoGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Equipo", "P.J.", "P.G.", "P.P.", "P.F.", "P.C.", "Ptos."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla.setViewportView(tb_InfoGeneral);

        jPanel1.add(tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 939, 320));

        gbtn_EG.add(rbtn_Equipo);
        rbtn_Equipo.setFont(new java.awt.Font("NSimSun", 1, 24)); // NOI18N
        rbtn_Equipo.setText("Equipo");
        rbtn_Equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_EquipoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_Equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 120, -1, -1));

        btn_Atras.setBackground(new java.awt.Color(218, 166, 100));
        btn_Atras.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        btn_Atras.setText("Atrás");
        btn_Atras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtn_GeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_GeneralActionPerformed
        
    }//GEN-LAST:event_rbtn_GeneralActionPerformed

    private void btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrasActionPerformed
        this.dispose();
    
        EleccionPartido ventanaAnterior = new EleccionPartido();
        ventanaAnterior.setVisible(true);
    }//GEN-LAST:event_btn_AtrasActionPerformed

    private void rbtn_EquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_EquipoActionPerformed
        // TODO add your handling code here:
        if (rbtn_Equipo.isSelected()) {
            // Desactivar el JFrame actual (ConsultaInfoEquipo)
            this.setVisible(false);

            // Crear y mostrar el nuevo JFrame (ConsultaInfoGeneral)
            ConsultaInfoEquipo consultaInfoEquipo = new ConsultaInfoEquipo();
            consultaInfoEquipo.setVisible(true);
        }
    }//GEN-LAST:event_rbtn_EquipoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaInfoGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaInfoGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaInfoGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaInfoGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaInfoGeneral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Atras;
    private javax.swing.ButtonGroup gbtn_EG;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbtn_Equipo;
    private javax.swing.JRadioButton rbtn_General;
    private javax.swing.JScrollPane tabla;
    private javax.swing.JTable tb_InfoGeneral;
    private javax.swing.JLabel txt_ConsultarInfo;
    // End of variables declaration//GEN-END:variables
}
