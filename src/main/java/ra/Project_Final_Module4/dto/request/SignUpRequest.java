package ra.Project_Final_Module4.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class SignUpRequest {
    @NotBlank(message = "Cannot be left blank.")
    @Size(max = 30, message = "The username must have a maximum length of 30 characters.")
    private String userName;

    @Size(min = 6, message = "The password must have a minimum of 6 characters.")
    @NotBlank(message = "Cannot be left blank.")
    private String password;

    @NotBlank(message = "Cannot be left blank.")
    private String rePassword;
    //--------------------

    @NotBlank(message = "Cannot be left blank.")
    @Size(max = 50, message = "The fullname must have a maximum length of 50 characters.")
    private String fullName;

    @NotBlank(message = "Cannot be left blank.")
    @Pattern(regexp = "^(.+)@(\\S+)$",message = "The email is invalid !")
    @Size(max = 100, message = "The email must have a maximum length of 100 characters.")
    private String email;

    @NotBlank(message = "Cannot be left blank.")
    @Pattern(regexp = "^0[0-9]{9,10}$",message = "The phone is invalid!")
    @Size(max = 100, message = "The phone number must have either 10 or 11 digits.")
    private String phone;

    @NotBlank(message = "Cannot be left blank.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Boolean gender;

    @NotBlank(message = "Cannot be left blank.")
    private String address;

    public SignUpRequest() {
    }

    public SignUpRequest(String userName, String password, String rePassword, String fullName, String email, String phone, Date birthday, Boolean gender, String address) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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
