package com.among.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.among.Service.AdminService;
import com.among.Service.MemberService;
import com.among.domain.Member;

public class AdminController {
/*
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MemberService memberService;
	
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
	
}