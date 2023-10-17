package com.among.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.among.domain.Board;
import com.among.domain.Reple;
import com.among.repository.BoardRepository;
import com.among.repository.RepleRepository;


@Service
public class RepleServiceImpl implements RepleService{

	@Autowired 
	 private RepleRepository repleRepository;

	 	private BoardRepository boardRepository;
	 
	 
	 public List<Reple> getAllRepleList() { 
	        // TODO Auto-generated method stub
		 return repleRepository.getAllRepleList();
	 } 
	 
	
	
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
		return repleRepository.getRepleList(boardKey);
	}   
	 

		public List<Board> getAllBoardList() { 
        // TODO Auto-generated method stub
	 return boardRepository.getAllBoardList();
 } 	
		
		//boardlist ������
		@Override
		 public List<Board> setboardlist(int boardKey) {
			List<Board> board = null;
			 board = repleRepository.setboardlist(boardKey);
			 return board;
		 }
		
		//** ��� �����޼��� �������̵� **
		 public void setDeleteReple(int repleKey) { 
		       repleRepository.setDeleteReple(repleKey);
		 }		

}