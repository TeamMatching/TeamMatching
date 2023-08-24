package teammatching.teammatching.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostSaveForm {

    @NotNull
    private String category;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    @Max(value = 100, message = "최대 100명까지 입니다")
    private Integer max_team;
}
