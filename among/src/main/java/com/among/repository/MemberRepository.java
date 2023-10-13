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
   
   Member getmemlist(int memKey);//member db memKey�� ��ȸ�� method //memlist
   
   Member getlogin(String memId, String memPw); //member db login �޼ҵ� //getlogin

   void getjoin(Member mem); //member ȸ������ �޼ҵ�

   Member getcheckId(String memId) throws Exception; //member id �ߺ�üũ
   
   Member getchecknName(String nName); //member nName �ߺ�üũ
   
   Member getMemberById(String memId);//getBookById() �޼��� �߰�
   
   Member getfindId(String memName, String memEmail1, String memEmail2); //member db id ã�� method

   void setUpdateInfo(Member member); //������ ȸ���������� �޼��� �߰�

	Member getfindPw(String memId, String memName, String memEmail1, String memEmail2);
	
	//** ȸ������ ���� �޼��� �߰� **
	void setDeleteMember(String memId);		
}