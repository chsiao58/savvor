package savvy.savor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
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

    private ResponseEntity<Product> show(String nixItemId) {
        Product found = productService.show(nixItemId);
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Header", "value");
//        headers.set("Other-Header", "othervalue");
//        HttpEntity entity = new HttpEntity(headers);
//        restTemplate.exchange("", HttpMethod.GET,entity,Product.class);
        if (found == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(found, HttpStatus.OK);
    }
}
