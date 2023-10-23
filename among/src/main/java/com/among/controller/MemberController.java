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
import org.springframework.web.servlet.ModelAndView;

import com.among.domain.Board;
import com.among.domain.Criteria;
import com.among.domain.Member;
import com.among.domain.PageMaker;
import com.among.domain.Reple;
import com.among.repository.MemberRowMapper;
import com.among.Service.BoardService;
import com.among.Service.MemberService;
import com.among.Service.RepleService;

@Controller
public class MemberController {
   
   @Autowired
   private MemberService memberService;
   private MemberRowMapper mrowmap;
   private BoardService boardService;
   private RepleService repleService;
   

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
 
   @GetMapping("/member/memjoin_false")
   public String memjoin_false() {
	   return "member/memjoin";
   }

   @RequestMapping(value = "/mypage", method = RequestMethod.GET)
   public String requestmypage(@RequestParam("memKey") int memKey, Model model) {
      
	  Member memlist = new Member();
      memlist = memberService.getmemlist(memKey);
      model.addAttribute("memlist", memlist);
      
      return "mypage/mypage";
      
   }

   @RequestMapping(value = "/login/login_proc",method = RequestMethod.POST) 
   public String logingProc(HttpSession session, HttpServletRequest req, HttpServletResponse resp,
         ModelMap modelMap, @ModelAttribute("mem") Member member, Model model){
          
      System.out.println("memberservice get long ="+ member.getMemId()+member.getMemPw() );
      	Member mem = new Member();
      	mem = memberService.getlogin(member.getMemId(), member.getMemPw());

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
          Board countbo = memberService.boardcount(mem.getMemKey());
          Reple countre = memberService.replecount(mem.getMemKey());
          Board sessionb = new Board();
          sessionb.setBoardKey(countbo.getBoardKey());
          sessionb.setRepleKey(countre.getRepleKey());
          session.setAttribute("sessionb", sessionb);
          
          
      return "redirect:/home";
   }
   

   @RequestMapping(value = "/logout/logout_proc", method = RequestMethod.POST)
   public String logoutProc(HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
   
      session.invalidate();
      
      return "redirect:/home";
      
   }
   

   @RequestMapping(value = "/member/checkId", method = RequestMethod.POST)
   @ResponseBody
   public String checkid(@RequestParam("memId")String memId) {
      
      Member result = null;
      result = memberService.getcheckId(memId);
      System.out.println("membercontroller = "+result.getMemId());
      return result.getMemId();
   }
   

   @RequestMapping(value = "/member/checknName", method = RequestMethod.POST)
   @ResponseBody
   public String checknName(@RequestParam("nName")String nName) {
      
      Member result = null;
      result = memberService.getchecknName(nName);
      return result.getnName();
   }
   

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

   @GetMapping("/idok")
   public String getidok() {
	   return "member/idok";
   }

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

   	return "redirect:/pwok";
   }

   @GetMapping("/pwok")
   public String getpwok() {
	  
	   
	   return "member/pwok";
   }
   

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

   @RequestMapping(value = "/myupdate", method = RequestMethod.GET)
   public String myudate(@RequestParam("memKey")int memKey,Model model) {
	   
	   Member memu = new Member();
	   memu = memberService.getmemlist(memKey);
	   model.addAttribute("memu", memu);
      return "mypage/myupdate";

   }
   
   //자유 게시판
   @RequestMapping(value = "/mypost", method = RequestMethod.GET)
   public ModelAndView mypost(@RequestParam("memKey")int memKey,Criteria cri) {
	   ModelAndView mav = new ModelAndView("/mypage/mypost");
	  List<Board> boardl = null;
	  boardl = memberService.setboardlist(memKey,cri.getPageStart(),cri.getPerPageNum());
	  int boardCount = memberService.Boardcount(memKey);
		PageMaker pageMaker = new PageMaker();
  		pageMaker.setCri(cri);
  		pageMaker.setTotalCount(boardCount);
  		mav.addObject("boardl", boardl);  
  		mav.addObject("pageMaker", pageMaker); 
	  
      return mav;

   }
   
   //인기 게시판
   @RequestMapping(value = "/mypost2", method = RequestMethod.GET)
   public ModelAndView mypost2(@RequestParam("memKey")int memKey, Criteria cri) {
	   ModelAndView mav = new ModelAndView("/mypage/mypost2");
		  List<Board> hboard = null;
		  hboard = memberService.gethotboardlist(memKey,cri.getPageStart(),cri.getPerPageNum());
		  int boardCount = memberService.hotBoardcount(memKey);
			PageMaker pageMaker = new PageMaker();
	  		pageMaker.setCri(cri);
	  		pageMaker.setTotalCount(boardCount);
	  		mav.addObject("hboard", hboard);  
	  		mav.addObject("pageMaker", pageMaker); 
	  
      return mav;

   }

   //게임 게시판
   @RequestMapping(value = "/mypost3", method = RequestMethod.GET)
   public ModelAndView mypost3(@RequestParam("memKey")int memKey,Criteria cri) {
	   ModelAndView mav = new ModelAndView("/mypage/mypost3");
	  List<Board> boardl = null;
	  boardl = memberService.setboardlist2(memKey,cri.getPageStart(),cri.getPerPageNum());
	  int boardCount = memberService.Boardcount2(memKey);
		PageMaker pageMaker = new PageMaker();
  		pageMaker.setCri(cri);
  		pageMaker.setTotalCount(boardCount);
  		mav.addObject("boardl", boardl);  
  		mav.addObject("pageMaker", pageMaker); 
	  
      return mav;
   }
   
   //맛집 게시판
   @RequestMapping(value = "/mypost4", method = RequestMethod.GET)
   public ModelAndView mypost4(@RequestParam("memKey")int memKey,Criteria cri) {
	   ModelAndView mav = new ModelAndView("/mypage/mypost4");
	  List<Board> boardl = null;
	  boardl = memberService.setboardlist3(memKey,cri.getPageStart(),cri.getPerPageNum());
	  int boardCount = memberService.Boardcount3(memKey);
		PageMaker pageMaker = new PageMaker();
  		pageMaker.setCri(cri);
  		pageMaker.setTotalCount(boardCount);
  		mav.addObject("boardl", boardl);  
  		mav.addObject("pageMaker", pageMaker); 
	  
      return mav;

   }
   
   //여행 게시판
   @RequestMapping(value = "/mypost5", method = RequestMethod.GET)
   public ModelAndView mypost5(@RequestParam("memKey")int memKey,Criteria cri) {
	   ModelAndView mav = new ModelAndView("/mypage/mypost5");
	  List<Board> boardl = null;
	  boardl = memberService.setboardlist4(memKey,cri.getPageStart(),cri.getPerPageNum());
	  int boardCount = memberService.Boardcount4(memKey);
		PageMaker pageMaker = new PageMaker();
  		pageMaker.setCri(cri);
  		pageMaker.setTotalCount(boardCount);
  		mav.addObject("boardl", boardl);  
  		mav.addObject("pageMaker", pageMaker); 
	  
      return mav;
   }
   
   //자유 게시판
   @RequestMapping(value = "/myreply", method = RequestMethod.GET) 
   public ModelAndView myreplelist(@RequestParam("memKey")int memKey,Criteria cri) {
	   ModelAndView mav = new ModelAndView("/mypage/myreply");
	   List<Reple> rep = null;
	   rep  = memberService.setreplelist(memKey,cri.getPageStart(),cri.getPerPageNum());
		  int replecount = memberService.Replecount(memKey);
			PageMaker pageMaker = new PageMaker();
	  		pageMaker.setCri(cri);
	  		pageMaker.setTotalCount(replecount);
	   mav.addObject("replelist",rep);  
 		mav.addObject("pageMaker", pageMaker); 
	   return mav;
   }
   //인기 게시판
   @RequestMapping(value = "/myreply2", method = RequestMethod.GET) 
   public ModelAndView myreplelist2(@RequestParam("memKey")int memKey,Criteria cri) {
	   ModelAndView mav = new ModelAndView("/mypage/myreply2");
	   List<Reple> hrep = null;
	   hrep  = memberService.gethotreplelist(memKey,cri.getPageStart(),cri.getPerPageNum());
	   int replecount = memberService.hotReplecount(memKey);
			PageMaker pageMaker = new PageMaker();
	  		pageMaker.setCri(cri);
	  		pageMaker.setTotalCount(replecount);
	   mav.addObject("hotreplelist",hrep);  
 		mav.addObject("pageMaker", pageMaker); 
	   return mav;

   }
   //게임 게시판
   @RequestMapping(value = "/myreply3", method = RequestMethod.GET) 
   public ModelAndView myreplelist3(@RequestParam("memKey")int memKey,Criteria cri) {
	   ModelAndView mav = new ModelAndView("/mypage/myreply3");
	   List<Reple> rep = null;
	   rep  = memberService.setreplelist2(memKey,cri.getPageStart(),cri.getPerPageNum());
		  int replecount = memberService.Replecount2(memKey);
			PageMaker pageMaker = new PageMaker();
	  		pageMaker.setCri(cri);
	  		pageMaker.setTotalCount(replecount);
	   mav.addObject("replelist",rep);  
 		mav.addObject("pageMaker", pageMaker); 
	   return mav;
   }
   //맛집 게시판
   @RequestMapping(value = "/myreply4", method = RequestMethod.GET) 
   public ModelAndView myreplelist4(@RequestParam("memKey")int memKey,Criteria cri) {
	   ModelAndView mav = new ModelAndView("/mypage/myreply4");
	   List<Reple> rep = null;
	   rep  = memberService.setreplelist3(memKey,cri.getPageStart(),cri.getPerPageNum());
		  int replecount = memberService.Replecount3(memKey);
			PageMaker pageMaker = new PageMaker();
	  		pageMaker.setCri(cri);
	  		pageMaker.setTotalCount(replecount);
	   mav.addObject("replelist",rep);  
 		mav.addObject("pageMaker", pageMaker); 
	   return mav;
   }
   //여행 게시판
   @RequestMapping(value = "/myreply5", method = RequestMethod.GET) 
   public ModelAndView myreplelist5(@RequestParam("memKey")int memKey,Criteria cri) {
	   ModelAndView mav = new ModelAndView("/mypage/myreply5");
	   List<Reple> rep = null;
	   rep  = memberService.setreplelist4(memKey,cri.getPageStart(),cri.getPerPageNum());
		  int replecount = memberService.Replecount4(memKey);
			PageMaker pageMaker = new PageMaker();
	  		pageMaker.setCri(cri);
	  		pageMaker.setTotalCount(replecount);
	   mav.addObject("replelist",rep);  
 		mav.addObject("pageMaker", pageMaker); 
	   return mav;
   }

   @PostMapping("/repledelete")
   public String replede(@ModelAttribute("memKey")int repleKey,int memKey) {
	   memberService.setdeleteReple(repleKey);
	   return "redirect:/mypage?memKey = "+ memKey;
	   
   }

   @PostMapping("/delboard")
   public String dleboad(@ModelAttribute("memKey")int memKey,Board delboard) {
	   
	   memberService.setdelboard(delboard);
	   System.out.println(memKey);
	   return "redirect:/mypage?memKey = "+ memKey;
   }
   
   //
   
}