package com.among.repository;

import java.util.List;
import com.among.domain.Member;

public interface MemberRepository {
	
	List<Member> getAllMemberList(); //member db ��ȸ�� //listOfMember
	List<Member> getmflist(String keyField);//member db �˻��� //mflist
	void setupmem(Member member); //member db ������  //upmem
	List<Member> getmemlist(int memKey);//member db memKey�� ��ȸ�� method //memlist
}
