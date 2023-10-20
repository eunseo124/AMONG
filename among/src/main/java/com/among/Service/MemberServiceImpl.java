package com.among.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.among.domain.Board;
import com.among.domain.Member;
import com.among.domain.Reple;

import org.springframework.stereotype.Service;
import com.among.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
   
   @Autowired
   private MemberRepository memberRepository;
   
   
   @Override
  
   public List<Member> getAllMemberList(int startPage, int perPageNum) {
      // TODO Auto-generated method stub
      List<Member> listOfMember = memberRepository.getAllMemberList(startPage,perPageNum);
      return listOfMember;
   }
   

   public List<Member> getmflist(String keyField) {
      return memberRepository.getmflist(keyField);
   }
   

   public void setupmem(Member member) {
      memberRepository.setupmem(member);
   }
   

   public Member getmemlist(int memKey){
      Member memlist = memberRepository.getmemlist(memKey);
      return memlist;
   }
   

   public Member getlogin(String memId, String memPw) {
      
    Member member = memberRepository.getlogin(memId, memPw);
      
      return member;
   }
   

   public void getjoin(Member mem) {
     
      memberRepository.getjoin(mem);
      
   }

    public Member getcheckId(String memId) {
       Member result = null;
       try {
         result = memberRepository.getcheckId(memId);
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
       return result;
    } 
    

    public Member getchecknName(String nName) {
       Member result = null;
       result = memberRepository.getchecknName(nName);
       return result;
    }
    

    public Member getfindId(String memName, String memEmail1, String memEmail2) {
       Member memi = memberRepository.getfindId(memName,memEmail1,memEmail2);
       return memi;
    }
    

	 public Member getMemberById(String memId) {
		 	Member memberById = memberRepository.getMemberById(memId);
	        return memberById;
	 }
	 

	 public void setUpdateInfo(Member member) {  
	        memberRepository.setUpdateInfo(member);
	 }

	@Override
	public Member getfindPw(String memId, String memName, String memEmail1, String memEmail2) {
		// TODO Auto-generated method stub
		Member mem = memberRepository.getfindPw(memId,memName,memEmail1,memEmail2);
		return mem;
	} 
	

	  public void setDeleteMember(String memId) { 
	        memberRepository.setDeleteMember(memId);
	 }	 
	

	 public List<Board> setboardlist(int memKey,int startPage, int perPageNum) {
		 List<Board> board = null;
		 board = memberRepository.setboardlist(memKey,startPage,perPageNum);
		 return board;
	 }
	

	 public List<Reple> setreplelist(int memKey,int startPage, int perPageNum) {
		 List<Reple> rep = null;
		 rep = memberRepository.setreplelist(memKey,startPage,perPageNum);
		 return rep;
	 }
	 

	@Override
	public void setdeleteReple(int repleKey) {
		memberRepository.setdeleteReple(repleKey);
		
	}
	

	public List<Board> gethotboardlist(int memKey,int startPage, int perPageNum){
	 List<Board> hboard = null;
	 hboard = memberRepository.gethotboardlist(memKey,startPage,perPageNum);
		return hboard;
	}
	

	@Override
	public void setdelboard(Board delboard) {
		// TODO Auto-generated method stub
		memberRepository.setdelboard(delboard);
		
	}


	public List<Reple> getreplelist(int memKey,int startPage, int perPageNum){
		List<Reple> hreple = null;
		hreple = memberRepository.getreplelist(memKey,startPage,perPageNum);
		return hreple;
	}
	

	public Board boardcount(int memKey) {
		Board countbo = new Board();
		countbo = memberRepository.boardcount(memKey);
		return countbo;
	}
	

	public Reple replecount(int memKey) {
		Reple countre = new Reple();
		countre = memberRepository.replecount(memKey);
		return countre;
	}
	
	public int membercount() {
		int membercount = memberRepository.membercount();
		return membercount;
	}
	
	public int Boardcount(int memKey) {
		
		 int countbo = memberRepository.Boardcount(memKey);
		return countbo;
	}
	

	public int Replecount(int memKey) {
		
		 int countre = memberRepository.Replecount(memKey);
		return countre;
	}
}