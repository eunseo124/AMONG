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
   public String loingProc(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
         ModelMap modelMap, @ModelAttribute("memlogin") Member memlogin) throws Exception {
      
         if(memlogin.getMemId() == null) throw new Exception("아이디를 입력해주세요");
         if(memlogin.getMemPw() == null) throw new Exception("비밀번호를 입력해주세요");
      
         Member getlogin = (Member) memberService.getlogin(memlogin.getMemId(), memlogin.getMemPw());
         SessionConfig sessionc = new SessionConfig();
         sessionc.setMemId(memlogin.getMemId());
         sessionc.setMemPw(memlogin.getMemPw());
         sessionc.setMemKey(memlogin.getMemKey());
         sessionc.setMemGrade(memlogin.getMemGrade());
         sessionc.setnName(memlogin.getnName());
         if(!getlogin.getMemId().equals(memlogin.getMemId()) || !getlogin.getMemPw().equals(memlogin.getMemPw())) {
            throw new Exception("아이디 및 비밀벊로를 확인해주세요.");
         }else {
            session.setAttribute("sessionc", sessionc);
            session.setAttribute("nName", sessionc.getnName());
         }
         
      return "redirect:/";
   }
   
}