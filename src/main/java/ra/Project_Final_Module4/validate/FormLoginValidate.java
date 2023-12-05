package ra.Project_Final_Module4.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.Project_Final_Module4.dto.request.LoginRequest;

public class FormLoginValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return LoginRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginRequest loginRequest = (LoginRequest) target;
    }
}
