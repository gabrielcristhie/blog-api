package com.solides.blog.controller;

import com.solides.blog.DTO.CommentDTO;
import com.solides.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/comments/")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("create")
    ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok(commentService.createComment(commentDTO));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id){commentService.deleteComment(id);}

}
