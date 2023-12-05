package ra.Project_Final_Module4.service;

import ra.Project_Final_Module4.dto.request.CategoryRequest;
import ra.Project_Final_Module4.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Long id);
    void save(CategoryRequest categoryRequest);
    void update(Category categoryEdit);
    void delete(Long id);

    // Tìm kiếm, hiển thị và phân trang
    List<Category> findAllAndSearchAndPagination(String query, int page, int size);
    int getTotalPage(String query, int size);
}
