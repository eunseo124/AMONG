package com.among.repository;

import java.util.List;
import com.among.domain.Member;

public interface MemberRepository {
	
	List<Member> getAllMemberList(); //member db 조회문 //listOfMember
	List<Member> getmflist(String keyField);//member db 검색문 //mflist
	void setupmem(Member member); //member db 수정문  //upmem
	List<Member> getmemlist(int memKey);//member db memKey로 조회문 method //memlist
}
