package ra.Project_Final_Module4.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.Project_Final_Module4.dto.request.SignUpRequest;
import ra.Project_Final_Module4.service.IUserService;

@Component
public class FormRegisterValidate implements Validator {
    @Autowired
    private IUserService userService;
    @Override
    public boolean supports(Class<?> clazz) {
        return SignUpRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignUpRequest signUpRequest = (SignUpRequest) target;
        // trùng lặp username
        if(userService.checkExistByUserName(signUpRequest.getUserName())){
            errors.rejectValue("userName","userName", "Tên đăng nhập đã tồn tại!");
        }
        // trùng lặp email
        if(userService.checkExistByEmail(signUpRequest.getEmail())){
            errors.rejectValue("email","email" ,"Email đã được đăng ký!");
        }
        // trùng lặp phone
        if(userService.checkExistByPhone(signUpRequest.getPhone())){
            errors.rejectValue("phone", "phone","Số điện thoại đã được đăng ký!");
        }
        // nhập password rỗng
        if(signUpRequest.getPassword().equals("")){
            errors.rejectValue("password","password","Vui lòng không để trống!");
        }
        // nhập lại password
        if(!signUpRequest.getRePassword().equals(signUpRequest.getPassword())){
            errors.rejectValue("rePassword","rePassword","Nhập lại mật khẩu không khớp!");
        }
    }
}
