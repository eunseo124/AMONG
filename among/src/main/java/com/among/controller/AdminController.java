package com.among.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.among.Service.AdminService;
import com.among.Service.MemberService;
import com.among.domain.Member;

public class AdminController {
	

	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MemberService memberService;
	
	/*
	@GetMapping("/admin_member")//member list
	public String requestlistOfMember(@RequestParam("memKey") int memKey, Model model) {
		
		List<Member> list = adminService.getAllMemberList();
		model.addAttribute("memberlist",list);
		return "admin/admin_member";	
	
	}
	
	
	@RequestMapping(value = "/admin_member", method = RequestMethod.GET)
	public String requestmypage(Model model) {
		
		List<Member> list = memberService.getAllme;
		model.addAttribute("list",list);
		return "mypage/mypage";
		
	}
	*/
	
	 @RequestMapping(value = "/admin/admin_form",method = RequestMethod.POST) 
	   public String adimin_form(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
	      Member mem, Model model){
		 
	        List<Member> Alist = memberService.getAllMemberList();
	        model.addAttribute("Alist", Alist);
	        return "admin/admin_member";
	 }
}
	
