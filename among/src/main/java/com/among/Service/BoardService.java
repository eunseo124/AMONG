package com.among.Service;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.among.domain.Board;


@Service
@Controller
public interface BoardService {
	
	//�Խ��� ��ȸ
	List<Board> getAllBoardList();
	
	//�α�Խ��� ��ȸ
	List<Board> getHotBoardList();
	
	//�Խ��� �۾���
	void getboardWrite(Board board);
	
	//�Խ��� ��ȸ�� ����
	void setbodView(int boardKey);
	
	//board 수정 페이지(조회)
	Board getBoardmodi(int boardKey);
}