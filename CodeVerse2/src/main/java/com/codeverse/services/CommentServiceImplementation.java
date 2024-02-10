package com.codeverse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeverse.entity.Comments;
import com.codeverse.repository.CommentRepository;

@Service
public class CommentServiceImplementation implements CommentService{
	@Autowired
	CommentRepository commentRepository;

	@Override
	public List<Comments> getCommentlist() {
		return commentRepository.findAll();
	}

	@Override
	public void addComment(Comments comment) {
		commentRepository.save(comment);
	}
}
