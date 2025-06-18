package id.my.hendisantika.fileuploaddownload.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-fileupload-download
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 18/06/25
 * Time: 07.47
 * To change this template use File | Settings | File Templates.
 */
@Service
public class FileProcessingService {
    @Value("${filePath}")
    private String basePath;

    public List<String> fileList() {
        File dir = new File(basePath);
        File[] files = dir.listFiles();

        return files != null ? Arrays.stream(files).map(File::getName).collect(Collectors.toList()) : null;
    }
}
