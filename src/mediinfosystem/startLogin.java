package medi_info_system;

import com.formdev.flatlaf.FlatLightLaf;
import controllers.loginUserController;
import java.awt.Color;
import javax.swing.UIManager;
import model.loginFeederModel;
import view.homeAdminGUI;
import view.homePatientGUI;
import view.homeReceptionistGUI;

public class startLogin extends javax.swing.JFrame {

    private int mousePx;
    private int mousePy;
    public startLogin() {
        initComponents();
        setUndecorated(true);
        setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MainPannel = new keeptoo.KGradientPanel();
        rightBar = new javax.swing.JPanel();
        closeLoginBtn = new keeptoo.KButton();
        leftBar = new javax.swing.JPanel();
        mainContent = new javax.swing.JPanel();
        loginPicCover = new javax.swing.JPanel();
        topPannel = new javax.swing.JPanel();
        bottemPannel = new javax.swing.JPanel();
        MidPannel = new javax.swing.JPanel();
        mainCircle = new keeptoo.KGradientPanel();
        userImg = new javax.swing.JLabel();
        passImg = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        userLoginBtn = new keeptoo.KButton();
        jLabel2 = new javax.swing.JLabel();
        passPasswordField = new javax.swing.JPasswordField();
        loginNotification = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 51, 255));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanel1.setLayout(new java.awt.BorderLayout());

        MainPannel.setkBorderRadius(600);
        MainPannel.setkEndColor(new java.awt.Color(53, 141, 233));
        MainPannel.setkStartColor(new java.awt.Color(125, 225, 232));
        MainPannel.setOpaque(false);
        MainPannel.setPreferredSize(new java.awt.Dimension(100, 600));
        MainPannel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MainPannelMouseDragged(evt);
            }
        });
        MainPannel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MainPannelMousePressed(evt);
            }
        });
        MainPannel.setLayout(new java.awt.BorderLayout());

        rightBar.setOpaque(false);
        rightBar.setPreferredSize(new java.awt.Dimension(50, 600));

        closeLoginBtn.setForeground(new java.awt.Color(255, 0, 102));
        closeLoginBtn.setText("X");
        closeLoginBtn.setToolTipText("Close");
        closeLoginBtn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        closeLoginBtn.setkBorderRadius(20);
        closeLoginBtn.setkEndColor(new java.awt.Color(255, 255, 255));
        closeLoginBtn.setkForeGround(new java.awt.Color(255, 0, 102));
        closeLoginBtn.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        closeLoginBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        closeLoginBtn.setkHoverStartColor(new java.awt.Color(255, 0, 102));
        closeLoginBtn.setkStartColor(new java.awt.Color(255, 255, 255));
        closeLoginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLoginBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout rightBarLayout = new javax.swing.GroupLayout(rightBar);
        rightBar.setLayout(rightBarLayout);
        rightBarLayout.setHorizontalGroup(
            rightBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeLoginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
        );
        rightBarLayout.setVerticalGroup(
            rightBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightBarLayout.createSequentialGroup()
                .addComponent(closeLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 555, Short.MAX_VALUE))
        );

        MainPannel.add(rightBar, java.awt.BorderLayout.LINE_END);

        leftBar.setOpaque(false);
        leftBar.setPreferredSize(new java.awt.Dimension(50, 600));

        javax.swing.GroupLayout leftBarLayout = new javax.swing.GroupLayout(leftBar);
        leftBar.setLayout(leftBarLayout);
        leftBarLayout.setHorizontalGroup(
            leftBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        leftBarLayout.setVerticalGroup(
            leftBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        MainPannel.add(leftBar, java.awt.BorderLayout.LINE_START);

        mainContent.setBackground(new java.awt.Color(255, 255, 255));
        mainContent.setOpaque(false);
        mainContent.setLayout(new java.awt.BorderLayout());

        loginPicCover.setBackground(new java.awt.Color(255, 255, 255));
        loginPicCover.setOpaque(false);
        loginPicCover.setLayout(new java.awt.BorderLayout());

        topPannel.setOpaque(false);

        javax.swing.GroupLayout topPannelLayout = new javax.swing.GroupLayout(topPannel);
        topPannel.setLayout(topPannelLayout);
        topPannelLayout.setHorizontalGroup(
            topPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        topPannelLayout.setVerticalGroup(
            topPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        loginPicCover.add(topPannel, java.awt.BorderLayout.PAGE_START);

        bottemPannel.setOpaque(false);

        javax.swing.GroupLayout bottemPannelLayout = new javax.swing.GroupLayout(bottemPannel);
        bottemPannel.setLayout(bottemPannelLayout);
        bottemPannelLayout.setHorizontalGroup(
            bottemPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        bottemPannelLayout.setVerticalGroup(
            bottemPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        loginPicCover.add(bottemPannel, java.awt.BorderLayout.PAGE_END);

        MidPannel.setOpaque(false);
        MidPannel.setLayout(new java.awt.BorderLayout());

        mainCircle.setkBorderRadius(600);
        mainCircle.setkEndColor(new java.awt.Color(255, 255, 255));
        mainCircle.setkStartColor(new java.awt.Color(255, 255, 255));
        mainCircle.setOpaque(false);

        userImg.setBackground(new java.awt.Color(0, 0, 0));
        userImg.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        userImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_medical_doctor_48px_1.png"))); // NOI18N


        passImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/password.png"))); // NOI18N

        userNameTextField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        userNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTextFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel6.setText("User Name");

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel7.setText("Password");

        userLoginBtn.setText("Login");
        userLoginBtn.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        userLoginBtn.setkBorderRadius(25);
        userLoginBtn.setkEndColor(new java.awt.Color(54, 172, 236));
        userLoginBtn.setkHoverEndColor(new java.awt.Color(57, 207, 216));
        userLoginBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        userLoginBtn.setkHoverStartColor(new java.awt.Color(54, 172, 236));
        userLoginBtn.setkPressedColor(new java.awt.Color(255, 255, 255));
        userLoginBtn.setkStartColor(new java.awt.Color(57, 207, 216));
        userLoginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLoginBtnMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_hospital_3_120px.png"))); // NOI18N

        passPasswordField.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        passPasswordField.setPreferredSize(new java.awt.Dimension(90, 24));

        loginNotification.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        loginNotification.setForeground(new java.awt.Color(255, 0, 102));

        javax.swing.GroupLayout mainCircleLayout = new javax.swing.GroupLayout(mainCircle);
        mainCircle.setLayout(mainCircleLayout);
        mainCircleLayout.setHorizontalGroup(mainCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainCircleLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(mainCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passImg)
                    .addComponent(userImg, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(userLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainCircleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(186, 186, 186)) );
        mainCircleLayout.setVerticalGroup(
            mainCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainCircleLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userNameTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(userLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        MidPannel.add(mainCircle, java.awt.BorderLayout.CENTER);

        loginPicCover.add(MidPannel, java.awt.BorderLayout.CENTER);

        mainContent.add(loginPicCover, java.awt.BorderLayout.CENTER);

        MainPannel.add(mainContent, java.awt.BorderLayout.CENTER);

        jPanel1.add(MainPannel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(600, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeLoginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLoginBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeLoginBtnMouseClicked

    private void userNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTextFieldActionPerformed

    private void userLoginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLoginBtnMouseClicked
        if(!userNameTextField.getText().equals("") && !passPasswordField.getPassword().equals("")){

            String userName=this.userNameTextField.getText();

            String userPass=new String(this.passPasswordField.getPassword());

            loginUserController newLogin=new loginUserController(userName,userPass);

            if(newLogin.loginChecker()){
                loginFeederModel loginFeedObj=new loginFeederModel(userName,newLogin.getUserType());
                switch(newLogin.getUserType()){
                    case "ADMIN":new homeAdminGUI("ADMIN","CHENURA").setVisible(true);
                    this.setVisible(false);break;
                    case "PAT":
                         loginFeedObj.getMatchedPatientObj();
                         new homePatientGUI(loginFeedObj.getMatchedPatientObj()).setVisible(true);
                         this.setVisible(false);break;
                }
            }else{
                loginNotification.setText("Login Details Are Wrong");
            }

        }else{

            loginNotification.setText("Enter Username & Password");

        }
    }//GEN-LAST:event_userLoginBtnMouseClicked

    private void MainPannelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainPannelMouseDragged
        int xCordinate=evt.getXOnScreen();
        int yCordinate=evt.getYOnScreen();

        this.setLocation(xCordinate-mousePx,yCordinate-mousePy);
    }//GEN-LAST:event_MainPannelMouseDragged

    private void MainPannelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainPannelMousePressed
        mousePx=evt.getX();
        mousePy=evt.getY();
    }//GEN-LAST:event_MainPannelMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf());
        } catch( Exception ex ) {
        System.err.println( "Failed to initialize LaF" );
        }
        //new homeAdminGUI("ADMIN","Chenura").setVisible(true);
        //new homeReceptionistGUI().setVisible(true);
        //new homePatientGUI().setVisible(true);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new startLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KGradientPanel MainPannel;
    private javax.swing.JPanel MidPannel;
    private javax.swing.JPanel bottemPannel;
    private keeptoo.KButton closeLoginBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel leftBar;
    private javax.swing.JLabel loginNotification;
    private javax.swing.JPanel loginPicCover;
    private keeptoo.KGradientPanel mainCircle;
    private javax.swing.JPanel mainContent;
    private javax.swing.JLabel passImg;
    private javax.swing.JPasswordField passPasswordField;
    private javax.swing.JPanel rightBar;
    private javax.swing.JPanel topPannel;
    private javax.swing.JLabel userImg;
    private keeptoo.KButton userLoginBtn;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}