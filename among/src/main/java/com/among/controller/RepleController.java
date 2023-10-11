package com.among.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

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

import com.among.Service.RepleService;
import com.among.domain.Reple;

@Controller
public class RepleController {

//	//Autowired 瑜� �젙�쓽�븯�뿬 BookService �겢�옒�뒪�쓽 getAllBookList() 硫붿꽌�뱶瑜� �샇異쒗빀�땲�떎.
	@Autowired
	private RepleService repleService;
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

	/*
	 * 
	 * 
	 * //�룄�꽌�벑濡� �럹�씠吏� addBook url留듯븨
	 * 
	 * @GetMapping("/boardlist") //@ModelAttribute 瑜� �씠�슜�븯�뿬 addBook.jsp �쓽 �뒪�봽留� �뤌 �깭洹몄�
	 * �뿰�룞�맂�떎. public String requestAddRepleForm(@ModelAttribute("NewReple") Reple
	 * reple) { return "board/boardlist"; }
	 * 
	 * //�룄�꽌�벑濡� �럹�씠吏� addBook url 留듯븨(post 諛⑹떇) //** submitAddNEwBook() 硫붿꽌�뱶 �닔�젙 **
	 * 
	 * @PostMapping("/boardlist") public String
	 * submitAddNewReple( @ModelAttribute("NewReple") Reple reple,BindingResult
	 * result) {
	 * 
	 * if(result.hasErrors()) { return "boardlist"; }
	 * 
	 * }
	 * 
	 */

}
