package com.codeverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeverse.entity.Course;
import com.codeverse.entity.Lesson;
import com.codeverse.services.StudentService;
import com.codeverse.services.TrainerService;


@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	private TrainerService trainerService;
	
	
	
	@PostMapping("/viewLessonDetails")
	public String demoLesson(@RequestParam("lessonId")int lessonId,
			Model model) {
		Lesson lesson = studentService.findById(lessonId);
		model.addAttribute("lesson", lesson);
		return "viewLessonDetails";
	}

	@GetMapping("/exploreCourses")
	public String exploreCourses(Model model) {
		List<Course> courses = trainerService.findAll();
		model.addAttribute("courses", courses);
		return "viewCourses";
	}
	
	@PostMapping("/viewSyllabus")
	public String viewSyllabus(@RequestParam("courseId")int courseId, Model model) {
		Course course = studentService.getById(courseId);
		List<Lesson> lessonList = studentService.findbyCourseId(courseId);
		model.addAttribute("course", course);
		model.addAttribute("lessons", lessonList);
		return "showSyllabus";
	}
	
	@PostMapping("/buyCourse")
	public String buyCourse(@RequestParam("courseId") int courseId,Model model) {
		Course course = studentService.getById(courseId);
		model.addAttribute("course",course);
		return "buyCourse";
	}
	
	@PostMapping("/paymentSuccess")
	public String addCourseToStudent() {
		return "paymentSuccess";
	}
}
