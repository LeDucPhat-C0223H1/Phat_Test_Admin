package ra.Project_Final_Module4.dto;

public class ProductDto {
    private long category_id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public ProductDto() {
    }

    public ProductDto(long category_id, String name, String description, double price, int stock) {
        this.category_id = category_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
