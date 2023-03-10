package com.skk.BlogApi.comment;

import com.skk.BlogApi.entity.Comment;
import com.skk.BlogApi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepository   extends JpaRepository<Comment,Long>  {
    Page<Comment> findAll(Pageable pageable);
}
