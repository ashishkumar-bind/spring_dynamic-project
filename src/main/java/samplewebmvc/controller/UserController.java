package samplewebmvc.controller;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@RequestMapping("/")
	@ResponseBody
	public String greet() {
		return "Welcome to the Spring project";
	}

	@RequestMapping("/movies")
	@ResponseBody
	public String movies() {
		return "Hello, Welcome in the Movie Pannel ";
	}
}
