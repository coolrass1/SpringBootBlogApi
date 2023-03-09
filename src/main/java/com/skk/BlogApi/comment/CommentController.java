package com.skk.BlogApi.comment;

import com.skk.BlogApi.comment.dto.CommentRequest;
import com.skk.BlogApi.entity.Comment;
import com.skk.BlogApi.entity.Post;
import com.skk.BlogApi.posts.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/comment")
    List<Comment> GetAllComment(){
        return commentService.all();
    }

    @PostMapping("/comment")
    Comment CreateComment(@RequestBody CommentRequest comment){


        Comment newComment = Comment.builder().content(comment.getContent()).post(postservice.getUserById(Long.valueOf(8))).build();

        System.out.println(newComment);
        return commentService.Create_Comment(newComment);

    }

}
