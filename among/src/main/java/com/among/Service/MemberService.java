package com.among.Service;

import java.util.List;
import com.among.domain.Member;

public interface MemberService {
	
	List<Member> getAllMemberList(); //member db 조회문 //listOfMember
	List<Member> getmflist(String keyField);//member db 검색문 //mflist
	void setupmem(Member member); //member db 수정문  //upmem
}
