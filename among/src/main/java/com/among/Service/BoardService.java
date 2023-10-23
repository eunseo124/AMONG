package com.among.Service;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.among.domain.Board;


@Service
@Controller
public interface BoardService {
	
	List<Board> getAllBoardList(int startPage, int perPageNum);
	
	List<Board> getAllBoardList2(int startPage, int perPageNum);
	
	List<Board> getAllBoardList3(int startPage, int perPageNum);
	
	List<Board> getAllBoardList4(int startPage, int perPageNum);
	
	List<Board> getHotBoardList(int startPage, int perPageNum);
	
	List<Board> getFreeBoardList();
	
	List<Board> getTravleBoardList();
	List<Board> getGameBoardList();
	List<Board> getfoodBoardList();
	
	List<Board> getHomeHotBoardList();
	
	void getboardWrite(Board board);
	
	void setbodView(int boardKey);
	
	Board getBoardmodi(int boardKey);
	
	void setBoardmodify(Board board);
	
	Board getBoardByBoardKey(int boardKey);	
	
	//관리자 페이지 게시판 수정
	void setBoardUpdateInfo(Board board); //관리자 회원정보수정 메서드 추가		
	
	void setbodRecommend(int boardKey);
	
	List<Board> getAllboardlist();
	
	int countBoardList();
	
	int countBoardList2();
	
	int countBoardList3();
	
	int countBoardList4();
	
	int counthotBoardList();
	
}