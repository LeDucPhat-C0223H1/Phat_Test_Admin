package ra.Project_Final_Module4.dao;

import ra.Project_Final_Module4.dto.request.UserEditRequest;
import ra.Project_Final_Module4.model.User;

public interface IUserDao extends IGenericDao <User,User,Long>{
    User findByUserName (String userName); // dùng cho login
    int toggleStatus(Long id);
    int toggleRole(Long id);

    UserEditRequest showInforAccountById (Long id);
}
