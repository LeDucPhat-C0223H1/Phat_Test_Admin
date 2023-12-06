package ra.Project_Final_Module4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.Project_Final_Module4.dto.request.UserEditRequest;
import ra.Project_Final_Module4.model.User;
import ra.Project_Final_Module4.service.IUserService;
import ra.Project_Final_Module4.validate.FormUserEditValidate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private FormUserEditValidate userEditValidate;

    // admin thay đổi trạng thái user
    @RequestMapping("/toggle-status/{id}")
    public String doToggleStatus(@PathVariable("id") Long id) {
        userService.toggleStatus(id);
        return "redirect:/admin/user";
    }

    // use tự cập nhật thông tin
    @RequestMapping("/profile")
    public String showProfile(HttpSession session, Model model) {
        User userLogin = (User) session.getAttribute("userLogin");
        if(userLogin!=null){
            model.addAttribute("view", "profile");
            model.addAttribute("userEdit", userService.showInforAccount(userLogin.getId()));
            return "user/index";
        }else {
            return "auth/login";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String doUpdateUser(
            Model model,
            @ModelAttribute("userEdit") @Valid UserEditRequest userEditRequest, BindingResult bindingResult, @RequestParam("fileAvatar") MultipartFile fileAvatar, HttpSession session)
    {
        userEditValidate.validate(userEditRequest,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("view", "profile");
            return "user/index";
        }
        userService.update(userEditRequest, fileAvatar);
        return "redirect:/product";
    }
}

