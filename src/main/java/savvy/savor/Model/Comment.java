package savvy.savor.Model;

import java.time.LocalDateTime;

public class Comment {
    Long commentId;
    User user;
    String commentBody;
    Integer vote;
    LocalDateTime created;
    LocalDateTime edited;



}
