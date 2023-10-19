package com.among.Service;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.among.domain.Board;


@Service
@Controller
public interface BoardService {
	
	List<Board> getAllBoardList();
	
	List<Board> getHotBoardList();
	
	void getboardWrite(Board board);
	
	void setbodView(int boardKey);
	
	Board getBoardmodi(int boardKey);
	
	void setBoardmodify(Board board);
	
	Board getBoardByBoardKey(int boardKey);	
	
	//관리자 페이지 게시판 수정
	void setBoardUpdateInfo(Board board); //관리자 회원정보수정 메서드 추가		
	
	void setbodRecommend(int boardKey);
}