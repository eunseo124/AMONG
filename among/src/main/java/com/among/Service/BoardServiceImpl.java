package com.among.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.among.domain.Board;
import com.among.domain.Member;
import com.among.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired 
	 private BoardRepository boardRepository;
	 
	 public List<Board> getAllBoardList() { 
	        // TODO Auto-generated method stub
		 return boardRepository.getAllBoardList();
	 } 
	 
	 public List<Board> getHotBoardList() { 
	        // TODO Auto-generated method stub
		 return boardRepository.getHotBoardList();
	 } 
	 
	 public void getboardWrite(Board board) {
		  
		   boardRepository.getboardWrite(board);
		   
	 }
	 
	 public void setbodView(int boardKey) {
		  
		   boardRepository.setbodView(boardKey);
		   
	 }
	 
	 public Board getBoardmodi(int boardKey) {
		 
		 Board bod = boardRepository.getBoardmodi(boardKey);
		 return bod;
	 }
	 
	 public void setBoardmodify(Board board) {
		 
		boardRepository.setBoardmodify(board);
	 }
	 
	 public Board getBoardByBoardKey(int boardKey) {
		 	Board boardByBoardKey = boardRepository.getBoardByBoardKey(boardKey);
	        return boardByBoardKey;
	 }	 
	 
	 public void setbodRecommend(int boardKey) {
		  
		   boardRepository.setbodRecommend(boardKey);
		   
	 }
}