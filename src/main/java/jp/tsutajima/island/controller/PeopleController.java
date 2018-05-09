package jp.tsutajima.island.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("people")
public class PeopleController {

	@RequestMapping
	public String index(Model model) {
		
		return "people";
	}
}
