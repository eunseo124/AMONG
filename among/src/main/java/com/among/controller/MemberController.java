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

import com.among.domain.Member;
import com.among.repository.MemberRowMapper;
import com.among.session.SessionConfig;
import com.among.Service.MemberService;

@Controller
public class MemberController {
   
   @Autowired
   private  MemberService memberService;
   private MemberRowMapper mrowmap;
   
   /*//회원가입 페이지 출력
   @GetMapping("/memjoin")
   public String memjoinForm() {
      return "member/memjoin";
   }
   
   @PostMapping("/memjoin")
   public String memjoin(@ModelAttribute MemberRowMapper member ) {
      memberService.memjoin(member);
      return "member/memjoin";
   }*/
   
   
   @RequestMapping(value = "/mypage", method = RequestMethod.GET)
   public String requestmypage(Model model, int memKey) {
      List<Member> mlist = memberService.getmemlist(memKey);
      model.addAttribute("mlist",mlist);
      return "mypage/mypage";
      
   }
   
   @RequestMapping(value = "/login/login_proc",method = RequestMethod.POST) 
   public String logingProc(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
         ModelMap modelMap, @ModelAttribute("mem") Member member, Model model){
	   	 
	   
	   	 Member mem = memberService.getlogin(member.getMemId(), member.getMemPw());
	   	 
	   	 /*model.addAttribute("memberList", mem);*/
	   	 
	   	 Member sessionc  = new Member();
	   	 
	   	 sessionc.setMemKey(mem.getMemKey());
	   	 sessionc.setMemId(mem.getMemId());
         sessionc.setMemPw(mem.getMemPw());
         sessionc.setMemEmail1(mem.getMemEmail1());
         sessionc.setMemEmail2(mem.getMemEmail2());
         sessionc.setMemName(mem.getMemName());
         sessionc.setMemResident1(mem.getMemResident1());
         sessionc.setMemResident2(mem.getMemResident2());
         sessionc.setMemJoinDate(mem.getMemJoinDate());
         sessionc.setDelYn(mem.getDelYn());
         sessionc.setMemGrade(mem.getMemGrade());
         sessionc.setnName(mem.getnName());
         
       	System.out.println("MemberController memKey = " + sessionc.getMemKey());
       	System.out.println("MemberController memId = " + sessionc.getMemId());
       	System.out.println("MemberController memPw = " + sessionc.getMemPw());
       	System.out.println("MemberController memEmail1 = " + sessionc.getMemEmail1());
       	System.out.println("MemberController memEmail2 = " + sessionc.getMemEmail2());
       	System.out.println("MemberController memName = " + sessionc.getMemName());
       	System.out.println("MemberController memResident1 = " + sessionc.getMemResident1());
       	System.out.println("MemberController memResident2 = " + sessionc.getMemResident2());
       	System.out.println("MemberController memJoinDate = " + sessionc.getMemJoinDate());
       	System.out.println("MemberController delYn = " + sessionc.getDelYn());
       	System.out.println("MemberController memGrade = " + sessionc.getMemGrade());
       	System.out.println("MemberController nName = " + sessionc.getnName());
       	 
         session.setAttribute("sessionc", sessionc);
	   	 
      return "redirect:/home";
   }
   
}