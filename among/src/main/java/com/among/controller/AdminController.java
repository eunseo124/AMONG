package com.among.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.among.Service.BoardService;
import com.among.Service.MemberService;
import com.among.Service.RepleService;
import com.among.domain.Board;
import com.among.domain.Member;
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
	public String requestadmin_member(Model model) {
        List<Member> Alist = memberService.getAllMemberList();
        model.addAttribute("Alist", Alist);
        return "admin/admin_member";
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
	public String requestAfreeBoardList(Model model) {
		
		List<Board> Blist = boardService.getAllBoardList();
		
		model.addAttribute("Blist", Blist);  
		return "admin/adminfreeboard"; 
	}
	
	//게시판 조회
	/* HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.*/
	@GetMapping("/adminfoodboard")
	public String requestAfoodBoardList(Model model) {
		
		List<Board> Blist = boardService.getAllBoardList();
		
		model.addAttribute("Blist", Blist);  
		return "admin/adminfoodboard"; 
	}	
	
	//게시판 조회
	/* HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.*/
	@GetMapping("/admingameboard")
	public String requestAgameBoardList(Model model) {
		
		List<Board> Blist = boardService.getAllBoardList();
		
		model.addAttribute("Blist", Blist);  
		return "admin/admingameboard"; 
	}

	//게시판 조회
	/* HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.*/
	@GetMapping("/admintravelboard")
	public String requestAtravelBoardList(Model model) {
		
		List<Board> Blist = boardService.getAllBoardList();
		
		model.addAttribute("Blist", Blist);  
		return "admin/admintravelboard"; 
	}		
	
	@GetMapping("/admin_comment")
	   public String adminreplelist(Model model) {
	      
	    List<Reple> repleList = repleService.getAllRepleList();

	    model.addAttribute("repleList", repleList);
	      
	      return "admin/admin_comment";

	   }
	
    // replyKey 에 대한 해당 댓글을 데이터베이스 에서 삭제 합니다.
    @PostMapping("/delete2" ) 
    public String getDeleteRepleForm(Model model, @RequestParam("repleKey") int repleKey) {
        
    	repleService.setDeleteReple(repleKey);    	
        
    	return "redirect:/admin_comment";
    } 	
	
	//게시판 조회
	/* HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.*/
	@RequestMapping("/admin_board_view")
	public String admin_board_view() {
		
		return "admin/admin_board_view"; 
	}	
	
}
	
