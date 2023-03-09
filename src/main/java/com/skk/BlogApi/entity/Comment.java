package com.skk.BlogApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment implements Serializable {
    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.UUID,
            generator = "comment_sequence"
    )
    private Long Id;
    private String content;
    /*@ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "Author",
            referencedColumnName = "Id"
    )
    private User user;*/
    @ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "Post",
            referencedColumnName = "postId"
    )
    private Post post;

}
