package com.among.repository;

import java.util.List;

import com.among.domain.Board;
import com.among.domain.Reple;


public interface RepleRepository {
	
	List<Reple> getAllRepleList();
	
	void setNewReple(Reple reple);
	
	
	Integer saveReple(Reple reple);
	
//	List<Reple> getRepleList(Integer boardKey);
	
//	List<Board> getAllBoardList();
	
	List<Board> setboardlist(int boardKey);
	
	void setDeleteReple(int repleKey);		


}
