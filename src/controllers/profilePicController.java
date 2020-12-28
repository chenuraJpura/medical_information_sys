package controllers;

import org.apache.commons.io.FilenameUtils;

public class profilePicController {
    private String fileName;
    private boolean fileState;
    private String fileType;
    private String userName;
    
    public profilePicController(String userName){
        setUserName(userName);
        setFileName("default.png");
    }

    public profilePicController(String[] dataRow){
        setUserName(dataRow[0]);
        setFileName(dataRow[1]);
    }
    
    @Override
    public String toString() {
        return getUserName()+","+getFileName();
    }
    
    public profilePicController(String fileString,String NIC) {
        setFileName(NIC);
        setFileType(FilenameUtils.getExtension(fileString));
        fileName=getFileName()+"."+getFileType();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isFileState() {
        return fileState;
    }

    public void setFileState(boolean fileState) {
        this.fileState = fileState;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    
    
}
