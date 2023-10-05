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

	//Autowired �� �����Ͽ� BookService Ŭ������ getAllBookList() �޼��带 ȣ���մϴ�.
	@Autowired
	private BoardService boardService;  

	/* HTTP ��û ����� GET�� ���, @GetMapping �� ����� �� �ֽ��ϴ�.*/
	@GetMapping
	public String requestBoardList(Model model) { 
		List<Board> list = boardService.getAllBoardList();
		model.addAttribute("boardList", list);  
		return "board/freeboard"; 
	}
		
}