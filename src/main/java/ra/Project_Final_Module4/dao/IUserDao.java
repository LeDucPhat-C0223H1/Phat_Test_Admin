package ra.Project_Final_Module4.dao;

import ra.Project_Final_Module4.dto.response.UserEditResponse;
import ra.Project_Final_Module4.model.User;

public interface IUserDao extends IGenericDao <User,User,Long>{
    User findByUserName (String userName); // dùng cho login
    int toggleStatus(Long id);
    int toggleRole(Long id);

    UserEditResponse showInforAccountById (Long id);
}
