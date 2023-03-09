package com.skk.BlogApi.posts;

import com.skk.BlogApi.entity.Post;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    @Autowired
    PostRepository postrepository;
    List<Post> all() {
        return postrepository.findAll();
    }
    Post newPost( Post post ) {


        return postrepository.save(post);
    }
    public Post updatePost(Long id, Post post) {
        Post existingPost = postrepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        return postrepository.save(existingPost);
    }

    public Post getUserById(Long id) {
        return postrepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteUser( Long id) {
        postrepository.deleteById(id);
    }
}
