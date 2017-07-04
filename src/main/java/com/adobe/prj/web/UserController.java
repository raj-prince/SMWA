package com.adobe.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adobe.prj.entity.Movie;
import com.adobe.prj.entity.User;
import com.adobe.prj.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("newUser.do")
	public String getMovieForm(Model model) {
		model.addAttribute("user", new User());
		return "userForm.jsp";
	}
	
	@RequestMapping("addUser.do")
	public String addMovie (@ModelAttribute("user") User user, Model model) {
		userService.addUser(user);
		model.addAttribute("msg", "User " + user.getFirstName() +" "+user.getLastName() + " added successfully!!!");
		return "index.jsp";
	}
}
