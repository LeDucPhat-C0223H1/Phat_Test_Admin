package ra.Project_Final_Module4.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.Project_Final_Module4.dto.request.SignUpRequest;
import ra.Project_Final_Module4.dto.request.UserEditRequest;
import ra.Project_Final_Module4.model.User;
import ra.Project_Final_Module4.service.IUserService;

import javax.servlet.http.HttpSession;

@Component
public class FormUserEditValidate implements Validator {
    @Autowired
    private IUserService userService;
    @Autowired
    private  HttpSession session;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserEditRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User userLogin = (User) session.getAttribute("userLogin");

        UserEditRequest userEditRequest = (UserEditRequest) target;

        User oldData = userService.findById(userLogin.getId());

        // trùng lặp email
        if(!userEditRequest.getEmail().equals(oldData.getEmail())){
            if (userService.checkExistByEmail(userEditRequest.getEmail())) {
                errors.rejectValue("email", "email", "Email mới đã được đăng ký!");
            }
        }

        // trùng lặp phone
        if(!userEditRequest.getPhone().equals(oldData.getPhone())){
            if (userService.checkExistByPhone(userEditRequest.getPhone())) {
                errors.rejectValue("phone", "phone", "Số điện thoại mới đã được đăng ký!");
            }
        }

    }
}
