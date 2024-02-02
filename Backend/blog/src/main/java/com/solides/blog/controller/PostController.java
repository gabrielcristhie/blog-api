package com.solides.blog.controller;

import com.solides.blog.DTO.PostDTO;
import com.solides.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/posts/")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("create")
    ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
        return ResponseEntity.ok(postService.createPost(postDTO));
    }
    @GetMapping("getAll")
    ResponseEntity<Page<PostDTO>> getAll(
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        Page<PostDTO> postDTOPage = postService.listAllPosts(pageNum, pageSize);
        return ResponseEntity.ok(postDTOPage);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){postService.deletePost(id);}
}
