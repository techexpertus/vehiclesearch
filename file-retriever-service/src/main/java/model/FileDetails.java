package model;

public class FileDetails {

    private String fileName;
    private String fileMimeType;
    private Long fileSize;
    private String fileExtn;

    public FileDetails(String fileName, String fileMimeType, Long fileSize, String fileExtn) {
        this.fileName = fileName;
        this.fileMimeType = fileMimeType;
        this.fileSize = fileSize;
        this.fileExtn = fileExtn;
    }

    public static FileDetails getNewFileDetails(String fileName, String fileMimeType, Long fileSize, String fileExtn) {
        return new FileDetails(fileName, fileMimeType, fileSize, fileMimeType);
    }
}


