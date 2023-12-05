package ra.Project_Final_Module4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.Project_Final_Module4.model.User;
import ra.Project_Final_Module4.service.ICategoryService;
import ra.Project_Final_Module4.service.IProductService;
import ra.Project_Final_Module4.service.IUserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminSidebarController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IUserService userService;

    @RequestMapping({"","/dashboard"})
    public String index(Model model){
        model.addAttribute("view","dashboard");
        return "admin/index";
    }
    @RequestMapping("/category")
    public String catalog(
            Model model,
            @RequestParam(name = "query", defaultValue = "") String query,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size
    )
    {
        model.addAttribute("view","category");
        model.addAttribute("categories",categoryService.findAllAndSearchAndPagination(query,page,size));
        model.addAttribute("query",query);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPage", new int[categoryService.getTotalPage(query, size)]);
        return "admin/index";
    }
    @RequestMapping("/product")
    public String product(
            Model model,
            @RequestParam(name = "query", defaultValue = "") String query,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "4") int size
    ){
        model.addAttribute("view","product");
        model.addAttribute("products", productService.findAllAndSearchAndPagination(query,page,size));
        model.addAttribute("query",query);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPage", new int[productService.getTotalPageAdmin(query,size)]);
        return "admin/index";
    }

    @RequestMapping("/user")
    public String user(
            Model model,
            @RequestParam(name = "query", defaultValue = "") String query,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "4") int size
    ){
        model.addAttribute("view","user");
        model.addAttribute("users",userService.findAllAndSearchAndPagination(query,page,size));
        model.addAttribute("query",query);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPage", new int[userService.getTotalPage(query,size)]);
        return "admin/index";
    }
}
