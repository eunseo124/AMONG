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

import com.among.Service.AdminService;
import com.among.Service.MemberService;
import com.among.domain.Board;
import com.among.domain.Member;

@Controller
public class AdminController {
	
	
	@Autowired
	private MemberService memberService;
	
	private AdminService adminService;
	
	
	@GetMapping("/admin_member")
	public String requestadmin_member(Model model) {
        List<Member> Alist = memberService.getAllMemberList();
        model.addAttribute("Alist", Alist);
        return "admin/admin_member";
    }
	
	@RequestMapping(value = "/admin_comment", method = RequestMethod.GET)
	public String admin_comment() {

	    return "admin/admin_comment";

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
		System.out.println("접근완료1");
    	memberService.setUpdateInfo(member);
		System.out.println("접근완료2"+member.getnName());
        return "redirect:/admin_member";
    }
    
	//게시판 조회
	/* HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.*/
	@GetMapping("/adminfreeboard")
	public String requestBoardList(Model model) {
		
		System.out.println("게시판 조회 접근완료1");
		
		List<Board> Blist = adminService.getAllBoardList();
		
		System.out.println("게시판 조회 접근완료2");
		
		model.addAttribute("Blist", Blist);  
		return "board/adminfreeboard"; 
	}
	
    //** getDeleteBookForm() 메서드는 요청 url이 /delete 일때 처리하는 메서드 입니다.
    //도서ID 에 대한 해당 도서를 데이터베이스 에서 삭제 합니다.
    @RequestMapping(value = "/delete") 
    public String getDeleteMemberForm(Model model, @RequestParam("id") String memId) {
        
    	memberService.setDeleteMember(memId);
        
    	return "redirect:/admin_member";
    } 	
			    	
}
	
