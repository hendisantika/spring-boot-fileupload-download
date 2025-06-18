package id.my.hendisantika.fileuploaddownload.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-fileupload-download
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 18/06/25
 * Time: 07.49
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
class FileProcessingServiceTest {
    @Value("${filePath}")
    private String filePath;

    @Autowired
    private FileProcessingService service;

    @Test
    public void fileListMethodShouldReturnTheExistingFileList() {
        File file = new File(filePath);
        List<String> existing = Arrays.asList(Objects.requireNonNull(file.list()));
        List<String> fileList = service.fileList();

        assertEquals(fileList, existing);
    }

    @Test
    public void fileUploadMethodShouldReturnCreatedOnSuccess() {
        MultipartFile mf = new MockMultipartFile("testUpload.txt", "This is test".getBytes());
        String response = service.uploadFile(mf);
        assertEquals("CREATED", response);

        File file = new File(filePath + "testUpload.txt");
        file.delete();
    }
}