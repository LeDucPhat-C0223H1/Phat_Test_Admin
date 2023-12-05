package ra.Project_Final_Module4.service;

import org.springframework.web.multipart.MultipartFile;
import ra.Project_Final_Module4.dto.request.ProductRequest;
import ra.Project_Final_Module4.dto.response.ProductResponseAdmin;
import ra.Project_Final_Module4.dto.response.ProductResponseClient;
import ra.Project_Final_Module4.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
    void save(ProductRequest productRequest);
    void update(Product productEdit, MultipartFile fileImage);
    void delete(Long id);

    // Tìm kiếm, hiển thị và phân trang bên admin
    List<ProductResponseAdmin> findAllAndSearchAndPagination(String query, int page, int size);
    int getTotalPageAdmin(String query,int size);

    //HomePage
    List<ProductResponseClient> findAllProductByCategoryAndSortAndPagination(Long catId, Boolean typeSort, String query, int page, int size);
    int getTotalPageClient(Long catId, Boolean typeSort, String query, int size);
}
