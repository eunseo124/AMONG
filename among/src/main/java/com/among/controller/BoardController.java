package com.among.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.among.Service.BoardService;
import com.among.domain.Board;

@Controller
@RequestMapping("/freeboard")
public class BoardController {

	//Autowired 를 정의하여 BookService 클래스의 getAllBookList() 메서드를 호출합니다.
	@Autowired
	private BoardService boardService;  

	/* HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.*/
	@GetMapping
	public String requestBoardList(Model model) { 
		List<Board> list = boardService.getAllBoardList();
		model.addAttribute("boardList", list);  
		return "board/freeboard"; 
	}
		
}