package com.among.Service;

import java.util.List;

import com.among.domain.Board;

public interface BoardService {
	
	//�Խ��� ��ȸ
	List<Board> getAllBoardList();
	
	//�Խ��� �۾���
	void getboardWrite(Board board);
	
	//�Խ��� ��ȸ�� ����
	void setbodView(int boardKey);
}