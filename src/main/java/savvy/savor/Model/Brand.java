package savvy.savor.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Brand {

    @Id
    String nixBrandId;

    @NotNull
    String brandName;

    @OneToMany
    List<Product> products;
}
