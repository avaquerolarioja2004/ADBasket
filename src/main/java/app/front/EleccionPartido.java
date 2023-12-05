package app.front;

import app.back.Libreria;
import app.back.Metodos;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class EleccionPartido extends javax.swing.JFrame {
    
    private String equipoLocalSeleccionado;
    private String equipoVisitanteSeleccionado;
    private boolean partidoSeleccionado = false;
    
    public EleccionPartido() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        initComponents();
        tb_TablaPartidos.setDefaultEditor(Object.class, null);
        int idJornada1 = EleccionJornada.idJornada;
        rellenarPartidos(idJornada1);
        tb_TablaPartidos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && tb_TablaPartidos.getSelectedRow() != -1) {
                    int selectedRow = tb_TablaPartidos.getSelectedRow();

                    if (selectedRow >= 0 && selectedRow < tb_TablaPartidos.getRowCount()) {
                        equipoLocalSeleccionado = tb_TablaPartidos.getValueAt(selectedRow, 0).toString();
                        equipoVisitanteSeleccionado = tb_TablaPartidos.getValueAt(selectedRow, 1).toString();

                        txt_NomELocal.setText(equipoLocalSeleccionado);
                        txt_NomEVisitante.setText(equipoVisitanteSeleccionado);
                    }
                }
            }
        });
        PuntosLocal.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
        });

        // Agregar KeyListener a PuntosVisitante
        PuntosVisitante.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumeros(evt);
            }
        });
    }
    private void soloNumeros(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Ignorar la tecla presionada si no es un número
        }
    }

    public void rellenarPartidos(int idJornada){
        limpiarTabla();
    
        try {
            Connection c = Libreria.creaConexion("sqlite", "C:\\Users\\elipu\\OneDrive\\Escritorio\\AD_ServersYConectores\\SGBD\\sqlite\\BALONCESTO.db");
            if (c != null) {
                ArrayList<String> partidos = app.back.Metodos.getPartidosJornada(idJornada, c);
                DefaultTableModel model = (DefaultTableModel) tb_TablaPartidos.getModel();
                for (String partido : partidos) {
                    String[] datosPartido = partido.split(";");
                    model.addRow(datosPartido);
                }
                c.close();
            } else {
                System.out.println("Error al establecer la conexion a la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) tb_TablaPartidos.getModel();
        model.setRowCount(0);
    }
    
    public JComboBox<String> getComboBox() {
        return getComboBox();
    } 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txt_Partidos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_TablaPartidos = new javax.swing.JTable();
        txt_ELocal = new javax.swing.JLabel();
        txt_EVisitante = new javax.swing.JLabel();
        txt_NomELocal = new javax.swing.JLabel();
        txt_NomEVisitante = new javax.swing.JLabel();
        txt_PtosELocal = new javax.swing.JLabel();
        txt_PtosEVisitante = new javax.swing.JLabel();
        btn_GrabarResultado = new javax.swing.JButton();
        btn_ConsultarInfo = new javax.swing.JButton();
        PuntosLocal = new javax.swing.JTextField();
        PuntosVisitante = new javax.swing.JTextField();
        btn_Atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(243, 209, 165));
        jPanel2.setFocusable(false);

        txt_Partidos.setFont(new java.awt.Font("NSimSun", 1, 36)); // NOI18N
        txt_Partidos.setText("PARTIDOS");

        tb_TablaPartidos.setAutoCreateRowSorter(true);
        tb_TablaPartidos.setFont(new java.awt.Font("NSimSun", 0, 18)); // NOI18N
        tb_TablaPartidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Local", "Visitante"
            }
        ));
        tb_TablaPartidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_TablaPartidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_TablaPartidos);

        txt_ELocal.setFont(new java.awt.Font("NSimSun", 1, 24)); // NOI18N
        txt_ELocal.setText("E.L.->");

        txt_EVisitante.setFont(new java.awt.Font("NSimSun", 1, 24)); // NOI18N
        txt_EVisitante.setText("E.V.->");

        txt_NomELocal.setFont(new java.awt.Font("NSimSun", 0, 18)); // NOI18N
        txt_NomELocal.setText("Equipo Local");
        txt_NomELocal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_NomEVisitante.setFont(new java.awt.Font("NSimSun", 0, 18)); // NOI18N
        txt_NomEVisitante.setText("Equipo Visitante");
        txt_NomEVisitante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_PtosELocal.setFont(new java.awt.Font("NSimSun", 1, 24)); // NOI18N
        txt_PtosELocal.setText("Ptos.E.L.->");

        txt_PtosEVisitante.setFont(new java.awt.Font("NSimSun", 1, 24)); // NOI18N
        txt_PtosEVisitante.setText("Ptos.E.V.->");

        btn_GrabarResultado.setBackground(new java.awt.Color(218, 166, 100));
        btn_GrabarResultado.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        btn_GrabarResultado.setText("Grabar Resultado");
        btn_GrabarResultado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_GrabarResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GrabarResultadoActionPerformed(evt);
            }
        });

        btn_ConsultarInfo.setBackground(new java.awt.Color(218, 166, 100));
        btn_ConsultarInfo.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        btn_ConsultarInfo.setText("Consultar Info.");
        btn_ConsultarInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_ConsultarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsultarInfoActionPerformed(evt);
            }
        });

        PuntosLocal.setFont(new java.awt.Font("NSimSun", 0, 18)); // NOI18N
        PuntosLocal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PuntosLocal.setToolTipText("ptos.");
        PuntosLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuntosLocalActionPerformed(evt);
            }
        });

        PuntosVisitante.setFont(new java.awt.Font("NSimSun", 0, 18)); // NOI18N
        PuntosVisitante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PuntosVisitante.setToolTipText("ptos.");
        PuntosVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuntosVisitanteActionPerformed(evt);
            }
        });

        btn_Atras.setBackground(new java.awt.Color(218, 166, 100));
        btn_Atras.setFont(new java.awt.Font("NSimSun", 1, 20)); // NOI18N
        btn_Atras.setText("Atrás");
        btn_Atras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(txt_Partidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_GrabarResultado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_ConsultarInfo))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txt_EVisitante)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_NomEVisitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txt_ELocal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_NomELocal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txt_PtosEVisitante)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PuntosVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txt_PtosELocal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PuntosLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 80, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btn_Atras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_Atras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Partidos)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ELocal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_PtosELocal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PuntosLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_NomELocal, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PuntosVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_EVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_PtosEVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_NomEVisitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ConsultarInfo)
                    .addComponent(btn_GrabarResultado))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ConsultarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsultarInfoActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ConsultaInfoEquipo ventanaSiguiente;
        ventanaSiguiente = new ConsultaInfoEquipo();
        ventanaSiguiente.setVisible(true);        
    }//GEN-LAST:event_btn_ConsultarInfoActionPerformed

    private void btn_GrabarResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GrabarResultadoActionPerformed
        // TODO add your handling code here:
        int jornada = EleccionJornada.idJornada;
        int idEL = app.back.Metodos.getIdEquipoByName(equipoLocalSeleccionado);
        int idEV = app.back.Metodos.getIdEquipoByName(equipoVisitanteSeleccionado);

        if (!partidoSeleccionado) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un partido antes de grabar el resultado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String puntosLocalText = PuntosLocal.getText();
        String puntosVisitanteText = PuntosVisitante.getText();
        if (puntosLocalText.isEmpty() || puntosVisitanteText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Compruebe los campos de puntuaje: \n"
                    + "-No está permitido dejar estos campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        int pEL = Integer.parseInt(PuntosLocal.getText());
        int pEV = Integer.parseInt(PuntosVisitante.getText());
        
        try {
            pEL = Integer.parseInt(puntosLocalText);
            pEV = Integer.parseInt(puntosVisitanteText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Compruebe los campos de puntuaje: \n"
                    + "-Asegúrese de ingresar valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return;        
        }
        if (pEL == pEV) {
            JOptionPane.showMessageDialog(this, "Compruebe los campos de puntuaje: \n"
                    + "-No están permitidos los empates.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (pEL < 0 || pEV < 0) {
            JOptionPane.showMessageDialog(this, "Compruebe los campos de puntuaje: \n"
                    + "-No están permitidos los valores negativos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean resultadoGrabacion = Metodos.grabar(jornada, idEL, pEL, idEV, pEV);

            if (resultadoGrabacion) {
                JOptionPane.showMessageDialog(this, "Resultado grabado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                int rowCount = tb_TablaPartidos.getRowCount();
                int selectedRow = tb_TablaPartidos.getSelectedRow();
                if (selectedRow != -1 && selectedRow < rowCount) {
                    DefaultTableModel model = (DefaultTableModel) tb_TablaPartidos.getModel();
                    model.removeRow(selectedRow);
                }
                PuntosLocal.setText("");
                PuntosVisitante.setText("");
                txt_NomELocal.setText("");
                txt_NomEVisitante.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error al grabar el resultado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_GrabarResultadoActionPerformed

    private void PuntosLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuntosLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PuntosLocalActionPerformed

    private void PuntosVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuntosVisitanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PuntosVisitanteActionPerformed

    private void btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtrasActionPerformed
        this.dispose();
        EleccionJornada ventanaAnterior;
                
        try {
            ventanaAnterior = new EleccionJornada();
            ventanaAnterior.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EleccionPartido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_AtrasActionPerformed

    private void tb_TablaPartidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_TablaPartidosMouseClicked
        // TODO add your handling code here:
        int selectedRow = tb_TablaPartidos.getSelectedRow();
        if (selectedRow >= 0 && selectedRow < tb_TablaPartidos.getRowCount()) {
            equipoLocalSeleccionado = tb_TablaPartidos.getValueAt(selectedRow, 0).toString();
            equipoVisitanteSeleccionado = tb_TablaPartidos.getValueAt(selectedRow, 1).toString();

            txt_NomELocal.setText(equipoLocalSeleccionado);
            txt_NomEVisitante.setText(equipoVisitanteSeleccionado);

            // Habilita los campos de puntuación al seleccionar un partido
            PuntosLocal.setEnabled(true);
            PuntosVisitante.setEnabled(true);

            // Actualiza la bandera de partido seleccionado
            partidoSeleccionado = true;
        }
    }//GEN-LAST:event_tb_TablaPartidosMouseClicked

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
            java.util.logging.Logger.getLogger(EleccionPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EleccionPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EleccionPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EleccionPartido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EleccionPartido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PuntosLocal;
    private javax.swing.JTextField PuntosVisitante;
    private javax.swing.JButton btn_Atras;
    private javax.swing.JButton btn_ConsultarInfo;
    private javax.swing.JButton btn_GrabarResultado;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_TablaPartidos;
    private javax.swing.JLabel txt_ELocal;
    private javax.swing.JLabel txt_EVisitante;
    private javax.swing.JLabel txt_NomELocal;
    private javax.swing.JLabel txt_NomEVisitante;
    private javax.swing.JLabel txt_Partidos;
    private javax.swing.JLabel txt_PtosELocal;
    private javax.swing.JLabel txt_PtosEVisitante;
    // End of variables declaration//GEN-END:variables
}
