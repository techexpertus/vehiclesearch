package service;

import model.FileDetails;
import org.apache.commons.io.FilenameUtils;
import javax.activation.MimetypesFileTypeMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesRetrieverSvcImpl implements  FilesRetrieverSvc{

    private MimetypesFileTypeMap mimeTypes = getMimetypesFileTypeMap();

    @Override
    public List<FileDetails> getFiles(String dirPath) {
        List<FileDetails> matchedFiles = new ArrayList<>();

        try {
            Files.list(Paths.get(dirPath))
                 .forEach(path -> matchedFiles.add(
                                          FileDetails.getNewFileDetails(
                                                  path.getFileName().toString(),
                                                  mimeTypes.getContentType(path.getFileName().toString()),
                                                  path.toFile().length() / 1024,
                                                  FilenameUtils.getExtension(path.getFileName().toString())
                                          ))
                 );
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return matchedFiles;
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
