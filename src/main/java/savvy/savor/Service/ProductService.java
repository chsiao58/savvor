package savvy.savor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import savvy.savor.Http.NixRetriever;
import savvy.savor.Model.Product;
import savvy.savor.Repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepo;
    private NixRetriever nixRetriever;


    @Autowired
    ProductService(ProductRepository productRepo, NixRetriever nixRetriever){
        this.productRepo = productRepo;
        this.nixRetriever = nixRetriever;
    }

    public Product show(String nixItemId) {
        Product found = productRepo.findByNixItemId(nixItemId);
        // if not already in database, fetch data from Nix and store it in this database
        if (found == null) {
            ResponseEntity<Product> ogNixData = nixRetriever.exchange(
                    "v2/search/item?nix_item_id="+nixItemId,
                    HttpMethod.GET, Product.class);
            create(ogNixData.getBody());
            return ogNixData.getBody();
        } else

        return productRepo.findByNixItemId(nixItemId);
    }

    public Product create(Product product) {
        productRepo.save(product);
        return product;
    }
}
