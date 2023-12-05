package ra.Project_Final_Module4.dto.request;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class ProductRequest {
    private Long categoryId;
    private String name;
    private MultipartFile fileImage;
    private String description;
    private BigDecimal price;
    private Integer stock;

    public ProductRequest() {
    }

    public ProductRequest(Long categoryId, String name, MultipartFile fileImage, String description, BigDecimal price, Integer stock) {
        this.categoryId = categoryId;
        this.name = name;
        this.fileImage = fileImage;
        this.description = description;
        this.price = price;
        this.stock = stock;
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

    public MultipartFile getFileImage() {
        return fileImage;
    }

    public void setFileImage(MultipartFile fileImage) {
        this.fileImage = fileImage;
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
