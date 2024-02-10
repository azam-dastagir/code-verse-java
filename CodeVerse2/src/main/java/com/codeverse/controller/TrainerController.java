package com.codeverse.controller;

import com.codeverse.entity.Lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.codeverse.entity.Course;
import com.codeverse.services.TrainerService;

@Controller
public class TrainerController {
	@Autowired
	TrainerService trainerService;

	@PostMapping("/createCourse")
	public String addCourse(@RequestParam("courseId") int courseId,
			@RequestParam("courseName") String courseName,
			@RequestParam("coursePrice") String coursePrice ) {

		Course course = new Course();

		course.setCourseId(courseId);
		course.setCourseName(courseName);
		course.setCoursePrice(coursePrice);

		String msg = trainerService.addCourse(course);

		return "redirect:/";
	}

	@PostMapping("/addLesson")
	public String addLesson(@RequestParam("courseId") int courseId,
			@RequestParam("lessonId") int lessonId,
			@RequestParam("lessonName") String lessonName,
			@RequestParam("lessonTopics") String lessonTopics,
			@RequestParam("videoLink") String videoLink) {

		Course course = trainerService.findById(courseId);

		Lesson lesson = new Lesson(courseId, lessonId, lessonName, lessonTopics, videoLink, course);

		trainerService.addLesson(lesson);

		course.getLessons().add(lesson);

		return "redirect:/";
	}

	@GetMapping("/viewCourses")
	public String viewCourses(Model model) {
		List<Course> courses = trainerService.findAll();
		model.addAttribute("courses", courses);
		return "viewCourses";
	}
	
	@PostMapping("/getLessonByCourseId")
	public String viewLessonsByCourseId(@RequestParam("courseId") int courseId,
			Model model) {
		List<Lesson> lessonList = trainerService.findByCourseId(courseId);
		model.addAttribute("lessons", lessonList);
		return "showLessons";
	}
	
}
