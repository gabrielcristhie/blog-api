package com.solides.blog.service.impl;


import com.solides.blog.DTO.CommentDTO;
import com.solides.blog.domain.entities.Comment;
import com.solides.blog.domain.enums.Errors;
import com.solides.blog.exception.BusinessErrorException;
import com.solides.blog.repository.CommentRepository;
import com.solides.blog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment =  modelMapper.map(commentDTO, Comment.class);
        Comment createdComment = commentRepository.save(comment);
        return modelMapper.map(createdComment, CommentDTO.class);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.delete(
                commentRepository.findById(id).
                        orElseThrow(() -> new BusinessErrorException(Errors.COMMENT_NOT_FOUND)));
    }
}
