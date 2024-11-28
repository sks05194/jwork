package kr.co.first.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
	
	@GetMapping("/")
	public String idx( Model model) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		model.addAttribute("toDate", dateTimeFormatter.format(LocalDateTime.now()));
		return "index";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("localDateTime", LocalDateTime.now());
		return "home";
	}
	
	@GetMapping("/ajaxHome")
	public String ajaxHome() {
		return "ajax";
	}
}
