package ra.Project_Final_Module4.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ra.Project_Final_Module4.dao.ICategoryDao;
import ra.Project_Final_Module4.model.Category;

import java.util.Date;
import java.util.List;

@Component
public class CategoryDao implements ICategoryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> findAll() {
        String sql = "{call Proce_FindAll_Category()}";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> {
                    Category cat = new Category();
                    cat.setId(rs.getLong("id"));
                    cat.setName(rs.getString("name"));
                    cat.setDescription(rs.getString("description"));
                    return cat;
                });
    }

    @Override
    public Category findById(Long id) {
        String sql = "{call Proce_FindById_Category(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public int save(Category category) {
        String sql = null;
        if (category.getId() == null) {
            // thêm mới
            sql = "{call Proce_AddNew_Category(?,?,?,?,)}";
            return jdbcTemplate.update(sql,
                    category.getName(),
                    category.getDescription(),
                    category.getCreated_at(),
                    category.getModified_at());
        } else {
            // cập nhật
            sql = "{call Proce_Update_Category(?,?,?,?,?,?)} ";
            return jdbcTemplate.update(sql,
                    category.getId(),
                    category.getName(),
                    category.getDescription(),
                    category.isStatus(),
                    category.getCreated_at(),
                    category.getModified_at());
        }
    }

    @Override
    public int delete(Long id) {
        String sql = "{call Proce_DeleteById_Category(?)}";
        return jdbcTemplate.update(sql, id);
    }
}
