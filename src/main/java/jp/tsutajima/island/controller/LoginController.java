package jp.tsutajima.island.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/login", "/"})
public class LoginController {

	private static final String VIEW_NAME = "login";
	
	@RequestMapping("")
	public String viewDefault(Model model) {
		System.out.println("viewDefault");
		return VIEW_NAME;
	}
	
	@RequestMapping("authenticate")
	public String viewAuthenticate(Model model) {
		return "redirect:/port";
	}
}
