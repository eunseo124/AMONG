package com.among.repository;

import java.util.List;

import com.among.domain.Member;

public interface AdminRepository {
	

	List<Member> getmflist(String keyField);//member db 검색문 //mflist
	void setupmem(Member member); //member db 수정문  //upmem	
	


}
