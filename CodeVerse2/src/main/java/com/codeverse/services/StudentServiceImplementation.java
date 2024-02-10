package com.codeverse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeverse.entity.Course;
import com.codeverse.entity.Lesson;
import com.codeverse.repository.CourseRepository;
import com.codeverse.repository.LessonRepository;

@Service
public class StudentServiceImplementation implements StudentService{
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	CourseRepository courseRepository;

	@Override 
	public Lesson findById(int lessonId) {
		Lesson lesson = lessonRepository.findById(lessonId).get();
		return lesson;
	}

	@Override
	public List<Lesson> findAll() {
		return lessonRepository.findAll();
	}

	@Override
	public List<Lesson> findbyCourseId(int courseId) {
		List<Lesson> lessonList = lessonRepository.findByCourseId(courseId);
		return lessonList ;
	}

	@Override
	public Course getById(int courseId) {
		Course course = courseRepository.findById(courseId).get();
		return course;
	}
}