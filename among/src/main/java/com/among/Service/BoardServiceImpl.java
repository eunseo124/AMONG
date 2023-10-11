package com.among.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.among.domain.Board;
import com.among.domain.Member;
import com.among.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired //@Autowired �� �����Ͽ� �޼��尡 ���ǵ� BookRepository Ŭ������ getAllBookList() �޼��带 ȣ���մϴ�.
	 private BoardRepository boardRepository;
	 
	 public List<Board> getAllBoardList() { 
	        // TODO Auto-generated method stub
		 return boardRepository.getAllBoardList();
	 } 
	 
	 public void getboardWrite(Board board) {
		  
		   boardRepository.getboardWrite(board);
		   
	   }
}