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


import com.among.Service.MemberService;
import com.among.domain.Member;

@Controller
public class AdminController {
	
	
	@Autowired
	private MemberService memberService;
	
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
    @GetMapping("/admin_member_info") 
    public String requestMemberById(@RequestParam("id") String memId, Model model) {  
    	
        Member memberById = memberService.getMemberById(memId);
        model.addAttribute("member", memberById );
        
        return "admin/admin_member_info";
    }
	
  	
}
	
