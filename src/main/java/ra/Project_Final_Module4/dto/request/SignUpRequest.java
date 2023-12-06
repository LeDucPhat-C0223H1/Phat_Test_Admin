package ra.Project_Final_Module4.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class SignUpRequest {
    @NotBlank(message = "Vui lòng không để trống!")
    @Size(max = 30, message = "Tên đăng nhập có độ dài tối đa 30 kí tự!")
    private String userName;

    @NotBlank(message = "Vui lòng không để trống!")
    @Size(min = 6, message = "Mật khẩu phải có tối thiểu 6 kí tự trở lên!")
    private String password;

    @NotBlank(message = "Vui lòng không để trống!")
    private String rePassword;
    //--------------------

    @NotBlank(message = "Vui lòng không để trống!")
    @Size(max = 50, message = "Họ và tên có độ dài tối da 50 kí tự!")
    private String fullName;

    @NotBlank(message = "Vui lòng không để trống!")
    @Pattern(regexp = "^(.+)@(\\S+)$",message = "Email không đúng định dạng!")
    @Size(max = 100, message = "Email có chiều dài tối da 100 kí tự!")
    private String email;

    @NotBlank(message = "Vui lòng không để trống!")
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{9})\\b",message = "Số điện thoại không đúng định dạng!")
    @Size(max = 11, message = "Số điện thoại chỉ có từ 10 hoặc 11 số!")
    private String phone;

    @NotBlank(message = "Vui lòng không để trống!")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthday;

    private Boolean gender;

    @NotBlank(message = "Vui lòng không để trống!")
    private String address;

    public SignUpRequest() {
    }

    public SignUpRequest(String userName, String password, String rePassword, String fullName, String email, String phone, String birthday, Boolean gender, String address) {
        this.userName = userName;
        this.password = password;
        this.rePassword = rePassword;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
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

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
