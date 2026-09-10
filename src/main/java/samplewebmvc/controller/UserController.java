package samplewebmvc.controller;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@RequestMapping("/")
	public String greet() {
		return "welcome";
	}

	@RequestMapping("/movies")
	@ResponseBody
	public String movies() {
		return "Hello, Welcome in the Movie Pannel ";
	}
}
