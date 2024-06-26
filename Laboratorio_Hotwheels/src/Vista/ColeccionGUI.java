
package Vista;


public class ColeccionGUI extends javax.swing.JFrame {

    /**
     * Creates new form ColeccionGUI
     */
    public ColeccionGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAgregarAuto = new javax.swing.JButton();
        jButtonBorrarAuto = new javax.swing.JButton();
        jButtonListarAuto = new javax.swing.JButton();
        jButtonBuscarAuto = new javax.swing.JButton();
        jbl_titulo = new javax.swing.JLabel();
        jtf_anhoSerieC = new javax.swing.JTextField();
        jbl_AhnoSerie = new javax.swing.JLabel();
        jbl_numSerie = new javax.swing.JLabel();
        jtf_numSerieC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jb_rueda = new javax.swing.JLabel();
        jb_logo = new javax.swing.JLabel();
        jb_torreto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Opciones para coleccion Hot Wheels");
        setBackground(new java.awt.Color(255, 204, 0));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(java.awt.Color.darkGray);

        jButtonAgregarAuto.setText("Agregar auto");
        jButtonAgregarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarAutoActionPerformed(evt);
            }
        });

        jButtonBorrarAuto.setText("Borrar Auto");
        jButtonBorrarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarAutoActionPerformed(evt);
            }
        });

        jButtonListarAuto.setText("Listar Auto");

        jButtonBuscarAuto.setText("Buscar auto");

        jbl_titulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jbl_titulo.setForeground(new java.awt.Color(255, 51, 51));
        jbl_titulo.setText("Coleccion de ");

        jtf_anhoSerieC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_anhoSerieCActionPerformed(evt);
            }
        });

        jbl_AhnoSerie.setText("Año de serie:");

        jbl_numSerie.setText("Numero de serie ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));

        jb_rueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rueda.png"))); // NOI18N

        jb_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N

        jb_torreto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/toretto.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jb_rueda)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jbl_titulo)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbl_AhnoSerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbl_numSerie))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtf_anhoSerieC)
                                .addComponent(jtf_numSerieC, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonAgregarAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonListarAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonBuscarAuto)
                                .addComponent(jButtonBorrarAuto)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jb_torreto)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jb_logo))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jb_rueda)
                .addGap(208, 208, 208)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(62, 62, 62)
                .addComponent(jbl_titulo)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_anhoSerieC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbl_AhnoSerie))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_torreto)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbl_numSerie)
                            .addComponent(jtf_numSerieC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAgregarAuto)
                            .addComponent(jButtonBorrarAuto))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonBuscarAuto)
                            .addComponent(jButtonListarAuto))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jb_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarAutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAgregarAutoActionPerformed

    private void jButtonBorrarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarAutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBorrarAutoActionPerformed

    private void jtf_anhoSerieCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_anhoSerieCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_anhoSerieCActionPerformed

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
            java.util.logging.Logger.getLogger(ColeccionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColeccionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColeccionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColeccionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColeccionGUI().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonAgregarAuto;
    public javax.swing.JButton jButtonBorrarAuto;
    public javax.swing.JButton jButtonBuscarAuto;
    public javax.swing.JButton jButtonListarAuto;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jb_logo;
    private javax.swing.JLabel jb_rueda;
    private javax.swing.JLabel jb_torreto;
    private javax.swing.JLabel jbl_AhnoSerie;
    private javax.swing.JLabel jbl_numSerie;
    private javax.swing.JLabel jbl_titulo;
    public javax.swing.JTextField jtf_anhoSerieC;
    public javax.swing.JTextField jtf_numSerieC;
    // End of variables declaration//GEN-END:variables
}
