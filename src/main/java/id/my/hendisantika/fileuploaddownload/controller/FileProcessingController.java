package id.my.hendisantika.fileuploaddownload.controller;

import id.my.hendisantika.fileuploaddownload.service.FileProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
