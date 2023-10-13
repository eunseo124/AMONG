package com.among.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.among.Service.BoardService;
import com.among.domain.Board;

@Controller

public class BoardController {

	@Autowired
	private BoardService boardService;  

	//게시판 조회
	/* HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.*/
	@GetMapping("/freeboard")
	public String requestBoardList(Model model) { 
		List<Board> list = boardService.getAllBoardList();
		model.addAttribute("boardList", list);  
		return "board/freeboard"; 
	}
	
	//게시판 글쓰기
	@PostMapping(value = "/board/boardwr")
	@ResponseBody
	public String boardWrite(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
			ModelMap modelMap, @ModelAttribute("board") Board board, Model model, MultipartFile[] uploadFile){
					
				for(MultipartFile multipartFile : uploadFile) {	
					File savefile = new File("C:\\Users\\Administrator\\git\\AMONG\\among\\src\\main\\webapp\\resources\\images", multipartFile.getOriginalFilename());
					try {
						multipartFile.transferTo(savefile);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("접근완료");
		    	boardService.getboardWrite(board);
	      
		    	return "redirect:/home";
	}
	
	//게시판 조회수 증가
	@RequestMapping(value = "/upView") 
    public String setbodView(Model model, @RequestParam("id") int boardKey) {
        
    	boardService.setbodView(boardKey);
        
    	return "redirect:/home";
    }
	
		
}