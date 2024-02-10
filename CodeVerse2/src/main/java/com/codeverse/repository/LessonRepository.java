package com.codeverse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeverse.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer>{

	List<Lesson> findByCourseId(int courseId);


}