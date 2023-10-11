package com.among.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.among.domain.Board;
import com.among.domain.Member;
import com.among.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired //@Autowired 를 정의하여 메서드가 정의된 BookRepository 클래스의 getAllBookList() 메서드를 호출합니다.
	 private BoardRepository boardRepository;
	 
	 public List<Board> getAllBoardList() { 
	        // TODO Auto-generated method stub
		 return boardRepository.getAllBoardList();
	 } 
	 
	 public void getboardWrite(Board board) {
		  
		   boardRepository.getboardWrite(board);
		   
	   }
}