package com.solides.blog.service.impl;

import com.solides.blog.DTO.PostDTO;
import com.solides.blog.domain.entities.Post;
import com.solides.blog.domain.enums.Errors;
import com.solides.blog.exception.BusinessErrorException;
import com.solides.blog.repository.PostRepository;
import com.solides.blog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepository postRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        Post createdPost = postRepository.save(post);
        return modelMapper.map(createdPost, PostDTO.class);
    }

    @Override
    public Page<PostDTO> listAllPosts(Integer pageNum, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        Page<Post> posts = postRepository.findAll(pageRequest);
        return posts.map(post -> modelMapper.map(post, PostDTO.class));
    }

    @Override
    public void deletePost(Long id) {
        postRepository.delete(
                postRepository.findById(id)
                        .orElseThrow(() -> new BusinessErrorException(Errors.POST_NOT_FOUND)));
    }
}
