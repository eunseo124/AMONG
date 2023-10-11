package com.among.repository;

import java.util.List;
import com.among.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository {
   
   List<Member> getAllMemberList(); //member db 조회문 //listOfMember
   
   List<Member> getmflist(String keyField);//member db 검색문 //mflist
  
   void setupmem(Member member); //member db 수정문  //upmem
   
   List<Member> getmemlist(Integer memKey);//member db memKey로 조회문 method //memlist
   
   Member getlogin(String memId, String memPw); //member db login 메소드 //getlogin

   void getjoin(Member mem); //member 회원가입 메소드
   
	//getBookById() 메서드 추가
	Member getMemberById(String memId);
}