package com.among.repository;

import java.util.List;

import com.among.domain.Board;
import com.among.domain.Member;

public interface AdminRepository {
	
	List<Member> getmflist(String keyField);
	void setupmem(Member member); 
	
	Board setboard(int boardKey);
	

}
