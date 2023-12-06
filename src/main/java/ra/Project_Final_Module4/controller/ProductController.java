package ra.Project_Final_Module4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.Project_Final_Module4.dto.request.ProductRequest;
import ra.Project_Final_Module4.model.Product;
import ra.Project_Final_Module4.service.ICategoryService;
import ra.Project_Final_Module4.service.IProductService;

import javax.validation.Valid;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    // Thêm mới
    @RequestMapping("/add")
    public String showFormAddNewProduct(Model model) {
        model.addAttribute("view", "form-add-product");
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("productRequest", new ProductRequest());
        return "admin/index";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String doAddNewProduct(@ModelAttribute("productRequest") @Valid ProductRequest productRequest, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("view", "form-add-product");
            return "admin/index";
        }
        productService.save(productRequest);
        return "redirect:/admin/product";
    }


    // Cập nhật
    @RequestMapping("/edit/{id}")
    public String showFormEditProduct(@PathVariable Long id, Model model) {
        model.addAttribute("view", "form-edit-product");
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("productEdit", productService.findById(id));
        return "admin/index";
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String doUpdateProduct(@ModelAttribute("productEdit") @Valid Product productEdit, @RequestParam("fileImage")MultipartFile fileImage, BindingResult bindingResult, Model model) {
//        if(bindingResult.hasErrors()){
//            model.addAttribute("view", "form-edit-product");
//            return "admin/index";
//        }
        productService.update(productEdit, fileImage);
        return "redirect:/admin/product";
    }


    // Xóa
    @RequestMapping("/delete/{id}")
    public String doDeleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/admin/product";
    }
}
