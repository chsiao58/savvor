package savvy.savor.Model;

import java.util.List;

public class User {
    Long userId;
    String password; // should encrypt
    String username; // should be unique
    String email; // should be unique

    List<Product> favedProduct;
    List<Recipe> favedRecipe;
    List<Comment> comments;
}
