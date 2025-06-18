package id.my.hendisantika.fileuploaddownload.controller;

import id.my.hendisantika.fileuploaddownload.service.FileProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-fileupload-download
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 18/06/25
 * Time: 07.51
 * To change this template use File | Settings | File Templates.
 */
@WebMvcTest(FileProcessingController.class)
class FileProcessingControllerTest {
    @Autowired
    private MockMvc mvc;

    @Value("${filePath}")
    private String basePath;

    @MockBean
    private FileProcessingService service;

    @Autowired
    private MockMvc mockMvc;

}