package com.among.Service;


import java.util.List;

import com.among.domain.Board;
import com.among.domain.Member;
import com.among.domain.Reple;

public interface RepleService {

	List<Reple> getAllRepleList(int startPage, int perPageNum);
	
	List<Reple> getAllreplelist();
	
	void setNewReple(Reple reple);
	
	// save repl
	Integer saveReple(Reple reple);

	// get repl list
	List<Reple> getRepleList(Integer boardKey);

		List<Board> getAllBoardList();
	
		List<Board> setboardlist(int boardKey);//boardlist �뜎�눖�봺�눧占�
		
		
		void setDeleteReple(int repleKey);		
		
		
	int countReplelist();
	


}