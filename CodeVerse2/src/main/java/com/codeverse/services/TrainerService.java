package com.codeverse.services;

import java.util.List;

import com.codeverse.entity.Course;
import com.codeverse.entity.Lesson;

public interface TrainerService {
	public String addCourse(Course course);
	
	public String addLesson(Lesson lesson);

	public Course findById(int courseId);

	public List<Course> findAll();

	public List<Lesson> findByCourseId(int courseId);

}
