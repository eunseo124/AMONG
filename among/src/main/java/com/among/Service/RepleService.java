package com.among.Service;

import java.util.List;
import com.among.domain.Reple;


public interface RepleService {
	
	List<Reple> getAllRepleList();	
	
	//댓글 등록 메서드 추가
		void setNewReple(Reple reple);
	
		
		
		
}