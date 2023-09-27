package com.among.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.among.domain.Reple;

import com.among.repository.RepleRepository;



@Service
public class RepleServiceImpl implements RepleService{

	@Autowired //@Autowired 를 정의하여 메서드가 정의된 BookRepository 클래스의 getAllBookList() 메서드를 호출합니다.
	 private RepleRepository repleRepository;
	 
	 public List<Reple> getAllRepleList() { 
	        // TODO Auto-generated method stub
		 return repleRepository.getAllRepleList();
	 } 
	 
	
	 //repleRepository 클래스 setNewReple() 메서드 호출
	 public void setNewReple(Reple reple) {  
		 repleRepository.setNewReple(reple);  
	 }  
	 
}