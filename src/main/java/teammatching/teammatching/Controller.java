package teammatching.teammatching;

import jakarta.annotation.PostConstruct;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import teammatching.teammatching.domain.Post;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/team-matching")
public class Controller {

    private MultiValueMap<String, Post> postsByCategory = new LinkedMultiValueMap<>();  //일단 db 예시


    @GetMapping //메인 페이지
    public String mainPage() {
        return "main";
    }

    @GetMapping("/posts/{id}") //게시글 상세조회
    public String postDetail(@PathVariable Integer id) {

        return "post-detail";
    }

    @GetMapping("/add") //게시글 등록 폼
    public String addForm() {
        return "addForm";
    }

    @PostMapping("/add")
    public String addPost() {

        return "redirect:/team-matching";
    }

    @DeleteMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Integer id) {
        return "redirect:/team-matching";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable Integer id) {

        return "editForm";
    }

    @PostMapping("/posts/{id}/edit")
    public String edit(@PathVariable Integer id) {

        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{category}")
    public String requestParam(@PathVariable String category, Model model) {
        List<Post> posts = getPostsByCategory(category);
        for (Post post : posts) {
            System.out.println(post);
        }
        model.addAttribute("posts", posts);
        return "main";
    }

    @PostConstruct  //테스트 데이터 추가
    public void addPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("project", "프로젝트1", "프로젝트 모집"));
        posts.add(new Post("project", "프로젝트2", "프로젝트 모집중"));
        posts.add(new Post("hobby", "취미1", "롤5인큐모집"));
        posts.add(new Post("hobby", "취미2", "취미모집"));
        posts.add(new Post("club", "동아리1", "동아리"));
        posts.add(new Post("club", "동아리2", "동아리모집"));
        for (Post post : posts) {
            postsByCategory.add(post.getCategory(),post);
        }


    }

    public List<Post> getPostsByCategory(String category) {
        return postsByCategory.getOrDefault(category, new ArrayList<>());
    }
}
