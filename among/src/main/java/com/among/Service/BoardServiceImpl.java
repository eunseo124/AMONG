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
	 
	 public List<Board> getAllBoardList(int startPage, int perPageNum) { 
	        // TODO Auto-generated method stub
		 return boardRepository.getAllBoardList(startPage, perPageNum);
	 } 
	 
	 public List<Board> getHotBoardList(int startPage, int perPageNum) { 
	        // TODO Auto-generated method stub
		 return boardRepository.getHotBoardList(startPage, perPageNum);
	 } 
	 public List<Board> getHomeBoardList() { 
         // TODO Auto-generated method stub
     return boardRepository.getHomeBoardList();
  } 
	 public List<Board> getHomeHotBoardList() { 
         // TODO Auto-generated method stub
     return boardRepository.getHomeHotBoardList();
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
	 
	 
	 public void setBoardUpdateInfo(Board board) {  
	        boardRepository.setBoardUpdateInfo(board);
	 }	 
	 
	 public void setbodRecommend(int boardKey) {
		  
		   boardRepository.setbodRecommend(boardKey);
		   
	 }

	@Override
	public int countBoardList() {
		// TODO Auto-generated method stub
		int boardcount = 0;
		boardcount = boardRepository.countBoardList();
		return boardcount;
	}
	
	public List<Board> getAllboardlist() {
		List<Board> board = null;
		board = boardRepository.getAllboardlist();
		return board;
	}
}