package ra.Project_Final_Module4.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserEditRequest {
    private Long id;
    private String avatarUrl;
    //--------------------
    private String fullName;
    private String email;
    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Boolean gender;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
