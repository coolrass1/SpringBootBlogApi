package com.skk.BlogApi.comment;

import com.skk.BlogApi.entity.Comment;
import com.skk.BlogApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository   extends JpaRepository<Comment,Long>  {
}
