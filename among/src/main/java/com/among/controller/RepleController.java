package com.among.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.among.Service.AdminService;
import com.among.Service.RepleService;
import com.among.Service.BoardService;
import com.among.domain.Board;
import com.among.domain.Reple;


@Controller
public class RepleController {

//	//Autowired 를 정의하여 BookService 클래스의 getAllBookList() 메서드를 호출합니다.
	@Autowired
	private RepleService repleService;

		@Autowired
	private BoardService boardService;
//
//	// HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.
//	@GetMapping
//	public String requestRepleList(Model model) { 
//	    List<Reple> list = repleService.getAllRepleList();
//	    model.addAttribute("repleList", list);  
//	    return "board/boardlist"; 
//	}
	
	/**
	 * 
	 * @param boardKey
	 */
	public void getRepleList(Integer boardKey) {
		
		// List<Reple> repleList = repleService.getBoardRepleList(boardKey);
		
	}

	/**
	 * 댓글 등록
	 * @param reple
	 */
	@RequestMapping(value = "/repl/save", method = RequestMethod.POST)
	public String saveRepl(Reple reple) {
		
		int result = repleService.saveReple(reple);
		
		return "board/repleSave";
	}

	
	
	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)
	   public String boardlist(HttpServletResponse res, HttpServletRequest req, Model model) {
	      
	      // getBoardKey
	      Integer boardKey = 1;
	      
	      List<Reple> repleList = repleService.getRepleList(boardKey);
	  	  List<Board> list = boardService.getAllBoardList();
		
	      model.addAttribute("boardList", list);  
	      req.setAttribute("repleList", repleList);
	      
	      return "board/boardlist";

	   }
	
	
		/* 게시판 리스트 조회 */
	/*	@GetMapping("/boardlist")
		public String requestBoardList(Model model) {
			
			
			
			
			List<Board> list = boardService.getAllBoardList();
			
			
			
			model.addAttribute("boardList", list);  
			return "board/boardlist"; 
		}
*/
	

}
