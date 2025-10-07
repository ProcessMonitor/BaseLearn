//package Interview.test;
//
//
//import lombok.Data;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.Arrays;
//import java.util.List;
//
//
//@Data
//public class PostVo {
//    private Long userId;
//    private Long id;
//    private String title;
//    private String body;
//
//}
//
//
//@RestController
//@RequestMapping("/api/posts")
//public class T2 {
//    @Resource
//    private PostService postService;
//    // smu
//    private List<PostVo> posts = Arrays.asList(
//            new PostVo(1L, 1L, "xxxxPost1", "body1"),
//            new PostVo(1L, 2L, "xxxPost2", "body2")
//    );
//
//    @GetMapping("/{id}")
//    public PostVo getPostById(@PathVariable("id") Long id) {
//        return posts.stream().filter(post -> post.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("id not found"));
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<PostVo>> getAllPost(
//            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "100") int size) {
//        Pageable page = PageRequest.of(page, size);
//        postService.getAll(page)
//        return ResponseEntity.ok(postService.getAll(page));
//    }
//
//    private final ReteLimiter rateLimiter = ReteLimiter.create(10.0);
//
//    public ResponseEntity<PostVo> createPost(Request request) {
//        if (!rateLimiter.tryAcquire()){
//            throw new RuntimeException("too many request");
//        }
////        xxxxxx work job ....
//
//        return doProcess();
//
//    }
//
//redisTemplate;
//    public ResponseEntity<PostVo> createPost(Request request , String apiKey) {
//        String key = Enum + "post:" + apiKey;
//
//        // Lua script :
//        String luaScript = "xxx";
//
//
//        Boolean isAllowed = redisTemplate.excute( new DefaultRedisScript<>(luaScript));
//
//        //        xxxxxx work job ....
//
//        return doProcess();
//
//    }
//
//
//    @SwitchDS(value = "id")
//
//
//
//}