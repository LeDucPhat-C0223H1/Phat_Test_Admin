package ra.Project_Final_Module4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.Project_Final_Module4.serviceimpl.CategoryService;
import ra.Project_Final_Module4.serviceimpl.ProductServive;


@Controller
@RequestMapping({"","/benjuice"})
public class HomeController {
    @Autowired
    private ProductServive productServive;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/home")
    public String showHome(Model model){
        model.addAttribute("view","home");
        return "user/index";
    }
    @RequestMapping({"","/product"})
    public String showProduct(
            Model model,
            @RequestParam(name = "catId", defaultValue = "0" ) Long catId,
            @RequestParam(name = "query", defaultValue = "") String query,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "6") int size
    ) {
        model.addAttribute("view","product");
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("products", productServive.findAllProductByCategoryAndPagination(catId,query, page,size));
        model.addAttribute("catId", catId);
        model.addAttribute("query",query);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPage",new int[productServive.getTotalPageClient(catId, query, size)]);
        return "user/index";
    }

    @RequestMapping("/cart")
    public String showCart(Model model){
        model.addAttribute("view","cart");
        return "user/index";
    }

    @RequestMapping("/about-us")
    public String showAboutUs(Model model){
        model.addAttribute("view","about-us");
        return "user/index";
    }
}

