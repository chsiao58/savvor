package savvy.savor.Model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long commentId;

    @ManyToOne
    @CreatedBy
    User user;

    @NotNull
    String commentBody;

    Integer vote = 0;

    @CreatedDate
    LocalDateTime created;

    @LastModifiedDate
    LocalDateTime edited;



}
