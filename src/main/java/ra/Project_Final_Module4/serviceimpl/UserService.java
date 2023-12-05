package ra.Project_Final_Module4.serviceimpl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.Project_Final_Module4.dao.IUserDao;
import ra.Project_Final_Module4.dto.request.LoginRequest;
import ra.Project_Final_Module4.dto.request.SignUpRequest;
import ra.Project_Final_Module4.dto.request.UserEditRequest;
import ra.Project_Final_Module4.dto.response.UserEditResponse;
import ra.Project_Final_Module4.model.User;
import ra.Project_Final_Module4.service.IUserService;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private UserService userService;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void register(SignUpRequest signUpRequest) {
        userDao.save(
                new User(
                        signUpRequest.getUserName(),
                        BCrypt.hashpw(signUpRequest.getPassword(),BCrypt.gensalt(12)),
                        //
                        signUpRequest.getFullName(),
                        signUpRequest.getEmail(),
                        signUpRequest.getPhone(),
                        signUpRequest.getBirthday(),
                        signUpRequest.getGender(),
                        signUpRequest.getAddress(),
                        //
                        new Date(),
                        new Date()
                )
        );
    }

    @Override
    public User login(LoginRequest loginRequest) {
        User userLogin = userDao.findByUserName(loginRequest.getUserName());
        if (userLogin != null && BCrypt.checkpw(loginRequest.getPassword(),userLogin.getPassword())){
            return userLogin;
        }
        return  null;
    }

    @Override
    public void update(UserEditRequest userEditRequest, MultipartFile fileAvartar) {
        if(!fileAvartar.isEmpty()){
            userEditRequest.setAvatarUrl(uploadService.uploadFileImage(fileAvartar));
        }
        userEditRequest.setModifiedAt(new Date());
        userDao.save(
                new User(
                        userEditRequest.getId(),
                        userEditRequest.getAvatarUrl(),
                        //
                        userEditRequest.getFullName(),
                        userEditRequest.getEmail(),
                        userEditRequest.getPhone(),
                        userEditRequest.getBirthday(),
                        userEditRequest.getGender(),
                        userEditRequest.getAddress(),
                        //
                        new Date()
                )
        );

    }

    @Override
    public void toggleStatus(Long id) {
        userDao.toggleStatus(id);
    }

    @Override
    public void toggleRole(Long id) {
        userDao.toggleRole(id);
    }

    // Tìm kiếm, hiển thị và phân trang
    @Override
    public List<User> findAllAndSearchAndPagination(String query, int page, int size) {
        return userDao.findAllAndSearchAndPagination(query,size,page*size);
    }

    @Override
    public int getTotalPage(String query, int size) {
        int count = userDao.findAllAndSearch(query).size();
        if (count % size == 0){
            return count/size;
        }
        return count/size + 1;
    }

    // hiển thị nhưng thông tin được cho người dùng edit
    @Override
    public UserEditResponse showInforAccount(Long id) {
        return userDao.showInforAccountById(id);
    }

    @Override
    public boolean checkExistByUserName(String userName) {
        return findAll().stream().anyMatch(u -> u.getUserName().equalsIgnoreCase(userName));
    }

    @Override
    public boolean checkExistByEmail(String email) {
        return findAll().stream().anyMatch(u -> u.getEmail().equalsIgnoreCase(email));
    }

    @Override
    public boolean checkExistByPhone(String phone) {
        return findAll().stream().anyMatch(u -> u.getPhone().equalsIgnoreCase(phone));
    }

}
