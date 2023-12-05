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
            errors.rejectValue("userName","userName", "The username already exists.");
        }
        // trùng lặp email
        if(userService.checkExistByEmail(signUpRequest.getEmail())){
            errors.rejectValue("email","email" ,"The email has already been registered.");
        }
        // trùng lặp phone
        if(userService.checkExistByPhone(signUpRequest.getPhone())){
            errors.rejectValue("phone", "phone","The phone number has already been registered");
        }
        // nhập password rỗng
        if(signUpRequest.getPassword().equals("")){
            errors.rejectValue("password","assword","Can be not left blank");
        }
        // nhập lại password
        if(!signUpRequest.getRePassword().equals(signUpRequest.getPassword())){
            errors.rejectValue("rePassword","rePassword","The re-entered password does not match.");
        }
    }
}
