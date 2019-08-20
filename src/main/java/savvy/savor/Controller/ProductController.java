package savvy.savor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import savvy.savor.Http.NixRetriever;
import savvy.savor.Model.Product;
import savvy.savor.Service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private ProductService productService;
    private NixRetriever nixRetriever;

    @Autowired
    public ProductController(ProductService productService, NixRetriever nixRetriever) {
        this.productService = productService;
        this.nixRetriever = nixRetriever;
    }

    @GetMapping(value = "/{nixItemId}")
    private ResponseEntity<Product> show(@PathVariable String nixItemId) {
        Product found = productService.show(nixItemId);

        // if not already in database, fetch data from Nix and store it in this database
        if (found == null) {
           ResponseEntity<Product> ogNixData = nixRetriever.exchange(
                    "v2/search/item?nix_item_id="+nixItemId,
                    HttpMethod.GET, Product.class);
           return new ResponseEntity<>(productService.create(ogNixData.getBody()), HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(found, HttpStatus.OK);
    }
}
