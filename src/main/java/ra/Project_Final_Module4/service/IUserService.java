package ra.Project_Final_Module4.service;

import org.springframework.web.multipart.MultipartFile;
import ra.Project_Final_Module4.dto.request.LoginRequest;
import ra.Project_Final_Module4.dto.request.SignUpRequest;
import ra.Project_Final_Module4.dto.request.UserEditRequest;
import ra.Project_Final_Module4.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    void register(SignUpRequest signUpRequest);
    User login(LoginRequest loginRequest);
    void update(UserEditRequest userEditRequest, MultipartFile fileAvartar);
    void toggleStatus(Long id);
    void toggleRole(Long id);

    // Tìm kiếm, hiển thị và phân trang bên admin
    List<User> findAllAndSearchAndPagination(String query, int page, int size);
    int getTotalPage(String query,int size);

    // hiển thị nhưng thông tin được cho người dùng edit
    UserEditRequest showInforAccount(Long id);

    boolean checkExistByUserName(String userName);
    boolean checkExistByEmail(String email);
    boolean checkExistByPhone(String phone);
}
