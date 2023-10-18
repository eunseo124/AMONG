/**BoardRepository**/
package com.among.repository;

import java.util.List;

import com.among.domain.Board;
import com.among.domain.Member;

public interface BoardRepository {

	//보드게시판 조회
	List<Board> getAllBoardList();
	
	//인기게시판 조회
	List<Board> getHotBoardList();
	
	void getboardWrite(Board board);
	
	void setbodView(int boardKey);
	
	Board getBoardmodi(int boardKey);
	
	void setBoardmodify(Board board);

	//관리자 페이지 게시판 내용불러오기
	Board getBoardByBoardKey(int boardKey);
	
	//추천수 증가
	void setbodRecommend(int boardKey);
	
}
