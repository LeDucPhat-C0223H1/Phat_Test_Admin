package ra.Project_Final_Module4.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ra.Project_Final_Module4.dao.IProductDao;
import ra.Project_Final_Module4.dto.response.ProductResponseAdmin;
import ra.Project_Final_Module4.dto.response.ProductResponseClient;
import ra.Project_Final_Module4.dto.response.UserEditResponse;
import ra.Project_Final_Module4.model.Product;

import java.util.List;

@Component
public class ProductDao implements IProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAll() {
        String sql = "{call Proce_FindAll_Product()}";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setCategoryId(rs.getLong("category_id"));
            product.setName(rs.getString("name"));
            product.setImageUrl(rs.getString("image_Url"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getBigDecimal("price"));
            product.setStock(rs.getInt("stock"));
            product.setStatus(rs.getBoolean("status"));
            product.setCreatedAt(rs.getDate("created_at"));
            product.setModifiedAt(rs.getDate("modified_at"));
            return product;
        });
    }
    @Override
    public List<ProductResponseClient> findAllActive() {
        String sql = "{call Proce_FindAll_Product_Active()}";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ProductResponseClient product = new ProductResponseClient();
            product.setId(rs.getLong("id"));
            product.setCategoryId(rs.getLong("categoryId"));
            product.setName(rs.getString("name"));
            product.setImageUrl(rs.getString("image_Url"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getBigDecimal("price"));
            product.setStock(rs.getInt("stock"));
            return product;
        });
    }


    @Override
    public List<ProductResponseAdmin> findAllAndSearch(String query) {
        String sql = "{call Proce_FindAll_Search_Product(?)}";
        return jdbcTemplate.query(sql, new Object[]{query}, (rs, rowNum) -> {
            ProductResponseAdmin product = new ProductResponseAdmin();
            product.setId(rs.getLong("id"));
            product.setCategoryName(rs.getString("category_name"));
            product.setName(rs.getString("name"));
            product.setImageUrl(rs.getString("image_Url"));
            product.setPrice(rs.getBigDecimal("price"));
            product.setStatus(rs.getBoolean("status"));
            product.setModifieddAt(rs.getDate("modified_at"));
            return product;
        });
    }

    @Override
    public List<ProductResponseAdmin> findAllAndSearchAndPagination(String query, int limit, int offset) {
        String sql = "{call Proce_FindAll_Search_Pagination_Product(?,?,?)}";
        return jdbcTemplate.query(sql, new Object[]{query,limit,offset}, (rs, rowNum) -> {
            ProductResponseAdmin product = new ProductResponseAdmin();
            product.setId(rs.getLong("id"));
            product.setCategoryName(rs.getString("category_name"));
            product.setName(rs.getString("name"));
            product.setImageUrl(rs.getString("image_Url"));
            product.setPrice(rs.getBigDecimal("price"));
            product.setStatus(rs.getBoolean("status"));
            product.setModifieddAt(rs.getDate("modified_at"));
            return product;
        });
    }

    @Override
    public Product findById(Long id) {
        String sql = "{call Proce_FindById_Product(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public int save(Product product) {
        String sql = null;
        if (product.getId() == null) {
            // thêm mới
            sql = "{call Proce_AddNew_Product(?,?,?,?,?,?,?,?)}";
            return jdbcTemplate.update(sql,
                    product.getCategoryId(),
                    product.getName(),
                    product.getImageUrl(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getStock(),
                    product.getCreatedAt(),
                    product.getModifiedAt());
        } else {
            // cập nhật
            sql = "{call Proce_Update_Product(?,?,?,?,?,?,?,?,?)} ";
            return jdbcTemplate.update(sql,
                    product.getId(),
                    product.getCategoryId(),
                    product.getName(),
                    product.getImageUrl(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getStock(),
                    product.isStatus(),
                    product.getModifiedAt());
        }
    }

    @Override
    public int delete(Long id) {
        String sql = "{call Proce_DeleteById_Product(?)}";
        return jdbcTemplate.update(sql, id);
    }


}
