package ra.Project_Final_Module4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ra.Project_Final_Module4.dto.request.CategoryRequest;
import ra.Project_Final_Module4.model.Category;
import ra.Project_Final_Module4.service.ICategoryService;


@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    // Thêm mới
    @RequestMapping("/add")
    public String showFormAddNewCategory(Model model){
        model.addAttribute("view","form-add-category");
        model.addAttribute("categoryRequest", new CategoryRequest());
        return "admin/index";
    }
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String doAddNewCategory(@ModelAttribute CategoryRequest categoryRequest){
        categoryService.save(categoryRequest);
        return "redirect:/admin/category";
    }


    // Cập nhật
    @RequestMapping("/edit/{id}")
    public String showFormEditCategory(@PathVariable Long id, Model model){
        model.addAttribute("view","form-edit-category");
        model.addAttribute("categoryEdit",categoryService.findById(id));
        return "admin/index";
    }
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String doUpdateCategory(@ModelAttribute Category categoryEdit){
        categoryService.update(categoryEdit);
        return "redirect:/admin/category";
    }


    // Xóa
    @RequestMapping("/delete/{id}")
    public String doDeleteCategory(@PathVariable Long id){
        categoryService.delete(id);
        return "redirect:/admin/category";
    }
}
