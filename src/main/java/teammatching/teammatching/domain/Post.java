package teammatching.teammatching.domain;

import lombok.Data;

@Data
public class Post {
    private String category;
    private String title;
    private String content;

    public Post(String category, String title, String content) {
        this.category = category;
        this.title = title;
        this.content = content;
    }
}
