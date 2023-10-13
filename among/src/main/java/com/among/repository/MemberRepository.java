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
   
   Member getmemlist(int memKey);//member db memKey로 조회문 method //memlist
   
   Member getlogin(String memId, String memPw); //member db login 메소드 //getlogin

   void getjoin(Member mem); //member 회원가입 메소드

   Member getcheckId(String memId) throws Exception; //member id 중복체크
   
   Member getchecknName(String nName); //member nName 중복체크
   
   Member getMemberById(String memId);//getBookById() 메서드 추가
   
   Member getfindId(String memName, String memEmail1, String memEmail2); //member db id 찾기 method

   void setUpdateInfo(Member member); //관리자 회원정보수정 메서드 추가

	Member getfindPw(String memId, String memName, String memEmail1, String memEmail2);
	
	//** 회원정보 삭제 메서드 추가 **
	void setDeleteMember(String memId);		
}