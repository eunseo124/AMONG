/**BoardRepository**/
package com.among.repository;

import java.util.List;

import com.among.domain.Board;

public interface BoardRepository {

	List<Board> getAllBoardList();
	
	void getboardWrite(Board board);
}
