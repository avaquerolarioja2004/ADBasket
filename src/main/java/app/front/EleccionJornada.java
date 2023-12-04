package app.front;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class EleccionJornada extends javax.swing.JFrame {

    private JComboBox <String> comboBox;
    
    public EleccionJornada() {
        initComponents();
        img_Fondo.setIcon(new ImageIcon("./src/main/java/img/Img2.jpg"));
        rellenarJornadas();
         
    }
    
    public void rellenarJornadas() {
        
        ArrayList<String> jornadas = app.back.Metodos.getJornadas();
        for(String item : jornadas){
            this.cb_SeleccionJornada.addItem("Jornada "+item);
        }
        
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_SeleccioneJornada = new javax.swing.JLabel();
        cb_SeleccionJornada = new javax.swing.JComboBox<>();
        btn_ConsultarInfo = new javax.swing.JButton();
        img_Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_SeleccioneJornada.setFont(new java.awt.Font("NSimSun", 1, 30)); // NOI18N
        txt_SeleccioneJornada.setForeground(new java.awt.Color(255, 255, 255));
        txt_SeleccioneJornada.setText("Seleccione una jornada");
        jPanel1.add(txt_SeleccioneJornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        cb_SeleccionJornada.setBackground(new java.awt.Color(218, 166, 100));
        cb_SeleccionJornada.setFont(new java.awt.Font("NSimSun", 0, 20)); // NOI18N
        cb_SeleccionJornada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cb_SeleccionJornada.setPreferredSize(new java.awt.Dimension(70, 30));
        cb_SeleccionJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_SeleccionJornadaActionPerformed(evt);
            }
        });
        jPanel1.add(cb_SeleccionJornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 240, 40));

        btn_ConsultarInfo.setBackground(new java.awt.Color(218, 166, 100));
        btn_ConsultarInfo.setFont(new java.awt.Font("NSimSun", 1, 22)); // NOI18N
        btn_ConsultarInfo.setText("Consultar Información");
        btn_ConsultarInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_ConsultarInfo.setPreferredSize(new java.awt.Dimension(70, 30));
        btn_ConsultarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsultarInfoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ConsultarInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 280, 50));

        img_Fondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(img_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ConsultarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsultarInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ConsultarInfoActionPerformed

    private void cb_SeleccionJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_SeleccionJornadaActionPerformed
        
    }//GEN-LAST:event_cb_SeleccionJornadaActionPerformed

    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EleccionJornada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EleccionJornada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EleccionJornada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EleccionJornada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EleccionJornada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConsultarInfo;
    private javax.swing.JComboBox<String> cb_SeleccionJornada;
    private javax.swing.JLabel img_Fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txt_SeleccioneJornada;
    // End of variables declaration//GEN-END:variables
}
