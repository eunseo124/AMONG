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

import com.among.domain.Board;
import com.among.domain.Member;
import com.among.domain.Reple;
import com.among.repository.MemberRowMapper;
import com.among.Service.BoardService;
import com.among.Service.MemberService;

@Controller
public class MemberController {
   
   @Autowired
   private  MemberService memberService;
   private MemberRowMapper mrowmap;
   private BoardService boardService;
   
  
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
   //회원가입 실패시
   @GetMapping("/member/memjoin_false")
   public String memjoin_false() {
	   return "member/memjoin";
   }
   
   //로그인 시 memKey로 회원정보 출력 method
   @RequestMapping(value = "/mypage", method = RequestMethod.GET)
   public String requestmypage(@RequestParam("memKey") int memKey, Model model) {
      
	  Member memlist = new Member();
      memlist = memberService.getmemlist(memKey);
      model.addAttribute("memlist", memlist);
      
      return "mypage/mypage";
      
   }
   //로그인
   @RequestMapping(value = "/login/login_proc",method = RequestMethod.POST) 
   public String logingProc(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
         ModelMap modelMap, @ModelAttribute("mem") Member member, Model model){
          
      
          Member mem = memberService.getlogin(member.getMemId(), member.getMemPw());
          
          model.addAttribute("memberList", mem);
          
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
      return result.getnName();
   }
   
   //id 찾기
   @RequestMapping(value = "/member/idfind", method = RequestMethod.POST)
   public String getfindId(HttpSession session,HttpServletRequest req,HttpServletResponse resp,String memName, String memEmail1, String memEmail2,Model model) {
   	
   	Member memf = null;
   	memf = memberService.getfindId(memName,memEmail1,memEmail2);
   	Member member = new Member();
   	member.setMemId(memf.getMemId());
   	member.setMemName(memf.getMemName());
   	session = req.getSession();
   	session.setAttribute("member", member);
   	
   	return "redirect:/idok";
   }
   //id 찾기 결과 페이지
   @GetMapping("/idok")
   public String getidok() {
	   return "member/idok";
   }
   //Pw 찾기
   @RequestMapping(value = "/member/pwfind", method = RequestMethod.POST)
   public String getfindPw(HttpSession session,HttpServletRequest req,HttpServletResponse resp,String memId,String memName, String memEmail1, String memEmail2, Model model) {
   	
   	Member memp = null;
   	memp = memberService.getfindPw(memId,memName,memEmail1,memEmail2);
   	Member memberp = new Member();
   	
   	memberp.setMemId(memp.getMemId());
   	memberp.setMemName(memp.getMemName());
   	memberp.setMemEmail1(memp.getMemEmail1());
   	memberp.setMemEmail2(memp.getMemEmail2());
   	memberp.setMemName(memp.getMemName());
   	memberp.setMemResident1(memp.getMemResident1());
   	memberp.setMemResident2(memp.getMemResident2());
   	memberp.setMemGrade(memp.getMemGrade());
   	memberp.setnName(memp.getnName());
   	memberp.setMemKey(memp.getMemKey());
   	session = req.getSession();
   	session.setAttribute("memberp", memberp);
   	System.out.println("memberp session 값 memKey = "+memberp.getMemKey());

   	return "redirect:/pwok";
   }
   //pw 찾기 결과 페이지
   @GetMapping("/pwok")
   public String getpwok() {
	   System.out.println("접근완료");
	   
	   return "member/pwok";
   }
   
   //pw 찾기 결과 후 비번 업데이트
   @PostMapping("/member/memupdate_proc")
   public String PwupdateProc(@ModelAttribute("memberset") Member memberset){
	  
      memberService.setupmem(memberset);
      System.out.println("memberupdate memPw = "+ memberset.getMemPw());
      return "redirect:/login";
   }
   
   //member update method
   @PostMapping("/mypage/memupdate_proc")
   public String updateProc(@ModelAttribute("mem") Member mem){
	  
      memberService.setupmem(mem);
      return "redirect:/mypage?memKey="+mem.getMemKey();
   }
   //정보 업데이트 페이지 member정보 출력
   @RequestMapping(value = "/myupdate", method = RequestMethod.GET)
   public String myudate(@RequestParam("memKey")int memKey,Model model) {
	   
	   Member memu = new Member();
	   memu = memberService.getmemlist(memKey);
	   model.addAttribute("memu", memu);
      return "mypage/myupdate";

   }
   
   //게시글 출력1
   @RequestMapping(value = "/mypost", method = RequestMethod.GET)
   public String mypost(@RequestParam("memKey")int memKey, Model model) {

	  List<Board> boardl = null;
	  boardl = memberService.setboardlist(memKey);
	  model.addAttribute("boardl",boardl);
      return "mypage/mypost";

   }
   
   //게시글 출력2//인기게시판
   @RequestMapping(value = "/mypost2", method = RequestMethod.GET)
   public String mypost2(@RequestParam("memKey")int memKey, Model model) {

	  List<Board> hboard = null;
	  hboard = memberService.gethotboardlist(memKey);
	  model.addAttribute("hboard",hboard);
      return "mypage/mypost2";

   }

   //게시글 출력3
   @RequestMapping(value = "/mypost3", method = RequestMethod.GET)
   public String mypost3(@RequestParam("memKey")int memKey, Model model) {

	  List<Board> boardl = null;
	  boardl = memberService.setboardlist(memKey);
	  model.addAttribute("boardl",boardl);
      return "mypage/mypost3";

   }

   //게시글 출력4
   @RequestMapping(value = "/mypost4", method = RequestMethod.GET)
   public String mypost4(@RequestParam("memKey")int memKey, Model model) {

	  List<Board> boardl = null;
	  boardl = memberService.setboardlist(memKey);
	  model.addAttribute("boardl",boardl);
      return "mypage/mypost4";

   }

   //게시글 출력5
   @RequestMapping(value = "/mypost5", method = RequestMethod.GET)
   public String mypost5(@RequestParam("memKey")int memKey, Model model) {

	  List<Board> boardl = null;
	  boardl = memberService.setboardlist(memKey);
	  model.addAttribute("boardl",boardl);
      return "mypage/mypost5";

   }
   
   //댓글 출력1
   @RequestMapping(value = "/myreply", method = RequestMethod.GET) 
   public String myboardlist(@RequestParam("memKey")int memKey,Model model) {
	   
	   List<Reple> rep = null;
	   rep = memberService.setreplelist(memKey);
	   model.addAttribute("replelist",rep);
	   
	   return "mypage/myreply";
   }
   //댓글 출력2
   @RequestMapping(value = "/myreply2", method = RequestMethod.GET) 
   public String myboardlist2(@RequestParam("memKey")int memKey,Model model) {
	   
	   List<Reple> rep = null;
	   rep = memberService.setreplelist(memKey);
	   model.addAttribute("replelist",rep);
	   
	   return "mypage/myreply2";
   }
   //댓글 출력3
   @RequestMapping(value = "/myreply3", method = RequestMethod.GET) 
   public String myboardlist3(@RequestParam("memKey")int memKey,Model model) {
	   
	   List<Reple> rep = null;
	   rep = memberService.setreplelist(memKey);
	   model.addAttribute("replelist",rep);
	   
	   return "mypage/myreply3";
   }
   //댓글 출력4
   @RequestMapping(value = "/myreply4", method = RequestMethod.GET) 
   public String myboardlist4(@RequestParam("memKey")int memKey,Model model) {
	   
	   List<Reple> rep = null;
	   rep = memberService.setreplelist(memKey);
	   model.addAttribute("replelist",rep);
	   
	   return "mypage/myreply4";
   }
   //댓글 출력5
   @RequestMapping(value = "/myreply5", method = RequestMethod.GET) 
   public String myboardlist5(@RequestParam("memKey")int memKey,Model model) {
	   
	   List<Reple> rep = null;
	   rep = memberService.setreplelist(memKey);
	   model.addAttribute("replelist",rep);
	   
	   return "mypage/myreply5";
   }
   //댓글삭제
   @PostMapping("/repledelete")
   public String replede(@ModelAttribute("memKey")int repleKey,int memKey) {
	   memberService.setdeleteReple(repleKey);
	   return "redirect:/mypage?memKey = "+ memKey;
	   
   }
   //게시글 삭제
   @PostMapping("/delboard")
   public String dleboad(@ModelAttribute("memKey")int memKey,Board delboard) {
	   
	   memberService.setdelboard(delboard);
	   System.out.println(memKey);
	   return "redirect:/mypage?memKey = "+ memKey;
   }
}