package com.among.repository;

import java.util.List;

import com.among.domain.Reple;


public interface RepleRepository {
	
	List<Reple> getAllRepleList();
	//��� ��� �߰�
	void setNewReple(Reple reple);
	


}
