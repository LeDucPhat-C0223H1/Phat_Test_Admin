package ra.Project_Final_Module4.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;


//@Configuration
//public class StorageConfig {
//    @Bean
//    public Storage storage() throws IOException {
//        File file = ResourceUtils.getFile("classpath:firebase/project-final-module4-firebase.json");
//        InputStream inputStream = Files.newInputStream(file.toPath());
//        return StorageOptions.newBuilder()
//                .setCredentials(GoogleCredentials.fromStream(inputStream))
//                .build()
//                .getService();
//    }
//
//}

@Configuration
public class StorageConfig{
    private final String firebaseConfigPath = "firebase/project-final-module4-firebase.json";
    @Bean
    public Storage storage() throws IOException {
        Resource resource = new ClassPathResource(firebaseConfigPath);
        InputStream inputStream = resource.getInputStream();
        return StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .build()
                .getService();
    }
}
