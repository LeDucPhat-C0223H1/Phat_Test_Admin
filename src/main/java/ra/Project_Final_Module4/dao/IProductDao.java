package ra.Project_Final_Module4.dao;

import ra.Project_Final_Module4.dto.response.ProductResponseAdmin;
import ra.Project_Final_Module4.dto.response.ProductResponseClient;
import ra.Project_Final_Module4.dto.response.UserEditResponse;
import ra.Project_Final_Module4.model.Product;

import java.util.List;

public interface IProductDao extends IGenericDao <Product, ProductResponseAdmin, Long>{
    // bên home page
    List<ProductResponseClient> findAllActive();

    List<ProductResponseClient> findAllActiveAndSort(boolean type);

}
