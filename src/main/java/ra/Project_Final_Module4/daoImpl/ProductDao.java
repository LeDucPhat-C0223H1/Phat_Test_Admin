package ra.Project_Final_Module4.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ra.Project_Final_Module4.dao.IProductDao;
import ra.Project_Final_Module4.model.Product;

import java.util.List;

@Component
public class ProductDao implements IProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public int save(Product product) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }
}
