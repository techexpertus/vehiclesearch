package service;

import model.FileDetails;

import javax.activation.MimetypesFileTypeMap;
import java.util.List;

public class FilesRetrieverSvcImpl implements  FilesRetrieverSvc{

    private MimetypesFileTypeMap mimeTypes = getMimetypesFileTypeMap();

    @Override
    public List<FileDetails> getFiles(String path) {
        return null;
    }

    @Override
    public List<FileDetails> getFiles(String path, List<String> allowedMimeTypes) {
        return null;
    }

    private MimetypesFileTypeMap getMimetypesFileTypeMap() {
        MimetypesFileTypeMap resultMimeTypes = new MimetypesFileTypeMap();
        resultMimeTypes.addMimeTypes("application/msword doc DOC");
        resultMimeTypes.addMimeTypes("application/json json JSON");
        resultMimeTypes.addMimeTypes("application/vnd.ms-excel xls XLS");
        resultMimeTypes.addMimeTypes("application/pdf pdf PDF");
        resultMimeTypes.addMimeTypes("application/xml xml XML");
        resultMimeTypes.addMimeTypes("text/html html htm HTML HTM");
        resultMimeTypes.addMimeTypes("text/plain txt text TXT TEXT");
        resultMimeTypes.addMimeTypes("text/csv csv CSV");
        return resultMimeTypes;
    }
}
