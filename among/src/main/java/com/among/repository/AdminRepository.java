package com.among.repository;

import java.util.List;

import com.among.domain.Member;

public interface AdminRepository {
	
	List<Member> getAllMemberList(); //member db ��ȸ�� //listOfMember
	List<Member> getmflist(String keyField);//member db �˻��� //mflist
	void setupmem(Member member); //member db ������  //upmem	

}