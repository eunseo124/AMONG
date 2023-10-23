package com.among.repository;

import java.util.List;

import com.among.domain.Board;
import com.among.domain.Member;
import com.among.domain.Reple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository {
   
   List<Member> getAllMemberList(int startPage, int perPageNum); 
   
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
	
	List<Board> setboardlist(int memKey,int startPage, int perPageNum);

	List<Board> setboardlist2(int memKey,int startPage, int perPageNum);
	
	List<Board> setboardlist3(int memKey,int startPage, int perPageNum);

	List<Board> setboardlist4(int memKey,int startPage, int perPageNum);
	
	List<Reple> setreplelist(int memKey,int startPage, int perPageNum);
	
	List<Reple> setreplelist2(int memKey,int startPage, int perPageNum);
	
	List<Reple> setreplelist3(int memKey,int startPage, int perPageNum);
	
	List<Reple> setreplelist4(int memKey,int startPage, int perPageNum);

	void setdeleteReple(int repleKey); 
	
	List<Board> gethotboardlist(int memKey,int startPage, int perPageNum);

	void setdelboard(Board delboard); 
	
	List<Reple> gethotreplelist(int memKey,int startPage, int perPageNum);
	
	Board boardcount(int memKey); 
	
	Reple replecount(int memKey); 
	
	int membercount( );
	
	int Boardcount(int memKey); 
	
	int Boardcount2(int memKey); 
	
	int Boardcount3(int memKey); 
	
	int Boardcount4(int memKey); 

	int hotBoardcount(int memKey); 
	
	int Replecount(int memKey); 
	
	int Replecount2(int memKey); 
	
	int Replecount3(int memKey); 
	
	int Replecount4(int memKey); 
	
	int hotReplecount(int memKey); 
	
}