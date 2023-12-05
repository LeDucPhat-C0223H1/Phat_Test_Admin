package ra.Project_Final_Module4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.Project_Final_Module4.dto.request.UserEditRequest;
import ra.Project_Final_Module4.dto.response.UserEditResponse;
import ra.Project_Final_Module4.model.Category;
import ra.Project_Final_Module4.model.User;
import ra.Project_Final_Module4.service.IUserService;
import ra.Project_Final_Module4.serviceimpl.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    // admin thay đổi trạng thái user
    @RequestMapping("/toggle-status/{id}")
    public String doToggleStatus(@PathVariable("id") Long id) {
        userService.toggleStatus(id);
        return "redirect:/admin/user";
    }

    // use tự cập nhật thông tin
    @RequestMapping("/profile/{id}")
    public String showProfile(@PathVariable Long id, Model model) {
        model.addAttribute("view", "profile");
        model.addAttribute("userEdit", userService.showInforAccount(id));
        return "user/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String doUpdateUser(@ModelAttribute UserEditRequest userEdit, @RequestParam("fileAvatar") MultipartFile fileAvatar, Model model) {
        userService.update(userEdit, fileAvatar);
        model.addAttribute("view", "product");
        return "user/index";
    }
}

