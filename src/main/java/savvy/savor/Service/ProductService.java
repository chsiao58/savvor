package savvy.savor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import savvy.savor.Model.Product;
import savvy.savor.Repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepo;

    @Autowired
    ProductService(ProductRepository productRepo){
        this.productRepo = productRepo;
    }

    public Product show(String nixItemId) {
        return productRepo.findByNixItemId(nixItemId);
    }

    public Product create(Product product) {
        productRepo.save(product);
        return product;
    }
}
