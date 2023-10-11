package com.among.repository;

import java.util.List;

import com.among.domain.Reple;


public interface RepleRepository {
	
	List<Reple> getAllRepleList();
	//占쏙옙占� 占쏙옙占� 占쌩곤옙
	void setNewReple(Reple reple);
	
	
	Integer saveReple(Reple reple);
	
	List<Reple> getReplList(Integer boardKey);
	


}
