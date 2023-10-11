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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.among.Service.BoardService;
import com.among.domain.Board;

@Controller

public class BoardController {

	@Autowired
	private BoardService boardService;  

	//�Խ��� ��ȸ
	/* HTTP ��û ����� GET�� ���, @GetMapping �� ����� �� �ֽ��ϴ�.*/
	@GetMapping("/freeboard")
	public String requestBoardList(Model model) { 
		List<Board> list = boardService.getAllBoardList();
		model.addAttribute("boardList", list);  
		return "board/freeboard"; 
	}
	
	//�Խ��� �۾���
	@RequestMapping(value = "/board/boardwr", method = RequestMethod.POST)
	@ResponseBody
	public String boardWrite(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
			ModelMap modelMap, @ModelAttribute("board") Board board, Model model){
	     		
				System.out.println("���ٿϷ�");
		    	boardService.getboardWrite(board);
	      
		    	return "redirect:/home";
	}
	
	//�Խ��� ��ȸ�� ����
	@RequestMapping(value = "/upView") 
    public String setbodView(Model model, @RequestParam("id") int boardKey) {
        
    	boardService.setbodView(boardKey);
        
    	return "redirect:/home";
    }
		
}