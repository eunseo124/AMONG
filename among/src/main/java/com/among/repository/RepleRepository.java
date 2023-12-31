package com.among.repository;

import java.util.List;

import com.among.domain.Board;
import com.among.domain.Member;
import com.among.domain.Reple;


public interface RepleRepository {
	
	List<Reple> getAllRepleList(int startPage, int perPageNum);
	
	List<Reple> getAllreplelist();
	
	void setNewReple(Reple reple);
	
	
	Integer saveReple(Reple reple);
	
	List<Reple> getRepleList(Integer boardKey);
	
	List<Board> getAllBoardList();
	
	List<Board> setboardlist(int boardKey);
	
	void setDeleteReple(int repleKey);
		
	int countReplelist();
	
	

}
