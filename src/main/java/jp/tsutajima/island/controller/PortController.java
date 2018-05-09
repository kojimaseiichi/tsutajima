package jp.tsutajima.island.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/port")
public class PortController {
	
	/** default view */
	private static final String VIEW_NAME = "port";

	@RequestMapping()
	public String index(Model model) {
		return VIEW_NAME;
	}
}
