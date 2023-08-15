package teammatching.teammatching;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
@RequestMapping("/TeamMatching")
public class Controller {

    @GetMapping //메인 페이지
    public String mainPage() {
        return "main";
    }

    @GetMapping("/posts/{id}") //게시글 상세조회
    public String postDetail(@PathVariable Integer id) {

        return "post_detail";
    }

    @GetMapping("/add") //게시글 등록 폼
    public String addForm() {
        return "addForm";
    }

    @PostMapping("/add")
    public String addPost() {

        return "redirect:/TeamMatching";
    }

    @DeleteMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Integer id) {
        return "redirect:/TeamMatching";
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable Integer id) {

        return "editForm";
    }

    @PostMapping("/posts/{id}/edit")
    public String edit(@PathVariable Integer id) {

        return "redirect:/basic/items/{itemId}";
    }
}
