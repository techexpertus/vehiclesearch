package service;

import model.FileDetails;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import javax.activation.MimetypesFileTypeMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Service
public class FilesRetrieverSvcImpl implements FilesRetrieverSvc {

    private MimetypesFileTypeMap mimeTypes = getMimetypesFileTypeMap();

    @Override
    public List<FileDetails> getFiles(String dirPath) {
        List<FileDetails> matchedFiles = new ArrayList<>();

        try {
            Files.list(Paths.get(dirPath))
                 .forEach(addFiles(matchedFiles)
                 );
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return matchedFiles;
    }

    @Override
    public List<FileDetails> getFiles(String dirPath, List<String> allowedMimeTypes) {
        List<FileDetails> matchedFiles = new ArrayList<>();

        try {
            Files.list(Paths.get(dirPath))
                 .filter(isAllowableMimeType(allowedMimeTypes))
                 .forEach(addFiles(matchedFiles));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }

        return matchedFiles;
    }

    private Consumer<Path> addFiles(List<FileDetails> matchedFiles) {
        return path -> matchedFiles.add(
                FileDetails.getNewFileDetails(
                        path.getFileName().toString(),
                        mimeTypes.getContentType(path.getFileName().toString()),
                        path.toFile().length(),
                        FilenameUtils.getExtension(path.getFileName().toString())
                ));
    }

    private Predicate<Path> isAllowableMimeType(List<String> allowedMimeType) {
        return path -> allowedMimeType.stream().anyMatch(mime -> {
            final String filename = path.getFileName().toString();
            String fileMime = mimeTypes.getContentType(filename);
            return fileMime.equals(mime);
        });
    }

    private MimetypesFileTypeMap getMimetypesFileTypeMap() {
        MimetypesFileTypeMap resultMimeTypes = new MimetypesFileTypeMap();
        resultMimeTypes.addMimeTypes("application/msword doc DOC");
        resultMimeTypes.addMimeTypes("application/json json JSON");
        resultMimeTypes.addMimeTypes("application/vnd.ms-excel xls XLS xlsx");
        resultMimeTypes.addMimeTypes("application/pdf pdf PDF");
        resultMimeTypes.addMimeTypes("application/xml xml XML");
        resultMimeTypes.addMimeTypes("text/html html htm HTML HTM");
        resultMimeTypes.addMimeTypes("text/plain txt text TXT TEXT");
        resultMimeTypes.addMimeTypes("text/csv csv CSV");
        return resultMimeTypes;
    }
}
