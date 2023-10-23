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
import org.springframework.web.servlet.ModelAndView;

import com.among.Service.BoardService;
import com.among.domain.Board;
import com.among.domain.Criteria;
import com.among.domain.PageMaker;

@Controller

public class BoardController {

	@Autowired
	private BoardService boardService;  
	/*
	@GetMapping("/board/boardmodify")
	public String modi1(Model model) { 
		
		return "board/boardmodify"; 
	}*/
	
	//freeboard
		@RequestMapping(value = "/freeboard")
		public ModelAndView openBoardList(Criteria cri) throws Exception { 
			
			ModelAndView mav = new ModelAndView("/board/freeboard");		
			int boardCount = boardService.countBoardList();
			PageMaker pageMaker = new PageMaker();
	    		pageMaker.setCri(cri);
	    		pageMaker.setTotalCount(boardCount);
			List<Board> list = boardService.getAllBoardList(cri.getPageStart(),cri.getPerPageNum());
			mav.addObject("boardList", list);  
			mav.addObject("pageMaker", pageMaker);
			return mav; 
		}
	///gameboard
		@RequestMapping(value = "/gameboard")
		public ModelAndView opengameBoardList(Criteria cri) throws Exception{
			
			ModelAndView mav = new ModelAndView("/board/gameboard");		
			int boardCount = boardService.countBoardList();
			PageMaker pageMaker = new PageMaker();
	    		pageMaker.setCri(cri);
	    		pageMaker.setTotalCount(boardCount);

			List<Board> list = boardService.getAllBoardList(cri.getPageStart(),cri.getPerPageNum());
			mav.addObject("boardList", list);  
			mav.addObject("pageMaker", pageMaker);
			return mav; 
		}

		//travleboard
		@RequestMapping(value = "/travleboard")
		public ModelAndView opentravleBoardList(Criteria cri) throws Exception{
			
			ModelAndView mav = new ModelAndView("/board/travleboard");		
			int boardCount = boardService.countBoardList();
			PageMaker pageMaker = new PageMaker();
	    		pageMaker.setCri(cri);
	    		pageMaker.setTotalCount(boardCount);

			List<Board> list = boardService.getAllBoardList(cri.getPageStart(),cri.getPerPageNum());
			mav.addObject("boardList", list);  
			mav.addObject("pageMaker", pageMaker); 
			return mav; 
		}

		//foodboard
		@RequestMapping(value = "/foodboard")
		public ModelAndView openfoodBoardList(Criteria cri) throws Exception{
			
			ModelAndView mav = new ModelAndView("/board/foodboard");		
			int boardCount = boardService.countBoardList();
			PageMaker pageMaker = new PageMaker();
	    		pageMaker.setCri(cri);
	    		pageMaker.setTotalCount(boardCount);

			List<Board> list = boardService.getAllBoardList(cri.getPageStart(),cri.getPerPageNum());
			mav.addObject("boardList", list);  
			mav.addObject("pageMaker", pageMaker);
			return mav; 
		}
		
	//인기게시판
	@GetMapping("/hotboard")
	public ModelAndView hotBoardList(Criteria cri) throws Exception { 
		
		ModelAndView mav = new ModelAndView("/board/hotboard");
		int boardCount = boardService.countBoardList();
		PageMaker pageMaker = new PageMaker();
    		pageMaker.setCri(cri);
    		pageMaker.setTotalCount(boardCount);
		List<Board> list = boardService.getHotBoardList(cri.getPageStart(),cri.getPerPageNum());
		mav.addObject("boardList", list);
		mav.addObject("pageMaker", pageMaker);
		return mav; 
	}
	@GetMapping("/home")
	   public String homeBoardList(Model model) { 
		List<Board> list1 = boardService.getFreeBoardList();
	      List<Board> list2 = boardService.getGameBoardList();
	      List<Board> list3 = boardService.getfoodBoardList();
	      List<Board> list4 = boardService.getTravleBoardList();
	      List<Board> list5 = boardService.getHomeHotBoardList();
	      model.addAttribute("FreeboardList", list1);
	      model.addAttribute("GameboardList", list2);
	      model.addAttribute("FoodboardList", list3);
	      model.addAttribute("TravleboardList", list4);
	      model.addAttribute("boardList2", list5);  
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