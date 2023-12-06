package ra.Project_Final_Module4.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class UserEditRequest {
    private Long id;
    private String avatarUrl;
    //--------------------
    @NotBlank(message = "Vui lòng không để trống!")
    @Size(max = 50, message = "Họ và tên mới dài hơn 50 kí tự!")
    private String fullName;

    @NotBlank(message = "Vui lòng không để trống!")
    @Pattern(regexp = "^(.+)@(\\S+)$",message = "Email mới không đúng định dạng!")
    @Size(max = 100, message = "Email mới dài hơn 100 kí tự!")
    private String email;

    @NotBlank(message = "Vui lòng không để trống!")
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b",message = "Số điện thoại mới không đúng định dạng!")
    @Size(max = 11, message = "Số điện thoại mới dài hơn 11 số!")
    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Boolean gender;
    @NotBlank(message = "Vui lòng không để trống!")
    private String address;
    //--------------------
    private Date modifiedAt;

    public UserEditRequest() {
    }

    public UserEditRequest(Long id, String avatarUrl, String fullName, String email, String phone, Date birthday, Boolean gender, String address, Date modifiedAt) {
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.modifiedAt = modifiedAt;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
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

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
