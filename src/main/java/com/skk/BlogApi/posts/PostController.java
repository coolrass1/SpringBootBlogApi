package com.skk.BlogApi.posts;


import com.skk.BlogApi.entity.Post;
import com.skk.BlogApi.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class PostController {
@Autowired
    PostService postservice;
PostresponseDTO postresponseDTO;


    @GetMapping("/post")
    public List<PostresponseDTO> hello(){
        //var thiep =postservice.all();

        List<PostresponseDTO> listpostdto= new ArrayList<>();



        postservice.all().stream().map(e->
            listpostdto
                    .add(PostresponseDTO.builder()
                            .title(e.getTitle())
                            .Author(e.getUser()
                                    .getName())
                            .AthorId(e.getUser()
                                    .getId())
                            .message(e.getContent())
                            .build())

        ).collect(Collectors.toList());

        return listpostdto;
    }
    @PostMapping("/post")
    Post createPost(@RequestBody PostDTO newPost) {

        User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post= Post.builder()

                        .title(newPost.getTitle())
                .content(newPost.getContent())
                                .user(author).build();




        return postservice.newPost(post);
    }
    @GetMapping("/post/{id}")
    public Post getUserById(@PathVariable Long id) {
        return postservice.getUserById(id);
    }
    @PutMapping("/post/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
       return postservice.updatePost(id, post);
    }

    @DeleteMapping("/post/{id}")
    public void deleteUser(@PathVariable Long id) {
        postservice.deleteUser(id);
    }
}
