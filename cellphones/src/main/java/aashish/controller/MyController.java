package aashish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping(value = { "/", "reqHome" })
	public String displayindex() {
		return "index";
	}

}