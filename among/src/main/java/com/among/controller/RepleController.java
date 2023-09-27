package com.among.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;




import com.among.Service.RepleService;
import com.among.domain.Reple;
/*
@Controller
//RequestMapping 의 단순화
@RequestMapping("/boardlist")
public class RepleController {
	
	//Autowired 를 정의하여 BookService 클래스의 getAllBookList() 메서드를 호출합니다.
	@Autowired
  private RepleService repleService;  

	HTTP 요청 방식이 GET인 경우, @GetMapping 을 사용할 수 있습니다.
	@GetMapping
	public String requestRepleList(Model model) { 
	    List<Reple> list = repleService.getAllRepleList();
	    model.addAttribute("repleList", list);  
	    return "board/boardlist"; 
	}
	
	  //도서등록 페이지 addBook url맵핑
    @GetMapping("/boardlist")  
    //@ModelAttribute 를 이용하여 addBook.jsp 의 스프링 폼 태그와 연동된다.
    public String requestAddRepleForm(@ModelAttribute("NewReple") Reple reple) {  
        return "board/boardlist";
    } 
    
  //도서등록 페이지 addBook url 맵핑(post 방식)
    //** submitAddNEwBook() 메서드 수정  **
    @PostMapping("/boardlist") 
    public String submitAddNewReple( @ModelAttribute("NewReple")  Reple reple,BindingResult result) {
    	
   	if(result.hasErrors()) { 
           return "boardlist";
        } 

    }
	
  
    
} 
*/