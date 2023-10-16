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

//	//Autowired 瑜� �젙�쓽�븯�뿬 BookService �겢�옒�뒪�쓽 getAllBookList() 硫붿꽌�뱶瑜� �샇異쒗빀�땲�떎.
	@Autowired
	private RepleService repleService;

		@Autowired
	private BoardService boardService;
//
//	// HTTP �슂泥� 諛⑹떇�씠 GET�씤 寃쎌슦, @GetMapping �쓣 �궗�슜�븷 �닔 �엳�뒿�땲�떎.
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
	 * �뙎湲� �벑濡�
	 * @param reple
	 */
	@RequestMapping(value = "/repl/save", method = RequestMethod.POST)
	public String saveRepl(Reple reple) {
		
		int result = repleService.saveReple(reple);
		
		return "board/repleSave";
	}

	
	
	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)
	   public String boardlist(@RequestParam("boardKey")int boardKey,HttpServletResponse res, HttpServletRequest req, Model model) {
	      
	      // getBoardKey
	     
	      
		
		  List<Board> list = null;
	      list = repleService.setboardlist(boardKey); //게시판 상세페이지
	      System.out.println("replecontroller list.getboardTitle = "+list.get(boardKey));
	      
	      model.addAttribute("list",list);
	      /*req.setAttribute("repleList", repleList);*/
	    
	      return "board/boardlist";

	   }
	
	
	
	
		/* 寃뚯떆�뙋 由ъ뒪�듃 議고쉶 */
	/*	@GetMapping("/boardlist")
		public String requestBoardList(Model model) {
			
			
			
			
			List<Board> list = boardService.getAllBoardList();
			
			
			
			model.addAttribute("boardList", list);  
			return "board/boardlist"; 
		}
*/
	

}
