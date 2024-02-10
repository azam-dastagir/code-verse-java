package com.codeverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeverse.entity.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>{

}
