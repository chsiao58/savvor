package savvy.savor.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @NotNull
    String password; // should encrypt

    @NotNull
    @Column(unique=true)
    String username; // should be unique

    @NotNull
    String nickname;

    @NotNull
    @Column(unique=true)
    String email; // should be unique

    @ManyToMany
    List<Product> favedProduct;

    @ManyToMany
    List<Recipe> favedRecipe;

    @OneToMany
    List<Comment> comments;
}
