package com.codeverse.services;

import java.util.List;

import com.codeverse.entity.Comments;

public interface CommentService {
	public List<Comments> getCommentlist();

	public void addComment(Comments comment);
}
