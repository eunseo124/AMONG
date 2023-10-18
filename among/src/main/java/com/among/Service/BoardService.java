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
	
	void setbodRecommend(int boardKey);
}