/**BoardRepository**/
package com.among.repository;

import java.util.List;

import com.among.domain.Board;

public interface BoardRepository {

	//�Խ��� ��ȸ
	List<Board> getAllBoardList();
	
	//�Խ��� �۾���
	void getboardWrite(Board board);
	
	//�Խ��� ��ȸ�� ī����
	void setbodView(int boardKey);
}
