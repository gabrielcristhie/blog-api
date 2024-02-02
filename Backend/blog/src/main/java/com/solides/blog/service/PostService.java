package com.solides.blog.service;

import com.solides.blog.DTO.PostDTO;
import org.springframework.data.domain.Page;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    Page<PostDTO> listAllPosts(Integer pageNum, Integer pageSize);
    void deletePost(Long id);
}
