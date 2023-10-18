/**BoardRepository**/
package com.among.repository;

import java.util.List;

import com.among.domain.Board;
import com.among.domain.Member;

public interface BoardRepository {

	//占쌉쏙옙占쏙옙 占쏙옙회
	List<Board> getAllBoardList();
	
	//占싸깍옙督占쏙옙占� 占쏙옙회
	List<Board> getHotBoardList();
	
	//占쌉쏙옙占쏙옙 占쌜억옙占쏙옙
	void getboardWrite(Board board);
	
	//占쌉쏙옙占쏙옙 占쏙옙회占쏙옙 카占쏙옙占쏙옙
	void setbodView(int boardKey);
	
	Board getBoardmodi(int boardKey);
	
	void setBoardmodify(Board board);

	//관리자 페이지 게시판 내용불러오기
	Board getBoardByBoardKey(int boardKey);
	
}
