package com.among.Service;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.among.domain.Board;


@Service
@Controller
public interface BoardService {
	
	//占쌉쏙옙占쏙옙 占쏙옙회
	List<Board> getAllBoardList();
	
	//占싸깍옙督占쏙옙占� 占쏙옙회
	List<Board> getHotBoardList();
	
	//占쌉쏙옙占쏙옙 占쌜억옙占쏙옙
	void getboardWrite(Board board);
	
	//占쌉쏙옙占쏙옙 占쏙옙회占쏙옙 占쏙옙占쏙옙
	void setbodView(int boardKey);
	
	//board �닔�젙 �럹�씠吏�(議고쉶)
	Board getBoardmodi(int boardKey);
	
	//board �닔�젙
	void setBoardmodify(Board board);
	
	Board getBoardByBoardKey(int boardKey);	
}