package id.my.hendisantika.fileuploaddownload.controller;

import id.my.hendisantika.fileuploaddownload.service.FileProcessingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Test
    public void getAllFilesShouldReturnExistingFileList() throws Exception {
        List<String> files = List.of("file1.txt", "file2.txt");

        given(service.fileList()).willReturn(files);

        mvc.perform(get("/file/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}