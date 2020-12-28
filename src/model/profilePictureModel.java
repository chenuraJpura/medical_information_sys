package model;

import controllers.profilePicController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FilenameUtils;
import view.homeAdminGUI;
import view.homePatientGUI;

public class profilePictureModel {
    
    private static String filePath = "userData\\profilePictureDetails.txt";
    
       //notification clear--------------------------------------------------------
    private static void notificationClear(JLabel notificationLabel){   
    new Timer(2500, (ActionEvent e) -> {
        notificationLabel.setText("");
    }).start();
    }
    
    public static void profilePicLoader(JLabel picLabel,String userName){
            try {
                BufferedImage img=ImageIO.read(new File("userData\\userPhoto\\"+profilePictureModel.getProfilePicture(userName)));
                picLabel.setIcon(new ImageIcon(img));
                picLabel.revalidate();
                picLabel.repaint();
                picLabel.update(picLabel.getGraphics());
            }catch(IOException ex){
                System.out.println(ex);
            }
        //-------------------------------------------------------------------------
    }
    //insert function----------------------------------------------------------
    public static void writingTXT(String AddNewPicDetail,String userName){//writing to objcet to file 
    
    BufferedWriter bw = null;
      try {//try catch start
                //file function
                File file = new File(filePath);
                boolean matchedState=false;
                if (!file.exists()) {//checking the is given file exists
                    file.createNewFile();//creating new file
                    Exception fileError =new IOException("File is not founded");
                }
                
            BufferedReader br = new BufferedReader(new FileReader(file));
            FileWriter fw = new FileWriter(file,true);
            bw = new BufferedWriter(fw);
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
             //all object are stor in temp in this array 
            ArrayList<profilePicController> lineObjList = new ArrayList<profilePicController>();
            profilePicController currAppObj;
            // extratct data from lines
            int matchedElemetNo=0;
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                if(dataRow[0].equals(userName)){
                    matchedState=true;
                    matchedElemetNo=i;
                    
                }
                currAppObj=new profilePicController(dataRow);
                lineObjList.add(currAppObj);
            }
            
            if(matchedState==true){
                profilePicController editedObj;
                editedObj=lineObjList.get(matchedElemetNo);
                editedObj.setFileName(AddNewPicDetail);
                lineObjList.set(matchedElemetNo,editedObj);
                
                //deleting a all lines in the txt
                PrintWriter writer = new PrintWriter(file);
                writer.print("");
                writer.close();
                
                    //writing existing files to txt 
            for(profilePicController loopObj: lineObjList){
                
                bw.write(loopObj.toString());
                bw.newLine();
                
            }
                
            }else{
                bw.write(userName+","+AddNewPicDetail);
                bw.newLine();
            }
            br.close();
                
                
                
        }catch (IOException ioe) {
          System.out.println(ioe);
          ioe.printStackTrace();
      }
	finally
    { 
        try{
                if(bw!=null){
                        bw.close();
                            }
                    }catch(Exception ex)
                    
                    {
                            System.out.println("Error in closing the BufferedWriter"+ex);
           }
	}
    }//end of the function
    //view function------------------------------------------------------------
    public static String getProfilePicture(String userName){
    String picFilePath="default.png";
    File file = new File(filePath);
    try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // get lines from txt file
            Object[] tableLines = br.lines().toArray();
            // extratct data from lines
            for(int i = 0; i < tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(",");
                if(dataRow[0].equals(userName)){
                       picFilePath=dataRow[1];
                }
            }
            br.close();
    }catch (Exception ex){
                    Logger.getLogger(homeAdminGUI.class.getName()).log(Level.SEVERE, null, ex);
    }
        return picFilePath;
    
} 
    //image change
    public static void changeProfilePicture(JLabel notificationLabel,String NIC,String userName){
    
         JFileChooser file = new JFileChooser();
            file.setFileSelectionMode(JFileChooser.FILES_ONLY);
            file.setDialogTitle("Choose a image");
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            //filter the files
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg","png");
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);
            //if the user click on save in Jfilechooser
            if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
                               
                profilePictureModel.writingTXT(NIC+"."+FilenameUtils.getExtension(path)
                        ,userName);
            //copy section---------------------------------------------------------------------------------------------
            Path FROM = Paths.get(path);
            Path TO = Paths.get("userData\\userPhoto\\"+NIC+"."+FilenameUtils.getExtension(path));
            //overwrite the destination file if it exists, and copy
            // the file attributes, including the rwx permissions
                CopyOption[] options = new CopyOption[]{
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES
                }; 
                try {
                    Files.copy(FROM, TO, options);
                    notificationLabel.setText("Profile Picture Updated");
                    notificationClear(notificationLabel);
                } catch (IOException ex) {
                    Logger.getLogger(homePatientGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            //if the user click on save in Jfilechooser
            }else if(result == JFileChooser.CANCEL_OPTION){
              notificationLabel.setText("No File Select");
              notificationClear(notificationLabel);

            }
            
        
    }
    
    
}
