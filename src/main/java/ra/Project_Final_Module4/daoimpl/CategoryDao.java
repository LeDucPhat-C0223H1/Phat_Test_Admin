package ra.Project_Final_Module4.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ra.Project_Final_Module4.dao.ICategoryDao;
import ra.Project_Final_Module4.model.Category;

import java.util.List;

@Component
public class CategoryDao implements ICategoryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> findAll() {
        String sql = "{call Proce_FindAll_Category()}";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
                    Category category = new Category();
                    category.setId(rs.getLong("id"));
                    category.setName(rs.getString("name"));
                    category.setDescription(rs.getString("description"));
                    category.setStatus(rs.getBoolean("status"));
                    category.setCreatedAt(rs.getDate("created_at"));
                    category.setModifiedAt(rs.getDate("modified_at"));
                    return category;
                });
    }

    @Override
    public List<Category> findAllAndSearch(String query) {
        String sql = "{call Proce_FindAll_Search_Category(?)}";
        return jdbcTemplate.query(sql, new Object[]{query}, (rs, rowNum) -> {
            Category category = new Category();
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            category.setDescription(rs.getString("description"));
            category.setStatus(rs.getBoolean("status"));
            category.setCreatedAt(rs.getDate("created_at"));
            category.setModifiedAt(rs.getDate("modified_at"));
            return category;
        });
    }

    @Override
    public List<Category> findAllAndSearchAndPagination(String query, int limit, int offset) {
        String sql = "{call Proce_FindAll_Search_Pagination_Category(?,?,?)}";
        return jdbcTemplate.query(sql, new Object[]{query, limit, offset}, (rs, rowNum) -> {
            Category category = new Category();
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            category.setDescription(rs.getString("description"));
            category.setStatus(rs.getBoolean("status"));
            category.setCreatedAt(rs.getDate("created_at"));
            category.setModifiedAt(rs.getDate("modified_at"));
            return category;
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
            sql = "{call Proce_AddNew_Category(?,?,?,?)}";
            return jdbcTemplate.update(sql,
                    category.getName(),
                    category.getDescription(),
                    category.getCreatedAt(),
                    category.getModifiedAt());
        } else {
            // cập nhật
            sql = "{call Proce_Update_Category(?,?,?,?,?)} ";
            return jdbcTemplate.update(sql,
                    category.getId(),
                    category.getName(),
                    category.getDescription(),
                    category.isStatus(),
                    category.getModifiedAt());
        }
    }

    @Override
    public int delete(Long id) {
        String sql = "{call Proce_DeleteById_Category(?)}";
        return jdbcTemplate.update(sql, id);
    }
}
