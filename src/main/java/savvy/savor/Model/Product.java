package savvy.savor.Model;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/*
* when user search for a product, it will search for nix database first,
* and when the user click on the item, if that nix item does not exist in our database,
* it will add a new entry to our database and how to user.
* if it exist, it will just show the entry
* */
@Entity
public class Product {

    @Id
    String nixItemId;

    @NotNull
    String productName;

    @ManyToOne
    Brand brand;

    String pictureLink;

    @ManyToMany
    List<Recipe> recipes;

    @OneToMany
    List<Comment> comments;

    @LastModifiedDate
    LocalDateTime edited;

    public String getNixItemId() {
        return nixItemId;
    }
}
