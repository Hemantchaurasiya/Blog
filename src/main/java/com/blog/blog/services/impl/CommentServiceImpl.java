package com.blog.blog.services.impl;

import com.blog.blog.entities.Comment;
import com.blog.blog.entities.Post;
import com.blog.blog.exceptions.ResourceNotFoundException;
import com.blog.blog.payloads.CommentDto;
import com.blog.blog.repositories.CommentRepository;
import com.blog.blog.repositories.PostRepository;
import com.blog.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post","PostId",postId));
        Comment comment = modelMapper.map(commentDto,Comment.class);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException("Comment","CommentId",commentId));
        commentRepository.delete(comment);
    }
}
