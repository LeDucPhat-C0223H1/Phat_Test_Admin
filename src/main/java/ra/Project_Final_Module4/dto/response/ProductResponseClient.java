package ra.Project_Final_Module4.dto.response;

import java.math.BigDecimal;
import java.util.Date;

public class ProductResponseClient {
    private Long id;
    private Long categoryId;
    private String name;
    private String imageUrl;
    private String description;
    private BigDecimal price;
    private Integer stock;

    public ProductResponseClient() {
    }

    public ProductResponseClient(Long id, Long categoryId, String name, String imageUrl, String description, BigDecimal price, Integer stock) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
