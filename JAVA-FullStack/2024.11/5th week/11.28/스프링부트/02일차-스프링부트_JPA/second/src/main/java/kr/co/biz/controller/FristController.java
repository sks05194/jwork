package kr.co.biz.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.biz.board.Board;
import kr.co.biz.board.BoardService;

@Controller
public class FristController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/")
	public String idx( Model model) {
		LocalDateTime local = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		model.addAttribute("toDate", dateTimeFormatter.format(LocalDateTime.now()));
		return "index";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("localDateTime", LocalDateTime.now());
		return "home";
	}
	
	@GetMapping("/boardList")
	public String listAll(Model model) {
		List<Board>  boardList = service.findAll();
		
		// LocalDateTime을 String으로 변환하여 boardList에 추가
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	    boardList.forEach(board -> board.setRegDateStr(board.getRegDate().format(formatter)));
	    
		model.addAttribute("boardList", boardList);
		return "boardList";
	} 
	
	@GetMapping("/ajaxHome")
	public String ajaxHome() {
		return "ajax";
	}
}
