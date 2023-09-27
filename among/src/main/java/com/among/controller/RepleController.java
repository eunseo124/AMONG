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
//RequestMapping �� �ܼ�ȭ
@RequestMapping("/boardlist")
public class RepleController {
	
	//Autowired �� �����Ͽ� BookService Ŭ������ getAllBookList() �޼��带 ȣ���մϴ�.
	@Autowired
  private RepleService repleService;  

	HTTP ��û ����� GET�� ���, @GetMapping �� ����� �� �ֽ��ϴ�.
	@GetMapping
	public String requestRepleList(Model model) { 
	    List<Reple> list = repleService.getAllRepleList();
	    model.addAttribute("repleList", list);  
	    return "board/boardlist"; 
	}
	
	  //������� ������ addBook url����
    @GetMapping("/boardlist")  
    //@ModelAttribute �� �̿��Ͽ� addBook.jsp �� ������ �� �±׿� �����ȴ�.
    public String requestAddRepleForm(@ModelAttribute("NewReple") Reple reple) {  
        return "board/boardlist";
    } 
    
  //������� ������ addBook url ����(post ���)
    //** submitAddNEwBook() �޼��� ����  **
    @PostMapping("/boardlist") 
    public String submitAddNewReple( @ModelAttribute("NewReple")  Reple reple,BindingResult result) {
    	
   	if(result.hasErrors()) { 
           return "boardlist";
        } 

    }
	
  
    
} 
*/