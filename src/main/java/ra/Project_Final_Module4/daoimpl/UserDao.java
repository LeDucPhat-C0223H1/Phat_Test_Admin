package ra.Project_Final_Module4.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ra.Project_Final_Module4.dao.IUserDao;
import ra.Project_Final_Module4.dto.response.ProductResponseAdmin;
import ra.Project_Final_Module4.dto.response.UserEditResponse;
import ra.Project_Final_Module4.model.User;

import java.util.Date;
import java.util.List;

@Component
public class UserDao implements IUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        String sql = "{call Proce_FindAll_User()}";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setAvatarUrl(rs.getString("avatarUrl"));
            //
            user.setFullName(rs.getString("fullname"));
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            user.setBirthday(rs.getDate("birthday"));
            user.setGender(rs.getBoolean("gender"));
            user.setAddress(rs.getString("address"));
            //
            user.setRole(rs.getBoolean("role"));
            user.setStatus(rs.getBoolean("status"));
            user.setCreatedAt(rs.getDate("created_at"));
            user.setModifiedAt(rs.getDate("modified_at"));
            return user;
        });
    }

    @Override
    public List<User> findAllAndSearch(String query) {
        String sql = "{call Proce_FindAll_Search_User(?)}";
        return jdbcTemplate.query(sql,new Object[]{query}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setAvatarUrl(rs.getString("avatarUrl"));
            //
            user.setFullName(rs.getString("fullname"));
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            user.setBirthday(rs.getDate("birthday"));
            user.setGender(rs.getBoolean("gender"));
            user.setAddress(rs.getString("address"));
            //
            user.setRole(rs.getBoolean("role"));
            user.setStatus(rs.getBoolean("status"));
            user.setCreatedAt(rs.getDate("created_at"));
            user.setModifiedAt(rs.getDate("modified_at"));
            return user;
        });
    }

    @Override
    public List<User> findAllAndSearchAndPagination(String query, int limit, int offset) {
        String sql = "{call Proce_FindAll_Search_Pagination_User(?,?,?)}";
        return jdbcTemplate.query(sql, new Object[]{query,limit,offset},(rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setAvatarUrl(rs.getString("avatarUrl"));
            //
            user.setFullName(rs.getString("fullname"));
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            user.setBirthday(rs.getDate("birthday"));
            user.setGender(rs.getBoolean("gender"));
            user.setAddress(rs.getString("address"));
            //
            user.setRole(rs.getBoolean("role"));
            user.setStatus(rs.getBoolean("status"));
            user.setCreatedAt(rs.getDate("created_at"));
            user.setModifiedAt(rs.getDate("modified_at"));
            return user;
        });
    }

    @Override
    public User findById(Long id) {
        String sql ="{call Proce_FindById_User(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public int save(User user) {
        String sql = null;
        if (user.getId() == null) {
            // thêm mới
            sql = "{call Proce_AddNew_User(?,?,?,?,?,?,?,?,?,?,?)}";
            return jdbcTemplate.update(sql,
                    user.getUserName(),
                    user.getPassword(),
                    user.getAvatarUrl(),
                    //
                    user.getFullName(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getBirthday(),
                    user.getGender(),
                    user.getAddress(),
                    //
                    user.getCreatedAt(),
                    user.getModifiedAt());
        } else {
            // cập nhật
            sql = "{call Proce_Update_User(?,?,?,?,?,?,?,?,?)}";
            return jdbcTemplate.update(sql,
                    user.getId(),
                    user.getAvatarUrl(),
                    //
                    user.getFullName(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getBirthday(),
                    user.getGender(),
                    user.getAddress(),
                    //
                    user.getModifiedAt());
        }
    }

    @Override
    public User findByUserName(String userName) {
        try{
            String sql = "{call Proce_FindByUserName_User(?)}";
            return jdbcTemplate.queryForObject(sql, new Object[]{userName}, new BeanPropertyRowMapper<>(User.class));
        } catch (Exception e){
            return null;
        }

    }

    @Override
    public int toggleStatus(Long id) {
        String sql = "{call Proce_Admin_Toggle_Status_User(?,?)}";
        return jdbcTemplate.update(sql,id, new Date());
    }

    @Override
    public int toggleRole(Long id) {
        String sql = "{call Proce_Admin_Toggle_Role_User(?,?)}";
        return jdbcTemplate.update(sql,id, new Date());
    }

    @Override
    public UserEditResponse showInforAccountById(Long id) {
        String sql = "{call Proce_Show_Infor_Account_By_Id(?)}";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<>(UserEditResponse.class));
    }



    /****************************************************************/
    @Override
    public int delete(Long id) {
        return 0;
    }
}
