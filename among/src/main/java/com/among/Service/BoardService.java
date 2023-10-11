package com.among.Service;

import java.util.List;

import com.among.domain.Board;

public interface BoardService {
	
	//게시판 조회
	List<Board> getAllBoardList();
	
	//게시판 글쓰기
	void getboardWrite(Board board);
	
	//게시판 조회수 증가
	void setbodView(int boardKey);
}