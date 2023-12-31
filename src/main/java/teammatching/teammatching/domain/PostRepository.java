package teammatching.teammatching.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByCategory(String category);
//    private static final Map<Long, Post> store = new HashMap<>();
//    private static long sequence = 0L;
//
//    public Post save(Post post) {
//        post.setId(++sequence);
//        store.put(post.getId(), post);
//        return post;
//    }
//
//    public Post findById(Long id) {
//        return store.get(id);
//    }
//
//    public List<Post> findAll() {
//        return new ArrayList<>(store.values());
//    }
//
//    public void update(Long postId, Post updateParam) {
//        Post findPost = findById(postId);
//        findPost.setCategory(updateParam.getCategory());
//        findPost.setTitle(updateParam.getTitle());
//        findPost.setContent(updateParam.getContent());
//        findPost.setMax_team(updateParam.getMax_team());
//    }
//
//    public void clearStore() {
//        store.clear();
//    }
//
//    public List<Post> findByCategory(String category) {
//        List<Post> posts = new ArrayList<>();
//        for (Post post : store.values()) {
//            if (post.getCategory().equals(category)) {
//                posts.add(post);
//            }
//        }
//        return posts;
//    }
}