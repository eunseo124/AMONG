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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.among.domain.Member;
import com.among.domain.Reple;
import com.among.Service.MemberService;
import com.among.Service.RepleService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

   @Autowired
   private MemberService memberService;
   
   @Autowired
   private RepleService repleService;

   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

   /**
    * Simply selects the home view to render by returning its name.
    */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      logger.info("Welcome home! The client locale is {}.", locale);

      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

      String formattedDate = dateFormat.format(date);

      model.addAttribute("serverTime", formattedDate);

      return "home";
   }

   @RequestMapping(value = "/home", method = RequestMethod.GET)
   public String home(Model model) {
      
	   
      return "home";

   }

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login() {

      return "member/login";

   }


   @RequestMapping(value = "/hotboard", method = RequestMethod.GET)
   public String hotboard() {

      return "board/hotboard";

   }

   @RequestMapping(value = "/gameboard", method = RequestMethod.GET)
   public String gameboard() {

      return "board/gameboard";

   }

   @RequestMapping(value = "/foodboard", method = RequestMethod.GET)
   public String foodboard() {

      return "board/foodboard";

   }

   @RequestMapping(value = "/travleboard", method = RequestMethod.GET)
   public String travleboard() {

      return "board/travleboard";

   }

   @RequestMapping(value = "/boardwrite", method = RequestMethod.GET)
   public String boardwrite() {

      return "board/boardwrite";

   }

   @RequestMapping(value = "/id", method = RequestMethod.GET)
   public String id() {

      return "member/id";

   }

   @RequestMapping(value = "/pass", method = RequestMethod.GET)
   public String pass() {

      return "member/pass";

   }


   @RequestMapping(value = "/mypost", method = RequestMethod.GET)
   public String mypost() {

      return "mypage/mypost";

   }

   @RequestMapping(value = "/mypost2", method = RequestMethod.GET)
   public String mypost2() {

      return "mypage/mypost2";

   }

   @RequestMapping(value = "/mypost3", method = RequestMethod.GET)
   public String mypost3() {

      return "mypage/mypost3";

   }

   @RequestMapping(value = "/mypost4", method = RequestMethod.GET)
   public String mypost4() {

      return "mypage/mypost4";

   }

   @RequestMapping(value = "/mypost5", method = RequestMethod.GET)
   public String mypost5() {

      return "mypage/mypost5";

   }

   @RequestMapping(value = "/myreply", method = RequestMethod.GET)
   public String myreply() {

      return "mypage/myreply";

   }

   @RequestMapping(value = "/myreply2", method = RequestMethod.GET)
   public String myreply2() {

      return "mypage/myreply2";

   }

   @RequestMapping(value = "/myreply3", method = RequestMethod.GET)
   public String myreply3() {

      return "mypage/myreply3";

   }

   @RequestMapping(value = "/myreply4", method = RequestMethod.GET)
   public String myreply4() {

      return "mypage/myreply4";

   }

   @RequestMapping(value = "/myreply5", method = RequestMethod.GET)
   public String myreply5() {

      return "mypage/myreply5";

   }

   @RequestMapping(value = "/boardlist", method = RequestMethod.GET)
   public String boardlist(HttpServletResponse res, HttpServletRequest req) {
      
      // getBoardKey
  /*    Integer boardKey = 1;
      
      List<Reple> repleList = repleService.getRepleList(boardKey);
      
      req.setAttribute("repleList", repleList);
*/      
      return "board/boardlist";

   }


   @RequestMapping(value = "/admingameboard", method = RequestMethod.GET)
   public String admingameboard() {

      return "admin/admingameboard";

   }

   @RequestMapping(value = "/adminfoodboard", method = RequestMethod.GET)
   public String adminfoodboard() {

      return "admin/adminfoodboard";

   }

   @RequestMapping(value = "/admintravleboard", method = RequestMethod.GET)
   public String admintravleboard() {

      return "admin/admintravleboard";

   }

}