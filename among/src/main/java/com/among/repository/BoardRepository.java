/**BoardRepository**/
package com.among.repository;

import java.util.List;

import com.among.domain.Board;

public interface BoardRepository {

	//게시판 조회
	List<Board> getAllBoardList();
	
	//게시판 글쓰기
	void getboardWrite(Board board);
	
	//게시판 조회수 카운팅
	void setbodView(int boardKey);
}
