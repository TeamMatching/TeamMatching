package teammatching.teammatching.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String title;
    private String content;
    private Integer max_team;

    public Post(String category, String title, String content, Integer max_team) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.max_team = max_team;
    }

    public Post() {
    }
}
