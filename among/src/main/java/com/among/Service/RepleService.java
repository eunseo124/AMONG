package com.among.Service;

import java.util.List;
import com.among.domain.Reple;

public interface RepleService {

	List<Reple> getAllRepleList();

	// 占쏙옙占� 占쏙옙占� 占쌨쇽옙占쏙옙 占쌩곤옙
	void setNewReple(Reple reple);
	
	// save repl
	Integer saveReple(Reple reple);

/*	// get repl list
	List<Reple> getRepleList(Integer boardKey);
*/	
	
	Reple getReplList(int boardKey);

}