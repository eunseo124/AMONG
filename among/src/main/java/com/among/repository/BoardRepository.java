/**BoardRepository**/
package com.among.repository;

import java.util.List;

import com.among.domain.Board;

public interface BoardRepository {

	//�Խ��� ��ȸ
	List<Board> getAllBoardList();
	
	//�α�Խ��� ��ȸ
	List<Board> getHotBoardList();
	
	//�Խ��� �۾���
	void getboardWrite(Board board);
	
	//�Խ��� ��ȸ�� ī����
	void setbodView(int boardKey);
	
	Board getBoardmodi(int boardKey);
	
	void setBoardmodi(Board board);
	
	
}
