package ra.Project_Final_Module4.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ra.Project_Final_Module4.dao.IUserDao;
import ra.Project_Final_Module4.model.User;

import java.util.List;

@Component
public class UserDao implements IUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }
}
