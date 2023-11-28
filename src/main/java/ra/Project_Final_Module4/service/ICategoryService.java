package ra.Project_Final_Module4.service;

import ra.Project_Final_Module4.dto.CategoryDto;
import ra.Project_Final_Module4.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Long id);
    void save(CategoryDto categoryDto);
    void delete(Long id);
}
