package savvy.savor.Model;

import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long recipeId;

    @ManyToOne
    @CreatedBy
    User created;

    @ManyToMany
    List<Product> used;

    @OneToMany
    List<Comment> comments;
}
