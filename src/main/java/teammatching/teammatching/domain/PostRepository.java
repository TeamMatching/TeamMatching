package teammatching.teammatching.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository {
    private static final Map<Long, Post> store = new HashMap<>();
    private static long sequence = 0L;

    public Post save(Post post) {
        post.setId(++sequence);
        store.put(post.getId(), post);
        return post;
    }

    public Post findById(Long id) {
        return store.get(id);
    }

    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long postId, Post updateParam) {
        Post findPost = findById(postId);
        findPost.setCategory(updateParam.getCategory());
        findPost.setTitle(updateParam.getTitle());
        findPost.setContent(updateParam.getContent());
        findPost.setMax_team(updateParam.getMax_team());
    }

    public void clearStore() {
        store.clear();
    }

    public List<Post> findByCategory(String category) {
        List<Post> posts = new ArrayList<>();
        for (Post post : store.values()) {
            if (post.getCategory().equals(category)) {
                posts.add(post);
            }
        }
        return posts;
    }
}