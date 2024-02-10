package com.codeverse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeverse.entity.Course;
import com.codeverse.entity.Lesson;
import com.codeverse.repository.CourseRepository;
import com.codeverse.repository.LessonRepository;

@Service
public class TrainerServiceImplementation implements TrainerService{

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	LessonRepository lessonRepository;

	@Override
	public String addCourse(Course course) {
		courseRepository.save(course);
		return "Course Added Successfully";
	}

	@Override
	public String addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
		return "Lesson Added Successfully";
	}

	@Override
	public Course findById(int courseId) {
		Course course = courseRepository.findById(courseId).get();
		return course;
	}

	@Override
	public List<Course> findAll() {
		List<Course> courses = courseRepository.findAll();
		return courses;
	}

	@Override
	public List<Lesson> findByCourseId(int courseId) {
		
		return lessonRepository.findByCourseId(courseId);
	}

}
