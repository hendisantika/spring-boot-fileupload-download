package id.my.hendisantika.fileuploaddownload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

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

}