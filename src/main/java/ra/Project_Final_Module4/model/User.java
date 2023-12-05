package ra.Project_Final_Module4.model;

import java.time.LocalDate;
import java.util.Date;

public class User {
    private Long id;
    private String userName;
    private String password;
    private String avatarUrl;
    //--------------------
    private String fullName;
    private String email;
    private String phone;
    private Date birthday;
    private Boolean gender;
    private String address;
    private boolean role = false;
    private boolean status = true;
    //--------------------
    private Date createdAt;
    private Date modifiedAt;

    public User() {
    }

    // constructor thêm mới
    public User(String userName, String password, String fullName, String email, String phone, Date birthday, Boolean gender, String address, Date createdAt, Date modifiedAt) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.avatarUrl=  "https://firebasestorage.googleapis.com/v0/b/project-final-module4.appspot.com/o/user-default-avatar.jpg?alt=media&token=5a38854d-1427-47ab-98f7-9f6dbeb2428b";
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    // constructor edit
    public User(Long id, String avatarUrl, String fullName, String email, String phone, Date birthday, Boolean gender, String address, Date modifiedAt) {
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

    // constructor full tham số
    public User(Long id, String userName, String password, String avatarUrl, String fullName, String email, String phone, Date birthday, Boolean gender, String address, boolean role, boolean status, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.avatarUrl = avatarUrl;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

}
