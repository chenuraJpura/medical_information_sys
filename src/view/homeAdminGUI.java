/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author chenura_pc
 */
public class homeAdminGUI extends javax.swing.JFrame {

    /**
     * Creates new form homeAdminGUI
     */
    public homeAdminGUI() {
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

        header = new javax.swing.JPanel();
        min_max_close = new javax.swing.JPanel();
        minmize = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        close = new javax.swing.JPanel();
        close_btn_img = new javax.swing.JLabel();
        maximize = new javax.swing.JPanel();
        max_btn_img = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        kButton1 = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        header.setBackground(new java.awt.Color(38, 44, 86));
        header.setForeground(new java.awt.Color(60, 63, 65));
        header.setPreferredSize(new java.awt.Dimension(800, 40));
        header.setLayout(new java.awt.BorderLayout());

        min_max_close.setBackground(new java.awt.Color(38, 44, 86));
        min_max_close.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minmize.setBackground(new java.awt.Color(38, 44, 86));
        minmize.setPreferredSize(new java.awt.Dimension(100, 30));
        minmize.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(38, 44, 86));
        jLabel1.setForeground(new java.awt.Color(45, 52, 99));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/min_button.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        minmize.add(jLabel1, java.awt.BorderLayout.CENTER);

        min_max_close.add(minmize, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 80, -1));

        close.setBackground(new java.awt.Color(38, 44, 86));
        close.setPreferredSize(new java.awt.Dimension(70, 30));
        close.setLayout(new java.awt.BorderLayout());

        close_btn_img.setBackground(new java.awt.Color(38, 44, 86));
        close_btn_img.setForeground(new java.awt.Color(45, 52, 99));
        close_btn_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close_btn_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close_button.png"))); // NOI18N
        close_btn_img.setToolTipText("close");
        close_btn_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_btn_imgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close_btn_imgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_btn_imgMouseExited(evt);
            }
        });
        close.add(close_btn_img, java.awt.BorderLayout.CENTER);

        min_max_close.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 100, -1));

        maximize.setBackground(new java.awt.Color(38, 44, 86));
        maximize.setPreferredSize(new java.awt.Dimension(100, 30));
        maximize.setLayout(new java.awt.BorderLayout());

        max_btn_img.setBackground(new java.awt.Color(38, 44, 86));
        max_btn_img.setForeground(new java.awt.Color(45, 52, 99));
        max_btn_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        max_btn_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/max_button.png"))); // NOI18N
        max_btn_img.setToolTipText("maximize");
        max_btn_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                max_btn_imgMouseClicked(evt);
            }
        });
        maximize.add(max_btn_img, java.awt.BorderLayout.LINE_END);

        min_max_close.add(maximize, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 0, 150, -1));

        header.add(min_max_close, java.awt.BorderLayout.LINE_END);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(38, 44, 86));
        kGradientPanel1.setkStartColor(new java.awt.Color(45, 52, 99));
        kGradientPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(45, 52, 99));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 450));

        kButton1.setText("Appointment");
        kButton1.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(584, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(351, Short.MAX_VALUE)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        kGradientPanel1.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(kGradientPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void close_btn_imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btn_imgMouseClicked
        System.exit(0);
    }//GEN-LAST:event_close_btn_imgMouseClicked

    private void close_btn_imgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btn_imgMouseEntered

    }//GEN-LAST:event_close_btn_imgMouseEntered

    private void close_btn_imgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btn_imgMouseExited

    }//GEN-LAST:event_close_btn_imgMouseExited

    private void max_btn_imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_max_btn_imgMouseClicked
        if(this.getExtendedState()!=appointmentAddGUI.MAXIMIZED_BOTH){
            this.setExtendedState(MAXIMIZED_BOTH);
        }else{
            this.setExtendedState(NORMAL);
        }
    }//GEN-LAST:event_max_btn_imgMouseClicked

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
            java.util.logging.Logger.getLogger(homeAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homeAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homeAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homeAdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homeAdminGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel close;
    private javax.swing.JLabel close_btn_img;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private keeptoo.KButton kButton1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel max_btn_img;
    private javax.swing.JPanel maximize;
    private javax.swing.JPanel min_max_close;
    private javax.swing.JPanel minmize;
    // End of variables declaration//GEN-END:variables
}
