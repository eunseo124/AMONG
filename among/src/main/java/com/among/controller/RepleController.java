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

//	
	@Autowired
	private RepleService repleService;

		@Autowired
	private BoardService boardService;

	public void getRepleList(Integer boardKey) {
		
		
	}

	/**
	
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
	
	
	
	
	
	

}
