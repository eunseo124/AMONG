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
import org.springframework.web.bind.annotation.ResponseBody;

import com.among.domain.Member;
import com.among.repository.MemberRowMapper;
import com.among.Service.MemberService;

@Controller
public class MemberController {
   
   @Autowired
   private  MemberService memberService;
   private MemberRowMapper mrowmap;
   
  
   //회원가입 페이지 출력
   @RequestMapping(value = "/memjoin", method = RequestMethod.GET)
   public String memjoin() {
      
      return "member/memjoin";
   }
   
   @RequestMapping(value = "/memjoin/memjoin_proc", method = RequestMethod.POST)
   public String memjoinProc(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
            ModelMap modelMap, @ModelAttribute("mem") Member mem, Model model){
     
      memberService.getjoin(mem);
      
      return "redirect:/home";
   }
   
   //마이페이지 메인페이지 이동
   @RequestMapping(value = "/mypage", method = RequestMethod.GET)
   public String requestmypage(Model model) {
      
      return "mypage/mypage";
      
   }
   //로그인
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
         session.setAttribute("sessionc", sessionc);
         session.setAttribute("nName", mem.getnName());
         session.setAttribute("memKey", mem.getMemKey());
         session.setAttribute("memGrade", mem.getMemGrade());
          
      return "redirect:/home";
   }
   //로그아웃 
   @RequestMapping(value = "/logout/logout_proc", method = RequestMethod.POST)
   public String logoutProc(HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
   
      session.invalidate();
      
      return "redirect:/home";
      
   }
   
   //id 중복체크
   @RequestMapping(value = "/member/checkId", method = RequestMethod.POST)
   @ResponseBody
   public String checkid(@RequestParam("memId")String memId) {
      
      Member result = null;
      result = memberService.getcheckId(memId);
      System.out.println("membercontroller = "+result.getMemId());
      return result.getMemId();
   }
   //nName 중복체크
   @RequestMapping(value = "/member/checknName", method = RequestMethod.POST)
   @ResponseBody
   public String checknName(@RequestParam("nName")String nName) {
      
      Member result = null;
      result = memberService.getchecknName(nName);
      System.out.println("membercontroller = "+result.getnName());
      return result.getnName();
   }
   
   
}