package ra.Project_Final_Module4.dto.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "Vui lòng không để trống!")
    private String userName;
    @NotBlank(message = "Vui lòng không để trống!")
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
