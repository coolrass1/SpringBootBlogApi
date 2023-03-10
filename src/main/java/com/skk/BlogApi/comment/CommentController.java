package com.skk.BlogApi.comment;

import com.skk.BlogApi.comment.dto.CommentRequest;
import com.skk.BlogApi.entity.Comment;
import com.skk.BlogApi.entity.Post;
import com.skk.BlogApi.entity.User;
import com.skk.BlogApi.entity.UserRepository;
import com.skk.BlogApi.posts.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postservice;
@Autowired
private UserRepository userRepository;
    @GetMapping("/comment")
    List<Comment> GetAllComment(){
        return commentService.all();
    }

    @GetMapping("/comment/page")
    Page<Comment> GetAllCommenPage(){
        return commentService.getPageableComment(1,2);
    }

    @PostMapping("/comment")
    Comment CreateComment(@RequestBody CommentRequest comment){
com.skk.BlogApi.entity.User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Comment newComment = Comment.builder().content(comment.getContent())
                .post(postservice.getUserById(Long.valueOf(comment.getPostId())))
                .user(author)
                .build();


        return commentService.Create_Comment(newComment);

    }

}
