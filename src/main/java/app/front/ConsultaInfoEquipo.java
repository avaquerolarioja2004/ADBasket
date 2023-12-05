
package app.front;

import app.back.Metodos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ConsultaInfoEquipo extends javax.swing.JFrame {

    public String nombreEquipo;
    public int idEquipo;

    public ConsultaInfoEquipo() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        // Bloquear la edición en las tablas
        tb_InfoEquipo.setDefaultEditor(Object.class, null);
        tb_PtosEnCasa.setDefaultEditor(Object.class, null);
        tb_PtosFuera.setDefaultEditor(Object.class, null);
        tb_PtosTotales.setDefaultEditor(Object.class, null);
        cb_SeleccEquipo.setEditable(false);
        rellenarEquipos();
    }

    public void rellenarEquipos() {
        ArrayList<String> equipos = app.back.Metodos.getNombresEquipos();
        for (String item : equipos) {
            this.cb_SeleccEquipo.addItem(item);
        }
    }

    public void rellenarTablaEquipos(int idEquipo) {        
        DefaultTableModel model = (DefaultTableModel) tb_InfoEquipo.getModel();
        model.setRowCount(0); 
        
        ArrayList<String> resultados = Metodos.getResultadosEquipo(idEquipo);

        for (String resultado : resultados) {
            String[] datos = resultado.split(";");
            model.addRow(datos);
        }
    }
    
    public void rellenarTablaPtosCasa(int idEquipo) {
        DefaultTableModel modelPuntos = (DefaultTableModel) tb_PtosEnCasa.getModel();
        modelPuntos.setRowCount(0);
        String resultados = Metodos.getInfoEquipo(idEquipo);

        if (!resultados.isEmpty()) {
            String[] datos = resultados.split(";");

            if (datos.length >= 18) {
                Object[] filaPuntos = new Object[6];
                for (int i = 1; i < 7; i++) {
                    filaPuntos[i - 1] = datos[i];
                }

                modelPuntos.addRow(filaPuntos);
            }
        }
    }
    
    public void rellenarTablaPtosFuera(int idEquipo) {
        DefaultTableModel modelPuntos = (DefaultTableModel) tb_PtosFuera.getModel();
        modelPuntos.setRowCount(0); 

        String resultados = Metodos.getInfoEquipo(idEquipo);

        if (!resultados.isEmpty()) {
            String[] datos = resultados.split(";");

            if (datos.length >= 18) {
                Object[] filaPuntos = new Object[6]; 
                for (int i = 7, j = 0; i < 13; i++, j++) {
                    filaPuntos[j] = datos[i];
                }

                modelPuntos.addRow(filaPuntos);
            }
        }
    }
    
   public void rellenarTablaPtosTotales(int idEquipo) {
    DefaultTableModel modelPuntos = (DefaultTableModel) tb_PtosTotales.getModel();
    modelPuntos.setRowCount(0); 

    String resultados = Metodos.getInfoEquipo(idEquipo);

    if (!resultados.isEmpty()) {
        String[] datos = resultados.split(";");

        if (datos.length >= 19) {
            Object[] filaPuntos = new Object[6]; 
            for (int i = 13, j = 0; i < 19; i++, j++) { 
                filaPuntos[j] = datos[i];
            }

            modelPuntos.addRow(filaPuntos);
        }
    }
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gbtn_EG = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txt_SeleccEquipo = new javax.swing.JLabel();
        cb_SeleccEquipo = new javax.swing.JComboBox<>();
        txt_ConsultarInfo = new javax.swing.JLabel();
        txt_PartidosEnCasa = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_PtosFuera = new javax.swing.JTable();
        rbtn_General = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_InfoEquipo = new javax.swing.JTable();
        rbtn_Equipo = new javax.swing.JRadioButton();
        btn_Atras = new javax.swing.JButton();
        txt_PartidosEnCasa1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_PtosEnCasa = new javax.swing.JTable();
        txt_PartidosEnCasa2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_PtosTotales = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 209, 165));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        txt_PartidosEnCasa.setText("Partidos fuera");
        txt_PartidosEnCasa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txt_PartidosEnCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, -1, -1));

        tb_PtosFuera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "P.J.", "P.G.", "P.P.", "P.F.", "P.C.", "Ptos."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tb_PtosFuera);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, -1, 50));

        gbtn_EG.add(rbtn_General);
        rbtn_General.setFont(new java.awt.Font("NSimSun", 1, 24)); // NOI18N
        rbtn_General.setText("General");
        rbtn_General.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_GeneralActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 120, -1, -1));

        tb_InfoEquipo.setFont(new java.awt.Font("NSimSun", 0, 18)); // NOI18N
        tb_InfoEquipo.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Jornada", "Fecha", "Local", "Visitante", "Ptos. Local", "Ptos. Visitante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_InfoEquipo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 939, 170));

        gbtn_EG.add(rbtn_Equipo);
        rbtn_Equipo.setFont(new java.awt.Font("NSimSun", 1, 24)); // NOI18N
        rbtn_Equipo.setSelected(true);
        rbtn_Equipo.setText("Equipo");
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
        jPanel1.add(btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txt_PartidosEnCasa1.setFont(new java.awt.Font("NSimSun", 1, 30)); // NOI18N
        txt_PartidosEnCasa1.setText("Resultados totales");
        txt_PartidosEnCasa1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txt_PartidosEnCasa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, -1, -1));

        tb_PtosEnCasa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "P.J.", "P.G.", "P.P.", "P.F.", "P.C.", "Ptos."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tb_PtosEnCasa);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, 50));

        txt_PartidosEnCasa2.setFont(new java.awt.Font("NSimSun", 1, 30)); // NOI18N
        txt_PartidosEnCasa2.setText("Partidos en casa");
        txt_PartidosEnCasa2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txt_PartidosEnCasa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, -1));

        tb_PtosTotales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "P.J.", "P.G.", "P.P.", "P.F.", "P.C.", "Ptos."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tb_PtosTotales);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 610, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        nombreEquipo = (String) cb_SeleccEquipo.getSelectedItem();
        idEquipo = Metodos.getIdEquipoByName(nombreEquipo);
        rellenarTablaEquipos(idEquipo);
        rellenarTablaPtosCasa(idEquipo);
        rellenarTablaPtosFuera(idEquipo);
        rellenarTablaPtosTotales(idEquipo);
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JRadioButton rbtn_Equipo;
    private javax.swing.JRadioButton rbtn_General;
    private javax.swing.JTable tb_InfoEquipo;
    private javax.swing.JTable tb_PtosEnCasa;
    private javax.swing.JTable tb_PtosFuera;
    private javax.swing.JTable tb_PtosTotales;
    private javax.swing.JLabel txt_ConsultarInfo;
    private javax.swing.JLabel txt_PartidosEnCasa;
    private javax.swing.JLabel txt_PartidosEnCasa1;
    private javax.swing.JLabel txt_PartidosEnCasa2;
    private javax.swing.JLabel txt_SeleccEquipo;
    // End of variables declaration//GEN-END:variables

}


