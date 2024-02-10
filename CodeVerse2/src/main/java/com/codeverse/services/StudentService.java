package com.codeverse.services;

import java.util.List;

import com.codeverse.entity.Course;
import com.codeverse.entity.Lesson;

public interface StudentService {

	Lesson findById(int lessonId);
	
	List<Lesson> findAll();

	List<Lesson> findbyCourseId(int courseId);
	
	Course getById(int courseId);

}
