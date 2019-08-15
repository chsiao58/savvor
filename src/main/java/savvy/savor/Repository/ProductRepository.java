package savvy.savor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savvy.savor.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    Product findByNixItemId(String nixItemId);
}
