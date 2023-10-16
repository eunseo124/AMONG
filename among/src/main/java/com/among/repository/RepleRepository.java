package com.among.repository;

import java.util.List;

import com.among.domain.Board;
import com.among.domain.Reple;


public interface RepleRepository {
	
	List<Reple> getAllRepleList();
	//�뜝�룞�삕�뜝占� �뜝�룞�삕�뜝占� �뜝�뙥怨ㅼ삕
	void setNewReple(Reple reple);
	
	
	Integer saveReple(Reple reple);
	
	List<Reple> getRepleList(Integer boardKey);
	
	List<Board> getAllBoardList();
	
	List<Board> setboardlist(int boardKey);//boardlist 荑쇰━臾�
	
	//** 댓글 삭제 메서드 추가 **
	void setDeleteReple(int repleKey);		


}
