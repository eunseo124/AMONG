/**BoardRepository**/
package com.among.repository;

import java.util.List;

import com.among.domain.Board;
import com.among.domain.Member;

public interface BoardRepository {

	List<Board> getAllBoardList();
	
	List<Board> getHotBoardList();
	
	List<Board> getHomeBoardList();
	
	List<Board> getHomeHotBoardList();
	
	void getboardWrite(Board board);
	
	void setbodView(int boardKey);
	
	Board getBoardmodi(int boardKey);
	
	void setBoardmodify(Board board);

	Board getBoardByBoardKey(int boardKey);
	
	//관리자 페이지 게시판 수정
	void setBoardUpdateInfo(Board board); //관리자 회원정보수정 메서드 추가		
	
	//異붿쿇�닔利앷�
	void setbodRecommend(int boardKey);
	
}
