package ra.Project_Final_Module4.dto.request;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {
    @NotBlank(message = "Cannot be left blank!")
    private String name;
    private String description;

    public CategoryRequest() {
    }

    public CategoryRequest(String name, String description) {
        this.name = name;
        this.description = description;
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
}
