
package app.front;

import java.util.ArrayList;

public class ConsultaInfoEquipo extends javax.swing.JFrame {

    public ConsultaInfoEquipo() {
        initComponents();
    }

    public void rellenarEquipos() { //Falta un metodo que me de los equipos
        ArrayList<String> jornadas = app.back.Metodos.getJornadas();
        for(String item : jornadas){
            this.cb_SeleccEquipo.addItem("Jornada "+item);
        }             
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gbtn_EG = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txt_SeleccEquipo = new javax.swing.JLabel();
        cb_SeleccEquipo = new javax.swing.JComboBox<>();
        txt_ConsultarInfo = new javax.swing.JLabel();
        txt_PartidosEnCasa = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        rbtn_General = new javax.swing.JRadioButton();
        txt_PartidosFuera = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        rbtn_Equipo = new javax.swing.JRadioButton();
        txt_PartidosTotales = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        btn_Atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 209, 165));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setBackground(new java.awt.Color(218, 166, 100));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "P.J.", "P.G.", "P.P.", "P.F.", "P.C.", "Ptos."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 700, -1, 50));

        txt_SeleccEquipo.setFont(new java.awt.Font("NSimSun", 1, 30)); // NOI18N
        txt_SeleccEquipo.setText("Selecciona un equipo");
        txt_SeleccEquipo.setToolTipText("");
        jPanel1.add(txt_SeleccEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        cb_SeleccEquipo.setBackground(new java.awt.Color(218, 166, 100));
        cb_SeleccEquipo.setEditable(true);
        cb_SeleccEquipo.setFont(new java.awt.Font("NSimSun", 0, 24)); // NOI18N
        cb_SeleccEquipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cb_SeleccEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_SeleccEquipoActionPerformed(evt);
            }
        });
        jPanel1.add(cb_SeleccEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, -1, -1));

        txt_ConsultarInfo.setFont(new java.awt.Font("NSimSun", 1, 36)); // NOI18N
        txt_ConsultarInfo.setText("Consultar Información");
        jPanel1.add(txt_ConsultarInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 43, -1, 37));

        txt_PartidosEnCasa.setFont(new java.awt.Font("NSimSun", 1, 30)); // NOI18N
        txt_PartidosEnCasa.setText("Partidos en casa");
        txt_PartidosEnCasa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txt_PartidosEnCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, -1));

        jTable3.setBackground(new java.awt.Color(218, 166, 100));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "P.J.", "P.G.", "P.P.", "P.F.", "P.C.", "Ptos."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, 50));

        gbtn_EG.add(rbtn_General);
        rbtn_General.setFont(new java.awt.Font("NSimSun", 1, 24)); // NOI18N
        rbtn_General.setText("General");
        rbtn_General.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_GeneralActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 120, -1, -1));

        txt_PartidosFuera.setFont(new java.awt.Font("NSimSun", 1, 30)); // NOI18N
        txt_PartidosFuera.setText("Partidos fuera");
        jPanel1.add(txt_PartidosFuera, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 500, -1, -1));

        jTable1.setBackground(new java.awt.Color(218, 166, 100));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Equipo", "Fecha", "Local", "Visitante", "Ptos. Local", "Ptos. Visitante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 939, 230));

        gbtn_EG.add(rbtn_Equipo);
        rbtn_Equipo.setFont(new java.awt.Font("NSimSun", 1, 24)); // NOI18N
        rbtn_Equipo.setSelected(true);
        rbtn_Equipo.setText("Equipo");
        jPanel1.add(rbtn_Equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 120, -1, -1));

        txt_PartidosTotales.setFont(new java.awt.Font("NSimSun", 1, 30)); // NOI18N
        txt_PartidosTotales.setText("Partidos totales");
        jPanel1.add(txt_PartidosTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 270, -1));

        jTable4.setBackground(new java.awt.Color(218, 166, 100));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "P.J.", "P.G.", "P.P.", "P.F.", "P.C.", "Ptos."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, -1, 50));

        btn_Atras.setBackground(new java.awt.Color(218, 166, 100));
        btn_Atras.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        btn_Atras.setText("Atrás");
        btn_Atras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtn_GeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_GeneralActionPerformed
        // TODO add your handling code here:
        if (rbtn_General.isSelected()) {
        this.setVisible(false);

        ConsultaInfoGeneral consultaInfoGeneral = new ConsultaInfoGeneral();
        consultaInfoGeneral.setVisible(true);
    }
    }//GEN-LAST:event_rbtn_GeneralActionPerformed

    private void btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrasActionPerformed
        this.dispose();
    
        EleccionPartido ventanaAnterior = new EleccionPartido();
        ventanaAnterior.setVisible(true);
    }//GEN-LAST:event_btn_AtrasActionPerformed

    private void cb_SeleccEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_SeleccEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_SeleccEquipoActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaInfoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaInfoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaInfoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaInfoEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaInfoEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Atras;
    private javax.swing.JComboBox<String> cb_SeleccEquipo;
    private javax.swing.ButtonGroup gbtn_EG;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JRadioButton rbtn_Equipo;
    private javax.swing.JRadioButton rbtn_General;
    private javax.swing.JLabel txt_ConsultarInfo;
    private javax.swing.JLabel txt_PartidosEnCasa;
    private javax.swing.JLabel txt_PartidosFuera;
    private javax.swing.JLabel txt_PartidosTotales;
    private javax.swing.JLabel txt_SeleccEquipo;
    // End of variables declaration//GEN-END:variables
}
