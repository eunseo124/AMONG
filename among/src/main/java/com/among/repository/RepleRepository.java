package com.among.repository;

import java.util.List;

import com.among.domain.Reple;


public interface RepleRepository {
	
	List<Reple> getAllRepleList();
	//댓글 등록 추가
	void setNewReple(Reple reple);
	


}
