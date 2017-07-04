package com.adobe.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adobe.prj.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String addUser(@RequestParam("userName") String userName,
			@RequestParam("password")String password, Model model) {
		//userService.addUser(user);
		model.addAttribute("msg", "User with username:" + userName + "login successfully");
		return "index.jsp";
	}
}
