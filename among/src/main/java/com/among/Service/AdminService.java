package com.among.Service;

import java.util.List;

import com.among.domain.Member;

public interface AdminService {
	

	List<Member> getmflist(String keyField);//member db �˻��� //mflist
	void setupmem(Member member); //member db ������  //upmem	
	

		
}
