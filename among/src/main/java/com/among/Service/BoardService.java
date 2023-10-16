package com.among.Service;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.among.domain.Board;


@Service
@Controller
public interface BoardService {
	
	//게시판 조회
	List<Board> getAllBoardList();
	
	//인기게시판 조회
	List<Board> getHotBoardList();
	
	//게시판 글쓰기
	void getboardWrite(Board board);
	
	//게시판 조회수 증가
	void setbodView(int boardKey);
}