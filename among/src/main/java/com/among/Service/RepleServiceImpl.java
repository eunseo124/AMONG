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

	@Autowired //@Autowired ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½Ï¿ï¿½ ï¿½Þ¼ï¿½ï¿½å°¡ ï¿½ï¿½ï¿½Çµï¿½ BookRepository Å¬ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ getAllBookList() ï¿½Þ¼ï¿½ï¿½å¸¦ È£ï¿½ï¿½ï¿½Õ´Ï´ï¿½.
	 private RepleRepository repleRepository;

	 	private BoardRepository boardRepository;
	 
	 
	 public List<Reple> getAllRepleList() { 
	        // TODO Auto-generated method stub
		 return repleRepository.getAllRepleList();
	 } 
	 
	
	 //repleRepository Å¬ï¿½ï¿½ï¿½ï¿½ setNewReple() ï¿½Þ¼ï¿½ï¿½ï¿½ È£ï¿½ï¿½
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
		
		//boardlist Äõ¸®¹®
		@Override
		 public List<Board> setboardlist(int boardKey) {
			List<Board> board = null;
			 board = repleRepository.setboardlist(boardKey);
			 return board;
		 }
		
		//** ´ñ±Û »èÁ¦¸Þ¼­µå ¿À¹ö¶óÀÌµå **
		 public void setDeleteReple(int repleKey) { 
		       repleRepository.setDeleteReple(repleKey);
		 }		

}