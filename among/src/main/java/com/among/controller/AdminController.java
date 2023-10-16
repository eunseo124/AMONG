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
	

    //** getUpdateBookForm() �޼���� ��û url�� /update �̰� Get��� �϶� ó���ϴ� �޼��� �Դϴ�.
    @GetMapping("/admin_member_info")  
    public String getUpdateInfoForm(@ModelAttribute("updateInfo") Member member, @RequestParam("id") String memId, Model model) {
        
    	//bookService Ŭ������ getBookById() �޼��带 ȣ���Ͽ� �����Ϸ��� ���� ������ model�� ��� updateForm.jsp �� ���� �մϴ�.
    	Member memberById = memberService.getMemberById(memId);
    	model.addAttribute("member", memberById);
    	      
        return "admin/admin_member_info";

    }  
    
    //** submitUpdateBookForm() �޼���� ��û url�� /update �̰� Post��� �϶� ó���ϴ� �޼��� �Դϴ�.
    @PostMapping("/update") 
    public String submitUpdateInfoForm(@ModelAttribute("updateInfo") Member member) {

    	memberService.setUpdateInfo(member);

        return "redirect:/admin_member";
    }
    
    //member ID �� ���� �ش� ȸ�������� �����ͺ��̽� ���� ���� �մϴ�.
    @RequestMapping(value = "/delete") 
    public String getDeleteMemberForm(Model model, @RequestParam("id") String memId) {
        
    	memberService.setDeleteMember(memId);
        
    	return "redirect:/admin_member";
    }
          
    
	//�Խ��� ��ȸ
	/* HTTP ��û ����� GET�� ���, @GetMapping �� ����� �� �ֽ��ϴ�.*/
	@GetMapping("/adminfreeboard")
	public String requestAfreeBoardList(Model model) {
		
		List<Board> Blist = boardService.getAllBoardList();
		
		model.addAttribute("Blist", Blist);  
		return "admin/adminfreeboard"; 
	}
	
	//�Խ��� ��ȸ
	/* HTTP ��û ����� GET�� ���, @GetMapping �� ����� �� �ֽ��ϴ�.*/
	@GetMapping("/adminfoodboard")
	public String requestAfoodBoardList(Model model) {
		
		List<Board> Blist = boardService.getAllBoardList();
		
		model.addAttribute("Blist", Blist);  
		return "admin/adminfoodboard"; 
	}	
	
	//�Խ��� ��ȸ
	/* HTTP ��û ����� GET�� ���, @GetMapping �� ����� �� �ֽ��ϴ�.*/
	@GetMapping("/admingameboard")
	public String requestAgameBoardList(Model model) {
		
		List<Board> Blist = boardService.getAllBoardList();
		
		model.addAttribute("Blist", Blist);  
		return "admin/admingameboard"; 
	}

	//�Խ��� ��ȸ
	/* HTTP ��û ����� GET�� ���, @GetMapping �� ����� �� �ֽ��ϴ�.*/
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
	
    // replyKey �� ���� �ش� ����� �����ͺ��̽� ���� ���� �մϴ�.
    @PostMapping("/delete2" ) 
    public String getDeleteRepleForm(Model model, @RequestParam("repleKey") int repleKey) {
        
    	repleService.setDeleteReple(repleKey);    	
        
    	return "redirect:/admin_comment";
    } 	
	
	//�Խ��� ��ȸ
	/* HTTP ��û ����� GET�� ���, @GetMapping �� ����� �� �ֽ��ϴ�.*/
	@RequestMapping("/admin_board_view")
	public String admin_board_view() {
		
		return "admin/admin_board_view"; 
	}	
	
}
	
