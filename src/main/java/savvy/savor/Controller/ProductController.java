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

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{nixItemId}")
    private ResponseEntity<Product> show(@PathVariable String nixItemId) {
        Product found = productService.show(nixItemId);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }
}
