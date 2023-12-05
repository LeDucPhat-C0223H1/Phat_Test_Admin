package ra.Project_Final_Module4.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.Project_Final_Module4.dao.IProductDao;
import ra.Project_Final_Module4.daoimpl.ProductDao;
import ra.Project_Final_Module4.dto.request.ProductRequest;
import ra.Project_Final_Module4.dto.response.ProductResponseAdmin;
import ra.Project_Final_Module4.dto.response.ProductResponseClient;
import ra.Project_Final_Module4.model.Product;
import ra.Project_Final_Module4.service.IProductService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServive implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Autowired
    private UploadService uploadService;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public void save(ProductRequest productRequest) {
        String imageUrl = null;
        if (!productRequest.getFileImage().isEmpty()) {
            imageUrl = uploadService.uploadFileImage(productRequest.getFileImage());
        }
        productDao.save(
                new Product(
                        productRequest.getCategoryId(),
                        productRequest.getName(),
                        imageUrl,
                        productRequest.getDescription(),
                        productRequest.getPrice(),
                        productRequest.getStock(),
                        new Date(),
                        new Date()
                )
        );
    }

    @Override
    public void update(Product productEdit, MultipartFile fileImage) {
        if (!fileImage.isEmpty()) {
            productEdit.setImageUrl(uploadService.uploadFileImage(fileImage));
        }
        productEdit.setModifiedAt(new Date());
        productDao.save(productEdit);
    }

    @Override
    public void delete(Long id) {
        productDao.delete(id);
    }

    // Tìm kiếm, hiển thị và phân trang bên admin
    @Override
    public List<ProductResponseAdmin> findAllAndSearchAndPagination(String query, int page, int size) {
        return productDao.findAllAndSearchAndPagination(query, size, page * size);
    }

    @Override
    public int getTotalPageAdmin(String query, int size) {
        int count = productDao.findAllAndSearch(query).size();
        if (count % size == 0) {
            return count / size;
        }
        return count / size + 1;
    }

    // HomePage
    @Override
    public List<ProductResponseClient> findAllProductByCategoryAndSortAndPagination(Long catId, Boolean typeSort, String query, int page, int size) {
        if(typeSort == null){
            if (catId == 0) {
                return productDao.findAllActive().stream()
                        .skip(page * size).limit(size).collect(Collectors.toList());
            } else {
                return productDao.findAllActive().stream()
                        .filter(p -> p.getCategoryId() == catId)
                        .filter(p -> p.getName().toLowerCase().contains(query.toLowerCase()) || p.getDescription().toLowerCase().contains(query.toLowerCase()))
                        .skip(page * size).limit(size).collect(Collectors.toList());
            }
        }
        else {
            if (catId == 0) {
                return productDao.findAllActiveAndSort(typeSort).stream()
                        .skip(page * size).limit(size).collect(Collectors.toList());
            } else {
                return productDao.findAllActiveAndSort(typeSort).stream()
                        .filter(p -> p.getCategoryId() == catId)
                        .filter(p -> p.getName().toLowerCase().contains(query.toLowerCase()) || p.getDescription().toLowerCase().contains(query.toLowerCase()))
                        .skip(page * size).limit(size).collect(Collectors.toList());
            }
        }


    }

    @Override
    public int getTotalPageClient(Long catId, Boolean typeSort, String query,  int size) {
         if(typeSort == null){
             if (catId == 0) {
                 int count = productDao.findAllActive().size();
                 if (count % size == 0) {
                     return count / size;
                 }
                 return count / size + 1;
             } else {
                 int count = (int) productDao.findAllActive().stream()
                         .filter(p -> p.getCategoryId() == catId)
                         .filter(p -> p.getName().toLowerCase().contains(query.toLowerCase()) || p.getDescription().toLowerCase().contains(query.toLowerCase()))
                         .count();
                 if (count % size == 0) {
                     return count / size;
                 }
                 return count / size + 1;
             }
         }else {
             if (catId == 0) {
                 int count = productDao.findAllActiveAndSort(typeSort).size();
                 if (count % size == 0) {
                     return count / size;
                 }
                 return count / size + 1;
             } else {
                 int count = (int) productDao.findAllActiveAndSort(typeSort).stream()
                         .filter(p -> p.getCategoryId() == catId)
                         .filter(p -> p.getName().toLowerCase().contains(query.toLowerCase()) || p.getDescription().toLowerCase().contains(query.toLowerCase()))
                         .count();
                 if (count % size == 0) {
                     return count / size;
                 }
                 return count / size + 1;
             }
         }

    }
}
