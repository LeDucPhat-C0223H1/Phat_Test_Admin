package ra.Project_Final_Module4.dto.response;

import java.math.BigDecimal;
import java.util.Date;

public class ProductResponseAdmin {
    private Long id;
    private String categoryName;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Date modifiedAt;
    private boolean status;

    public ProductResponseAdmin() {
    }

    public ProductResponseAdmin(Long id, String categoryName, String name, String imageUrl, BigDecimal price, Date modifiedAt, boolean status) {
        this.id = id;
        this.categoryName = categoryName;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.modifiedAt = modifiedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifieddAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
