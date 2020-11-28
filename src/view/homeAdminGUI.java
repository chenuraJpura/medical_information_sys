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
        kButton1 = new keeptoo.KButton();
        kButton2 = new keeptoo.KButton();
        kButton3 = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 900));

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

        kButton1.setText("Appointment");
        kButton1.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        kButton1.setkBorderRadius(15);
        kButton1.setkEndColor(new java.awt.Color(251, 145, 83));
        kButton1.setkStartColor(new java.awt.Color(253, 116, 156));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        kButton2.setText("Complain");
        kButton2.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        kButton2.setkBorderRadius(15);
        kButton2.setkEndColor(new java.awt.Color(220, 12, 254));
        kButton2.setkStartColor(new java.awt.Color(146, 2, 249));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        kButton3.setText("Postal");
        kButton3.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N
        kButton3.setkBorderRadius(15);
        kButton3.setkEndColor(new java.awt.Color(141, 146, 250));
        kButton3.setkStartColor(new java.awt.Color(81, 87, 202));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(362, 362, 362))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(kButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(595, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1000, 900));
        setLocationRelativeTo(null);
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

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton1ActionPerformed

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
    private javax.swing.JPanel jPanel2;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton2;
    private keeptoo.KButton kButton3;
    private javax.swing.JLabel max_btn_img;
    private javax.swing.JPanel maximize;
    private javax.swing.JPanel min_max_close;
    private javax.swing.JPanel minmize;
    // End of variables declaration//GEN-END:variables
}
