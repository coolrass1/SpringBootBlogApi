package com.skk.BlogApi.comment;

import com.skk.BlogApi.entity.Comment;
import com.skk.BlogApi.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    List<Comment> all() {
        return   commentRepository.findAll();
    }

    Comment  Create_Comment( Comment comment) {


        return commentRepository.save(comment);
    }

    public Comment  update_Comment(Long id,  Comment comment ) {
        Comment existingComment  = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        existingComment.setContent(comment.getContent());

        return commentRepository.save(existingComment);
    }

    public void deleteComment( Long id) {
        commentRepository.deleteById(id);
    }
}
