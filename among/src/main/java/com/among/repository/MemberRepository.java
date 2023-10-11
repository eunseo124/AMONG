package com.among.repository;

import java.util.List;
import com.among.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository {
   
   List<Member> getAllMemberList(); //member db ��ȸ�� //listOfMember
   
   List<Member> getmflist(String keyField);//member db �˻��� //mflist
  
   void setupmem(Member member); //member db ������  //upmem
   
   List<Member> getmemlist(Integer memKey);//member db memKey�� ��ȸ�� method //memlist
   
   Member getlogin(String memId, String memPw); //member db login �޼ҵ� //getlogin

   void getjoin(Member mem); //member ȸ������ �޼ҵ�
   
	//getBookById() �޼��� �߰�
	Member getMemberById(String memId);
}