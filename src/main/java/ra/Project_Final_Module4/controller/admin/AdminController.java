package ra.Project_Final_Module4.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.Project_Final_Module4.service.ICategoryService;

@Controller
@RequestMapping({"/admin",""})
public class AdminController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping({"/dashboard","","/"})
    public String index(Model model){
        model.addAttribute("view","dashboard");
        return "admin/index";
    }
    @RequestMapping("/category")
    public String catalog(Model model){
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("view","catalog");
        return "admin/index";
    }
    @RequestMapping("/product")
    public String product(Model model){
        model.addAttribute("view","product");
        return "admin/index";
    }

    @RequestMapping("/user")
    public String user(Model model){
        model.addAttribute("view","user");
        return "admin/index";
    }
}
