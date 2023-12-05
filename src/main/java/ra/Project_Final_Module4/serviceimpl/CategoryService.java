package ra.Project_Final_Module4.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ra.Project_Final_Module4.dao.ICategoryDao;
import ra.Project_Final_Module4.dto.request.CategoryRequest;
import ra.Project_Final_Module4.model.Category;
import ra.Project_Final_Module4.service.ICategoryService;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public void save(CategoryRequest categoryRequest) {
        categoryDao.save(
                new Category(
                        categoryRequest.getName(),
                        categoryRequest.getDescription(),
                        new Date(),
                        new Date()
                )
        );
    }

    @Override
    public void update(Category categoryEdit) {
        categoryEdit.setModifiedAt(new Date());
        categoryDao.save(categoryEdit);
    }

    @Override
    public void delete(Long id) {
        categoryDao.delete(id);
    }

    // Tìm kiếm, hiển thị và phân trang
    @Override
    public List<Category> findAllAndSearchAndPagination(String query, int page, int size) {
        return categoryDao.findAllAndSearchAndPagination(query, size, page*size);
    }

    @Override
    public int getTotalPage(String query, int size) {
        int count = categoryDao.findAllAndSearch(query).size();
        if (count % size == 0){
            return count/size;
        }
        return count/size + 1;
    }
}
