package savvy.savor.Model;

import java.util.List;

public class Recipe {
    Long recipeId;
    User created;
    List<Product> used;
    List<Comment> comments;
}
