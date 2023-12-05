package ra.Project_Final_Module4.serviceimpl;

import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadService {
    // bucketname
    private final String  bucketName = "project-final-module4.appspot.com";
    // lấy ra đường dẫn gốc trên server
    @Autowired
    private ServletContext servletContext;

    @Autowired
    private Storage storage;

    public String uploadFileImage(MultipartFile fileUpload){
        // tạo đường dẫn đến thư mục uploads
        String uploadPath = servletContext.getRealPath("/uploads");

        // kiểm tra thư mục có tồn tại không
        File file = new File(uploadPath);
        if (!file.exists()) {
            // tạo thự mục mới
            file.mkdirs();
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

        // upload lên server rồi lên firebase
        String fileName = dtf.format(LocalDateTime.now())+ fileUpload.getOriginalFilename();
        try {
            // tạo địa chỉ lưu trên server
            FileCopyUtils.copy(fileUpload.getBytes(),new File(uploadPath+File.separator+fileName));

            // lưu lại đường dẫn server
            String filePath = uploadPath+File.separator+fileName;

            // upload từ server lên cloud firebase
            String imageUrlFirebase = uploadFileFromServerToFirebase(filePath);

            // đã đưa lên server nên xóa trên server cho nhẹ
            File fileImage = new File(filePath);
            if (fileImage.exists()){
                fileImage.delete();
            }
            return  imageUrlFirebase;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // upload file lên firebase
    private String uploadFileFromServerToFirebase(String filePath){
        // lấy ra đối tượng Paths của ảnh vừa upload lên server
        Path localPath = Paths.get(filePath);

        // lấy ra tên file upload
        String fileName = localPath.getFileName().toString();

        // tạo file trên storage bằng tên và bucketname chỉ đinh
        BlobId blobId = BlobId.of(bucketName, fileName);

        // Thiết lập quyền truy cập công cộng
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        List<Acl> acls = new ArrayList<>();
        acls.add(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));
        blobInfo = blobInfo.toBuilder().setAcl(acls).build();
        try {
            Blob blob = storage.create(blobInfo, Files.readAllBytes(localPath));
            return blob.getMediaLink(); // trả về đường dẫn ảnh online
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
