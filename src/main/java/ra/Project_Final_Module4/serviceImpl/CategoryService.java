package ra.Project_Final_Module4.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.Project_Final_Module4.dao.ICategoryDao;
import ra.Project_Final_Module4.daoImpl.CategoryDao;
import ra.Project_Final_Module4.dto.CategoryDto;
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
    public void save(CategoryDto categoryDto) {
        categoryDao.save(new Category(categoryDto.getName(), categoryDto.getDescription(), new Date(), new Date()));
    }

    @Override
    public void update(Category categoryEdit) {
        categoryDao.save(new Category(categoryEdit.getId(), categoryEdit.getName(), categoryEdit.getDescription(),categoryEdit.isStatus(), categoryEdit.getCreated_at(), new Date()));
    }

    @Override
    public void delete(Long id) {
        categoryDao.delete(id);
    }
}
