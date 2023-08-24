package teammatching.teammatching;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import teammatching.teammatching.domain.Category;
import teammatching.teammatching.domain.Post;
import teammatching.teammatching.domain.PostRepository;
import teammatching.teammatching.form.PostSaveForm;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor
public class MainController {

    @ModelAttribute("categories")
    public List<Category> categories(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("project", "프로젝트"));
        categories.add(new Category("club", "동아리"));
        categories.add(new Category("hobby", "취미"));
        categories.add(new Category("etc", "기타"));
        return categories;
    }

    private final PostRepository postRepository;        //일단 db 예시

    @GetMapping("/") //메인 페이지
    public String mainPage(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        return "main";
    }

    @GetMapping("/posts/{id}") //게시글 상세조회
    public String postDetail(@PathVariable Long id,Model model) {
        //db에서 id로 게시글을 찾아서 Post객체에 주입
        Post post = postRepository.findById(id);
        model.addAttribute("post",post);
        return "post-detail";
    }

    @GetMapping("/add") //게시글 등록 폼
    public String addForm(Model model) {
        model.addAttribute("post", new Post());
        return "addForm";
    }

    @PostMapping("/add")
    public String addPost(@Validated @ModelAttribute("post")PostSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "addForm";
        }

        Post post = new Post();
        post.setCategory(form.getCategory());
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setMax_team(form.getMax_team());
        postRepository.save(post);
        redirectAttributes.addAttribute("id", post.getId());
        return "redirect:/team-matching/posts/{id}";
    }

    @DeleteMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        return "redirect:/team-matching";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable Long id) {

        return "editForm";
    }

    @PostMapping("/posts/{id}/edit")
    public String edit(@PathVariable Long id) {

        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{category}")
    public String requestParam(@PathVariable String category, Model model) {
        List<Post> posts = postRepository.findByCategory(category);
        model.addAttribute("posts", posts);
        return "main";
    }

    @PostConstruct  //테스트 데이터 추가
    public void addPosts() {
        postRepository.save(new Post("project", "프로젝트1", "프로젝트 모집",6));
        postRepository.save(new Post("project", "프로젝트2", "프로젝트 모집중",3));
        postRepository.save(new Post("hobby", "취미1", "롤5인큐모집",5));
        postRepository.save(new Post("hobby", "취미2", "취미모집",3));
        postRepository.save(new Post("club", "동아리1", "동아리",6));
        postRepository.save(new Post("club", "동아리2", "동아리모집",1));
    }

}
