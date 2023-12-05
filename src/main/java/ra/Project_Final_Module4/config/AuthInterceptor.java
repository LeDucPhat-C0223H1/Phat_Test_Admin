package ra.Project_Final_Module4.config;

import org.springframework.web.servlet.HandlerInterceptor;
import ra.Project_Final_Module4.dto.request.SignUpRequest;
import ra.Project_Final_Module4.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User userLogin = (User) request.getSession().getAttribute("userLogin");
        if (userLogin == null){
            response.sendRedirect("/auth/login");
            return false;
        }
        if(userLogin!=null && userLogin.isRole()){
            return true;
        }
        response.sendRedirect("auth/403");
        return false;
    }



}
