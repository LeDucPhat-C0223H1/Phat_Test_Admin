package ra.Project_Final_Module4.model;

import java.util.Date;

public class Category {
    private Long id;
    private String name;
    private String description;
    private boolean status;
    //--------------------
    private Date created_at;
    private Date modified_at;

    public Category() {
    }

    public Category(String name, String description, Date created_at, Date modified_at) {
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public Category(Long id, String name, String description, boolean status, Date created_at, Date modified_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }
}
