package ra.Project_Final_Module4.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ra.Project_Final_Module4.dto.CategoryDto;
import ra.Project_Final_Module4.service.ICategoryService;


@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    // Thêm mới
    @RequestMapping("/add")
    public String showFormAddNew(Model model){
        model.addAttribute("view","category_add");
        model.addAttribute("category_dto", new CategoryDto());
        return "admin/index";
    }
    @RequestMapping(value="/create" , method=RequestMethod.POST)
    public String doAdd(@ModelAttribute CategoryDto categoryDto){
        categoryService.save(categoryDto);
        return "redirect:/admin/category";
    }
    // Cập nhật
    @RequestMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model){
        model.addAttribute("view","category_edit");
        model.addAttribute("categ",categoryService.findById(id));
        return "admin/index";
    }
//    @RequestMapping(value = "/update" , method = RequestMethod.POST)
//    public String doUpdate(@ModelAttribute Catalog cat){
//        catalogService.save(cat);
//        return "redirect:/admin/catalog";
//    }

//    // Xóa
//    @RequestMapping("/delete/{id}")
//    public String doDelete(@PathVariable Long id){
//        catalogService.delete(id);
//        return "redirect:/admin/catalog";
//    }
}
