import config.FilesRetrieverSvcConfig;
import model.FileDetails;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.FilesRetrieverSvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FilesRetrieverSvcConfig.class)
public class FilesRetrieverSvcIT {

    @Autowired
    private FilesRetrieverSvc filesRetrieverSvc;

    @Value("${SEARCH_PATH:/Users/shambugpujar/IdeaProjects/filematcher/src/test/resources/data}")
    private String searchPath;

    @Test
    public void shouldReturnAllFiles() {
        assertThat(filesRetrieverSvc.getFiles(searchPath), hasSize(11));
    }

    @Test
    public void shouldReturnFileDetails() {

        FileDetails details = new FileDetails("vehicles_01.csv",
                                              "text/csv",
                                              0L, ".csv");
        boolean result = filesRetrieverSvc.getFiles(searchPath).stream()
                         .anyMatch(
                                 fileDetails -> fileDetails.getFileName().equals("vehicles_01.csv")
                                         && fileDetails.getFileMimeType().equals("text/csv")
                                         && fileDetails.getFileSize().equals(0L)
                                         && fileDetails.getFileExtn().equals("csv")
                         );
        assertTrue(result);
    }
}
