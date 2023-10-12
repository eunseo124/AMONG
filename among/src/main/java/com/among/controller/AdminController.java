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
		System.out.println("���ٿϷ�1");
    	memberService.setUpdateInfo(member);
		System.out.println("���ٿϷ�2"+member.getnName());
        return "redirect:/admin_member";
    }
    
	//�Խ��� ��ȸ
	/* HTTP ��û ����� GET�� ���, @GetMapping �� ����� �� �ֽ��ϴ�.*/
	@GetMapping("/adminfreeboard")
	public String requestBoardList(Model model) {
		
		System.out.println("�Խ��� ��ȸ ���ٿϷ�1");
		
		List<Board> Blist = adminService.getAllBoardList();
		
		System.out.println("�Խ��� ��ȸ ���ٿϷ�2");
		
		model.addAttribute("Blist", Blist);  
		return "board/adminfreeboard"; 
	}
	
    //** getDeleteBookForm() �޼���� ��û url�� /delete �϶� ó���ϴ� �޼��� �Դϴ�.
    //����ID �� ���� �ش� ������ �����ͺ��̽� ���� ���� �մϴ�.
    @RequestMapping(value = "/delete") 
    public String getDeleteMemberForm(Model model, @RequestParam("id") String memId) {
        
    	memberService.setDeleteMember(memId);
        
    	return "redirect:/admin_member";
    } 	
			    	
}
	
