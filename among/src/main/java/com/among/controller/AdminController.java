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
import com.among.Service.MemberService;
import com.among.Service.RepleService;
import com.among.domain.Board;
import com.among.domain.Criteria;
import com.among.domain.Member;
import com.among.domain.PageMaker;
import com.among.domain.Reple;

@Controller
public class AdminController {
	
	
	@Autowired
	private MemberService memberService;
	
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private RepleService repleService;
	
	
	
	@GetMapping("/admin_member")
	public ModelAndView requestadmin_member(Criteria cri) {
		ModelAndView mav = new ModelAndView("/admin/admin_member");
		List<Member> Alist = memberService.getAllMemberList(cri.getPageStart(),cri.getPerPageNum());
        int memberCount = memberService.membercount();
		PageMaker pageMaker = new PageMaker();
    		pageMaker.setCri(cri);
    		pageMaker.setTotalCount(memberCount);
    		mav.addObject("Alist", Alist);  
    		mav.addObject("pageMaker", pageMaker); 
        
        return mav;
    }
	

    //** getUpdateBookForm() 메서드는 요청 url이 /update 이고 Get방식 일때 처리하는 메서드 입니다.
    @GetMapping("/admin_member_info")  
    public String getUpdateInfoForm(@ModelAttribute("updateInfo") Member member, @RequestParam("id") String memId, Model model) {
        
    	//bookService 클래스의 getBookById() 메서드를 호출하여 수정하려는 도서 정보를 model에 담아 updateForm.jsp 로 전달 합니다.
    	Member memberById = memberService.getMemberById(memId);
    	model.addAttribute("member", memberById);
    	      
        return "admin/admin_member_info";

    }  
    
    //** submitUpdateBookForm() 메서드는 요청 url이 /update 이고 Post방식 일때 처리하는 메서드 입니다.
    @PostMapping("/update") 
    public String submitUpdateInfoForm(@ModelAttribute("updateInfo") Member member) {

    	memberService.setUpdateInfo(member);

        return "redirect:/admin_member";
    }
    
    //member ID 에 대한 해당 회원정보를 데이터베이스 에서 삭제 합니다.
    @RequestMapping(value = "/delete") 
    public String getDeleteMemberForm(Model model, @RequestParam("id") String memId) {
        
    	memberService.setDeleteMember(memId);
        
    	return "redirect:/admin_member";
    }
          
    
	//게시판 조회
	/* HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.*/
	@GetMapping("/adminfreeboard")
	public ModelAndView requestAfreeBoardList(Criteria cri) throws Exception{
		ModelAndView mav = new ModelAndView("/admin/adminfreeboard");
		int boardCount = boardService.countBoardList();
		PageMaker pageMaker = new PageMaker();
    		pageMaker.setCri(cri);
    		pageMaker.setTotalCount(boardCount);
		List<Board> Blist = boardService.getAllBoardList(cri.getPageStart(),cri.getPerPageNum());
		mav.addObject("Blist", Blist);  
		mav.addObject("pageMaker", pageMaker);  
		return mav; 
	}
	
	//게시판 조회
	/* HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.*/
	@GetMapping("/adminfoodboard")
	public ModelAndView requestAfoodBoardList(Criteria cri) {
		ModelAndView mav = new ModelAndView("/admin/adminfoodboard");
		int boardCount = boardService.countBoardList();
		PageMaker pageMaker = new PageMaker();
    		pageMaker.setCri(cri);
    		pageMaker.setTotalCount(boardCount);
		List<Board> Blist = boardService.getAllBoardList(cri.getPageStart(),cri.getPerPageNum());
		mav.addObject("Blist", Blist);  
		mav.addObject("pageMaker", pageMaker);  
		return mav; 
	}	
	
	//게시판 조회
	/* HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.*/
	@GetMapping("/admingameboard")
	public ModelAndView requestAgameBoardList(Criteria cri) {
		ModelAndView mav = new ModelAndView("/admin/admingameboard");
		int boardCount = boardService.countBoardList();
		PageMaker pageMaker = new PageMaker();
    		pageMaker.setCri(cri);
    		pageMaker.setTotalCount(boardCount);
		List<Board> Blist = boardService.getAllBoardList(cri.getPageStart(),cri.getPerPageNum());
		mav.addObject("Blist", Blist);  
		mav.addObject("pageMaker", pageMaker);  
		return mav; 
	}

	//게시판 조회
	/* HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.*/
	@GetMapping("/admintravelboard")
	public ModelAndView requestAtravelBoardList(Criteria cri) {
		ModelAndView mav = new ModelAndView("/admin/admintravelboard");
		int boardCount = boardService.countBoardList();
		PageMaker pageMaker = new PageMaker();
    		pageMaker.setCri(cri);
    		pageMaker.setTotalCount(boardCount);
		List<Board> Blist = boardService.getAllBoardList(cri.getPageStart(),cri.getPerPageNum());
		mav.addObject("Blist", Blist);  
		mav.addObject("pageMaker", pageMaker);  
		return mav; 
	}		
	
	@GetMapping("/admin_comment")
	   public ModelAndView adminreplelist(Criteria cri) {
		ModelAndView mav = new ModelAndView("/admin/admin_comment");
	    
		List<Reple> repleList = repleService.getAllRepleList(cri.getPageStart(),cri.getPerPageNum());
		int repleCount = repleService.countReplelist();
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(repleCount);
		mav.addObject("repleList", repleList);
		mav.addObject("pageMaker", pageMaker);  
	      
	      return mav;

	   }
	
    // replyKey 에 대한 해당 댓글을 데이터베이스 에서 삭제 합니다.
    @PostMapping("/delete2" ) 
    public String getDeleteRepleForm(Model model, @RequestParam("repleKey") int repleKey) {
        
    	repleService.setDeleteReple(repleKey);    	
        
    	return "redirect:/admin_comment";
    } 	
	
	
    //** getUpdateBookForm() 메서드는 요청 url이 /update 이고 Get방식 일때 처리하는 메서드 입니다.
    @GetMapping("/admin_board_view")  
    public String getboardInfoForm(@ModelAttribute("boardUpdateInfo") Board board, @RequestParam("key") int boardKey, Model model) {
        
    	//bookService 클래스의 getBookById() 메서드를 호출하여 수정하려는 도서 정보를 model에 담아 updateForm.jsp 로 전달 합니다.
    	Board boardByBoardKey = boardService.getBoardByBoardKey(boardKey);
    	model.addAttribute("board", boardByBoardKey);
    	      
        return "admin/admin_board_view";

    }
    
    //** submitUpdateBookForm() 메서드는 요청 url이 /update 이고 Post방식 일때 처리하는 메서드 입니다.
    @PostMapping("/update_board") 
    public String submitBoardUpdateInfoForm(@ModelAttribute("boardUpdateInfo") Board board) {

    	boardService.setBoardUpdateInfo(board);
    	
    	System.out.println("접근완료" + board.getBoardKey());
    	System.out.println("접근완료" + board.getDelYn());
    	System.out.println("접근완료");

        return "redirect:/admin_member";
    }    
    
	
}
	
