package io.users.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.users.models.User;
import io.users.models.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	//Display all the users
	@RequestMapping("")
	public String getUsers(Model model) {
		
		model.addAttribute("list",UserService.getAll());
		model.addAttribute("title", "Users");
		return "users/index";
	}
	
	//Display the user form
	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String displayUserForm(Model model) {
		model.addAttribute("title","Add a User");
		model.addAttribute(new User());
		return "users/add";
	}
	
	//Process the post request in the form
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String processUserForm(@ModelAttribute @Valid User newUser, Errors errors,
									Model model) {
		
		if(errors.hasErrors()) {
			model.addAttribute("title","Add a User");
			return "users/add";
		}
		UserService.add(newUser);
		return "redirect:";
	}
	
	//Display the list of all the users
	@RequestMapping(value = "/remove", method=RequestMethod.GET)
	public String displayRemoveUserForm(Model model) {
		model.addAttribute("list", UserService.getAll());
		model.addAttribute("title","Remove a User");
		return "users/remove";
	}
	
	//Process the remove post request 
	@RequestMapping(value = "/remove", method=RequestMethod.POST)
	public String processRemoveUserForm(@RequestParam int[] userIds) {
		for(int userId :userIds) {
			UserService.remove(userId);
		}
		
		return "redirect:";
	}
}
