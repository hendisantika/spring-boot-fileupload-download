package id.my.hendisantika.fileuploaddownload.controller;

import id.my.hendisantika.fileuploaddownload.service.FileProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-fileupload-download
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 18/06/25
 * Time: 07.50
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileProcessingController {

    private final FileProcessingService fileProcessingService;

    @GetMapping("/list")
    public ResponseEntity<?> getFileList() {
        return new ResponseEntity<>(fileProcessingService.fileList(), HttpStatus.OK);
    }

    @GetMapping(value = "/download/{name}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<?> downloadFile(@PathVariable(value = "name") String fileName) {
        Resource file = fileProcessingService.downloadFile(fileName);
        if (file == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(file);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file) {
        String status = fileProcessingService.uploadFile(file);
        return "CREATED".equals(status) ? new ResponseEntity<>(HttpStatus.CREATED) : ("EXIST".equals(status) ? new ResponseEntity<>(HttpStatus.NOT_MODIFIED) : new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED));
    }
}
