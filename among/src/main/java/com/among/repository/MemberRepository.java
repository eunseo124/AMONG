package com.among.repository;

import java.util.List;

import com.among.domain.Board;
import com.among.domain.Member;
import com.among.domain.Reple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository {
   
   List<Member> getAllMemberList(); 
   
   List<Member> getmflist(String keyField);
  
   void setupmem(Member member); 
   
   Member getmemlist(int memKey);
   
   Member getlogin(String memId, String memPw); 

   void getjoin(Member mem); 

   Member getcheckId(String memId) throws Exception;
   
   Member getchecknName(String nName); 
   
   Member getMemberById(String memId);
   
   Member getfindId(String memName, String memEmail1, String memEmail2); 

   void setUpdateInfo(Member member); 

	Member getfindPw(String memId, String memName, String memEmail1, String memEmail2);
	
	
	void setDeleteMember(String memId);		
	
	List<Board> setboardlist(int memKey);

	List<Reple> setreplelist(int memKey);

	void setdeleteReple(int repleKey); 
	
	List<Board> gethotboardlist(int memKey);

	void setdelboard(Board delboard); 
	
	List<Reple> getreplelist(int memKey);
	
	Board boardcount(int memKey); 
	
	Reple replecount(int memKey); 
	
}