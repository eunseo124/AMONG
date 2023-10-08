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

	@Autowired //@Autowired �� �����Ͽ� �޼��尡 ���ǵ� BookRepository Ŭ������ getAllBookList() �޼��带 ȣ���մϴ�.
	 private RepleRepository repleRepository;
	 
	 public List<Reple> getAllRepleList() { 
	        // TODO Auto-generated method stub
		 return repleRepository.getAllRepleList();
	 } 
	 
	
	 //repleRepository Ŭ���� setNewReple() �޼��� ȣ��
	 public void setNewReple(Reple reple) {  
		 repleRepository.setNewReple(reple);  
	 }


	@Override
	public Integer saveReple(Reple reple) {
		// TODO Auto-generated method stub
		return repleRepository.saveReple(reple);
	}


	@Override
	public List<Reple> getRepleList(Integer boardKey) {
		// TODO Auto-generated method stub
		return repleRepository.getReplList(boardKey);
	}   
	 
}