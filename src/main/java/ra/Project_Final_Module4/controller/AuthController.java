package ra.Project_Final_Module4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ra.Project_Final_Module4.dto.request.LoginRequest;
import ra.Project_Final_Module4.dto.request.SignUpRequest;
import ra.Project_Final_Module4.model.User;
import ra.Project_Final_Module4.service.IUserService;
import ra.Project_Final_Module4.validate.FormRegisterValidate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IUserService userService;
    @Autowired
    private FormRegisterValidate registerValidate;

    // đăng nhập
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("loginRequest",new LoginRequest());
        return "auth/login";
    }
    @RequestMapping(value = "/do-login", method = RequestMethod.POST)
    public String doLogin
            (Model model, @ModelAttribute("loginRequest") @Valid LoginRequest loginRequest, BindingResult bindingResult, HttpSession session)
    {
        if (bindingResult.hasErrors()){
            return "auth/login";
        }
        User userLogin = userService.login(loginRequest);

        if (userLogin == null) {
            model.addAttribute("login_fail","Tên đăng nhập hoặc mật không đúng!");
            return "auth/login";
        }
        session.setAttribute("userLogin", userLogin);
        if (userLogin.isRole()) {
            return "redirect:/admin";
        }
        return "redirect:/product";
    }

    // đăng xuất
    @RequestMapping("/logout")
    public String doLogout(HttpSession session){
        session.removeAttribute("userLogin");
        return "redirect:/product";
    }

    // đăng ký
    @RequestMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("signUpRequest",new SignUpRequest());
        return "auth/sign-up";
    }
    @RequestMapping(value = "/do-sign-up", method = RequestMethod.POST)
    public String doAddNewUser(
            @ModelAttribute("signUpRequest") @Valid SignUpRequest signUpRequest, BindingResult bindingResult
    ){
        registerValidate.validate(signUpRequest,bindingResult);
        if (bindingResult.hasErrors()){
            return "auth/sign-up";
        }
        userService.register(signUpRequest);
        return "redirect:/auth/login";
    }

    @RequestMapping("/403")
    public String page403(Model model){
        return "auth/page403";
    }

}
