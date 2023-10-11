package com.among.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.among.Service.BoardService;
import com.among.domain.Board;

@Controller

public class BoardController {

	//Autowired 를 정의하여 BookService 클래스의 getAllBookList() 메서드를 호출합니다.
	@Autowired
	private BoardService boardService;  

	/* HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.*/
	@GetMapping("/freeboard")
	public String requestBoardList(Model model) { 
		List<Board> list = boardService.getAllBoardList();
		model.addAttribute("boardList", list);  
		return "board/freeboard"; 
	}
	
	//게시판 글쓰기
	@RequestMapping(value = "/board/boardwr", method = RequestMethod.POST)
	@ResponseBody
	public String boardWrite(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
			ModelMap modelMap, @ModelAttribute("board") Board board, Model model){
	     		
				System.out.println("접근완료");
		    	boardService.getboardWrite(board);
	      
		    	return "redirect:/home";
	}
		
}