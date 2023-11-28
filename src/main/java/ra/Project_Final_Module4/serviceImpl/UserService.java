package ra.Project_Final_Module4.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.Project_Final_Module4.dao.IUserDao;

@Service
public class UserService {
    @Autowired
    private IUserDao userDao;
}
