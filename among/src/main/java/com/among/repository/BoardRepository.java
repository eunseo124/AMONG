/**BoardRepository**/
package com.among.repository;

import java.util.List;

import com.among.domain.Board;
import com.among.domain.Member;

public interface BoardRepository {

	List<Board> getAllBoardList();
	
	List<Board> getHotBoardList();
	
	void getboardWrite(Board board);
	
	void setbodView(int boardKey);
	
	Board getBoardmodi(int boardKey);
	
	void setBoardmodify(Board board);

	Board getBoardByBoardKey(int boardKey);
	
	void setbodRecommend(int boardKey);
	
}
