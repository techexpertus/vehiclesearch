import config.FilesRetrieverSvcConfig;
import model.FileDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.FilesRetrieverSvc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FilesRetrieverSvcConfig.class)
public class FilesRetrieverSvcIT {

    @Autowired
    private FilesRetrieverSvc filesRetrieverSvc;

    @Value("${SEARCH_PATH:/Users/shambugpujar/IdeaProjects/vehiclesearch/file-retriever-service/src/test/resources/data}")
    private String searchPath;

    @Test
    public void shouldReturnAllFiles() {
        assertThat(filesRetrieverSvc.getFiles(searchPath), hasSize(11));
    }

    @Test
    public void shouldReturnFileDetails() {

        boolean result = filesRetrieverSvc.getFiles(searchPath).stream()
                                          .anyMatch(
                                                  fileDetails -> fileDetails.getFileName().equals("vehicles_01.csv")
                                                          && fileDetails.getFileMimeType().equals("text/csv")
                                                          && fileDetails.getFileSize().equals(136L)
                                                          && fileDetails.getFileExtn().equals("csv")
                                          );
        assertTrue(result);
    }

    @Test
    public void shouldRetrieveFilesBasedOnAllowableMimeTypes() {
        List<String> allowableMimeTypes = Arrays.asList("application/vnd.ms-excel", "text/csv");
        List<FileDetails> returnedFiles = filesRetrieverSvc.getFiles(searchPath, allowableMimeTypes);
        assertThat(returnedFiles, hasSize(8));
    }

    @Test
    public void filesOnlyBelongToRetrievedMimeTypes() {
        List<String> allowableMimeTypes = Arrays.asList("application/vnd.ms-excel", "text/csv");
        List<FileDetails> returnedFiles = filesRetrieverSvc.getFiles(searchPath, allowableMimeTypes);
        List<FileDetails> FilteredFiles = returnedFiles.stream()
                                                       .filter(fileDetails -> fileDetails.getFileMimeType().equals(
                                                               allowableMimeTypes.get(0))
                                                               || fileDetails.getFileMimeType().equals(
                                                               allowableMimeTypes.get(1)))
                                                       .collect(Collectors.toList());

        assertEquals(returnedFiles.size(), FilteredFiles.size());
    }
}
