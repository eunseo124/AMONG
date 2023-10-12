package com.among.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.among.Service.BoardService;
import com.among.Service.MemberService;
import com.among.domain.Board;
import com.among.domain.Member;

@Controller
public class AdminController {
	
	
	@Autowired
	private MemberService memberService;
	
	private BoardService boardService;
	
	
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
	
	
    //@RequestParam 은 변수명=값 형태로 데이터를 전송합니다.
    //http://localhost8080....../book?name="홍길동"
	/*
    @GetMapping("/admin_member_info") 
    public String requestMemberById(@RequestParam("id") String memId, Model model) {  
    	
        Member memberById = memberService.getMemberById(memId);
        model.addAttribute("member", memberById );
        
        return "admin/admin_member_info";
    }
    */

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
	public String requestadminfreeBoardList(Model model) { 
		

		List<Board> aFreelist = boardService.getAllBoardList();
		model.addAttribute("aFreelist", aFreelist);  
		return "admin/adminfreeboard"; 
	}
			    	
}
	
