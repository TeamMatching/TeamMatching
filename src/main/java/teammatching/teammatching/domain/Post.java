package teammatching.teammatching.domain;

import lombok.Data;

@Data
public class Post {
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
}
