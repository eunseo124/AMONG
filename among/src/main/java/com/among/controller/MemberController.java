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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.among.domain.Member;
import com.among.Service.MemberService;

@Controller
@RequestMapping("/mypage")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/mypage")//member list
	public String requestlistOfMember(@RequestParam("memKey") int memKey, Model model) {
		
		List<Member> list = memberService.getAllMemberList();
		model.addAttribute("memberlist",list);
		return "mypage/mypage";
		
	}
	
	@GetMapping("/mypage") //member list update method 불러오기
	public String getupmemForm(@ModelAttribute("upmem")Member member,
			@RequestParam("memKey") int memKey, Model model) {
		List<Member> list = memberService.getAllMemberList();
		model.addAttribute("upmem", list);
		return "mypage/mypage";
	}
	
	@PostMapping("/mypage")//member list update method 불러오기
	public String submitupmemForm(@ModelAttribute("upmem")Member member) {
		memberService.setupmem(member);
		return "redirect:/mypage";
	}
	
	
}
