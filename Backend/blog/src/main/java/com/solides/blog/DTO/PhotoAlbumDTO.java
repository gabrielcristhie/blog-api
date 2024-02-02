package com.solides.blog.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhotoAlbumDTO {

    private Long id;
    private UserDTO user;
    private String title;
    private String description;
}
