package com.codeverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codeverse.services.CommentService;
import com.codeverse.services.UserService;

import jakarta.servlet.http.HttpSession;

import com.codeverse.entity.Comments;
import com.codeverse.entity.Users;

@Controller
public class ServiceController {
	@Autowired
	UserService uService;
	@Autowired
	CommentService commentService;
	@Autowired
	private HttpSession httpSession;

	@PostMapping("/registerUser")
	public String addUser(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("role") String role,
			@RequestParam("mobile") String mobile, RedirectAttributes res) {

		if(uService.isEmailExists(email)) {
			res.addFlashAttribute("error","User Already Exists!");
			return "failed";
		}else {
			Users user = new Users();

			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(role);
			user.setMobile(mobile);

			uService.addUser(user);
			res.addFlashAttribute("success", "Registration Successful!");
			return "redirect:/";
		}
	}

	@PostMapping("/login")
	public String validateUser(@RequestParam("email") String email,
			@RequestParam("password") String password, RedirectAttributes res) {
		boolean isValid = uService.validate(email, password);
		boolean is_Student = uService.checkRole(email);
		if (isValid){
			Users user = null;
			httpSession.setAttribute("loggedInUser", user);
			if (is_Student) {
				res.addFlashAttribute("success", "Login Successful!");
				return "studentHome";
			}
			else {
				return "trainerHome";
			}
		}
		return "login";
	}
	
	@PostMapping("/addComment")
	public String addComment(@RequestParam("comment") String comment,
			Model model) {
		Comments c = new Comments();
		c.setComment(comment);
		commentService.addComment(c);
		
		List<Comments> commentList = commentService.getCommentlist();
		model.addAttribute("comment", commentList);
		return "redirect:/";
	}
}