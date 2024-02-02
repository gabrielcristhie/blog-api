package com.solides.blog.DTO;

import com.solides.blog.domain.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {

    private Long id;
    private String postTitle;
    private String postContent;
    private String photo;
    private Date postCreatedDate;
    private User user;
}
