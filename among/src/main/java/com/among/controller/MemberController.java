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
   
  
   //ȸ������ ������ ���
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
   
   //���������� ���������� �̵�
   @RequestMapping(value = "/mypage", method = RequestMethod.GET)
   public String requestmypage(Model model) {
      
      return "mypage/mypage";
      
   }
   //�α���
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
   //�α׾ƿ� 
   @RequestMapping(value = "/logout/logout_proc", method = RequestMethod.POST)
   public String logoutProc(HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
	
	   session.invalidate();
	   
	   return "redirect:/home";
	   
   }
   
   /* ���� �޽��� 
   //ȸ������
   @RequestMapping(value = "/memjoin/memjoin_proc", method = RequestMethod.POST)
   public String msg(HttpServletRequest req) throws Exception{
	   
	   Member mem = (Member) req.getSession().getAttribute("mem");
	   System.out.println("alert msg = " + mem);
	   if(mem == null) {
		   req.setAttribute("msg","�α����� �ʿ��մϴ�.");
		   req.setAttribute("url", "/member/login");
		   return "alert";
	   }
	   req.setAttribute("msg", "���� ��û�� �Ϸ�Ǿ����ϴ�.");
	   req.setAttribute("url", "/home");
	   return "alert";
   }
   
   //�α���â
   @RequestMapping(value = "/login/login_proc", method = RequestMethod.POST)
   public String lmsg(HttpServletRequest req,HttpSession session) throws Exception{
	   
	   Member lmem = (Member) req.getSession().getAttribute("lmem");
	   int memKey = (Integer) session.getAttribute("memKey");
	   String nName = (String) session.getAttribute("nName");
	   int memGrade = (Integer) session.getAttribute("memGrade");
	   if(lmem == null) {
		   req.setAttribute("msg","���̵� ��й�ȣ�� �ٽ� Ȯ�����ּ���.");
		   req.setAttribute("url", "/member/login");
		   return "alert";
	   }
	   else if(memKey != 0 && memGrade == 1) {
		   req.setAttribute("msg", nName+"�� ȯ���մϴ�.");
		   req.setAttribute("url", "/home");
		   return "alert";
	   }
	   else if(memKey != 0 && memGrade == 2) {
		   req.setAttribute("msg", "�����ڴ� ȯ���մϴ�.");
		   req.setAttribute("url", "/home");
	   }
	   return "alert";
	   
   }*/
   /* ���� �޽��� �� */
   
}