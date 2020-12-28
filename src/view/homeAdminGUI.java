package view;

import com.itextpdf.text.DocumentException;
import controllers.appointmentController;
import controllers.complainsController;
import controllers.date;
import controllers.dispatchPostController;
import controllers.loginController;
import controllers.medicalOfficers;
import controllers.patient;
import controllers.receptionist;
import controllers.recievedPostController;
import controllers.referenceController;
import controllers.time;
import controllers.visitorsController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.TableModel;
import medi_info_system.startLogin;
import model.AppointmentModel;
import model.ComplainModel;
import model.DispatchModel;
import model.MedicalOfficerModel;
import model.PatientModel;
import model.ReceptionistModel;
import model.RecievedPostModel;
import model.ReferenceModel;
import model.ReportModel;
import model.UserModel;
import model.VisitorModel;
import model.dropDownFeederModel;


public class homeAdminGUI extends javax.swing.JFrame {
    private static int updateRow;
    private static int referenceState;
    int mousePx;
    int mousePy;

    public homeAdminGUI(String userRole) {
        initComponents();
        setUndecorated(true);
        
        setBackground(new Color(0,0,0,0));
        TableCellListener tcl0 = new TableCellListener(viewAppointmentTable, action);
        TableCellListener tcl1 = new TableCellListener(viewVisitorsRecordTable, action);
        TableCellListener tcl2 = new TableCellListener(ComplainViewTable, action);
        TableCellListener tcl3 = new TableCellListener(viewRecivedTable, action);
        TableCellListener tcl4 = new TableCellListener(viewDispatchTable, action);
        TableCellListener tcl5 = new TableCellListener(patientDetailsTable, action);
        TableCellListener tcl6 = new TableCellListener(MedicalOfficersTable, action);
        TableCellListener tcl7 = new TableCellListener(ReceptiontistTable, action);
        TableCellListener tcl8 = new TableCellListener(userLoginTable, action);

        //digital clock start----------------------------------
        new Thread(){
            public void run(){
                
                while(true){
                  
                    Calendar cal=new GregorianCalendar();
                    int hour=cal.get(Calendar.HOUR);
                    int min=cal.get(Calendar.MINUTE);
                    int sec=cal.get(Calendar.SECOND);
                  
                    int AM_PM=cal.get(Calendar.AM_PM);
                    String Am_Pm="";
                    if(AM_PM==1){
                        Am_Pm="PM";
                        if(hour==0){
                            hour+=12;
                        }
                    }
                    else{
                        Am_Pm="AM";
                    }
                   headerTextClock.setText(""+hour+":"+min+":"+sec+" "+Am_Pm);
                   mainClockHours.setText(""+hour+"");
                   mainClockMinutes.setText(""+min+"");
                   mainClockSeconds.setText(""+sec+"");
                   mainClockAMPM.setText(Am_Pm);
                }
            }
        }.start();
        //digital clock end------------------------------------
        //-----------------------------------------------------
        date todayObj=new date();
        calenderYear.setText(""+todayObj.getYear()+"");
        calenderMonth.setText("/"+todayObj.getMonth()+"");
        calenderDay.setText("/"+todayObj.getDay()+"");
        //-----------------------------------------------------
        //intialy hide sections
        if(userType.getSelectedItem()=="Patient"){
            emailLabel.setVisible(false);
            emailText.setVisible(false);
            StaffIDLabel.setVisible(false);
            AddNewStaffID.setVisible(false);
            AddNewUserSpecializedAreaDropDown.setVisible(false);
            AddNewUserSpecializedAreaLabel.setVisible(false);
        }
        //intially disable btn
        //appointment section
        deleteConformationYes.setVisible(false);
        deleteConformationNo.setVisible(false);
        
        AppIntialDeleteBtn.setEnabled(false);
        AppIntialSaveBtn.setEnabled(false);
        //visitors section
        deleteVisitorRecordConformationYes.setVisible(false);
        deleteVisitorRecordConformationNo.setVisible(false);
        
        //recived
        RecievedDeleteConformationYes.setVisible(false);
        RecievedDeleteConformationNo.setVisible(false);
        
        //dispatch
        DispatchDeleteConformationYes.setVisible(false);
        DispatchDeleteConformationNo.setVisible(false);
        
        //complain
        deleteComplainConformationYes.setVisible(false);
        deleteComplainConformationNo.setVisible(false);
        
        //patient
        patientDeleteConformationYes.setVisible(false);
        patientDeleteConformationNo.setVisible(false);
        
        //medical officer
        medicalDeleteConformationYes.setVisible(false);
        medicalDeleteConformationNo.setVisible(false);
        
        //receptionist
        receptionConformationYes.setVisible(false);
        receptionConformationNo.setVisible(false);
        
        //login 
        loginDetailsConformationYes.setVisible(false);
        loginDetailsConformationNo.setVisible(false);
        //reference
        referenceDeleteConformationYes.setVisible(false);
        referenceDeleteConformationNo.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        marriedState = new javax.swing.ButtonGroup();
        curvedMainPannel = new keeptoo.KGradientPanel();
        header = new javax.swing.JPanel();
        closeMaxMinPanel = new javax.swing.JPanel();
        closeBtn = new keeptoo.KGradientPanel();
        maximumBtn = new keeptoo.KGradientPanel();
        minimumBtn = new keeptoo.KGradientPanel();
        jPanel35 = new javax.swing.JPanel();
        headerTextClock = new javax.swing.JLabel();
        headerTextMain = new javax.swing.JLabel();
        sideMenu = new javax.swing.JPanel();
        appointment = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        visitors = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        postal = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        complain = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        reference = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        user = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        report = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        home = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        homePannel = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        mainClockSeconds = new javax.swing.JLabel();
        minutesHome = new keeptoo.KGradientPanel();
        mainClockMinutes = new javax.swing.JLabel();
        hourHome = new keeptoo.KGradientPanel();
        mainClockHours = new javax.swing.JLabel();
        mainClockAMPM = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        calenderMonth = new javax.swing.JLabel();
        calenderYear = new javax.swing.JLabel();
        calenderDay = new javax.swing.JLabel();
        appPanel = new javax.swing.JPanel();
        viewAppointmentBtn = new javax.swing.JTabbedPane();
        newAppPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        addNewAppointmentSymptoms = new javax.swing.JTextField();
        addNewAppointmentPatientName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        AddNewAppointmentBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        AddNewAppointmentAMPM = new javax.swing.JComboBox<>();
        AddNewAppointmentMinutes = new javax.swing.JSpinner();
        AddNewAppointmentHours = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        MedicalOfficerDropDown = new javax.swing.JComboBox<>();
        addNewAppointmentDay = new javax.swing.JSpinner();
        addNewAppointmentMonth = new javax.swing.JSpinner();
        addNewAppointmentYear = new javax.swing.JSpinner();
        AddNewAppointmnetSpecializedAreaDropDown = new javax.swing.JComboBox<>();
        AddNewUserSpecializedAreaLabel1 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        addNewAppointmentNotficationLabel = new javax.swing.JLabel();
        viewAppPanel = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        AppIntialSaveBtn = new javax.swing.JButton();
        AppIntialDeleteBtn = new javax.swing.JButton();
        areYouWantToDelete = new javax.swing.JLabel();
        deleteConformationYes = new javax.swing.JButton();
        deleteConformationNo = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        viewAppointmentTable = new javax.swing.JTable();
        visitorsPanel = new javax.swing.JPanel();
        viewVisitorsBtn = new javax.swing.JTabbedPane();
        addVisitors = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        VisitorRecordNotification = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        VisitorRecordNIC = new javax.swing.JTextField();
        VisitorRecordName = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        AddNewVisitorRecord = new javax.swing.JButton();
        VisitorRecordPurpose = new javax.swing.JTextField();
        VisitorRecordAmPmState = new javax.swing.JComboBox<>();
        VisitorRecordOutMinutes = new javax.swing.JSpinner();
        VisitorRecordOutHours = new javax.swing.JSpinner();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        VisitorRecordPhoneNo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        VisitorRecordNote = new javax.swing.JTextArea();
        viewVisitors = new javax.swing.JPanel();
        viewVisitorsTable = new javax.swing.JScrollPane();
        viewVisitorsRecordTable = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        visitorUpdateIntialBtn = new javax.swing.JButton();
        VisitorIntialDeleteBtn = new javax.swing.JButton();
        VisitorAreYouWantToDelete = new javax.swing.JLabel();
        deleteVisitorRecordConformationYes = new javax.swing.JButton();
        deleteVisitorRecordConformationNo = new javax.swing.JButton();
        postalPanel = new javax.swing.JPanel();
        ViewRecievedDispatchPost = new javax.swing.JTabbedPane();
        recievedTab = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        recievedPostNotification = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        RecievedPostFrom = new javax.swing.JTextField();
        RecievedPostRefNo = new javax.swing.JTextField();
        RecievedPostAddress = new javax.swing.JTextField();
        RecievedPostTo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        RecievedPostNote = new javax.swing.JTextArea();
        RecievedPostDay = new javax.swing.JSpinner();
        RecievedPostMonth = new javax.swing.JSpinner();
        RecievedPostYear = new javax.swing.JSpinner();
        AddNewRecievedPost = new javax.swing.JButton();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        dispatchTab = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        dispatchPostNotification = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        DispatchPostTo = new javax.swing.JTextField();
        DispatchPostRefNo = new javax.swing.JTextField();
        DispatchPostAddress = new javax.swing.JTextField();
        DispatchPostFrom = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        DispatchPostNote = new javax.swing.JTextArea();
        DispatchPostDay = new javax.swing.JSpinner();
        DispatchPostMonth = new javax.swing.JSpinner();
        DispatchPostYear = new javax.swing.JSpinner();
        AddNewDispatchPost = new javax.swing.JButton();
        viewRecivedTab = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        viewRecivedTable = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        recievedUpdateBtn = new javax.swing.JButton();
        RecivedPostIntialDeleteBtn = new javax.swing.JButton();
        recievedAreYouWantToDelete = new javax.swing.JLabel();
        RecievedDeleteConformationYes = new javax.swing.JButton();
        RecievedDeleteConformationNo = new javax.swing.JButton();
        viewDispatchTab = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        viewDispatchTable = new javax.swing.JTable();
        jPanel28 = new javax.swing.JPanel();
        dispatchUpdateBtn = new javax.swing.JButton();
        DispatchIntialDeleteBtn = new javax.swing.JButton();
        dispatchAreYouWantToDelete = new javax.swing.JLabel();
        DispatchDeleteConformationYes = new javax.swing.JButton();
        DispatchDeleteConformationNo = new javax.swing.JButton();
        complainPanel = new javax.swing.JPanel();
        viewComplainBtn = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        complainWarning = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        AddNewComplainName = new javax.swing.JTextField();
        AddNewComplainPhoneNumber = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        AddNewComplainDesTextArea = new javax.swing.JTextArea();
        AddNewComplainBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        AddNewComplainNote = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        AddNewComplainReferenceDepartment = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ComplainViewTable = new javax.swing.JTable();
        jPanel29 = new javax.swing.JPanel();
        complainUpdateSaveBtn = new javax.swing.JButton();
        ComplainDeleteIntialBtn = new javax.swing.JButton();
        ComplainAreYouWantToDelete = new javax.swing.JLabel();
        deleteComplainConformationYes = new javax.swing.JButton();
        deleteComplainConformationNo = new javax.swing.JButton();
        referencePanel = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        referenceNotification = new javax.swing.JLabel();
        referenceDeleteConformationYes = new javax.swing.JButton();
        referenceDeleteConformationNo = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        avalaibleDepartmentDropDown = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        addNewComplainDepartment = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        addNewComplainDepartmentBtn = new javax.swing.JButton();
        addNewSpecialistArea = new javax.swing.JTextField();
        specializedAreaDropDown = new javax.swing.JComboBox<>();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        addNewSpecialistAreaBtn = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        deleteComplainDepartment = new javax.swing.JComboBox<>();
        deleteComplainBtn = new javax.swing.JButton();
        jLabel84 = new javax.swing.JLabel();
        deleteSpecialArea = new javax.swing.JComboBox<>();
        deleteSpecialAreaBtn = new javax.swing.JButton();
        userPanel = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        addNewUserFormNotificationLabel = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        AddNewUserGenderFemale = new javax.swing.JRadioButton();
        jLabel59 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        addNewUserLastName = new javax.swing.JTextField();
        addNewUserPhoneNo = new javax.swing.JTextField();
        addNewUserName = new javax.swing.JTextField();
        addNewUserFirstName = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        addNewUserNIC = new javax.swing.JTextField();
        userType = new javax.swing.JComboBox<>();
        AddNewUserGenderMale = new javax.swing.JRadioButton();
        jLabel66 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        AddNewUserDOBMoth = new javax.swing.JSpinner();
        AddNewUserDOBYear = new javax.swing.JSpinner();
        AddNewUserDOBDay = new javax.swing.JSpinner();
        jLabel60 = new javax.swing.JLabel();
        allergiesLabel = new javax.swing.JLabel();
        addNewUserAllergies = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        AddNewUserSpecializedAreaLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        StaffIDLabel = new javax.swing.JLabel();
        addNewUserAddress = new javax.swing.JScrollPane();
        addNewUserAddressTextArea = new javax.swing.JTextArea();
        jLabel65 = new javax.swing.JLabel();
        AddNewUserSpecializedAreaDropDown = new javax.swing.JComboBox<>();
        addNewUserBtn = new javax.swing.JButton();
        AddNewStaffID = new javax.swing.JTextField();
        bloodG = new javax.swing.JLabel();
        bloodSel = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        addNewUserMarriedState = new javax.swing.JRadioButton();
        addNewUserUnMarriedState = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        patientDetailsTab = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        patientDetailsTable = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        patientUpdateBtn = new javax.swing.JButton();
        patientIntialDeleteBtn = new javax.swing.JButton();
        patientAreYouWantToDelete = new javax.swing.JLabel();
        patientDeleteConformationYes = new javax.swing.JButton();
        patientDeleteConformationNo = new javax.swing.JButton();
        resetPatientPassword = new javax.swing.JButton();
        MedicalOfficersDetailsViewTab = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        MedicalOfficersTable = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        MedicalOfficerUpdateBtn = new javax.swing.JButton();
        medicalIntialDeleteBtn = new javax.swing.JButton();
        medicalAreYouWantDelete = new javax.swing.JLabel();
        medicalDeleteConformationYes = new javax.swing.JButton();
        medicalDeleteConformationNo = new javax.swing.JButton();
        resetMedicalOfficerPassword = new javax.swing.JButton();
        ReceptiontistDetailsViewTab = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        ReceptiontistTable = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        receptionistUpdateBtn = new javax.swing.JButton();
        receptionIntialDeleteBtn = new javax.swing.JButton();
        receptionAreYouWantToDelete = new javax.swing.JLabel();
        receptionConformationYes = new javax.swing.JButton();
        receptionConformationNo = new javax.swing.JButton();
        resetReceptionPassword = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        userLoginUpdateSaveBtn = new javax.swing.JButton();
        loginDetailsIntialDeleteBtn = new javax.swing.JButton();
        loginDetailsAreYouWantToDelete = new javax.swing.JLabel();
        loginDetailsConformationYes = new javax.swing.JButton();
        loginDetailsConformationNo = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        userLoginTable = new javax.swing.JTable();
        reportPanel = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        saveToPdfApp = new javax.swing.JButton();
        saveToJson = new javax.swing.JButton();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        pdfMedicalOfficersDropDown = new javax.swing.JComboBox<>();
        jLabel94 = new javax.swing.JLabel();
        saveToJson1 = new javax.swing.JButton();
        jLabel95 = new javax.swing.JLabel();
        saveToJson2 = new javax.swing.JButton();
        jLabel96 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        reportNotification = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        curvedMainPannel.setBackground(new java.awt.Color(255, 255, 255));
        curvedMainPannel.setkBorderRadius(60);
        curvedMainPannel.setkEndColor(new java.awt.Color(255, 255, 255));
        curvedMainPannel.setkStartColor(new java.awt.Color(255, 255, 255));
        curvedMainPannel.setOpaque(false);
        curvedMainPannel.setPreferredSize(new java.awt.Dimension(900, 700));
        curvedMainPannel.setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(0, 153, 255));
        header.setForeground(new java.awt.Color(60, 63, 65));
        header.setOpaque(false);
        header.setPreferredSize(new java.awt.Dimension(800, 40));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        header.setLayout(new java.awt.BorderLayout());

        closeMaxMinPanel.setBackground(new java.awt.Color(0, 102, 255));
        closeMaxMinPanel.setMinimumSize(new java.awt.Dimension(250, 40));
        closeMaxMinPanel.setOpaque(false);

        closeBtn.setkBorderRadius(20);
        closeBtn.setkEndColor(new java.awt.Color(255, 0, 153));
        closeBtn.setkStartColor(new java.awt.Color(255, 0, 102));
        closeBtn.setOpaque(false);
        closeBtn.setPreferredSize(new java.awt.Dimension(100, 15));
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout closeBtnLayout = new javax.swing.GroupLayout(closeBtn);
        closeBtn.setLayout(closeBtnLayout);
        closeBtnLayout.setHorizontalGroup(
            closeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        closeBtnLayout.setVerticalGroup(
            closeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        maximumBtn.setkEndColor(new java.awt.Color(255, 204, 51));
        maximumBtn.setkStartColor(new java.awt.Color(255, 153, 0));
        maximumBtn.setOpaque(false);
        maximumBtn.setPreferredSize(new java.awt.Dimension(100, 15));
        maximumBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maximumBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout maximumBtnLayout = new javax.swing.GroupLayout(maximumBtn);
        maximumBtn.setLayout(maximumBtnLayout);
        maximumBtnLayout.setHorizontalGroup(
            maximumBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        maximumBtnLayout.setVerticalGroup(
            maximumBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        minimumBtn.setForeground(new java.awt.Color(204, 204, 204));
        minimumBtn.setkEndColor(new java.awt.Color(0, 255, 204));
        minimumBtn.setkStartColor(new java.awt.Color(0, 255, 204));
        minimumBtn.setOpaque(false);
        minimumBtn.setPreferredSize(new java.awt.Dimension(100, 15));
        minimumBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimumBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout minimumBtnLayout = new javax.swing.GroupLayout(minimumBtn);
        minimumBtn.setLayout(minimumBtnLayout);
        minimumBtnLayout.setHorizontalGroup(
            minimumBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        minimumBtnLayout.setVerticalGroup(
            minimumBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout closeMaxMinPanelLayout = new javax.swing.GroupLayout(closeMaxMinPanel);
        closeMaxMinPanel.setLayout(closeMaxMinPanelLayout);
        closeMaxMinPanelLayout.setHorizontalGroup(
            closeMaxMinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closeMaxMinPanelLayout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(minimumBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maximumBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        closeMaxMinPanelLayout.setVerticalGroup(
            closeMaxMinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(closeMaxMinPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(closeMaxMinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimumBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maximumBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        header.add(closeMaxMinPanel, java.awt.BorderLayout.LINE_END);

        jPanel35.setBackground(new java.awt.Color(0, 102, 255));
        jPanel35.setOpaque(false);
        jPanel35.setPreferredSize(new java.awt.Dimension(750, 40));

        headerTextClock.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        headerTextClock.setForeground(new java.awt.Color(0, 102, 255));
        headerTextClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        headerTextMain.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        headerTextMain.setForeground(new java.awt.Color(0, 102, 255));
        headerTextMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTextMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_25px.png"))); // NOI18N
        headerTextMain.setText("Admin Dashboard");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(headerTextMain)
                .addGap(39, 39, 39)
                .addComponent(headerTextClock, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerTextClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(headerTextMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        header.add(jPanel35, java.awt.BorderLayout.CENTER);

        curvedMainPannel.add(header, java.awt.BorderLayout.PAGE_START);

        sideMenu.setBackground(new java.awt.Color(241, 246, 253));
        sideMenu.setPreferredSize(new java.awt.Dimension(200, 620));
        sideMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointment.setBackground(new java.awt.Color(0, 210, 255));
        appointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIconClick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                appointmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                appointmentMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_health_checkup_15px.png"))); // NOI18N
        jLabel2.setLabelFor(appointment);
        jLabel2.setText("Appointment");

        javax.swing.GroupLayout appointmentLayout = new javax.swing.GroupLayout(appointment);
        appointment.setLayout(appointmentLayout);
        appointmentLayout.setHorizontalGroup(
            appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appointmentLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        appointmentLayout.setVerticalGroup(
            appointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        sideMenu.add(appointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, 50));

        visitors.setBackground(new java.awt.Color(0, 159, 255));
        visitors.setPreferredSize(new java.awt.Dimension(200, 50));
        visitors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIconClick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                visitorsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                visitorsMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_waiting_room_15px.png"))); // NOI18N
        jLabel3.setLabelFor(visitors);
        jLabel3.setText("Visitors");

        javax.swing.GroupLayout visitorsLayout = new javax.swing.GroupLayout(visitors);
        visitors.setLayout(visitorsLayout);
        visitorsLayout.setHorizontalGroup(
            visitorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visitorsLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(65, 65, 65))
        );
        visitorsLayout.setVerticalGroup(
            visitorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        sideMenu.add(visitors, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 50));

        postal.setBackground(new java.awt.Color(0, 120, 255));
        postal.setPreferredSize(new java.awt.Dimension(200, 50));
        postal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIconClick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                postalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                postalMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_postcard_15px.png"))); // NOI18N
        jLabel4.setLabelFor(postal);
        jLabel4.setText("Postal");

        javax.swing.GroupLayout postalLayout = new javax.swing.GroupLayout(postal);
        postal.setLayout(postalLayout);
        postalLayout.setHorizontalGroup(
            postalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postalLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        postalLayout.setVerticalGroup(
            postalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        sideMenu.add(postal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, 50));

        complain.setBackground(new java.awt.Color(0, 81, 255));
        complain.setPreferredSize(new java.awt.Dimension(200, 50));
        complain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIconClick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                complainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                complainMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_documents_15px.png"))); // NOI18N
        jLabel5.setLabelFor(complain);
        jLabel5.setText("Complain");
        jLabel5.setMaximumSize(new java.awt.Dimension(94, 50));
        jLabel5.setName(""); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(94, 50));

        javax.swing.GroupLayout complainLayout = new javax.swing.GroupLayout(complain);
        complain.setLayout(complainLayout);
        complainLayout.setHorizontalGroup(
            complainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(complainLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        complainLayout.setVerticalGroup(
            complainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sideMenu.add(complain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, 50));

        reference.setBackground(new java.awt.Color(95, 0, 231));
        reference.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIconClick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                referenceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                referenceMouseExited(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_postcard_15px.png"))); // NOI18N
        jLabel46.setLabelFor(complain);
        jLabel46.setText("Reference");
        jLabel46.setPreferredSize(new java.awt.Dimension(98, 50));

        javax.swing.GroupLayout referenceLayout = new javax.swing.GroupLayout(reference);
        reference.setLayout(referenceLayout);
        referenceLayout.setHorizontalGroup(
            referenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(referenceLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        referenceLayout.setVerticalGroup(
            referenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sideMenu.add(reference, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 200, 50));

        user.setBackground(new java.awt.Color(159, 2, 221));
        user.setPreferredSize(new java.awt.Dimension(200, 50));
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIconClick(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userMouseExited(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_15px_1.png"))); // NOI18N
        jLabel47.setLabelFor(complain);
        jLabel47.setText("User");
        jLabel47.setPreferredSize(new java.awt.Dimension(57, 50));

        javax.swing.GroupLayout userLayout = new javax.swing.GroupLayout(user);
        user.setLayout(userLayout);
        userLayout.setHorizontalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        userLayout.setVerticalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sideMenu.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 200, 50));

        report.setBackground(new java.awt.Color(217, 12, 254));
        report.setPreferredSize(new java.awt.Dimension(200, 50));
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIconClick(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_documents_15px.png"))); // NOI18N
        jLabel48.setLabelFor(complain);
        jLabel48.setText("Report");

        javax.swing.GroupLayout reportLayout = new javax.swing.GroupLayout(report);
        report.setLayout(reportLayout);
        reportLayout.setHorizontalGroup(
            reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(77, 77, 77))
        );
        reportLayout.setVerticalGroup(
            reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        sideMenu.add(report, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 200, 50));

        home.setBackground(new java.awt.Color(0, 204, 204));
        home.setPreferredSize(new java.awt.Dimension(200, 50));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuIconClick(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_home_15px_1.png"))); // NOI18N
        jLabel75.setText("Home");
        jLabel75.setPreferredSize(new java.awt.Dimension(68, 50));

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sideMenu.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        logOutBtn.setBackground(new java.awt.Color(255, 0, 102));
        logOutBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        logOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logOutBtn.setText("Logout");
        logOutBtn.setPreferredSize(new java.awt.Dimension(160, 30));
        logOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtnMouseClicked(evt);
            }
        });
        sideMenu.add(logOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 180, 30));

        curvedMainPannel.add(sideMenu, java.awt.BorderLayout.LINE_START);

        content.setPreferredSize(new java.awt.Dimension(850, 620));
        content.setLayout(new java.awt.CardLayout());

        homePannel.setPreferredSize(new java.awt.Dimension(700, 620));
        homePannel.setLayout(new java.awt.BorderLayout());

        jPanel36.setBackground(new java.awt.Color(0, 102, 255));
        jPanel36.setPreferredSize(new java.awt.Dimension(700, 30));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        homePannel.add(jPanel36, java.awt.BorderLayout.PAGE_START);

        jPanel37.setBackground(new java.awt.Color(0, 102, 255));
        jPanel37.setPreferredSize(new java.awt.Dimension(700, 30));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        homePannel.add(jPanel37, java.awt.BorderLayout.PAGE_END);

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel1.setkBorderRadius(120);
        kGradientPanel1.setkGradientFocus(200);
        kGradientPanel1.setOpaque(false);
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(81, 81));

        mainClockSeconds.setFont(new java.awt.Font("Oswald", 0, 48)); // NOI18N
        mainClockSeconds.setForeground(new java.awt.Color(255, 255, 255));
        mainClockSeconds.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainClockSeconds.setText("00");
        mainClockSeconds.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainClockSeconds, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainClockSeconds, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );

        minutesHome.setkBorderRadius(120);
        minutesHome.setkEndColor(new java.awt.Color(9, 238, 221));
        minutesHome.setkGradientFocus(200);
        minutesHome.setkStartColor(new java.awt.Color(51, 102, 255));
        minutesHome.setkTransparentControls(false);
        minutesHome.setOpaque(false);

        mainClockMinutes.setFont(new java.awt.Font("Oswald", 0, 48)); // NOI18N
        mainClockMinutes.setForeground(new java.awt.Color(255, 255, 255));
        mainClockMinutes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainClockMinutes.setText("00");
        mainClockMinutes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout minutesHomeLayout = new javax.swing.GroupLayout(minutesHome);
        minutesHome.setLayout(minutesHomeLayout);
        minutesHomeLayout.setHorizontalGroup(
            minutesHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainClockMinutes, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );
        minutesHomeLayout.setVerticalGroup(
            minutesHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainClockMinutes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );

        hourHome.setkBorderRadius(120);
        hourHome.setkEndColor(new java.awt.Color(9, 238, 221));
        hourHome.setkGradientFocus(200);
        hourHome.setkStartColor(new java.awt.Color(0, 51, 255));
        hourHome.setkTransparentControls(false);
        hourHome.setOpaque(false);
        hourHome.setPreferredSize(new java.awt.Dimension(120, 120));

        mainClockHours.setFont(new java.awt.Font("Oswald", 0, 48)); // NOI18N
        mainClockHours.setForeground(new java.awt.Color(255, 255, 255));
        mainClockHours.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainClockHours.setText("00");
        mainClockHours.setToolTipText("");
        mainClockHours.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout hourHomeLayout = new javax.swing.GroupLayout(hourHome);
        hourHome.setLayout(hourHomeLayout);
        hourHomeLayout.setHorizontalGroup(
            hourHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainClockHours, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );
        hourHomeLayout.setVerticalGroup(
            hourHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainClockHours, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );

        mainClockAMPM.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        mainClockAMPM.setForeground(new java.awt.Color(0, 102, 255));
        mainClockAMPM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainClockAMPM.setText("AM");
        mainClockAMPM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel85.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(153, 153, 153));
        jLabel85.setText("MEDICAL INFO SYS");

        jLabel86.setFont(new java.awt.Font("Montserrat", 0, 48)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 102, 255));
        jLabel86.setText("WELCOME!");

        jLabel87.setFont(new java.awt.Font("Montserrat", 0, 60)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 102, 255));
        jLabel87.setText(":");

        jLabel88.setFont(new java.awt.Font("Montserrat", 0, 60)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 102, 255));
        jLabel88.setText(":");

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home_main.png"))); // NOI18N

        calenderMonth.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        calenderMonth.setForeground(new java.awt.Color(153, 153, 153));
        calenderMonth.setText("01");

        calenderYear.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        calenderYear.setForeground(new java.awt.Color(153, 153, 153));
        calenderYear.setText("2021");
        calenderYear.setPreferredSize(new java.awt.Dimension(100, 30));

        calenderDay.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        calenderDay.setForeground(new java.awt.Color(153, 153, 153));
        calenderDay.setText("01");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel38Layout.createSequentialGroup()
                            .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(79, 79, 79))
                        .addGroup(jPanel38Layout.createSequentialGroup()
                            .addComponent(hourHome, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel87)
                            .addGap(12, 12, 12)
                            .addComponent(minutesHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel88)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mainClockAMPM)
                                .addComponent(calenderYear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(calenderMonth)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(calenderDay)))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel85)
                            .addComponent(jLabel86))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(107, 107, 107))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel85)
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minutesHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87)
                    .addComponent(jLabel88)
                    .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel38Layout.createSequentialGroup()
                            .addComponent(mainClockAMPM)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(calenderYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(calenderDay)
                                .addComponent(calenderMonth)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hourHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        homePannel.add(jPanel38, java.awt.BorderLayout.CENTER);

        content.add(homePannel, "card9");

        appPanel.setBackground(new java.awt.Color(241, 246, 253));
        appPanel.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        appPanel.setPreferredSize(new java.awt.Dimension(700, 620));
        appPanel.setLayout(new java.awt.BorderLayout());

        viewAppointmentBtn.setBackground(new java.awt.Color(255, 255, 255));
        viewAppointmentBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        viewAppointmentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewAppointmentBtnMouseClicked(evt);
            }
        });

        newAppPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(241, 246, 253));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 531));

        addNewAppointmentSymptoms.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        addNewAppointmentSymptoms.setPreferredSize(null);

        addNewAppointmentPatientName.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        addNewAppointmentPatientName.setMinimumSize(new java.awt.Dimension(64, 30));
        addNewAppointmentPatientName.setPreferredSize(null);

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel8.setText("Appointment Time");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel9.setText("Patient Name");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel11.setText("Symptoms");

        jLabel12.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel12.setText("Appointment Date");

        AddNewAppointmentBtn.setBackground(new java.awt.Color(95, 0, 231));
        AddNewAppointmentBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewAppointmentBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddNewAppointmentBtn.setText("Add Appointment");
        AddNewAppointmentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddNewAppointmentBtnMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel13.setText("Day");

        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel14.setText("Month");

        jLabel15.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel15.setText("Year");

        AddNewAppointmentAMPM.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewAppointmentAMPM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        AddNewAppointmentMinutes.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewAppointmentMinutes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        AddNewAppointmentHours.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewAppointmentHours.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabel16.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel16.setText("Hours");

        jLabel17.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel17.setText("Minutes");

        jLabel19.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel19.setText("Medical Officer");

        MedicalOfficerDropDown.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        MedicalOfficerDropDown.setForeground(new java.awt.Color(51, 51, 51));
        MedicalOfficerDropDown.setPreferredSize(new java.awt.Dimension(52, 30));

        addNewAppointmentDay.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewAppointmentDay.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        addNewAppointmentMonth.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewAppointmentMonth.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        addNewAppointmentYear.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewAppointmentYear.setModel(new javax.swing.SpinnerNumberModel(2020, 2020, 2030, 1));

        AddNewAppointmnetSpecializedAreaDropDown.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewAppointmnetSpecializedAreaDropDown.setPreferredSize(new java.awt.Dimension(52, 30));
        AddNewAppointmnetSpecializedAreaDropDown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AddNewAppointmnetSpecializedAreaDropDownItemStateChanged(evt);
            }
        });

        AddNewUserSpecializedAreaLabel1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewUserSpecializedAreaLabel1.setText("Specialized Area");

        jLabel71.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel71.setText("Dr.");

        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_25px_2.png"))); // NOI18N

        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_doctor_male_25px.png"))); // NOI18N

        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_wheelchair_25px.png"))); // NOI18N

        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_runny_nose_25px.png"))); // NOI18N

        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_today_25px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addNewAppointmentPatientName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MedicalOfficerDropDown, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddNewUserSpecializedAreaLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddNewAppointmnetSpecializedAreaDropDown, javax.swing.GroupLayout.Alignment.LEADING, 0, 300, Short.MAX_VALUE)
                            .addComponent(addNewAppointmentSymptoms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(addNewAppointmentDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(addNewAppointmentMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(addNewAppointmentYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel12)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(AddNewAppointmentHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(AddNewAppointmentMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(AddNewAppointmentAMPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel17)))
                            .addComponent(AddNewAppointmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(0, 295, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(AddNewUserSpecializedAreaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AddNewAppointmnetSpecializedAreaDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MedicalOfficerDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addNewAppointmentPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel105))
                            .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(addNewAppointmentSymptoms, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addNewAppointmentDay)
                                    .addComponent(addNewAppointmentMonth)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addNewAppointmentYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddNewAppointmentHours)
                    .addComponent(AddNewAppointmentMinutes)
                    .addComponent(AddNewAppointmentAMPM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddNewAppointmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(597, 597, 597))
        );

        newAppPanel.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel33.setBackground(new java.awt.Color(95, 0, 231));
        jPanel33.setPreferredSize(new java.awt.Dimension(700, 45));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Add new Appointment");

        addNewAppointmentNotficationLabel.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewAppointmentNotficationLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addGap(67, 67, 67)
                .addComponent(addNewAppointmentNotficationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(addNewAppointmentNotficationLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        newAppPanel.add(jPanel33, java.awt.BorderLayout.PAGE_START);

        viewAppointmentBtn.addTab("Add Appointmet", newAppPanel);

        viewAppPanel.setBackground(new java.awt.Color(246, 250, 251));
        viewAppPanel.setLayout(new java.awt.BorderLayout());

        jPanel18.setBackground(new java.awt.Color(241, 246, 253));
        jPanel18.setPreferredSize(new java.awt.Dimension(700, 45));

        AppIntialSaveBtn.setBackground(new java.awt.Color(40, 167, 69));
        AppIntialSaveBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AppIntialSaveBtn.setForeground(new java.awt.Color(255, 255, 255));
        AppIntialSaveBtn.setText("Save");
        AppIntialSaveBtn.setPreferredSize(new java.awt.Dimension(72, 35));
        AppIntialSaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppIntialSaveBtnMouseClicked(evt);
            }
        });

        AppIntialDeleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        AppIntialDeleteBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AppIntialDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        AppIntialDeleteBtn.setText("Delete");
        AppIntialDeleteBtn.setPreferredSize(new java.awt.Dimension(78, 26));
        AppIntialDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AppIntialDeleteBtnMouseClicked(evt);
            }
        });

        areYouWantToDelete.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        deleteConformationYes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        deleteConformationYes.setText("Yes");
        deleteConformationYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteConformationYesMouseClicked(evt);
            }
        });

        deleteConformationNo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        deleteConformationNo.setText("No");
        deleteConformationNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteConformationNoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AppIntialSaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AppIntialDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(areYouWantToDelete)
                .addGap(27, 27, 27)
                .addComponent(deleteConformationYes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteConformationNo)
                .addGap(14, 14, 14))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AppIntialDeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(areYouWantToDelete)
                        .addComponent(deleteConformationYes)
                        .addComponent(deleteConformationNo))
                    .addComponent(AppIntialSaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        viewAppPanel.add(jPanel18, java.awt.BorderLayout.PAGE_START);

        viewAppointmentTable.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        viewAppointmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient name", "Medical Officer", "Appointment Date", "Appointment Time", "Symptoms", "Status", "AppRefID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        viewAppointmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewAppointmentTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(viewAppointmentTable);

        viewAppPanel.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        viewAppointmentBtn.addTab("View/Edit/Delete Appointment", viewAppPanel);

        appPanel.add(viewAppointmentBtn, java.awt.BorderLayout.CENTER);

        content.add(appPanel, "card2");

        visitorsPanel.setBackground(new java.awt.Color(241, 246, 253));
        visitorsPanel.setPreferredSize(new java.awt.Dimension(700, 620));
        visitorsPanel.setLayout(new java.awt.BorderLayout());

        viewVisitorsBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        viewVisitorsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewVisitorsBtnMouseClicked(evt);
            }
        });

        addVisitors.setPreferredSize(new java.awt.Dimension(700, 627));
        addVisitors.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(0, 159, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(700, 45));

        jLabel36.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Add new visitors Record");

        VisitorRecordNotification.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        VisitorRecordNotification.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(VisitorRecordNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(VisitorRecordNotification, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        addVisitors.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel9.setBackground(new java.awt.Color(241, 246, 253));

        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_25px_3.png"))); // NOI18N

        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_identity_theft_25px_1.png"))); // NOI18N

        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_question_mark_25px.png"))); // NOI18N

        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_phone_25px_2.png"))); // NOI18N

        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_time_25px.png"))); // NOI18N

        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_note_25px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel111))
                    .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );

        addVisitors.add(jPanel9, java.awt.BorderLayout.LINE_START);

        jPanel10.setBackground(new java.awt.Color(241, 246, 253));
        jPanel10.setPreferredSize(new java.awt.Dimension(600, 627));

        VisitorRecordNIC.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        VisitorRecordNIC.setPreferredSize(new java.awt.Dimension(303, 30));

        VisitorRecordName.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        VisitorRecordName.setPreferredSize(new java.awt.Dimension(303, 30));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("Visitors Note");

        jLabel38.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 51));
        jLabel38.setText("Visitors Phone No");

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setText("Visitors Name");

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 51, 51));
        jLabel40.setText("Visitors Purpose");

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 51, 51));
        jLabel41.setText("Visitors NIC");

        jLabel42.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 51, 51));
        jLabel42.setText("Visitor Out Time");

        AddNewVisitorRecord.setBackground(new java.awt.Color(0, 159, 255));
        AddNewVisitorRecord.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewVisitorRecord.setForeground(new java.awt.Color(255, 255, 255));
        AddNewVisitorRecord.setText("Add Record");
        AddNewVisitorRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddNewVisitorRecordMouseClicked(evt);
            }
        });

        VisitorRecordPurpose.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        VisitorRecordPurpose.setPreferredSize(new java.awt.Dimension(303, 30));

        VisitorRecordAmPmState.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        VisitorRecordAmPmState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        VisitorRecordOutMinutes.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        VisitorRecordOutMinutes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        VisitorRecordOutHours.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        VisitorRecordOutHours.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabel43.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel43.setText("Hours");

        jLabel44.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel44.setText("Minutes");

        VisitorRecordPhoneNo.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        VisitorRecordPhoneNo.setPreferredSize(new java.awt.Dimension(303, 30));

        VisitorRecordNote.setColumns(20);
        VisitorRecordNote.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        VisitorRecordNote.setRows(5);
        jScrollPane3.setViewportView(VisitorRecordNote);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel42)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(VisitorRecordOutHours, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel43))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel44)
                                .addComponent(VisitorRecordOutMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(VisitorRecordAmPmState, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(VisitorRecordPurpose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                        .addComponent(VisitorRecordName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VisitorRecordNIC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel40)
                        .addComponent(jLabel41)
                        .addComponent(jLabel37)
                        .addComponent(jLabel38)
                        .addComponent(jScrollPane3)
                        .addComponent(VisitorRecordPhoneNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddNewVisitorRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VisitorRecordName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VisitorRecordNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VisitorRecordPurpose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VisitorRecordPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VisitorRecordOutHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VisitorRecordOutMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VisitorRecordAmPmState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddNewVisitorRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        addVisitors.add(jPanel10, java.awt.BorderLayout.CENTER);

        viewVisitorsBtn.addTab("Add New Visitors", addVisitors);

        viewVisitors.setLayout(new java.awt.BorderLayout());

        viewVisitorsTable.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        viewVisitorsRecordTable.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        viewVisitorsRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Visitors NIC", "Visitors Name", "Visitors Purpose", "Phone No", "Date", "In Time", "Out Time", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        viewVisitorsRecordTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                viewVisitorsRecordTablePropertyChange(evt);
            }
        });
        viewVisitorsTable.setViewportView(viewVisitorsRecordTable);

        viewVisitors.add(viewVisitorsTable, java.awt.BorderLayout.CENTER);

        jPanel26.setBackground(new java.awt.Color(241, 246, 253));
        jPanel26.setPreferredSize(new java.awt.Dimension(700, 45));

        visitorUpdateIntialBtn.setBackground(new java.awt.Color(40, 167, 69));
        visitorUpdateIntialBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        visitorUpdateIntialBtn.setForeground(new java.awt.Color(255, 255, 255));
        visitorUpdateIntialBtn.setText("Save");
        visitorUpdateIntialBtn.setPreferredSize(new java.awt.Dimension(72, 35));
        visitorUpdateIntialBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visitorUpdateIntialBtnMouseClicked(evt);
            }
        });

        VisitorIntialDeleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        VisitorIntialDeleteBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        VisitorIntialDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        VisitorIntialDeleteBtn.setText("Delete");
        VisitorIntialDeleteBtn.setPreferredSize(new java.awt.Dimension(78, 26));
        VisitorIntialDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VisitorIntialDeleteBtnMouseClicked(evt);
            }
        });

        VisitorAreYouWantToDelete.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        deleteVisitorRecordConformationYes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        deleteVisitorRecordConformationYes.setText("Yes");
        deleteVisitorRecordConformationYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteVisitorRecordConformationYesMouseClicked(evt);
            }
        });
        deleteVisitorRecordConformationYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVisitorRecordConformationYesActionPerformed(evt);
            }
        });

        deleteVisitorRecordConformationNo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        deleteVisitorRecordConformationNo.setText("No");
        deleteVisitorRecordConformationNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteVisitorRecordConformationNoMouseClicked(evt);
            }
        });
        deleteVisitorRecordConformationNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVisitorRecordConformationNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(visitorUpdateIntialBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VisitorIntialDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(VisitorAreYouWantToDelete)
                .addGap(27, 27, 27)
                .addComponent(deleteVisitorRecordConformationYes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteVisitorRecordConformationNo)
                .addGap(14, 14, 14))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(VisitorIntialDeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(VisitorAreYouWantToDelete)
                        .addComponent(deleteVisitorRecordConformationYes)
                        .addComponent(deleteVisitorRecordConformationNo))
                    .addComponent(visitorUpdateIntialBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        viewVisitors.add(jPanel26, java.awt.BorderLayout.PAGE_START);

        viewVisitorsBtn.addTab("View/Edit/Delete Visitors", viewVisitors);

        visitorsPanel.add(viewVisitorsBtn, java.awt.BorderLayout.PAGE_START);

        content.add(visitorsPanel, "card3");

        postalPanel.setBackground(new java.awt.Color(241, 246, 253));
        postalPanel.setPreferredSize(new java.awt.Dimension(700, 620));
        postalPanel.setLayout(new java.awt.BorderLayout());

        ViewRecievedDispatchPost.setBackground(new java.awt.Color(255, 255, 255));
        ViewRecievedDispatchPost.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        ViewRecievedDispatchPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewRecievedDispatchPostMouseClicked(evt);
            }
        });

        recievedTab.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        recievedTab.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel14.setBackground(new java.awt.Color(0, 153, 153));
        jPanel14.setPreferredSize(new java.awt.Dimension(350, 45));

        jLabel55.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel55.setText("Add new Recieved Post");
        jLabel55.setPreferredSize(new java.awt.Dimension(219, 50));

        recievedPostNotification.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        recievedPostNotification.setPreferredSize(new java.awt.Dimension(45, 50));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addComponent(recievedPostNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(recievedPostNotification, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel14, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(241, 246, 253));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel6.setText("From");

        jLabel28.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel28.setText("Ref No");

        jLabel29.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel29.setText("Address");

        jLabel30.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel30.setText("To");

        jLabel31.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel31.setText("Note");

        jLabel32.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel32.setText("Date");

        jLabel33.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel33.setText("Day");

        jLabel34.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel34.setText("Month");

        jLabel35.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel35.setText("Year");

        RecievedPostFrom.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        RecievedPostFrom.setPreferredSize(new java.awt.Dimension(64, 30));

        RecievedPostRefNo.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        RecievedPostRefNo.setPreferredSize(new java.awt.Dimension(64, 30));

        RecievedPostAddress.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        RecievedPostAddress.setPreferredSize(new java.awt.Dimension(64, 30));

        RecievedPostTo.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        RecievedPostTo.setPreferredSize(new java.awt.Dimension(64, 30));

        RecievedPostNote.setColumns(20);
        RecievedPostNote.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        RecievedPostNote.setRows(5);
        jScrollPane1.setViewportView(RecievedPostNote);

        RecievedPostDay.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        RecievedPostDay.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        RecievedPostMonth.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        RecievedPostMonth.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        RecievedPostYear.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        RecievedPostYear.setModel(new javax.swing.SpinnerNumberModel(2000, 2000, 2050, 1));

        AddNewRecievedPost.setBackground(new java.awt.Color(0, 153, 153));
        AddNewRecievedPost.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewRecievedPost.setForeground(new java.awt.Color(255, 255, 255));
        AddNewRecievedPost.setText("Add Post");
        AddNewRecievedPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddNewRecievedPostMouseClicked(evt);
            }
        });

        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_google_calendar_25px_1.png"))); // NOI18N

        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_date_from_25px_1.png"))); // NOI18N

        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_touch_id_25px.png"))); // NOI18N

        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_home_address_25px_1.png"))); // NOI18N

        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_torrent_25px.png"))); // NOI18N

        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_note_25px_2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RecievedPostDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RecievedPostMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(RecievedPostYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RecievedPostTo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RecievedPostAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RecievedPostRefNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RecievedPostFrom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AddNewRecievedPost, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel32)
                                                            .addComponent(RecievedPostDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(RecievedPostMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(RecievedPostYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel33)
                                                            .addComponent(jLabel34)
                                                            .addComponent(jLabel35)))
                                                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(7, 7, 7)
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(RecievedPostFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6)))
                                            .addComponent(jLabel115, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(RecievedPostRefNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel28)))
                                    .addComponent(jLabel116, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RecievedPostAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29)))
                            .addComponent(jLabel117, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RecievedPostTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)))
                    .addComponent(jLabel118, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddNewRecievedPost, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel8, java.awt.BorderLayout.CENTER);

        recievedTab.add(jPanel5, java.awt.BorderLayout.CENTER);

        ViewRecievedDispatchPost.addTab("Recieved Post", recievedTab);

        dispatchTab.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(224, 49, 83));
        jPanel3.setPreferredSize(new java.awt.Dimension(850, 45));

        jLabel54.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel54.setText("Add new Dispatch Post");

        dispatchPostNotification.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        dispatchPostNotification.setPreferredSize(new java.awt.Dimension(45, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(dispatchPostNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dispatchPostNotification, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        dispatchTab.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel13.setBackground(new java.awt.Color(241, 246, 253));

        jLabel18.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel18.setText("To");

        jLabel20.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel20.setText("Ref No");

        jLabel21.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel21.setText("Address");

        jLabel22.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel22.setText("From");

        jLabel23.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel23.setText("Note");

        jLabel24.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel24.setText("Date");

        jLabel25.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel25.setText("Day");

        jLabel26.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel26.setText("Month");

        jLabel27.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel27.setText("Year");

        DispatchPostTo.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        DispatchPostTo.setPreferredSize(new java.awt.Dimension(64, 30));

        DispatchPostRefNo.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        DispatchPostRefNo.setPreferredSize(new java.awt.Dimension(64, 30));

        DispatchPostAddress.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        DispatchPostAddress.setPreferredSize(new java.awt.Dimension(64, 30));

        DispatchPostFrom.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        DispatchPostFrom.setPreferredSize(new java.awt.Dimension(64, 30));

        DispatchPostNote.setColumns(20);
        DispatchPostNote.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        DispatchPostNote.setRows(5);
        jScrollPane2.setViewportView(DispatchPostNote);

        DispatchPostDay.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        DispatchPostDay.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        DispatchPostMonth.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        DispatchPostMonth.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        DispatchPostYear.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        DispatchPostYear.setModel(new javax.swing.SpinnerNumberModel(2000, 2000, 2050, 1));

        AddNewDispatchPost.setBackground(new java.awt.Color(224, 49, 83));
        AddNewDispatchPost.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewDispatchPost.setForeground(new java.awt.Color(255, 255, 255));
        AddNewDispatchPost.setText("Add Post");
        AddNewDispatchPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddNewDispatchPostMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DispatchPostDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DispatchPostMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(DispatchPostYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(DispatchPostFrom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DispatchPostAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DispatchPostRefNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DispatchPostTo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AddNewDispatchPost, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(DispatchPostDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DispatchPostMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DispatchPostYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(7, 7, 7)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DispatchPostTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DispatchPostRefNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DispatchPostAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DispatchPostFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddNewDispatchPost, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        dispatchTab.add(jPanel13, java.awt.BorderLayout.CENTER);

        ViewRecievedDispatchPost.addTab("Dispatch Post", dispatchTab);

        viewRecivedTab.setLayout(new java.awt.BorderLayout());

        viewRecivedTable.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        viewRecivedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Refference No", "To", "From", "Address", "Note", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        viewRecivedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewRecivedTableMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(viewRecivedTable);

        viewRecivedTab.add(jScrollPane12, java.awt.BorderLayout.CENTER);

        jPanel27.setBackground(new java.awt.Color(241, 246, 253));
        jPanel27.setPreferredSize(new java.awt.Dimension(700, 45));

        recievedUpdateBtn.setBackground(new java.awt.Color(40, 167, 69));
        recievedUpdateBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        recievedUpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        recievedUpdateBtn.setText("Save");
        recievedUpdateBtn.setPreferredSize(new java.awt.Dimension(72, 35));
        recievedUpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recievedUpdateBtnMouseClicked(evt);
            }
        });

        RecivedPostIntialDeleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        RecivedPostIntialDeleteBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        RecivedPostIntialDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        RecivedPostIntialDeleteBtn.setText("Delete");
        RecivedPostIntialDeleteBtn.setPreferredSize(new java.awt.Dimension(78, 26));
        RecivedPostIntialDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecivedPostIntialDeleteBtnMouseClicked(evt);
            }
        });
        RecivedPostIntialDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecivedPostIntialDeleteBtnActionPerformed(evt);
            }
        });

        recievedAreYouWantToDelete.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        RecievedDeleteConformationYes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        RecievedDeleteConformationYes.setText("Yes");
        RecievedDeleteConformationYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecievedDeleteConformationYesMouseClicked(evt);
            }
        });
        RecievedDeleteConformationYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecievedDeleteConformationYesActionPerformed(evt);
            }
        });

        RecievedDeleteConformationNo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        RecievedDeleteConformationNo.setText("No");
        RecievedDeleteConformationNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecievedDeleteConformationNoMouseClicked(evt);
            }
        });
        RecievedDeleteConformationNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecievedDeleteConformationNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(recievedUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RecivedPostIntialDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(recievedAreYouWantToDelete)
                .addGap(27, 27, 27)
                .addComponent(RecievedDeleteConformationYes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RecievedDeleteConformationNo)
                .addGap(14, 14, 14))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RecivedPostIntialDeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(recievedAreYouWantToDelete)
                        .addComponent(RecievedDeleteConformationYes)
                        .addComponent(RecievedDeleteConformationNo))
                    .addComponent(recievedUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        viewRecivedTab.add(jPanel27, java.awt.BorderLayout.PAGE_START);

        ViewRecievedDispatchPost.addTab("View Recieved Post", viewRecivedTab);

        viewDispatchTab.setLayout(new java.awt.BorderLayout());

        jPanel20.setLayout(new java.awt.BorderLayout());

        viewDispatchTable.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        viewDispatchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Refference No", "To", "From", "Address", "Note", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane11.setViewportView(viewDispatchTable);

        jPanel20.add(jScrollPane11, java.awt.BorderLayout.CENTER);

        jPanel28.setBackground(new java.awt.Color(241, 246, 253));
        jPanel28.setPreferredSize(new java.awt.Dimension(700, 45));

        dispatchUpdateBtn.setBackground(new java.awt.Color(40, 167, 69));
        dispatchUpdateBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        dispatchUpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        dispatchUpdateBtn.setText("Save");
        dispatchUpdateBtn.setPreferredSize(new java.awt.Dimension(72, 35));
        dispatchUpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispatchUpdateBtnMouseClicked(evt);
            }
        });

        DispatchIntialDeleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        DispatchIntialDeleteBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        DispatchIntialDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        DispatchIntialDeleteBtn.setText("Delete");
        DispatchIntialDeleteBtn.setPreferredSize(new java.awt.Dimension(78, 26));
        DispatchIntialDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DispatchIntialDeleteBtnMouseClicked(evt);
            }
        });
        DispatchIntialDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DispatchIntialDeleteBtnActionPerformed(evt);
            }
        });

        dispatchAreYouWantToDelete.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        DispatchDeleteConformationYes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        DispatchDeleteConformationYes.setText("Yes");
        DispatchDeleteConformationYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DispatchDeleteConformationYesMouseClicked(evt);
            }
        });
        DispatchDeleteConformationYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DispatchDeleteConformationYesActionPerformed(evt);
            }
        });

        DispatchDeleteConformationNo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        DispatchDeleteConformationNo.setText("No");
        DispatchDeleteConformationNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DispatchDeleteConformationNoMouseClicked(evt);
            }
        });
        DispatchDeleteConformationNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DispatchDeleteConformationNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dispatchUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DispatchIntialDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(dispatchAreYouWantToDelete)
                .addGap(27, 27, 27)
                .addComponent(DispatchDeleteConformationYes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DispatchDeleteConformationNo)
                .addGap(14, 14, 14))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DispatchIntialDeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(dispatchAreYouWantToDelete)
                        .addComponent(DispatchDeleteConformationYes)
                        .addComponent(DispatchDeleteConformationNo))
                    .addComponent(dispatchUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel20.add(jPanel28, java.awt.BorderLayout.PAGE_START);

        viewDispatchTab.add(jPanel20, java.awt.BorderLayout.CENTER);

        ViewRecievedDispatchPost.addTab("View Dispatch Post ", viewDispatchTab);

        postalPanel.add(ViewRecievedDispatchPost, java.awt.BorderLayout.CENTER);

        content.add(postalPanel, "card4");

        complainPanel.setBackground(new java.awt.Color(241, 246, 253));
        complainPanel.setPreferredSize(new java.awt.Dimension(700, 620));
        complainPanel.setLayout(new java.awt.BorderLayout());

        viewComplainBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        viewComplainBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewComplainBtnMouseClicked(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(38, 99, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(700, 45));

        jLabel45.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Add new Complain");
        jLabel45.setPreferredSize(new java.awt.Dimension(176, 45));

        complainWarning.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(complainWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(complainWarning, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel11.setBackground(new java.awt.Color(241, 246, 253));

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 51, 51));
        jLabel51.setText("Your Name");

        AddNewComplainName.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        AddNewComplainName.setPreferredSize(new java.awt.Dimension(64, 30));

        AddNewComplainPhoneNumber.setFont(new java.awt.Font("Montserrat", 0, 15)); // NOI18N
        AddNewComplainPhoneNumber.setPreferredSize(new java.awt.Dimension(64, 30));

        AddNewComplainDesTextArea.setColumns(20);
        AddNewComplainDesTextArea.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewComplainDesTextArea.setRows(5);
        jScrollPane4.setViewportView(AddNewComplainDesTextArea);

        AddNewComplainBtn.setBackground(new java.awt.Color(38, 99, 255));
        AddNewComplainBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewComplainBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddNewComplainBtn.setText("Add Complain");
        AddNewComplainBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddNewComplainBtnMouseClicked(evt);
            }
        });

        AddNewComplainNote.setColumns(20);
        AddNewComplainNote.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewComplainNote.setRows(5);
        jScrollPane5.setViewportView(AddNewComplainNote);

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel1.setText("Phone Number");

        jLabel67.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel67.setText("Description");

        jLabel68.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel68.setText("Note");

        AddNewComplainReferenceDepartment.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewComplainReferenceDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Out-Patient & Front-Office Department", "Pathology Department", "Pharmacy Department", "Radiology Department", "Finance Department", "Human Resources Department" }));

        jLabel69.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel69.setText("Relvent Department");

        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_25px_2.png"))); // NOI18N

        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_mobile_25px.png"))); // NOI18N

        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_dropdown_field_25px.png"))); // NOI18N

        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_paste_as_text_25px.png"))); // NOI18N

        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_note_25px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67)
                    .addComponent(jLabel69)
                    .addComponent(jLabel1)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AddNewComplainReferenceDepartment, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddNewComplainPhoneNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddNewComplainName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AddNewComplainBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(AddNewComplainName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(AddNewComplainPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel69))
                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddNewComplainReferenceDepartment)
                    .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel68)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel100)
                        .addGap(91, 91, 91)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddNewComplainBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel11, java.awt.BorderLayout.CENTER);

        viewComplainBtn.addTab("Add New Complain", jPanel1);

        jPanel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel19.setLayout(new java.awt.BorderLayout());

        jScrollPane6.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        ComplainViewTable.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        ComplainViewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Complained By", "Phone No", "Date", "Description", "Action Take", "Note", "Refer Dept", "Refer No"
            }
        ));
        jScrollPane6.setViewportView(ComplainViewTable);

        jPanel19.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jPanel29.setBackground(new java.awt.Color(241, 246, 253));
        jPanel29.setPreferredSize(new java.awt.Dimension(700, 45));

        complainUpdateSaveBtn.setBackground(new java.awt.Color(40, 167, 69));
        complainUpdateSaveBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        complainUpdateSaveBtn.setForeground(new java.awt.Color(255, 255, 255));
        complainUpdateSaveBtn.setText("Save");
        complainUpdateSaveBtn.setPreferredSize(new java.awt.Dimension(72, 35));
        complainUpdateSaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                complainUpdateSaveBtnMouseClicked(evt);
            }
        });

        ComplainDeleteIntialBtn.setBackground(new java.awt.Color(220, 53, 69));
        ComplainDeleteIntialBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        ComplainDeleteIntialBtn.setForeground(new java.awt.Color(255, 255, 255));
        ComplainDeleteIntialBtn.setText("Delete");
        ComplainDeleteIntialBtn.setPreferredSize(new java.awt.Dimension(78, 26));
        ComplainDeleteIntialBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComplainDeleteIntialBtnMouseClicked(evt);
            }
        });

        ComplainAreYouWantToDelete.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        deleteComplainConformationYes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        deleteComplainConformationYes.setText("Yes");
        deleteComplainConformationYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteComplainConformationYesMouseClicked(evt);
            }
        });

        deleteComplainConformationNo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        deleteComplainConformationNo.setText("No");
        deleteComplainConformationNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteComplainConformationNoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(complainUpdateSaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComplainDeleteIntialBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(ComplainAreYouWantToDelete)
                .addGap(27, 27, 27)
                .addComponent(deleteComplainConformationYes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteComplainConformationNo)
                .addGap(14, 14, 14))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComplainDeleteIntialBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(ComplainAreYouWantToDelete)
                        .addComponent(deleteComplainConformationYes)
                        .addComponent(deleteComplainConformationNo))
                    .addComponent(complainUpdateSaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel19.add(jPanel29, java.awt.BorderLayout.PAGE_START);

        jPanel4.add(jPanel19, java.awt.BorderLayout.CENTER);

        viewComplainBtn.addTab("View/Edit/Delete Complain", jPanel4);

        complainPanel.add(viewComplainBtn, java.awt.BorderLayout.CENTER);

        content.add(complainPanel, "card5");

        referencePanel.setBackground(new java.awt.Color(255, 255, 255));
        referencePanel.setLayout(new java.awt.BorderLayout());

        jPanel42.setBackground(new java.awt.Color(95, 0, 231));
        jPanel42.setPreferredSize(new java.awt.Dimension(700, 45));

        jLabel79.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Add New Reference");

        referenceNotification.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        referenceNotification.setForeground(new java.awt.Color(255, 255, 255));

        referenceDeleteConformationYes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        referenceDeleteConformationYes.setText("Yes");
        referenceDeleteConformationYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                referenceDeleteConformationYesMouseClicked(evt);
            }
        });

        referenceDeleteConformationNo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        referenceDeleteConformationNo.setText("No");
        referenceDeleteConformationNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                referenceDeleteConformationNoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(referenceNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(referenceDeleteConformationYes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(referenceDeleteConformationNo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(referenceNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(referenceDeleteConformationYes)
                    .addComponent(referenceDeleteConformationNo))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        referencePanel.add(jPanel42, java.awt.BorderLayout.PAGE_START);

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));

        avalaibleDepartmentDropDown.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        avalaibleDepartmentDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Out-Patient & Front-Office Department", "Pathology Department", "Pharmacy Department", "Radiology Department", "Finance Department", "Human Resources Department" }));

        jLabel49.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel49.setText("Available Complain Departmets");

        addNewComplainDepartment.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        jLabel76.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel76.setText("Add New Complain Department");

        addNewComplainDepartmentBtn.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        addNewComplainDepartmentBtn.setText("Add");
        addNewComplainDepartmentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewComplainDepartmentBtnMouseClicked(evt);
            }
        });

        addNewSpecialistArea.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        specializedAreaDropDown.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        specializedAreaDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Physician", "Pediatrician", "Obstetrician", "Psychiatrist", "Cardiologist", "Dermatologist", "Gastroenterologist", "Ophthalmologist", "Neurologist", "Radiologist", "Anesthesiologist   " }));

        jLabel77.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel77.setText("Add New Specialist Area");

        jLabel78.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel78.setText("Available Specialist Area");

        addNewSpecialistAreaBtn.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        addNewSpecialistAreaBtn.setText("Add");
        addNewSpecialistAreaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewSpecialistAreaBtnMouseClicked(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel80.setText("Delete Complain Department");

        deleteComplainDepartment.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        deleteComplainDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        deleteComplainBtn.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        deleteComplainBtn.setText("Delete");
        deleteComplainBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteComplainBtnMouseClicked(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel84.setText("Delete Specialist Area");

        deleteSpecialArea.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        deleteSpecialArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        deleteSpecialAreaBtn.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        deleteSpecialAreaBtn.setText("Delete");
        deleteSpecialAreaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteSpecialAreaBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(deleteComplainBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(deleteComplainDepartment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(addNewSpecialistArea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                            .addComponent(addNewComplainDepartment, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(jLabel77)))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel49)
                                        .addComponent(avalaibleDepartmentDropDown, 0, 290, Short.MAX_VALUE)
                                        .addComponent(jLabel78)
                                        .addComponent(specializedAreaDropDown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(deleteSpecialArea, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel84)
                                    .addComponent(deleteSpecialAreaBtn)))
                            .addComponent(addNewComplainDepartmentBtn)
                            .addComponent(addNewSpecialistAreaBtn)
                            .addComponent(jLabel80))
                        .addGap(79, 79, 79))))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel76))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addNewComplainDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(avalaibleDepartmentDropDown))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addNewComplainDepartmentBtn)
                .addGap(37, 37, 37)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jLabel78))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(specializedAreaDropDown, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(addNewSpecialistArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addNewSpecialistAreaBtn)
                .addGap(66, 66, 66)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jLabel84))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteComplainDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteSpecialArea, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteComplainBtn)
                    .addComponent(deleteSpecialAreaBtn))
                .addContainerGap(181, Short.MAX_VALUE))
        );

        referencePanel.add(jPanel43, java.awt.BorderLayout.CENTER);

        content.add(referencePanel, "card6");

        userPanel.setBackground(new java.awt.Color(241, 246, 253));
        userPanel.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        userPanel.setPreferredSize(new java.awt.Dimension(700, 620));
        userPanel.setLayout(new java.awt.BorderLayout());

        jTabbedPane5.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jTabbedPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane5MouseClicked(evt);
            }
        });

        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel16.setBackground(new java.awt.Color(2, 127, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(700, 45));

        jLabel50.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Register new User");

        addNewUserFormNotificationLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        addNewUserFormNotificationLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel50)
                .addGap(169, 169, 169)
                .addComponent(addNewUserFormNotificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(addNewUserFormNotificationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel16, java.awt.BorderLayout.PAGE_START);

        jPanel17.setBackground(new java.awt.Color(241, 246, 253));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel21.setBackground(new java.awt.Color(241, 246, 253));
        jPanel21.setPreferredSize(new java.awt.Dimension(400, 542));

        jLabel57.setBackground(new java.awt.Color(255, 255, 255));
        jLabel57.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 102, 255));
        jLabel57.setText("First Name");

        genderGroup.add(AddNewUserGenderFemale);
        AddNewUserGenderFemale.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewUserGenderFemale.setForeground(new java.awt.Color(0, 102, 255));
        AddNewUserGenderFemale.setText("Female");

        jLabel59.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 102, 255));
        jLabel59.setText("Day");

        jLabel62.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 102, 255));
        jLabel62.setText("NIC No");

        jLabel64.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 102, 255));
        jLabel64.setText("User Type");

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 102, 255));
        jLabel53.setText("userName");

        jLabel61.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 102, 255));
        jLabel61.setText("Phone No");

        jLabel58.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 102, 255));
        jLabel58.setText("Year");

        addNewUserLastName.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewUserLastName.setMinimumSize(new java.awt.Dimension(80, 27));
        addNewUserLastName.setPreferredSize(new java.awt.Dimension(80, 27));

        addNewUserPhoneNo.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewUserPhoneNo.setPreferredSize(new java.awt.Dimension(64, 30));

        addNewUserName.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewUserName.setPreferredSize(new java.awt.Dimension(64, 30));

        addNewUserFirstName.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewUserFirstName.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 102, 255));
        jLabel56.setText("Last Name");

        addNewUserNIC.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewUserNIC.setPreferredSize(new java.awt.Dimension(64, 30));

        userType.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        userType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patient", "Receptionist", "Medical officer" }));
        userType.setPreferredSize(new java.awt.Dimension(147, 30));
        userType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                userTypeItemStateChanged(evt);
            }
        });

        genderGroup.add(AddNewUserGenderMale);
        AddNewUserGenderMale.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewUserGenderMale.setForeground(new java.awt.Color(0, 102, 255));
        AddNewUserGenderMale.setText("Male");

        jLabel66.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 102, 255));
        jLabel66.setText("Gender");

        jLabel52.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 255));
        jLabel52.setText("Birthday");

        AddNewUserDOBMoth.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewUserDOBMoth.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        AddNewUserDOBYear.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewUserDOBYear.setModel(new javax.swing.SpinnerNumberModel(1990, 1900, 2030, 1));

        AddNewUserDOBDay.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewUserDOBDay.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jLabel60.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 102, 255));
        jLabel60.setText("Month");

        allergiesLabel.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        allergiesLabel.setForeground(new java.awt.Color(0, 102, 255));
        allergiesLabel.setText("Allergies");

        addNewUserAllergies.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewUserAllergies.setPreferredSize(new java.awt.Dimension(64, 30));

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_25px_2.png"))); // NOI18N

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_mobile_25px.png"))); // NOI18N

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_identity_theft_25px.png"))); // NOI18N

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_birthday_25px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addNewUserPhoneNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addNewUserLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addNewUserFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addNewUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(178, 178, 178))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(allergiesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(188, 188, 188))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(197, 197, 197))
                            .addComponent(addNewUserNIC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(175, 175, 175))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(177, 177, 177))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(172, 172, 172))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(170, 170, 170))
                            .addComponent(addNewUserAllergies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(119, 119, 119))
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addComponent(jLabel52)
                                        .addGap(68, 68, 68))
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(126, 126, 126)))
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addComponent(AddNewUserGenderMale)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(AddNewUserGenderFemale))
                                    .addGroup(jPanel21Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel59)))))
                        .addGap(46, 46, 46))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddNewUserDOBYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(AddNewUserDOBMoth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(AddNewUserDOBDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userType, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(addNewUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addNewUserFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addNewUserLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addNewUserPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addNewUserNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddNewUserGenderMale)
                    .addComponent(AddNewUserGenderFemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddNewUserDOBYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddNewUserDOBMoth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddNewUserDOBDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel93, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allergiesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addNewUserAllergies, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jPanel17.add(jPanel21, java.awt.BorderLayout.LINE_START);

        jPanel34.setBackground(new java.awt.Color(241, 246, 253));
        jPanel34.setMinimumSize(new java.awt.Dimension(350, 542));
        jPanel34.setPreferredSize(new java.awt.Dimension(350, 542));

        AddNewUserSpecializedAreaLabel.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewUserSpecializedAreaLabel.setForeground(new java.awt.Color(0, 102, 255));
        AddNewUserSpecializedAreaLabel.setText("Specialized Area");

        emailLabel.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(0, 102, 255));
        emailLabel.setText("Email");

        emailText.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        emailText.setMaximumSize(new java.awt.Dimension(300, 30));
        emailText.setMinimumSize(new java.awt.Dimension(250, 24));
        emailText.setPreferredSize(new java.awt.Dimension(250, 30));

        StaffIDLabel.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        StaffIDLabel.setForeground(new java.awt.Color(0, 102, 255));
        StaffIDLabel.setText("Staff ID");

        addNewUserAddressTextArea.setColumns(20);
        addNewUserAddressTextArea.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewUserAddressTextArea.setRows(5);
        addNewUserAddressTextArea.setPreferredSize(new java.awt.Dimension(250, 80));
        addNewUserAddress.setViewportView(addNewUserAddressTextArea);

        jLabel65.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 102, 255));
        jLabel65.setText("Address");

        AddNewUserSpecializedAreaDropDown.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewUserSpecializedAreaDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Physician", "Pediatrician", "Obstetrician", "Psychiatrist", "Cardiologist", "Dermatologist", "Gastroenterologist", "Ophthalmologist", "Neurologist", "Radiologist", "Anesthesiologist   " }));

        addNewUserBtn.setBackground(new java.awt.Color(0, 102, 255));
        addNewUserBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewUserBtn.setForeground(new java.awt.Color(255, 255, 255));
        addNewUserBtn.setText("Add New User");
        addNewUserBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewUserBtnMouseClicked(evt);
            }
        });

        AddNewStaffID.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        AddNewStaffID.setMaximumSize(new java.awt.Dimension(300, 30));
        AddNewStaffID.setMinimumSize(new java.awt.Dimension(250, 24));
        AddNewStaffID.setPreferredSize(new java.awt.Dimension(250, 30));

        bloodG.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        bloodG.setForeground(new java.awt.Color(0, 102, 255));
        bloodG.setText("Blood Group");

        bloodSel.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        bloodSel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "AB", "O", "A-", "B-", "AB-", "O-" }));
        bloodSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloodSelActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 102, 255));
        jLabel63.setText("Married State");

        marriedState.add(addNewUserMarriedState);
        addNewUserMarriedState.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewUserMarriedState.setForeground(new java.awt.Color(0, 102, 255));
        addNewUserMarriedState.setText("Married");

        marriedState.add(addNewUserUnMarriedState);
        addNewUserUnMarriedState.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        addNewUserUnMarriedState.setForeground(new java.awt.Color(0, 102, 255));
        addNewUserUnMarriedState.setText("Unmarried");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                            .addComponent(jLabel65)
                            .addGap(172, 172, 172))
                        .addComponent(addNewUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel34Layout.createSequentialGroup()
                            .addComponent(addNewUserMarriedState, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addNewUserUnMarriedState))
                        .addComponent(jLabel63)
                        .addComponent(StaffIDLabel)
                        .addComponent(emailLabel)
                        .addComponent(AddNewUserSpecializedAreaLabel))
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(addNewUserAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel34Layout.createSequentialGroup()
                            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(AddNewUserSpecializedAreaDropDown, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AddNewStaffID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel34Layout.createSequentialGroup()
                                    .addComponent(bloodG)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bloodSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewUserMarriedState)
                    .addComponent(addNewUserUnMarriedState))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addNewUserAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(StaffIDLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddNewStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddNewUserSpecializedAreaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddNewUserSpecializedAreaDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bloodG, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bloodSel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(addNewUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel17.add(jPanel34, java.awt.BorderLayout.CENTER);

        jPanel12.add(jPanel17, java.awt.BorderLayout.CENTER);

        jTabbedPane5.addTab("Add New User", jPanel12);

        jPanel15.setBackground(new java.awt.Color(255, 204, 0));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });
        jPanel15.setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 204, 0));
        jTabbedPane1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        patientDetailsTab.setLayout(new java.awt.BorderLayout());

        patientDetailsTable.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        patientDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "userName", "First Name", "Last Name", "Phone No", "NIC", "DOB", "Address", "Blood Group", "Gender", "Married State", "Allergies"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane8.setViewportView(patientDetailsTable);

        patientDetailsTab.add(jScrollPane8, java.awt.BorderLayout.CENTER);

        jPanel30.setBackground(new java.awt.Color(241, 246, 253));
        jPanel30.setPreferredSize(new java.awt.Dimension(700, 40));

        patientUpdateBtn.setBackground(new java.awt.Color(40, 167, 69));
        patientUpdateBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        patientUpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        patientUpdateBtn.setText("Save");
        patientUpdateBtn.setPreferredSize(new java.awt.Dimension(72, 26));
        patientUpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientUpdateBtnMouseClicked(evt);
            }
        });

        patientIntialDeleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        patientIntialDeleteBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        patientIntialDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        patientIntialDeleteBtn.setText("Delete");
        patientIntialDeleteBtn.setPreferredSize(new java.awt.Dimension(78, 26));
        patientIntialDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientIntialDeleteBtnMouseClicked(evt);
            }
        });

        patientAreYouWantToDelete.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        patientDeleteConformationYes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        patientDeleteConformationYes.setText("Yes");
        patientDeleteConformationYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientDeleteConformationYesMouseClicked(evt);
            }
        });

        patientDeleteConformationNo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        patientDeleteConformationNo.setText("No");
        patientDeleteConformationNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientDeleteConformationNoMouseClicked(evt);
            }
        });
        patientDeleteConformationNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientDeleteConformationNoActionPerformed(evt);
            }
        });

        resetPatientPassword.setBackground(new java.awt.Color(255, 153, 0));
        resetPatientPassword.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        resetPatientPassword.setForeground(new java.awt.Color(255, 255, 255));
        resetPatientPassword.setText("Reset Pass");
        resetPatientPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetPatientPasswordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patientUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientIntialDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetPatientPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientAreYouWantToDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientDeleteConformationYes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientDeleteConformationNo)
                .addGap(14, 14, 14))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientIntialDeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientDeleteConformationYes)
                    .addComponent(patientDeleteConformationNo)
                    .addComponent(resetPatientPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientUpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(patientAreYouWantToDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        patientDetailsTab.add(jPanel30, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Patient Details View", patientDetailsTab);

        MedicalOfficersDetailsViewTab.setLayout(new java.awt.BorderLayout());

        MedicalOfficersTable.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        MedicalOfficersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff ID", "Email", "Specialized Area", "UserName", "First Name", "Last Name", "Phone No", "NIC", "DOB", "Address", "Gender", "Married State"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        MedicalOfficersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicalOfficersTableMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(MedicalOfficersTable);

        MedicalOfficersDetailsViewTab.add(jScrollPane9, java.awt.BorderLayout.CENTER);

        jPanel31.setBackground(new java.awt.Color(241, 246, 253));
        jPanel31.setPreferredSize(new java.awt.Dimension(700, 40));

        MedicalOfficerUpdateBtn.setBackground(new java.awt.Color(40, 167, 69));
        MedicalOfficerUpdateBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        MedicalOfficerUpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        MedicalOfficerUpdateBtn.setText("Save");
        MedicalOfficerUpdateBtn.setPreferredSize(new java.awt.Dimension(72, 35));
        MedicalOfficerUpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MedicalOfficerUpdateBtnMouseClicked(evt);
            }
        });

        medicalIntialDeleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        medicalIntialDeleteBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        medicalIntialDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        medicalIntialDeleteBtn.setText("Delete");
        medicalIntialDeleteBtn.setPreferredSize(new java.awt.Dimension(78, 26));
        medicalIntialDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicalIntialDeleteBtnMouseClicked(evt);
            }
        });
        medicalIntialDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalIntialDeleteBtnActionPerformed(evt);
            }
        });

        medicalAreYouWantDelete.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        medicalDeleteConformationYes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        medicalDeleteConformationYes.setText("Yes");
        medicalDeleteConformationYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicalDeleteConformationYesMouseClicked(evt);
            }
        });
        medicalDeleteConformationYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalDeleteConformationYesActionPerformed(evt);
            }
        });

        medicalDeleteConformationNo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        medicalDeleteConformationNo.setText("No");
        medicalDeleteConformationNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicalDeleteConformationNoMouseClicked(evt);
            }
        });
        medicalDeleteConformationNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicalDeleteConformationNoActionPerformed(evt);
            }
        });

        resetMedicalOfficerPassword.setBackground(new java.awt.Color(255, 153, 0));
        resetMedicalOfficerPassword.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        resetMedicalOfficerPassword.setForeground(new java.awt.Color(255, 255, 255));
        resetMedicalOfficerPassword.setText("Reset Pass");
        resetMedicalOfficerPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMedicalOfficerPasswordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MedicalOfficerUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicalIntialDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetMedicalOfficerPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(medicalAreYouWantDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicalDeleteConformationYes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicalDeleteConformationNo)
                .addGap(14, 14, 14))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(medicalIntialDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(resetMedicalOfficerPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(medicalDeleteConformationYes)
                        .addComponent(medicalDeleteConformationNo))
                    .addComponent(MedicalOfficerUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(medicalAreYouWantDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MedicalOfficersDetailsViewTab.add(jPanel31, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Medical Officers View", MedicalOfficersDetailsViewTab);

        ReceptiontistDetailsViewTab.setLayout(new java.awt.BorderLayout());

        ReceptiontistTable.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        ReceptiontistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff ID", "Email", "User Name", "First Name", "Last Name", "Phone No", "NIC", "DOB", "Address", "Gender", "Married"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(ReceptiontistTable);

        ReceptiontistDetailsViewTab.add(jScrollPane10, java.awt.BorderLayout.CENTER);

        jPanel32.setBackground(new java.awt.Color(241, 246, 253));
        jPanel32.setPreferredSize(new java.awt.Dimension(700, 40));

        receptionistUpdateBtn.setBackground(new java.awt.Color(40, 167, 69));
        receptionistUpdateBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        receptionistUpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        receptionistUpdateBtn.setText("Save");
        receptionistUpdateBtn.setPreferredSize(new java.awt.Dimension(72, 35));
        receptionistUpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receptionistUpdateBtnMouseClicked(evt);
            }
        });

        receptionIntialDeleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        receptionIntialDeleteBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        receptionIntialDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        receptionIntialDeleteBtn.setText("Delete");
        receptionIntialDeleteBtn.setPreferredSize(new java.awt.Dimension(78, 26));
        receptionIntialDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receptionIntialDeleteBtnMouseClicked(evt);
            }
        });
        receptionIntialDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receptionIntialDeleteBtnActionPerformed(evt);
            }
        });

        receptionAreYouWantToDelete.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        receptionConformationYes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        receptionConformationYes.setText("Yes");
        receptionConformationYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receptionConformationYesMouseClicked(evt);
            }
        });
        receptionConformationYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receptionConformationYesActionPerformed(evt);
            }
        });

        receptionConformationNo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        receptionConformationNo.setText("No");
        receptionConformationNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receptionConformationNoMouseClicked(evt);
            }
        });
        receptionConformationNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receptionConformationNoActionPerformed(evt);
            }
        });

        resetReceptionPassword.setBackground(new java.awt.Color(255, 153, 0));
        resetReceptionPassword.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        resetReceptionPassword.setForeground(new java.awt.Color(255, 255, 255));
        resetReceptionPassword.setText("Reset Pass");
        resetReceptionPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetReceptionPasswordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(receptionistUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receptionIntialDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetReceptionPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receptionAreYouWantToDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receptionConformationYes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receptionConformationNo)
                .addGap(14, 14, 14))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receptionIntialDeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(receptionConformationYes)
                    .addComponent(receptionConformationNo)
                    .addComponent(resetReceptionPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(receptionistUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(receptionAreYouWantToDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ReceptiontistDetailsViewTab.add(jPanel32, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Receptiontist View", ReceptiontistDetailsViewTab);

        jPanel15.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane5.addTab("View/Edit/Delete Users", jPanel15);

        jPanel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel39MouseClicked(evt);
            }
        });
        jPanel39.setLayout(new java.awt.BorderLayout());

        jPanel40.setBackground(new java.awt.Color(241, 246, 253));
        jPanel40.setPreferredSize(new java.awt.Dimension(700, 45));

        userLoginUpdateSaveBtn.setBackground(new java.awt.Color(40, 167, 69));
        userLoginUpdateSaveBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        userLoginUpdateSaveBtn.setForeground(new java.awt.Color(255, 255, 255));
        userLoginUpdateSaveBtn.setText("Save");
        userLoginUpdateSaveBtn.setPreferredSize(new java.awt.Dimension(72, 35));
        userLoginUpdateSaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLoginUpdateSaveBtnMouseClicked(evt);
            }
        });

        loginDetailsIntialDeleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        loginDetailsIntialDeleteBtn.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        loginDetailsIntialDeleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginDetailsIntialDeleteBtn.setText("Delete");
        loginDetailsIntialDeleteBtn.setPreferredSize(new java.awt.Dimension(78, 26));
        loginDetailsIntialDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginDetailsIntialDeleteBtnMouseClicked(evt);
            }
        });

        loginDetailsAreYouWantToDelete.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        loginDetailsConformationYes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        loginDetailsConformationYes.setText("Yes");
        loginDetailsConformationYes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginDetailsConformationYesMouseClicked(evt);
            }
        });

        loginDetailsConformationNo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        loginDetailsConformationNo.setText("No");
        loginDetailsConformationNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginDetailsConformationNoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLoginUpdateSaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginDetailsIntialDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(loginDetailsAreYouWantToDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginDetailsConformationYes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginDetailsConformationNo)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginDetailsConformationNo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(loginDetailsAreYouWantToDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loginDetailsIntialDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userLoginUpdateSaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(loginDetailsConformationYes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel39.add(jPanel40, java.awt.BorderLayout.PAGE_START);

        jPanel41.setLayout(new java.awt.BorderLayout());

        userLoginTable.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        userLoginTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "userName", "userID", "userType", "userPass"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane13.setViewportView(userLoginTable);

        jPanel41.add(jScrollPane13, java.awt.BorderLayout.CENTER);

        jPanel39.add(jPanel41, java.awt.BorderLayout.CENTER);

        jTabbedPane5.addTab("EditLogin Details", jPanel39);

        userPanel.add(jTabbedPane5, java.awt.BorderLayout.CENTER);

        content.add(userPanel, "card7");

        reportPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportPanel.setLayout(new java.awt.BorderLayout());

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_json_download_120px.png"))); // NOI18N
        jLabel82.setText("jLabel80");

        jLabel83.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel83.setText("Save Patient Details");

        saveToPdfApp.setBackground(new java.awt.Color(159, 2, 221));
        saveToPdfApp.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        saveToPdfApp.setForeground(new java.awt.Color(255, 255, 255));
        saveToPdfApp.setText("Save To PDF");
        saveToPdfApp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveToPdfAppMouseClicked(evt);
            }
        });

        saveToJson.setBackground(new java.awt.Color(159, 2, 221));
        saveToJson.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        saveToJson.setForeground(new java.awt.Color(255, 255, 255));
        saveToJson.setText("Save As JSON");
        saveToJson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveToJsonMouseClicked(evt);
            }
        });

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_pdf_120px.png"))); // NOI18N

        jLabel91.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel91.setText("Select the Doctor");

        pdfMedicalOfficersDropDown.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N

        jLabel94.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel94.setText("Save Medical Details");

        saveToJson1.setBackground(new java.awt.Color(159, 2, 221));
        saveToJson1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        saveToJson1.setForeground(new java.awt.Color(255, 255, 255));
        saveToJson1.setText("Save As JSON");
        saveToJson1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveToJson1MouseClicked(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel95.setText("Save Receptionist Details");

        saveToJson2.setBackground(new java.awt.Color(159, 2, 221));
        saveToJson2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        saveToJson2.setForeground(new java.awt.Color(255, 255, 255));
        saveToJson2.setText("Save As JSON");
        saveToJson2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveToJson2MouseClicked(evt);
            }
        });

        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_json_download_120px.png"))); // NOI18N
        jLabel96.setText("jLabel80");

        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_json_download_120px.png"))); // NOI18N
        jLabel106.setText("jLabel80");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveToJson, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel83))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveToJson1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel94)
                            .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveToJson2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel95)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel91)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(pdfMedicalOfficersDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveToPdfApp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel90)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel91)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveToPdfApp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pdfMedicalOfficersDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(64, 64, 64)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(jLabel96)
                    .addComponent(jLabel106))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(jLabel94))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveToJson1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveToJson, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveToJson2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        reportPanel.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel23.setBackground(new java.awt.Color(217, 12, 254));
        jPanel23.setPreferredSize(new java.awt.Dimension(0, 40));

        reportNotification.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        reportNotification.setForeground(new java.awt.Color(255, 255, 255));
        reportNotification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(reportNotification, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(reportNotification, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        reportPanel.add(jPanel23, java.awt.BorderLayout.PAGE_START);

        content.add(reportPanel, "card8");

        curvedMainPannel.add(content, java.awt.BorderLayout.CENTER);

        footer.setOpaque(false);
        footer.setPreferredSize(new java.awt.Dimension(900, 40));

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        curvedMainPannel.add(footer, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(curvedMainPannel);

        setSize(new java.awt.Dimension(900, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //notification clear--------------------------------------------------------
    private static void notificationClear(JLabel notificationLabel){   
    new Timer(2500, (ActionEvent e) -> {
        notificationLabel.setText("");
    }).start();
    }
    
    private String[] stringSeparator(String commaSeparatedString){
            String[] dataRow = commaSeparatedString.split(",");
            return dataRow;
    }

    
    private String getSelectedRowStringFromReleventTable(JTable relevantTable){
        TableModel model = relevantTable.getModel();
        
        int selectedRowIndex = relevantTable.getSelectedRow();
            
          String objectString="";  
          for(int i = 0; i < model.getColumnCount(); i++){
            if(i==0){  
            objectString=String.valueOf(model.getValueAt(selectedRowIndex,i)); 
            }else{
            objectString=objectString+","+String.valueOf(model.getValueAt(selectedRowIndex,i));
            }
         }
          
          
         return objectString; 
    }
    
    private String getUpdatedRowStringFromReleventTable(JTable relevantTable,
            int updateRowNo){
        TableModel model = relevantTable.getModel();
                  
          String objectString="";  
          for(int i = 0; i < model.getColumnCount(); i++){
            if(i==0){  
            objectString=String.valueOf(model.getValueAt(updateRowNo,i)); 
            }else{
            objectString=objectString+","+String.valueOf(model.getValueAt(updateRowNo,i));
            }
         }
          
          
         return objectString; 
    }
    
    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int xCordinate=evt.getXOnScreen();
        int yCordinate=evt.getYOnScreen();
        
        this.setLocation(xCordinate-mousePx,yCordinate-mousePy);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        mousePx=evt.getX();
        mousePy=evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void menuIconClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuIconClick
        if(evt.getSource()==home){
            homePannel.setVisible(true);
            appPanel.setVisible(false);
            postalPanel.setVisible(false);
            complainPanel.setVisible(false);
            visitorsPanel.setVisible(false);
            referencePanel.setVisible(false);
            userPanel.setVisible(false);
            reportPanel.setVisible(false);
        }
        if(evt.getSource()==appointment){
            homePannel.setVisible(false);
            appPanel.setVisible(true);
            postalPanel.setVisible(false);
            complainPanel.setVisible(false);
            visitorsPanel.setVisible(false);
            referencePanel.setVisible(false);
            userPanel.setVisible(false);
            reportPanel.setVisible(false);
            dropDownFeederModel specialAreaObj=new dropDownFeederModel("specializedArea.txt",AddNewAppointmnetSpecializedAreaDropDown);
            specialAreaObj.dropFeeder(true);
        }
        if(evt.getSource()==postal){
            homePannel.setVisible(false);
            appPanel.setVisible(false);
            postalPanel.setVisible(true);
            complainPanel.setVisible(false);
            visitorsPanel.setVisible(false);
            referencePanel.setVisible(false);
            userPanel.setVisible(false);
            reportPanel.setVisible(false);
        }
        if(evt.getSource()==complain){
            homePannel.setVisible(false);
            appPanel.setVisible(false);
            postalPanel.setVisible(false);
            complainPanel.setVisible(true);
            visitorsPanel.setVisible(false);
            referencePanel.setVisible(false);
            userPanel.setVisible(false);
            reportPanel.setVisible(false);
        }
        if(evt.getSource()==visitors){
            homePannel.setVisible(false);
            appPanel.setVisible(false);
            postalPanel.setVisible(false);
            complainPanel.setVisible(false);
            visitorsPanel.setVisible(true);
            referencePanel.setVisible(false);
            userPanel.setVisible(false);
            reportPanel.setVisible(false);
        }
        if(evt.getSource()==reference){
            homePannel.setVisible(false);
            appPanel.setVisible(false);
            postalPanel.setVisible(false);
            complainPanel.setVisible(false);
            visitorsPanel.setVisible(false);
            referencePanel.setVisible(true);
            userPanel.setVisible(false);
            reportPanel.setVisible(false);
            //feeding the reference modules drop down menus
            dropDownFeederModel departmentObj=new dropDownFeederModel("departments.txt",avalaibleDepartmentDropDown);
            departmentObj.dropFeeder(true);
            departmentObj.setComboBoxForFeed(deleteComplainDepartment);
            departmentObj.dropFeeder(true);
            dropDownFeederModel specialAreaObj=new dropDownFeederModel("specializedArea.txt",specializedAreaDropDown);
            specialAreaObj.dropFeeder(true);
            specialAreaObj.setComboBoxForFeed(deleteSpecialArea);
            specialAreaObj.dropFeeder(true);
        }
        if(evt.getSource()==user){
            homePannel.setVisible(false);
            appPanel.setVisible(false);
            postalPanel.setVisible(false);
            complainPanel.setVisible(false);
            visitorsPanel.setVisible(false);
            referencePanel.setVisible(false);
            userPanel.setVisible(true);
            reportPanel.setVisible(false);
        }
        if(evt.getSource()==report){
            homePannel.setVisible(false);
            appPanel.setVisible(false);
            postalPanel.setVisible(false);
            complainPanel.setVisible(false);
            visitorsPanel.setVisible(false);
            referencePanel.setVisible(false);
            userPanel.setVisible(false);
            reportPanel.setVisible(true);
            dropDownFeederModel mediOfficerObj=new dropDownFeederModel("medicalOfficerDetails.txt",pdfMedicalOfficersDropDown);
            mediOfficerObj.dropDownFeederMedical();
        }
        
        
        
    }//GEN-LAST:event_menuIconClick

    private void AddNewComplainBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddNewComplainBtnMouseClicked
        
        boolean textField7=AddNewComplainName.getText().equals("");
        boolean textField8=AddNewComplainPhoneNumber.getText().equals("");
        boolean textField9=AddNewComplainDesTextArea.getText().equals("");
        boolean textField10=AddNewComplainNote.getText().equals("");
        
        if(!(textField7 || textField8 || textField9 || textField10 )){
                
                complainWarning.setText("Sumbiting the Complain");
                date complainDateObj=new date();
                complainsController newComplain=new complainsController(
                AddNewComplainName.getText(),
                Integer.parseInt(AddNewComplainPhoneNumber.getText()),
                complainDateObj,
                AddNewComplainDesTextArea.getText(),
                "no-action-taken",
                AddNewComplainNote.getText(),
                AddNewComplainReferenceDepartment.getSelectedItem().toString(),
                ComplainModel.getNextReferenceNo());
                ComplainModel.writingTXT(newComplain.toString());
        }else{
                complainWarning.setText("Please fill all fields");
        }        
    }//GEN-LAST:event_AddNewComplainBtnMouseClicked

    private void AddNewVisitorRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddNewVisitorRecordMouseClicked
        boolean textField14=VisitorRecordName.getText().equals("");
        boolean textField15=VisitorRecordPhoneNo.getText().equals("");
        boolean textField16=VisitorRecordPurpose.getText().equals("");
        boolean textField17=VisitorRecordNIC.getText().equals("");
        if(!(textField14 || textField15 || textField16 || textField17)){
            VisitorRecordNotification.setText("Sumbiting Record");
            //craeting date/time object for get current date/time
            
            date visitorCurrentDateObj=new date();
            
            time visitorInTimeObj=new time();
            
            time visitorOutTimeObj=new time(
                    (Integer)VisitorRecordOutMinutes.getValue(),
                    (Integer)VisitorRecordOutHours.getValue(),
                    VisitorRecordAmPmState.getSelectedItem().toString()
            );
            
            //creating new record objcet
            visitorsController addNewVisitorRecordObj=new visitorsController(
                    VisitorRecordNIC.getText(),
                    VisitorRecordName.getText(),
                    VisitorRecordPurpose.getText(),
                    Integer.parseInt(VisitorRecordPhoneNo.getText()),
                    visitorCurrentDateObj,
                    visitorInTimeObj,
                    visitorOutTimeObj,
                    VisitorRecordNote.getText());
            VisitorModel.writingTXT(addNewVisitorRecordObj.toString());
            

        }else{
                VisitorRecordNotification.setText("Please fill the Fields");
        
        }
    }//GEN-LAST:event_AddNewVisitorRecordMouseClicked

    private void AddNewDispatchPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddNewDispatchPostMouseClicked
                boolean textField23=DispatchPostFrom.getText().equals("");
                boolean textField24=DispatchPostTo.getText().equals("");
                boolean textField25=DispatchPostRefNo.getText().equals("");
                boolean textField26=DispatchPostNote.getText().equals("");
                boolean textField27=DispatchPostAddress.getText().equals("");
        if(!(textField23 || textField24 || textField25 || textField26 || textField27)){
            dispatchPostNotification.setText("Sumbiting Record");
            //craeting date/time object for get current date/time
            
            date postalDispatchDateObj=new date(
                    (Integer)DispatchPostDay.getValue(),
                    (Integer)DispatchPostMonth.getValue(),
                    (Integer)DispatchPostYear.getValue()
            );
            
            //creating new record objcet
            dispatchPostController newDispatchPostObj=new dispatchPostController(
                    Integer.parseInt(DispatchPostRefNo.getText()),
                    DispatchPostTo.getText(),
                    DispatchPostFrom.getText(),
                    DispatchPostAddress.getText(),
                    DispatchPostNote.getText(),
                    postalDispatchDateObj);
            
            
            DispatchModel.writingTXT(newDispatchPostObj.toString());
        }else{
                dispatchPostNotification.setText("Please Fill The Fields");
        }
        
        
        
        
    }//GEN-LAST:event_AddNewDispatchPostMouseClicked

    private void AddNewRecievedPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddNewRecievedPostMouseClicked
                boolean textField18=RecievedPostFrom.getText().equals("");
                boolean textField19=RecievedPostTo.getText().equals("");
                boolean textField20=RecievedPostRefNo.getText().equals("");
                boolean textField21=RecievedPostNote.getText().equals("");
                boolean textField22=RecievedPostAddress.getText().equals("");
        if(!(textField18 || textField19 || textField20 || textField21 || textField22)){
            recievedPostNotification.setText("Sumbiting Record");
            //craeting date/time object for get current date/time
            
            date postalRecievedDateObj=new date(
                    (Integer)RecievedPostDay.getValue(),
                    (Integer)RecievedPostMonth.getValue(),
                    (Integer)RecievedPostYear.getValue()
            );
            
            //creating new record objcet
            recievedPostController newRecievedPostObj=new recievedPostController(
                    Integer.parseInt(RecievedPostRefNo.getText()),
                    RecievedPostTo.getText(),
                    RecievedPostFrom.getText(),
                    RecievedPostAddress.getText(),
                    RecievedPostNote.getText(),
                    postalRecievedDateObj);
            
            RecievedPostModel.writingTXT(newRecievedPostObj.toString());
        }else{
                recievedPostNotification.setText("Please Fill The Fields");
        }
    }//GEN-LAST:event_AddNewRecievedPostMouseClicked

    private void viewComplainBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewComplainBtnMouseClicked
        ComplainModel.viewComplain(ComplainViewTable);
    }//GEN-LAST:event_viewComplainBtnMouseClicked

    private void viewVisitorsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewVisitorsBtnMouseClicked
       VisitorModel.viewVisitor(viewVisitorsRecordTable);
    }//GEN-LAST:event_viewVisitorsBtnMouseClicked

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jTabbedPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane5MouseClicked
        PatientModel.viewPatientDetails(patientDetailsTable);
        UserModel.viewLoginDetails(userLoginTable);
    }//GEN-LAST:event_jTabbedPane5MouseClicked

    private void MedicalOfficersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicalOfficersTableMouseClicked
        
    }//GEN-LAST:event_MedicalOfficersTableMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        MedicalOfficerModel.viewMedicalOfficers(MedicalOfficersTable);
        ReceptionistModel.viewReceptionist(ReceptiontistTable);
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void ViewRecievedDispatchPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewRecievedDispatchPostMouseClicked
        RecievedPostModel.viewRecievedPost(viewRecivedTable);
        DispatchModel.viewDispatchPost(viewDispatchTable);
    }//GEN-LAST:event_ViewRecievedDispatchPostMouseClicked

    private void userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseEntered
       user.setSize(new Dimension(180,50));
        
    }//GEN-LAST:event_userMouseEntered

    private void userMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseExited
        user.setSize(new Dimension(200,50));
    }//GEN-LAST:event_userMouseExited

    private void appointmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentMouseEntered
        appointment.setSize(new Dimension(180,50)); 
    }//GEN-LAST:event_appointmentMouseEntered

    private void appointmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentMouseExited
       appointment.setSize(new Dimension(200,50));
    }//GEN-LAST:event_appointmentMouseExited

    private void visitorsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visitorsMouseEntered
        visitors.setSize(new Dimension(180,50));
    }//GEN-LAST:event_visitorsMouseEntered

    private void visitorsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visitorsMouseExited
        visitors.setSize(new Dimension(200,50));
    }//GEN-LAST:event_visitorsMouseExited

    private void postalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postalMouseEntered
        postal.setSize(new Dimension(180,50));
    }//GEN-LAST:event_postalMouseEntered

    private void postalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postalMouseExited
        postal.setSize(new Dimension(200,50));
    }//GEN-LAST:event_postalMouseExited

    private void complainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_complainMouseEntered
        complain.setSize(new Dimension(180,50));
    }//GEN-LAST:event_complainMouseEntered

    private void complainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_complainMouseExited
        complain.setSize(new Dimension(200,50));
    }//GEN-LAST:event_complainMouseExited

    private void referenceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_referenceMouseEntered
        reference.setSize(new Dimension(180,50));
    }//GEN-LAST:event_referenceMouseEntered

    private void referenceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_referenceMouseExited
        reference.setSize(new Dimension(200,50));
    }//GEN-LAST:event_referenceMouseExited

    private void VisitorIntialDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VisitorIntialDeleteBtnMouseClicked
        if(!viewVisitorsRecordTable.getSelectionModel().isSelectionEmpty()){
            VisitorAreYouWantToDelete.setVisible(true);
            VisitorAreYouWantToDelete.setText("Are you sure want to delete this record?");
            deleteVisitorRecordConformationYes.setVisible(true);
            deleteVisitorRecordConformationNo.setVisible(true);
        }else{
            VisitorAreYouWantToDelete.setVisible(true);
            VisitorAreYouWantToDelete.setText("Please Select the Record To Delete");
        }

    }//GEN-LAST:event_VisitorIntialDeleteBtnMouseClicked

    private void deleteVisitorRecordConformationYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteVisitorRecordConformationYesMouseClicked
        if(!viewVisitorsRecordTable.getSelectionModel().isSelectionEmpty()){

          visitorsController deleteAppObj=new visitorsController(
                  getSelectedRowStringFromReleventTable(viewVisitorsRecordTable));
          VisitorModel.deleteVisitors(deleteAppObj);
          VisitorModel.viewVisitor(viewVisitorsRecordTable);
          deleteVisitorRecordConformationYes.setVisible(false);
          deleteVisitorRecordConformationNo.setVisible(false);
          VisitorAreYouWantToDelete.setVisible(false);
        
        }else{
        
            VisitorAreYouWantToDelete.setText("Please Select the Row to Delete");
            deleteVisitorRecordConformationYes.setVisible(false);
            deleteVisitorRecordConformationNo.setVisible(false);
          
        }
    }//GEN-LAST:event_deleteVisitorRecordConformationYesMouseClicked

    private void deleteVisitorRecordConformationYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVisitorRecordConformationYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteVisitorRecordConformationYesActionPerformed

    private void deleteVisitorRecordConformationNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteVisitorRecordConformationNoMouseClicked
        deleteVisitorRecordConformationYes.setVisible(false);
        deleteVisitorRecordConformationNo.setVisible(false);
        VisitorAreYouWantToDelete.setVisible(false);
    }//GEN-LAST:event_deleteVisitorRecordConformationNoMouseClicked

    private void deleteVisitorRecordConformationNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVisitorRecordConformationNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteVisitorRecordConformationNoActionPerformed

    private void RecivedPostIntialDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecivedPostIntialDeleteBtnMouseClicked
        if(!viewRecivedTable.getSelectionModel().isSelectionEmpty()){
        recievedAreYouWantToDelete.setVisible(true);
        recievedAreYouWantToDelete.setText("Are you sure want to delete this record?");
        RecievedDeleteConformationYes.setVisible(true);
        RecievedDeleteConformationNo.setVisible(true);
        }else{
            recievedAreYouWantToDelete.setVisible(true);
            recievedAreYouWantToDelete.setText("Please Select the Record To Delete");
        }

    }//GEN-LAST:event_RecivedPostIntialDeleteBtnMouseClicked

    private void RecivedPostIntialDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecivedPostIntialDeleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecivedPostIntialDeleteBtnActionPerformed

    private void RecievedDeleteConformationYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecievedDeleteConformationYesMouseClicked
        if(!viewRecivedTable.getSelectionModel().isSelectionEmpty()){
        
          recievedPostController deleteAppObj=new recievedPostController(stringSeparator(getSelectedRowStringFromReleventTable(viewRecivedTable)));
            RecievedPostModel.deleteRecieved(deleteAppObj);
            RecievedDeleteConformationYes.setVisible(false);
            RecievedDeleteConformationNo.setVisible(false);
            recievedAreYouWantToDelete.setVisible(false);
            RecievedPostModel.viewRecievedPost(viewRecivedTable);
            
        }else{
        
            recievedAreYouWantToDelete.setText("Please Select the Row to Delete");
            RecievedDeleteConformationYes.setVisible(false);
            RecievedDeleteConformationNo.setVisible(false);
          
        }
    }//GEN-LAST:event_RecievedDeleteConformationYesMouseClicked

    private void RecievedDeleteConformationYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecievedDeleteConformationYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecievedDeleteConformationYesActionPerformed

    private void RecievedDeleteConformationNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecievedDeleteConformationNoMouseClicked
        
        RecievedDeleteConformationYes.setVisible(false);
        RecievedDeleteConformationNo.setVisible(false);
        recievedAreYouWantToDelete.setVisible(false);
    }//GEN-LAST:event_RecievedDeleteConformationNoMouseClicked

    private void RecievedDeleteConformationNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecievedDeleteConformationNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecievedDeleteConformationNoActionPerformed

    private void DispatchIntialDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DispatchIntialDeleteBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DispatchIntialDeleteBtnMouseClicked

    private void DispatchIntialDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DispatchIntialDeleteBtnActionPerformed
        if(!viewDispatchTable.getSelectionModel().isSelectionEmpty()){
        dispatchAreYouWantToDelete.setVisible(true);
        dispatchAreYouWantToDelete.setText("Are you sure want to delete this record?");
        DispatchDeleteConformationNo.setVisible(true);
        DispatchDeleteConformationYes.setVisible(true);
        }else{
            dispatchAreYouWantToDelete.setVisible(true);
            dispatchAreYouWantToDelete.setText("Please Select the Record To Delete");
        }

    }//GEN-LAST:event_DispatchIntialDeleteBtnActionPerformed

    private void DispatchDeleteConformationYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DispatchDeleteConformationYesMouseClicked
        if(!viewDispatchTable.getSelectionModel().isSelectionEmpty()){
        
            dispatchPostController deleteDispatchObj=new dispatchPostController(stringSeparator(getSelectedRowStringFromReleventTable(viewDispatchTable)));
            DispatchModel.deleteDispatch(deleteDispatchObj);
            DispatchModel.viewDispatchPost(viewDispatchTable);
            DispatchDeleteConformationYes.setVisible(false);
            DispatchDeleteConformationNo.setVisible(false);
            dispatchAreYouWantToDelete.setVisible(false);
            
        }else{
        
            dispatchAreYouWantToDelete.setText("Please Select the Row to Delete");
            DispatchDeleteConformationYes.setVisible(false);
            DispatchDeleteConformationNo.setVisible(false);
          
        }
        
        
        
        
    }//GEN-LAST:event_DispatchDeleteConformationYesMouseClicked

    private void DispatchDeleteConformationYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DispatchDeleteConformationYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DispatchDeleteConformationYesActionPerformed

    private void DispatchDeleteConformationNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DispatchDeleteConformationNoMouseClicked
        DispatchDeleteConformationYes.setVisible(false);
        DispatchDeleteConformationNo.setVisible(false);
        dispatchAreYouWantToDelete.setVisible(false);        
    }//GEN-LAST:event_DispatchDeleteConformationNoMouseClicked

    private void DispatchDeleteConformationNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DispatchDeleteConformationNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DispatchDeleteConformationNoActionPerformed

    private void ComplainDeleteIntialBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComplainDeleteIntialBtnMouseClicked
        if(!ComplainViewTable.getSelectionModel().isSelectionEmpty()){
        ComplainAreYouWantToDelete.setVisible(true);
        ComplainAreYouWantToDelete.setText("Are you sure want to delete this record?");
        deleteComplainConformationYes.setVisible(true);
        deleteComplainConformationNo.setVisible(true);
        }else{
            ComplainAreYouWantToDelete.setVisible(true);
            ComplainAreYouWantToDelete.setText("Please Select the Record To Delete");
        }

    }//GEN-LAST:event_ComplainDeleteIntialBtnMouseClicked

    private void deleteComplainConformationYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteComplainConformationYesMouseClicked
        if(!ComplainViewTable.getSelectionModel().isSelectionEmpty()){
        
          complainsController deleteAppObj=new complainsController(
                  getSelectedRowStringFromReleventTable(ComplainViewTable));
            ComplainModel.deleteComplain(deleteAppObj);
            ComplainModel.viewComplain(ComplainViewTable);
            deleteComplainConformationYes.setVisible(false);
            deleteComplainConformationNo.setVisible(false);
            ComplainAreYouWantToDelete.setVisible(false);
        
        }else{
        
            ComplainAreYouWantToDelete.setText("Please Select the Row to Delete");
            deleteComplainConformationYes.setVisible(false);
            deleteComplainConformationNo.setVisible(false);
          
        }
    }//GEN-LAST:event_deleteComplainConformationYesMouseClicked

    private void deleteComplainConformationNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteComplainConformationNoMouseClicked
        deleteComplainConformationYes.setVisible(false);
        deleteComplainConformationNo.setVisible(false);
        ComplainAreYouWantToDelete.setVisible(false);
    }//GEN-LAST:event_deleteComplainConformationNoMouseClicked

    private void patientIntialDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientIntialDeleteBtnMouseClicked
       if(!patientDetailsTable.getSelectionModel().isSelectionEmpty()){
        patientAreYouWantToDelete.setVisible(true);
        patientAreYouWantToDelete.setText("Are you sure want to delete this record?");
        patientDeleteConformationYes.setVisible(true);
        patientDeleteConformationNo.setVisible(true);
        }else{
            patientAreYouWantToDelete.setVisible(true);
            patientAreYouWantToDelete.setText("Please Select the Record To Delete");
        } 
    }//GEN-LAST:event_patientIntialDeleteBtnMouseClicked

    private void patientDeleteConformationYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientDeleteConformationYesMouseClicked
        if(!patientDetailsTable.getSelectionModel().isSelectionEmpty()){
        
            patient deleteAppObj=new patient(stringSeparator(
                    getSelectedRowStringFromReleventTable(patientDetailsTable)));
            PatientModel.deletePatient(deleteAppObj);
            PatientModel.viewPatientDetails(patientDetailsTable);
            patientDeleteConformationYes.setVisible(false);
            patientDeleteConformationNo.setVisible(false);
            patientAreYouWantToDelete.setVisible(false);
        
        }else{
        
            patientAreYouWantToDelete.setText("Please Select the Row to Delete");
            notificationClear(patientAreYouWantToDelete);
            patientDeleteConformationYes.setVisible(false);
            patientDeleteConformationNo.setVisible(false);
          
        }
    }//GEN-LAST:event_patientDeleteConformationYesMouseClicked

    private void patientDeleteConformationNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientDeleteConformationNoMouseClicked
        patientDeleteConformationYes.setVisible(false);
        patientDeleteConformationNo.setVisible(false);
        patientAreYouWantToDelete.setVisible(false);
    }//GEN-LAST:event_patientDeleteConformationNoMouseClicked

    private void patientDeleteConformationNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientDeleteConformationNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientDeleteConformationNoActionPerformed

    private void medicalIntialDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicalIntialDeleteBtnMouseClicked
        if(!MedicalOfficersTable.getSelectionModel().isSelectionEmpty()){
        medicalAreYouWantDelete.setVisible(true);
        medicalAreYouWantDelete.setText("Are you sure want to delete this record?");
        medicalDeleteConformationYes.setVisible(true);
        medicalDeleteConformationNo.setVisible(true);
        }else{
            medicalAreYouWantDelete.setVisible(true);
            medicalAreYouWantDelete.setText("Please Select the Record To Delete");
        } 
    }//GEN-LAST:event_medicalIntialDeleteBtnMouseClicked

    private void medicalIntialDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicalIntialDeleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicalIntialDeleteBtnActionPerformed

    private void medicalDeleteConformationYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicalDeleteConformationYesMouseClicked
         if(!MedicalOfficersTable.getSelectionModel().isSelectionEmpty()){
        
            medicalOfficers deleteAppObj=new medicalOfficers(stringSeparator(
                    getSelectedRowStringFromReleventTable(MedicalOfficersTable)));
             MedicalOfficerModel.deleteMedical(deleteAppObj);
             MedicalOfficerModel.viewMedicalOfficers(MedicalOfficersTable);
             medicalDeleteConformationYes.setVisible(false);
             medicalDeleteConformationNo.setVisible(false);
             medicalAreYouWantDelete.setVisible(false);
        
        }else{
        
            medicalAreYouWantDelete.setText("Please Select the Row to Delete");
            medicalDeleteConformationYes.setVisible(false);
            medicalDeleteConformationNo.setVisible(false);
          
        }
        
        
        
        
        
    }//GEN-LAST:event_medicalDeleteConformationYesMouseClicked

    private void medicalDeleteConformationYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicalDeleteConformationYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicalDeleteConformationYesActionPerformed

    private void medicalDeleteConformationNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicalDeleteConformationNoMouseClicked
        medicalDeleteConformationYes.setVisible(false);
        medicalDeleteConformationNo.setVisible(false);
        medicalAreYouWantDelete.setVisible(false);
        
    }//GEN-LAST:event_medicalDeleteConformationNoMouseClicked

    private void medicalDeleteConformationNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicalDeleteConformationNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicalDeleteConformationNoActionPerformed

    private void receptionIntialDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionIntialDeleteBtnMouseClicked
         if(!ReceptiontistTable.getSelectionModel().isSelectionEmpty()){
        receptionAreYouWantToDelete.setVisible(true);
        receptionAreYouWantToDelete.setText("Are you sure want to delete this record?");
        receptionConformationYes.setVisible(true);
        receptionConformationNo.setVisible(true);
        }else{
            receptionAreYouWantToDelete.setVisible(true);
            receptionAreYouWantToDelete.setText("Please Select the Record To Delete");
        } 
    }//GEN-LAST:event_receptionIntialDeleteBtnMouseClicked

    private void receptionIntialDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receptionIntialDeleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receptionIntialDeleteBtnActionPerformed

    private void receptionConformationYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionConformationYesMouseClicked
        if(!ReceptiontistTable.getSelectionModel().isSelectionEmpty()){
        
            receptionist deleteAppObj=new receptionist(stringSeparator(
                    getSelectedRowStringFromReleventTable(ReceptiontistTable)));
             ReceptionistModel.deleteReceptionist(deleteAppObj);
             ReceptionistModel.viewReceptionist(ReceptiontistTable);
             receptionConformationYes.setVisible(false);
             receptionConformationNo.setVisible(false);
             receptionAreYouWantToDelete.setVisible(false);
        
        }else{
        
            receptionAreYouWantToDelete.setText("Please Select the Row to Delete");
            receptionConformationYes.setVisible(false);
            receptionConformationNo.setVisible(false);
          
        }
       
    }//GEN-LAST:event_receptionConformationYesMouseClicked

    private void receptionConformationYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receptionConformationYesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receptionConformationYesActionPerformed

    private void receptionConformationNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionConformationNoMouseClicked
            receptionAreYouWantToDelete.setVisible(false);
            receptionConformationYes.setVisible(false);
            receptionConformationNo.setVisible(false);
    }//GEN-LAST:event_receptionConformationNoMouseClicked

    private void receptionConformationNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receptionConformationNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receptionConformationNoActionPerformed

    private void viewRecivedTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewRecivedTableMouseClicked
        
        if(!viewRecivedTable.getSelectionModel().isSelectionEmpty()){
            RecievedDeleteConformationYes.setEnabled(true);
            RecievedDeleteConformationNo.setEnabled(true);
        }else{
            recievedAreYouWantToDelete.setText("Please Select The Record");
        }
        
    }//GEN-LAST:event_viewRecivedTableMouseClicked

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeBtnMouseClicked

    private void jPanel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel39MouseClicked
            UserModel.viewLoginDetails(userLoginTable);
    }//GEN-LAST:event_jPanel39MouseClicked

    private void loginDetailsConformationYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginDetailsConformationYesMouseClicked
         if(!userLoginTable.getSelectionModel().isSelectionEmpty()){
                        
            loginController deleteAppObj=new loginController(stringSeparator(
            getSelectedRowStringFromReleventTable(userLoginTable)));
            UserModel.deleteUser(deleteAppObj);
            UserModel.viewLoginDetails(userLoginTable);
            loginDetailsConformationYes.setVisible(false);
            loginDetailsConformationNo.setVisible(false);
            loginDetailsAreYouWantToDelete.setVisible(false);
        
        }else{
        
            loginDetailsAreYouWantToDelete.setText("Please Select the Row to Delete");
            loginDetailsConformationNo.setVisible(false);
            loginDetailsConformationYes.setVisible(false);
          
        }
     
    }//GEN-LAST:event_loginDetailsConformationYesMouseClicked

    private void loginDetailsConformationNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginDetailsConformationNoMouseClicked
            loginDetailsAreYouWantToDelete.setVisible(false);
            loginDetailsConformationYes.setVisible(false);
            loginDetailsConformationNo.setVisible(false);
    }//GEN-LAST:event_loginDetailsConformationNoMouseClicked

    private void loginDetailsIntialDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginDetailsIntialDeleteBtnMouseClicked
        if(!userLoginTable.getSelectionModel().isSelectionEmpty()){
         loginDetailsAreYouWantToDelete.setVisible(true);
         loginDetailsAreYouWantToDelete.setText("Are you sure want to delete this record?");
        loginDetailsConformationYes.setVisible(true);
        loginDetailsConformationNo.setVisible(true);
        }else{
            loginDetailsAreYouWantToDelete.setVisible(true);
            loginDetailsAreYouWantToDelete.setText("Please Select the Record To Delete");
        } 
    }//GEN-LAST:event_loginDetailsIntialDeleteBtnMouseClicked

    private void viewVisitorsRecordTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_viewVisitorsRecordTablePropertyChange
        
    }//GEN-LAST:event_viewVisitorsRecordTablePropertyChange

    Action action = new AbstractAction()
{
    public void actionPerformed(ActionEvent e)
    {
        TableCellListener tcl = (TableCellListener)e.getSource();
        updateRow=tcl.getRow();
                
    }
};
    
    
    private void complainUpdateSaveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_complainUpdateSaveBtnMouseClicked
        ComplainAreYouWantToDelete.setText("Record Has Been Updated");
               
        ComplainModel.updateComplain(updateRow,
                getUpdatedRowStringFromReleventTable(ComplainViewTable,updateRow)
                        );
       ComplainModel.viewComplain(ComplainViewTable);
        
    }//GEN-LAST:event_complainUpdateSaveBtnMouseClicked

    private void visitorUpdateIntialBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visitorUpdateIntialBtnMouseClicked
        VisitorAreYouWantToDelete.setText("Record Has Been Updated");
        VisitorModel.updateVisitors(updateRow,
                getUpdatedRowStringFromReleventTable(viewVisitorsRecordTable,updateRow)
                        );
               VisitorModel.viewVisitor(viewVisitorsRecordTable);

        
    }//GEN-LAST:event_visitorUpdateIntialBtnMouseClicked

    private void recievedUpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recievedUpdateBtnMouseClicked
        recievedAreYouWantToDelete.setText("Record Has Been Updated");
               
        RecievedPostModel.updateRecieved(updateRow,
                getUpdatedRowStringFromReleventTable(viewRecivedTable,updateRow)
                        );
        RecievedPostModel.viewRecievedPost(viewRecivedTable);
    }//GEN-LAST:event_recievedUpdateBtnMouseClicked

    private void dispatchUpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dispatchUpdateBtnMouseClicked
        dispatchAreYouWantToDelete.setText("Record Has Been Updated");
               
                DispatchModel.updateDispatch(updateRow,
                getUpdatedRowStringFromReleventTable(viewDispatchTable,updateRow)
                        );
        DispatchModel.viewDispatchPost(viewDispatchTable);
    }//GEN-LAST:event_dispatchUpdateBtnMouseClicked

    private void patientUpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientUpdateBtnMouseClicked
        patientAreYouWantToDelete.setText("Record Has Been Updated");
        notificationClear(patientAreYouWantToDelete);       
                PatientModel.updatePatient(updateRow,
                getUpdatedRowStringFromReleventTable(patientDetailsTable,updateRow)
                        );
        PatientModel.viewPatientDetails(patientDetailsTable);
    }//GEN-LAST:event_patientUpdateBtnMouseClicked

    private void MedicalOfficerUpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MedicalOfficerUpdateBtnMouseClicked
        medicalAreYouWantDelete.setText("Record Has Been Updated");
               
                MedicalOfficerModel.updateMedicalOfficer(updateRow,
                getUpdatedRowStringFromReleventTable(MedicalOfficersTable,updateRow)
                        );
        MedicalOfficerModel.viewMedicalOfficers(MedicalOfficersTable);
    }//GEN-LAST:event_MedicalOfficerUpdateBtnMouseClicked

    private void receptionistUpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receptionistUpdateBtnMouseClicked
        receptionAreYouWantToDelete.setText("Record Has Been Updated");
               
                ReceptionistModel.updateReceptionist(updateRow,
                getUpdatedRowStringFromReleventTable(ReceptiontistTable,updateRow)
                        );
        ReceptionistModel.viewReceptionist(ReceptiontistTable);
    
    }//GEN-LAST:event_receptionistUpdateBtnMouseClicked

    private void userLoginUpdateSaveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLoginUpdateSaveBtnMouseClicked
        loginDetailsAreYouWantToDelete.setText("Record Has Been Updated");
               
        UserModel.updateUser(updateRow,
        getUpdatedRowStringFromReleventTable(userLoginTable,updateRow)
                        );
        UserModel.viewLoginDetails(userLoginTable);
    
    }//GEN-LAST:event_userLoginUpdateSaveBtnMouseClicked

    private void maximumBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maximumBtnMouseClicked
        if(this.getExtendedState()!=this.MAXIMIZED_BOTH){
          this.setExtendedState(this.MAXIMIZED_BOTH);
        }
        else{
            this.setExtendedState(this.NORMAL);
        }
    }//GEN-LAST:event_maximumBtnMouseClicked

    private void userTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_userTypeItemStateChanged
        if(userType.getSelectedItem()=="Patient"){
            emailLabel.hide();
            emailText.hide();
            bloodG.show();
            bloodSel.show();
            allergiesLabel.show();
            addNewUserAllergies.setVisible(true);
            StaffIDLabel.setVisible(false);
            AddNewStaffID.setVisible(false);
            AddNewUserSpecializedAreaDropDown.setVisible(false);
            AddNewUserSpecializedAreaLabel.setVisible(false);
        }else if(userType.getSelectedItem()=="Receptionist"){
            StaffIDLabel.setVisible(true);
            AddNewStaffID.setVisible(true);
            bloodG.hide();
            bloodSel.hide();
            allergiesLabel.hide();
            addNewUserAllergies.setVisible(false);
            emailLabel.setVisible(true);
            emailText.setVisible(true);
            AddNewUserSpecializedAreaDropDown.setVisible(false);
            AddNewUserSpecializedAreaLabel.setVisible(false);
        }else if(userType.getSelectedItem()=="Medical officer"){
            StaffIDLabel.setVisible(true);
            AddNewStaffID.setVisible(true);
            bloodG.hide();
            bloodSel.hide();
            allergiesLabel.hide();
            addNewUserAllergies.setVisible(false);
            emailLabel.setVisible(true);
            emailText.setVisible(true);
            AddNewUserSpecializedAreaDropDown.setVisible(true);
            AddNewUserSpecializedAreaLabel.setVisible(true);
        }
    }//GEN-LAST:event_userTypeItemStateChanged

    private void bloodSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloodSelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloodSelActionPerformed

    private void addNewUserBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewUserBtnMouseClicked
        //validation part
        //checking the null state of the text fields

        boolean textField1=addNewUserName.getText().equals("");
        boolean textField2=addNewUserFirstName.getText().equals("");
        boolean textField3=addNewUserLastName.getText().equals("");
        boolean textField4=addNewUserPhoneNo.getText().equals("");
        boolean textField5=addNewUserAddressTextArea.getText().equals("");
        boolean textField6=addNewUserNIC.getText().equals("");
        ButtonModel selectedGender = genderGroup.getSelection();

        AddNewUserGenderMale.setActionCommand("MALE");
        AddNewUserGenderFemale.setActionCommand("FEMALE");
        addNewUserMarriedState.setActionCommand("MARRIED");
        addNewUserUnMarriedState.setActionCommand("UNMARRIED");

        if(!(textField1 || textField2 || textField3 || textField4 || textField5 || textField6)){
            date AddNewUserDOB=new date(
                (Integer)AddNewUserDOBDay.getValue(),
                (Integer)AddNewUserDOBMoth.getValue(),
                (Integer)AddNewUserDOBYear.getValue()
            );
            loginController newUser=null;
            if((userType.getSelectedItem()).toString()=="Patient"){

                if(addNewUserAllergies.getText().equals("")){
                    addNewUserFormNotificationLabel.setText("Please Fill The Data Fields");
                    notificationClear(addNewUserFormNotificationLabel);
                }else{
                    if(UserModel.userNameChecker(addNewUserName.getText())){
                        addNewUserFormNotificationLabel.setText("UserName Already Taken!");
                        notificationClear(addNewUserFormNotificationLabel);
                    }else{
                        addNewUserFormNotificationLabel.setText("Sumbiting A Requset");
                        notificationClear(addNewUserFormNotificationLabel);
                    //setup a date
                    patient newPatient=new patient(
                        addNewUserName.getText(),
                        addNewUserFirstName.getText(),
                        addNewUserLastName.getText(),
                        Integer.parseInt(addNewUserPhoneNo.getText()),
                        addNewUserNIC.getText(),
                        AddNewUserDOB,
                        addNewUserAddressTextArea.getText(),
                        bloodSel.getSelectedItem().toString(),
                        genderGroup.getSelection().getActionCommand(),
                        marriedState.getSelection().getActionCommand(),
                        addNewUserAllergies.getText()    
                    );
                    //passing the value to model for write txt
                    PatientModel.writingTXT(newPatient.toString());
                    newPatient.newLoginPatient();
                    }
               }

            }
            if((userType.getSelectedItem()).toString()=="Receptionist"){
                if(AddNewStaffID.getText().equals("")){
                    addNewUserFormNotificationLabel.setText("Please Fill The Data Fields");
                    notificationClear(addNewUserFormNotificationLabel);
                }else{

                    if(UserModel.userNameChecker(addNewUserName.getText())){
                    
                        addNewUserFormNotificationLabel.setText("UserName Already Taken!");
                        notificationClear(addNewUserFormNotificationLabel);
                    }else{
                    addNewUserFormNotificationLabel.setText("Sumbiting A Requset");
                    notificationClear(addNewUserFormNotificationLabel);
                    //setup a date
                    receptionist newReceptionist=new receptionist(
                        Integer.parseInt(AddNewStaffID.getText()),
                        emailText.getText(),
                        addNewUserName.getText(),
                        addNewUserFirstName.getText(),
                        addNewUserLastName.getText(),
                        Integer.parseInt(addNewUserPhoneNo.getText()),
                        addNewUserNIC.getText(),
                        AddNewUserDOB,
                        addNewUserAddressTextArea.getText(),
                        genderGroup.getSelection().getActionCommand(),
                        marriedState.getSelection().getActionCommand()
                    );
                    //passing the value to model for write txt
                    ReceptionistModel.writingTXT(newReceptionist.toString());
                    newReceptionist.newLoginReceptionist();
                    }
                }
            }
            if((userType.getSelectedItem()).toString()=="Medical officer"){
                if(AddNewStaffID.getText().equals("") && emailText.getText().equals("")){
                    addNewUserFormNotificationLabel.setText("Please Fill The Data Fields");
                    notificationClear(addNewUserFormNotificationLabel);
                }else{
                    if(UserModel.userNameChecker(addNewUserName.getText())){
                        addNewUserFormNotificationLabel.setText("UserName Already Taken!");
                        notificationClear(addNewUserFormNotificationLabel);
                    }else{
                        addNewUserFormNotificationLabel.setText("Sumbiting A Requset");
                        notificationClear(addNewUserFormNotificationLabel);
                    //setup a date
                        medicalOfficers newMedicalOfficerObj=new medicalOfficers(
                        Integer.parseInt(AddNewStaffID.getText()),
                        emailText.getText(),
                        AddNewUserSpecializedAreaDropDown.getSelectedItem().toString(),
                        addNewUserName.getText(),
                        addNewUserFirstName.getText(),
                        addNewUserLastName.getText(),
                        Integer.parseInt(addNewUserPhoneNo.getText()),
                        addNewUserNIC.getText(),
                        AddNewUserDOB,
                        addNewUserAddressTextArea.getText(),
                        genderGroup.getSelection().getActionCommand(),
                        marriedState.getSelection().getActionCommand()
                    );
                    //passing the value to model for write txt
                    MedicalOfficerModel.writingTXT(newMedicalOfficerObj.toString());
                    newMedicalOfficerObj.newLoginMedicalOfficer();
                    }
                    }
             }
        }else{
            addNewUserFormNotificationLabel.setText("Please Fill The Data Fields");
            notificationClear(addNewUserFormNotificationLabel);
        }
    }//GEN-LAST:event_addNewUserBtnMouseClicked

    private void addNewComplainDepartmentBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewComplainDepartmentBtnMouseClicked
        referenceController newComplainDepartmentObj= new referenceController(addNewComplainDepartment.getText(),true); 
        newComplainDepartmentObj.newRecord();        
        referenceNotification.setText("Department Added");
        dropDownFeederModel departmentObj=new dropDownFeederModel("departments.txt",avalaibleDepartmentDropDown);
        departmentObj.dropFeeder(true);
    }//GEN-LAST:event_addNewComplainDepartmentBtnMouseClicked

    private void addNewSpecialistAreaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewSpecialistAreaBtnMouseClicked
        referenceController newSpecialAreaObj= new referenceController(addNewSpecialistArea.getText(),false); 
        newSpecialAreaObj.newRecord();        
        referenceNotification.setText("Specialized Area Added");
        dropDownFeederModel specialAreaObj=new dropDownFeederModel("specializedArea.txt",specializedAreaDropDown);
        specialAreaObj.dropFeeder(true);
    }//GEN-LAST:event_addNewSpecialistAreaBtnMouseClicked

    private void deleteComplainBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteComplainBtnMouseClicked
        referenceNotification.setText("Are You Want To Delete?");
        referenceDeleteConformationYes.setVisible(true);
        referenceDeleteConformationNo.setVisible(true);
        referenceState=1;
    }//GEN-LAST:event_deleteComplainBtnMouseClicked

    private void minimumBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimumBtnMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimumBtnMouseClicked

    private void deleteSpecialAreaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteSpecialAreaBtnMouseClicked
        referenceNotification.setText("Are You Want To Delete?");
        referenceDeleteConformationYes.setVisible(true);
        referenceDeleteConformationNo.setVisible(true);
        referenceState=2;
    }//GEN-LAST:event_deleteSpecialAreaBtnMouseClicked

    private void referenceDeleteConformationNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_referenceDeleteConformationNoMouseClicked
        referenceNotification.setText("");
        referenceDeleteConformationYes.setVisible(false);
        referenceDeleteConformationNo.setVisible(false);
    }//GEN-LAST:event_referenceDeleteConformationNoMouseClicked

    private void referenceDeleteConformationYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_referenceDeleteConformationYesMouseClicked
        if(referenceState==1){
            try {
                ReferenceModel.deleteRefRecord(1,deleteComplainDepartment.getSelectedItem().toString());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            dropDownFeederModel departmentObj=new dropDownFeederModel("departments.txt",deleteComplainDepartment);
            departmentObj.dropFeeder(true);
       }else{
        
            try {
                ReferenceModel.deleteRefRecord(2,deleteSpecialArea.getSelectedItem().toString());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            dropDownFeederModel specialAreaObj=new dropDownFeederModel("specializedArea.txt",deleteSpecialArea);
            specialAreaObj.dropFeeder(true);
        }
        
        referenceDeleteConformationYes.setVisible(false);
        referenceDeleteConformationNo.setVisible(false);
        referenceNotification.setText("Record Deleted!");
    }//GEN-LAST:event_referenceDeleteConformationYesMouseClicked

    private void logOutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseClicked
        new startLogin().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logOutBtnMouseClicked

    private void saveToJsonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveToJsonMouseClicked
        ReportModel.patientToJson();
        reportNotification.setText("JSON Saved");
        notificationClear(reportNotification);
    }//GEN-LAST:event_saveToJsonMouseClicked

    private void resetPatientPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetPatientPasswordMouseClicked
        if(!patientDetailsTable.getSelectionModel().isSelectionEmpty()){
           UserModel.patientPassReset(getSelectedRowStringFromReleventTable(patientDetailsTable));
            patientAreYouWantToDelete.setText("Password Reset");
            notificationClear(patientAreYouWantToDelete);
        }else{
            patientAreYouWantToDelete.setText("Select the Row to Reset");
            notificationClear(patientAreYouWantToDelete);
        }
    }//GEN-LAST:event_resetPatientPasswordMouseClicked

    private void resetMedicalOfficerPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMedicalOfficerPasswordMouseClicked
        if(!MedicalOfficersTable.getSelectionModel().isSelectionEmpty()){
             
        UserModel.medicalPassReset(getSelectedRowStringFromReleventTable(MedicalOfficersTable));
        medicalAreYouWantDelete.setText("Password Reset");
        notificationClear(medicalAreYouWantDelete);
        }else{
            medicalAreYouWantDelete.setText("Select the Row to Reset");
            notificationClear(medicalAreYouWantDelete);
        }
    }//GEN-LAST:event_resetMedicalOfficerPasswordMouseClicked

    private void resetReceptionPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetReceptionPasswordMouseClicked
        if(!ReceptiontistTable.getSelectionModel().isSelectionEmpty()){
           UserModel.receptionistPassReset(getSelectedRowStringFromReleventTable(ReceptiontistTable));
            receptionAreYouWantToDelete.setText("Password Reset");
            notificationClear(receptionAreYouWantToDelete);
        }else{
            receptionAreYouWantToDelete.setText("Select the Row to Reset");
            notificationClear(receptionAreYouWantToDelete);
        }
    }//GEN-LAST:event_resetReceptionPasswordMouseClicked

    private void saveToPdfAppMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveToPdfAppMouseClicked
        try {
            ReportModel.appointmentToPDF(AppointmentModel.medicalOffierAppoinmentSelecter(pdfMedicalOfficersDropDown.getSelectedItem().toString()),pdfMedicalOfficersDropDown.getSelectedItem().toString());
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        reportNotification.setText("Pdf Saved");
        notificationClear(reportNotification);
    }//GEN-LAST:event_saveToPdfAppMouseClicked

    private void viewAppointmentBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewAppointmentBtnMouseClicked
        AppointmentModel.viewAppointment(viewAppointmentTable);

    }//GEN-LAST:event_viewAppointmentBtnMouseClicked

    private void viewAppointmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewAppointmentTableMouseClicked

        if(!viewAppointmentTable.getSelectionModel().isSelectionEmpty()){
            AppIntialDeleteBtn.setEnabled(true);
            AppIntialSaveBtn.setEnabled(true);
        }
    }//GEN-LAST:event_viewAppointmentTableMouseClicked

    private void deleteConformationNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteConformationNoMouseClicked
        deleteConformationYes.setVisible(false);
        deleteConformationNo.setVisible(false);
        areYouWantToDelete.setVisible(false);
    }//GEN-LAST:event_deleteConformationNoMouseClicked

    private void deleteConformationYesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteConformationYesMouseClicked
        if(!viewAppointmentTable.getSelectionModel().isSelectionEmpty()){

            appointmentController deleteAppObj=new appointmentController(getSelectedRowStringFromReleventTable(viewAppointmentTable));
            AppointmentModel.deleteAppointment(deleteAppObj);
            AppointmentModel.viewAppointment(viewAppointmentTable);
            deleteConformationYes.setVisible(false);
            deleteConformationNo.setVisible(false);
            areYouWantToDelete.setVisible(false);

        }else{

            areYouWantToDelete.setText("Please Select the Row to Delete");
            deleteConformationYes.setVisible(false);
            deleteConformationNo.setVisible(false);
            notificationClear(areYouWantToDelete);

        }

    }//GEN-LAST:event_deleteConformationYesMouseClicked

    private void AppIntialDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppIntialDeleteBtnMouseClicked
        if(!viewAppointmentTable.getSelectionModel().isSelectionEmpty()){
            areYouWantToDelete.setVisible(true);
            areYouWantToDelete.setText("Are you sure want to delete this record?");
            deleteConformationYes.setVisible(true);
            deleteConformationNo.setVisible(true);
        }else{
            areYouWantToDelete.setVisible(true);
            areYouWantToDelete.setText("Please Select the Record To Delete");
            notificationClear(areYouWantToDelete);
        }
    }//GEN-LAST:event_AppIntialDeleteBtnMouseClicked

    private void AppIntialSaveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AppIntialSaveBtnMouseClicked
        areYouWantToDelete.setVisible(true);
        areYouWantToDelete.setText("Record Has Been Updated");
        notificationClear(areYouWantToDelete);
        AppointmentModel.updateAppointment(updateRow,
            getUpdatedRowStringFromReleventTable(viewAppointmentTable,updateRow)
        );
        AppointmentModel.viewAppointment(viewAppointmentTable);
    }//GEN-LAST:event_AppIntialSaveBtnMouseClicked

    private void AddNewAppointmnetSpecializedAreaDropDownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AddNewAppointmnetSpecializedAreaDropDownItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            //remove the existing valus of drop down menu
            MedicalOfficerDropDown.removeAllItems();
            dropDownFeederModel medicalOfficerDropDownObj=new dropDownFeederModel("medicalOfficerDetails.txt",
                MedicalOfficerDropDown,
                AddNewAppointmnetSpecializedAreaDropDown.getSelectedItem().toString());
            medicalOfficerDropDownObj.dropFeeder();

        }
    }//GEN-LAST:event_AddNewAppointmnetSpecializedAreaDropDownItemStateChanged

    private void AddNewAppointmentBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddNewAppointmentBtnMouseClicked
        boolean textField11=addNewAppointmentPatientName.getText().equals("");
        boolean textField12=addNewAppointmentSymptoms.getText().equals("");

        if(!(textField11 || textField12)){

            addNewAppointmentNotficationLabel.setText("Sumbiting the Appointment");
            notificationClear(addNewAppointmentNotficationLabel);
            date appointmentDateObj=new date(
                (Integer)addNewAppointmentDay.getValue(),
                (Integer)addNewAppointmentMonth.getValue(),
                (Integer)addNewAppointmentYear.getValue()
            );
            time appointmentTimeObj=new time(
                (Integer)AddNewAppointmentMinutes.getValue(),
                (Integer)AddNewAppointmentHours.getValue(),
                AddNewAppointmentAMPM.getSelectedItem().toString()
            );
            appointmentController addNewApp=new appointmentController(
                addNewAppointmentPatientName.getText(),//0
                MedicalOfficerDropDown.getSelectedItem().toString(),//1
                appointmentDateObj,//2
                appointmentTimeObj,//3
                addNewAppointmentSymptoms.getText(),//4
                "Pending",//5
                AppointmentModel.getNextAppRefNo());//6

            AppointmentModel.writingTXT(addNewApp.toString());

        }else{
            addNewAppointmentNotficationLabel.setText("Please fill all fields");
            notificationClear(addNewAppointmentNotficationLabel);

        }

    }//GEN-LAST:event_AddNewAppointmentBtnMouseClicked

    private void saveToJson1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveToJson1MouseClicked
        ReportModel.medicalToJson();
        reportNotification.setText("JSON Saved");
        notificationClear(reportNotification);
    }//GEN-LAST:event_saveToJson1MouseClicked

    private void saveToJson2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveToJson2MouseClicked
        ReportModel.receptionistToJson();
        reportNotification.setText("JSON Saved");
        notificationClear(reportNotification);
    }//GEN-LAST:event_saveToJson2MouseClicked
 
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
                
                new homeAdminGUI("ADMIN").setVisible(true);
                
            }
        });
  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AddNewAppointmentAMPM;
    private javax.swing.JButton AddNewAppointmentBtn;
    private javax.swing.JSpinner AddNewAppointmentHours;
    private javax.swing.JSpinner AddNewAppointmentMinutes;
    private javax.swing.JComboBox<String> AddNewAppointmnetSpecializedAreaDropDown;
    private javax.swing.JButton AddNewComplainBtn;
    private javax.swing.JTextArea AddNewComplainDesTextArea;
    private javax.swing.JTextField AddNewComplainName;
    private javax.swing.JTextArea AddNewComplainNote;
    private javax.swing.JTextField AddNewComplainPhoneNumber;
    private javax.swing.JComboBox<String> AddNewComplainReferenceDepartment;
    private javax.swing.JButton AddNewDispatchPost;
    private javax.swing.JButton AddNewRecievedPost;
    private javax.swing.JTextField AddNewStaffID;
    private javax.swing.JSpinner AddNewUserDOBDay;
    private javax.swing.JSpinner AddNewUserDOBMoth;
    private javax.swing.JSpinner AddNewUserDOBYear;
    private javax.swing.JRadioButton AddNewUserGenderFemale;
    private javax.swing.JRadioButton AddNewUserGenderMale;
    private javax.swing.JComboBox<String> AddNewUserSpecializedAreaDropDown;
    private javax.swing.JLabel AddNewUserSpecializedAreaLabel;
    private javax.swing.JLabel AddNewUserSpecializedAreaLabel1;
    private javax.swing.JButton AddNewVisitorRecord;
    private javax.swing.JButton AppIntialDeleteBtn;
    private javax.swing.JButton AppIntialSaveBtn;
    private javax.swing.JLabel ComplainAreYouWantToDelete;
    private javax.swing.JButton ComplainDeleteIntialBtn;
    private javax.swing.JTable ComplainViewTable;
    private javax.swing.JButton DispatchDeleteConformationNo;
    private javax.swing.JButton DispatchDeleteConformationYes;
    private javax.swing.JButton DispatchIntialDeleteBtn;
    private javax.swing.JTextField DispatchPostAddress;
    private javax.swing.JSpinner DispatchPostDay;
    private javax.swing.JTextField DispatchPostFrom;
    private javax.swing.JSpinner DispatchPostMonth;
    private javax.swing.JTextArea DispatchPostNote;
    private javax.swing.JTextField DispatchPostRefNo;
    private javax.swing.JTextField DispatchPostTo;
    private javax.swing.JSpinner DispatchPostYear;
    private javax.swing.JComboBox<String> MedicalOfficerDropDown;
    private javax.swing.JButton MedicalOfficerUpdateBtn;
    private javax.swing.JPanel MedicalOfficersDetailsViewTab;
    private javax.swing.JTable MedicalOfficersTable;
    private javax.swing.JPanel ReceptiontistDetailsViewTab;
    private javax.swing.JTable ReceptiontistTable;
    private javax.swing.JButton RecievedDeleteConformationNo;
    private javax.swing.JButton RecievedDeleteConformationYes;
    private javax.swing.JTextField RecievedPostAddress;
    private javax.swing.JSpinner RecievedPostDay;
    private javax.swing.JTextField RecievedPostFrom;
    private javax.swing.JSpinner RecievedPostMonth;
    private javax.swing.JTextArea RecievedPostNote;
    private javax.swing.JTextField RecievedPostRefNo;
    private javax.swing.JTextField RecievedPostTo;
    private javax.swing.JSpinner RecievedPostYear;
    private javax.swing.JButton RecivedPostIntialDeleteBtn;
    private javax.swing.JLabel StaffIDLabel;
    private javax.swing.JTabbedPane ViewRecievedDispatchPost;
    private javax.swing.JLabel VisitorAreYouWantToDelete;
    private javax.swing.JButton VisitorIntialDeleteBtn;
    private javax.swing.JComboBox<String> VisitorRecordAmPmState;
    private javax.swing.JTextField VisitorRecordNIC;
    private javax.swing.JTextField VisitorRecordName;
    private javax.swing.JTextArea VisitorRecordNote;
    private javax.swing.JLabel VisitorRecordNotification;
    private javax.swing.JSpinner VisitorRecordOutHours;
    private javax.swing.JSpinner VisitorRecordOutMinutes;
    private javax.swing.JTextField VisitorRecordPhoneNo;
    private javax.swing.JTextField VisitorRecordPurpose;
    private javax.swing.JSpinner addNewAppointmentDay;
    private javax.swing.JSpinner addNewAppointmentMonth;
    private javax.swing.JLabel addNewAppointmentNotficationLabel;
    private javax.swing.JTextField addNewAppointmentPatientName;
    private javax.swing.JTextField addNewAppointmentSymptoms;
    private javax.swing.JSpinner addNewAppointmentYear;
    private javax.swing.JTextField addNewComplainDepartment;
    private javax.swing.JButton addNewComplainDepartmentBtn;
    private javax.swing.JTextField addNewSpecialistArea;
    private javax.swing.JButton addNewSpecialistAreaBtn;
    private javax.swing.JScrollPane addNewUserAddress;
    private javax.swing.JTextArea addNewUserAddressTextArea;
    private javax.swing.JTextField addNewUserAllergies;
    private javax.swing.JButton addNewUserBtn;
    private javax.swing.JTextField addNewUserFirstName;
    private javax.swing.JLabel addNewUserFormNotificationLabel;
    private javax.swing.JTextField addNewUserLastName;
    private javax.swing.JRadioButton addNewUserMarriedState;
    private javax.swing.JTextField addNewUserNIC;
    private javax.swing.JTextField addNewUserName;
    private javax.swing.JTextField addNewUserPhoneNo;
    private javax.swing.JRadioButton addNewUserUnMarriedState;
    private javax.swing.JPanel addVisitors;
    private javax.swing.JLabel allergiesLabel;
    private javax.swing.JPanel appPanel;
    private javax.swing.JPanel appointment;
    private javax.swing.JLabel areYouWantToDelete;
    private javax.swing.JComboBox<String> avalaibleDepartmentDropDown;
    private javax.swing.JLabel bloodG;
    private javax.swing.JComboBox<String> bloodSel;
    private javax.swing.JLabel calenderDay;
    private javax.swing.JLabel calenderMonth;
    private javax.swing.JLabel calenderYear;
    private keeptoo.KGradientPanel closeBtn;
    private javax.swing.JPanel closeMaxMinPanel;
    private javax.swing.JPanel complain;
    private javax.swing.JPanel complainPanel;
    private javax.swing.JButton complainUpdateSaveBtn;
    private javax.swing.JLabel complainWarning;
    private javax.swing.JPanel content;
    private keeptoo.KGradientPanel curvedMainPannel;
    private javax.swing.JButton deleteComplainBtn;
    private javax.swing.JButton deleteComplainConformationNo;
    private javax.swing.JButton deleteComplainConformationYes;
    private javax.swing.JComboBox<String> deleteComplainDepartment;
    private javax.swing.JButton deleteConformationNo;
    private javax.swing.JButton deleteConformationYes;
    private javax.swing.JComboBox<String> deleteSpecialArea;
    private javax.swing.JButton deleteSpecialAreaBtn;
    private javax.swing.JButton deleteVisitorRecordConformationNo;
    private javax.swing.JButton deleteVisitorRecordConformationYes;
    private javax.swing.JLabel dispatchAreYouWantToDelete;
    private javax.swing.JLabel dispatchPostNotification;
    private javax.swing.JPanel dispatchTab;
    private javax.swing.JButton dispatchUpdateBtn;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JPanel footer;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JPanel header;
    private javax.swing.JLabel headerTextClock;
    private javax.swing.JLabel headerTextMain;
    private javax.swing.JPanel home;
    private javax.swing.JPanel homePannel;
    private keeptoo.KGradientPanel hourHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane5;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel loginDetailsAreYouWantToDelete;
    private javax.swing.JButton loginDetailsConformationNo;
    private javax.swing.JButton loginDetailsConformationYes;
    private javax.swing.JButton loginDetailsIntialDeleteBtn;
    private javax.swing.JLabel mainClockAMPM;
    private javax.swing.JLabel mainClockHours;
    private javax.swing.JLabel mainClockMinutes;
    private javax.swing.JLabel mainClockSeconds;
    private javax.swing.ButtonGroup marriedState;
    private keeptoo.KGradientPanel maximumBtn;
    private javax.swing.JLabel medicalAreYouWantDelete;
    private javax.swing.JButton medicalDeleteConformationNo;
    private javax.swing.JButton medicalDeleteConformationYes;
    private javax.swing.JButton medicalIntialDeleteBtn;
    private keeptoo.KGradientPanel minimumBtn;
    private keeptoo.KGradientPanel minutesHome;
    private javax.swing.JPanel newAppPanel;
    private javax.swing.JLabel patientAreYouWantToDelete;
    private javax.swing.JButton patientDeleteConformationNo;
    private javax.swing.JButton patientDeleteConformationYes;
    private javax.swing.JPanel patientDetailsTab;
    private javax.swing.JTable patientDetailsTable;
    private javax.swing.JButton patientIntialDeleteBtn;
    private javax.swing.JButton patientUpdateBtn;
    private javax.swing.JComboBox<String> pdfMedicalOfficersDropDown;
    private javax.swing.JPanel postal;
    private javax.swing.JPanel postalPanel;
    private javax.swing.JLabel receptionAreYouWantToDelete;
    private javax.swing.JButton receptionConformationNo;
    private javax.swing.JButton receptionConformationYes;
    private javax.swing.JButton receptionIntialDeleteBtn;
    private javax.swing.JButton receptionistUpdateBtn;
    private javax.swing.JLabel recievedAreYouWantToDelete;
    private javax.swing.JLabel recievedPostNotification;
    private javax.swing.JPanel recievedTab;
    private javax.swing.JButton recievedUpdateBtn;
    private javax.swing.JPanel reference;
    private javax.swing.JButton referenceDeleteConformationNo;
    private javax.swing.JButton referenceDeleteConformationYes;
    private javax.swing.JLabel referenceNotification;
    private javax.swing.JPanel referencePanel;
    private javax.swing.JPanel report;
    private javax.swing.JLabel reportNotification;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JButton resetMedicalOfficerPassword;
    private javax.swing.JButton resetPatientPassword;
    private javax.swing.JButton resetReceptionPassword;
    private javax.swing.JButton saveToJson;
    private javax.swing.JButton saveToJson1;
    private javax.swing.JButton saveToJson2;
    private javax.swing.JButton saveToPdfApp;
    private javax.swing.JPanel sideMenu;
    private javax.swing.JComboBox<String> specializedAreaDropDown;
    private javax.swing.JPanel user;
    private javax.swing.JTable userLoginTable;
    private javax.swing.JButton userLoginUpdateSaveBtn;
    private javax.swing.JPanel userPanel;
    private javax.swing.JComboBox<String> userType;
    private javax.swing.JPanel viewAppPanel;
    private javax.swing.JTabbedPane viewAppointmentBtn;
    private javax.swing.JTable viewAppointmentTable;
    private javax.swing.JTabbedPane viewComplainBtn;
    private javax.swing.JPanel viewDispatchTab;
    private javax.swing.JTable viewDispatchTable;
    private javax.swing.JPanel viewRecivedTab;
    private javax.swing.JTable viewRecivedTable;
    private javax.swing.JPanel viewVisitors;
    private javax.swing.JTabbedPane viewVisitorsBtn;
    private javax.swing.JTable viewVisitorsRecordTable;
    private javax.swing.JScrollPane viewVisitorsTable;
    private javax.swing.JButton visitorUpdateIntialBtn;
    private javax.swing.JPanel visitors;
    private javax.swing.JPanel visitorsPanel;
    // End of variables declaration//GEN-END:variables

/*
 *  This class listens for changes made to the data in the table via the
 *  TableCellEditor. When editing is started, the value of the cell is saved
 *  When editing is stopped the new value is saved. When the oold and new
 *  values are different, then the provided Action is invoked.
 *
 *  The source of the Action is a TableCellListener instance.
 */
public class TableCellListener implements PropertyChangeListener, Runnable
{
	private JTable table;
	private Action action;

	private int row;
	private int column;
	private Object oldValue;
	private Object newValue;

	/**
	 *  Create a TableCellListener.
	 *
	 *  @param table   the table to be monitored for data changes
	 *  @param action  the Action to invoke when cell data is changed
	 */
	public TableCellListener(JTable table, Action action)
	{
		this.table = table;
		this.action = action;
		this.table.addPropertyChangeListener( this );
	}

	/**
	 *  Create a TableCellListener with a copy of all the data relevant to
	 *  the change of data for a given cell.
	 *
	 *  @param row  the row of the changed cell
	 *  @param column  the column of the changed cell
	 *  @param oldValue  the old data of the changed cell
	 *  @param newValue  the new data of the changed cell
	 */
	private TableCellListener(JTable table, int row, int column, Object oldValue, Object newValue)
	{
		this.table = table;
		this.row = row;
		this.column = column;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	/**
	 *  Get the column that was last edited
	 *
	 *  @return the column that was edited
	 */
	public int getColumn()
	{
		return column;
	}

	/**
	 *  Get the new value in the cell
	 *
	 *  @return the new value in the cell
	 */
	public Object getNewValue()
	{
		return newValue;
	}

	/**
	 *  Get the old value of the cell
	 *
	 *  @return the old value of the cell
	 */
	public Object getOldValue()
	{
		return oldValue;
	}

	/**
	 *  Get the row that was last edited
	 *
	 *  @return the row that was edited
	 */
	public int getRow()
	{
		return row;
	}

	/**
	 *  Get the table of the cell that was changed
	 *
	 *  @return the table of the cell that was changed
	 */
	public JTable getTable()
	{
		return table;
	}
//
//  Implement the PropertyChangeListener interface
//
	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		//  A cell has started/stopped editing

		if ("tableCellEditor".equals(e.getPropertyName()))
		{
			if (table.isEditing())
				processEditingStarted();
			else
				processEditingStopped();
		}
	}

	/*
	 *  Save information of the cell about to be edited
	 */
	private void processEditingStarted()
	{
		//  The invokeLater is necessary because the editing row and editing
		//  column of the table have not been set when the "tableCellEditor"
		//  PropertyChangeEvent is fired.
		//  This results in the "run" method being invoked

		SwingUtilities.invokeLater( this );
	}
	/*
	 *  See above.
	 */
	@Override
	public void run()
	{
		row = table.convertRowIndexToModel( table.getEditingRow() );
		column = table.convertColumnIndexToModel( table.getEditingColumn() );
		oldValue = table.getModel().getValueAt(row, column);
		newValue = null;
	}

	/*
	 *	Update the Cell history when necessary
	 */
	private void processEditingStopped()
	{
		newValue = table.getModel().getValueAt(row, column);

		//  The data has changed, invoke the supplied Action

		if (! newValue.equals(oldValue))
		{
			//  Make a copy of the data in case another cell starts editing
			//  while processing this change

			TableCellListener tcl = new TableCellListener(
				getTable(), getRow(), getColumn(), getOldValue(), getNewValue());

			ActionEvent event = new ActionEvent(
				tcl,
				ActionEvent.ACTION_PERFORMED,
				"");
			action.actionPerformed(event);
		}
	}
}

}