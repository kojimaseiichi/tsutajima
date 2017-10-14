package jp.tsutajima.people.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/index", "/"})
public class IndexController {
	
	/** default view */
	private static final String VIEW_NAME = "index";

	@RequestMapping
	public String index(Model model) {
		return VIEW_NAME;
	}
}
