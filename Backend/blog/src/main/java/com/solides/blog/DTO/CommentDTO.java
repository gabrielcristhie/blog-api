package com.solides.blog.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {

    private Long id;
    private String content;
    private PostDTO post;
    private UserDTO user;
}
