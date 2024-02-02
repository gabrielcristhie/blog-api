package com.solides.blog.service;

import com.solides.blog.DTO.CommentDTO;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO);
    void deleteComment(Long id);
}
