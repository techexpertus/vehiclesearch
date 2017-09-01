package model;

public class FileDetails {

    private String fileName;
    private String fileMimeType;
    private Long fileSize;
    private String fileExtn;

    public String getFileName() {
        return fileName;
    }

    public String getFileMimeType() {
        return fileMimeType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public String getFileExtn() {
        return fileExtn;
    }


    public FileDetails(String fileName, String fileMimeType, Long fileSize, String fileExtn) {
        this.fileName = fileName;
        this.fileMimeType = fileMimeType;
        this.fileSize = fileSize;
        this.fileExtn = fileExtn;
    }

    public static FileDetails getNewFileDetails(String fileName, String fileMimeType, Long fileSize, String fileExtn) {
        return new FileDetails(fileName, fileMimeType, fileSize, fileExtn);
    }
}


