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

import com.among.domain.Board;
import com.among.domain.Member;
import com.among.domain.Reple;
import com.among.Service.MemberService;
import com.among.Service.RepleService;
import com.among.Service.BoardService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

   @Autowired
   private MemberService memberService;
   
   @Autowired
   private RepleService repleService;
   
   @Autowired
   private BoardService boardService;

   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

   /**
    * Simply selects the home view to render by returning its name.
    */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      logger.info("Welcome home! The client locale is {}.", locale);

      List<Board> list = boardService.getHomeBoardList();
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

      String formattedDate = dateFormat.format(date);
      
      model.addAttribute("boardList", list);  
      model.addAttribute("serverTime", formattedDate);

      return "home";
   }

  

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login() {

      return "member/login";

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

}