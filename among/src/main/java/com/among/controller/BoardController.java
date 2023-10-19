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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.among.Service.BoardService;
import com.among.domain.Board;

@Controller

public class BoardController {

	@Autowired
	private BoardService boardService;  
	/*
	@GetMapping("/board/boardmodify")
	public String modi1(Model model) { 
		
		return "board/boardmodify"; 
	}*/
	
	//자유게시판
	@GetMapping("/freeboard")
	public String requestBoardList(Model model) { 
		List<Board> list = boardService.getAllBoardList();
		model.addAttribute("boardList", list);  
		return "board/freeboard"; 
	}
	//게임게시판
	@GetMapping("/gameboard")
	public String gameBoardList(Model model) { 
		List<Board> list = boardService.getAllBoardList();
		model.addAttribute("boardList", list);  
		return "board/gameboard"; 
	}
	//여행게시판
	@GetMapping("/travleboard")
	public String travleBoardList(Model model) { 
		List<Board> list = boardService.getAllBoardList();
		model.addAttribute("boardList", list);  
		return "board/travleboard"; 
	}
	//맛집게시판
	@GetMapping("/foodboard")
	public String foodBoardList(Model model) { 
		List<Board> list = boardService.getAllBoardList();
		model.addAttribute("boardList", list);  
		return "board/foodboard"; 
	}
	//인기게시판
	@GetMapping("/hotboard")
	public String hotBoardList(Model model) { 
		List<Board> list = boardService.getHotBoardList();
		model.addAttribute("boardList", list);  
		return "board/hotboard"; 
	}
	@GetMapping("/home")
	   public String homeBoardList(Model model) { 
	      List<Board> list = boardService.getHomeBoardList();
	      model.addAttribute("boardList", list);  
	      return "/home"; 
	   }
	//게시판글쓰기
	@PostMapping(value = "/board/boardwr")
	@ResponseBody
	public String boardWrite(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
			ModelMap modelMap, @ModelAttribute("board") Board board, Model model, MultipartFile[] uploadFile){
					
			if (uploadFile != null) {
				for(MultipartFile multipartFile : uploadFile) {	
					File savefile = new File("C:\\Users\\Administrator\\git\\AMONG\\among\\src\\main\\webapp\\resources\\images", multipartFile.getOriginalFilename());
					try {
						multipartFile.transferTo(savefile);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		    	boardService.getboardWrite(board);
	      
		    	return "redirect:/home";
	}
	
	//조회수증가
	@RequestMapping(value = "/board/upView", method = RequestMethod.POST) 
    public String setbodView(Model model, @RequestParam("boardKey") int boardKey) {
        
    	boardService.setbodView(boardKey);
        
    	return "redirect:/home";
    }
	
	//게시판 수정(조회)
	@RequestMapping(value= "/boardmodify", method = RequestMethod.GET) 
	public String modiBoard(@RequestParam("boardKey") int boardKey,Model model)	{
		System.out.println("boardmodify 컨트롤러 진입");
		System.out.println("boardKey = "+boardKey);
		Board bod = new Board();
		bod = boardService.getBoardmodi(boardKey);
		model.addAttribute("board",bod);
		
		System.out.println("boardmodify 메서드 호출 완료");
		
		return "board/boardmodify";
	}
	
	//게시판 수정
	//글쓰기
	@PostMapping(value = "/board/boardmodi")
	@ResponseBody
	public String Updatebd(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
			ModelMap modelMap, @ModelAttribute("board") Board board, Model model, MultipartFile[] uploadFile){
						
			if (uploadFile != null) {
				for(MultipartFile multipartFile : uploadFile) {	
					File savefile = new File("C:\\Users\\Administrator\\git\\AMONG\\among\\src\\main\\webapp\\resources\\images", multipartFile.getOriginalFilename());
					try {
						multipartFile.transferTo(savefile);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			    boardService.setBoardmodify(board);
			    System.out.println("setBoardmodi 메서드 호출 완료");
			    System.out.println(board.getBoardContent());
			    System.out.println(board.getBoardImg());
			    System.out.println(board.getBoardKey());
			    System.out.println(board.getBoardTitle());
			    return "redirect:/home";
	}
	
	//게시판 추천기능
	@RequestMapping(value = "/board/recommend", method = RequestMethod.POST) 
    public String setbodRec(Model model, @RequestParam("boardKey") int boardKey) {
        
    	boardService.setbodRecommend(boardKey);
        
    	return "redirect:/home";
    }
		
}