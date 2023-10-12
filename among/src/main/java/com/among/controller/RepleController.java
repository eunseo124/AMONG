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

import com.among.Service.RepleService;
import com.among.domain.Reple;

@Controller
public class RepleController {

//	//Autowired �몴占� 占쎌젟占쎌벥占쎈릭占쎈연 BookService 占쎄깻占쎌삋占쎈뮞占쎌벥 getAllBookList() 筌롫뗄苑뚳옙諭띄몴占� 占쎌깈�빊�뮉鍮�占쎈빍占쎈뼄.
	@Autowired
	private RepleService repleService;
//
//	// HTTP 占쎌뒄筌ｏ옙 獄쎻뫗�뻼占쎌뵠 GET占쎌뵥 野껋럩�뒭, @GetMapping 占쎌뱽 占쎄텢占쎌뒠占쎈막 占쎈땾 占쎌뿳占쎈뮸占쎈빍占쎈뼄.
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
	 * 占쎈솊疫뀐옙 占쎈쾻嚥∽옙
	 * @param reple
	 */
	@RequestMapping(value = "/repl/save", method = RequestMethod.POST)
	public String saveRepl(Reple reple) {
		
		int result = repleService.saveReple(reple);
		
		return "board/repleSave";
	}
	
	
	
/*	 @RequestMapping(value = "/boardlist", method = RequestMethod.GET)
	   public String boardlist(HttpServletResponse res, HttpServletRequest req) {
	      
	      // getBoardKey
	      Integer boardKey = 1;
	      
	      List<Reple> repleList = repleService.getRepleList(boardKey);
	      
	      req.setAttribute("repleList", repleList);
	      
	      return "board/boardlist";

	   }
*/
	 
	 
	 @RequestMapping(value = "/repl/repleList", method = RequestMethod.POST)
		public String saveRepl(@RequestParam("boardKey")int boardKey,Model model) {
			
			Reple replist = null;
			replist = repleService.getReplList(boardKey);
			model.addAttribute("replist", replist); 
			 return "board/boardlist";
		}
	 
	/*
	 * 
	 * 
	 * //占쎈즲占쎄퐣占쎈쾻嚥∽옙 占쎈읂占쎌뵠筌욑옙 addBook url筌띾벏釉�
	 * 
	 * @GetMapping("/boardlist") //@ModelAttribute �몴占� 占쎌뵠占쎌뒠占쎈릭占쎈연 addBook.jsp 占쎌벥 占쎈뮞占쎈늄筌랃옙 占쎈쨲 占쎄묶域밸챷占�
	 * 占쎈염占쎈짗占쎈쭆占쎈뼄. public String requestAddRepleForm(@ModelAttribute("NewReple") Reple
	 * reple) { return "board/boardlist"; }
	 * 
	 * //占쎈즲占쎄퐣占쎈쾻嚥∽옙 占쎈읂占쎌뵠筌욑옙 addBook url 筌띾벏釉�(post 獄쎻뫗�뻼) //** submitAddNEwBook() 筌롫뗄苑뚳옙諭� 占쎈땾占쎌젟 **
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
