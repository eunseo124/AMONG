package com.among.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.among.domain.Member;
import com.among.Service.MemberService;

@Controller
public class MemberController {
	/*
	private final MemberService memberService = null;
	
	//회원가입 페이지 출력
	@GetMapping("/member/memjoin")
	public String memjoinForm() {
		return "memjoin";
	}
	
	@PostMapping("/member/memjoin")
	public String memjoin(@ModelAttribute Member member) {
		return "memjoin";
	}
	
	
	@GetMapping("/mypage")
	public String mypage(Model model){
		
		List<Member> list = memberService.getAllMemberList();
		model.addAttribute("mypage",list);
		return "mypage/mypage";

	}
	*/
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String requestmypage(Model model) {
		int memKey = 1;
		List<Member> list = memberService.getmemlist(memKey);
		model.addAttribute("list",list);
		return "mypage/mypage";
		
	}
	
}