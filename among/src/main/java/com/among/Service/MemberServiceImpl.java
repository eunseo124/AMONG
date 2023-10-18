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
   //member list method불러오기
   public List<Member> getAllMemberList() {
      // TODO Auto-generated method stub
      List<Member> listOfMember = memberRepository.getAllMemberList();
      return listOfMember;
   }
   
   //member 조회문 method불러오기
   public List<Member> getmflist(String keyField) {
      return memberRepository.getmflist(keyField);
   }
   
   //member update method불러오기
   public void setupmem(Member member) {
      memberRepository.setupmem(member);
   }
   
   //member 조회 method불러오기
   public Member getmemlist(int memKey){
      Member memlist = memberRepository.getmemlist(memKey);
      return memlist;
   }
   
   //member db login 메소드 
   public Member getlogin(String memId, String memPw) {
      
    Member member = memberRepository.getlogin(memId, memPw);
      
      return member;
   }
   
   //member 회원가입 메소드
   public void getjoin(Member mem) {
     
      memberRepository.getjoin(mem);
      
   }
 //member id 중복체크
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
    
    //member nName 중복체크
    public Member getchecknName(String nName) {
       Member result = null;
       result = memberRepository.getchecknName(nName);
       return result;
    }
    
    
    //member db id 찾기 method
    public Member getfindId(String memName, String memEmail1, String memEmail2) {
       Member memi = memberRepository.getfindId(memName,memEmail1,memEmail2);
       return memi;
    }
    
	 //BookRepository 클래스 getBookById() 메서드 호출
	 public Member getMemberById(String memId) {
		 	Member memberById = memberRepository.getMemberById(memId);
	        return memberById;
	 }
	 
	 //** 도서 정보 수정메서드 오버라이드 **
	 public void setUpdateInfo(Member member) {  
	        memberRepository.setUpdateInfo(member);
	 }

	@Override
	public Member getfindPw(String memId, String memName, String memEmail1, String memEmail2) {
		// TODO Auto-generated method stub
		Member mem = memberRepository.getfindPw(memId,memName,memEmail1,memEmail2);
		return mem;
	} 
	
	//** 회원정보 삭제메서드 오버라이드 **
	  public void setDeleteMember(String memId) { 
	        memberRepository.setDeleteMember(memId);
	 }	 
	
	//boardlist 쿼리문 	
	 public List<Board> setboardlist(int memKey) {
		 List<Board> board = null;
		 board = memberRepository.setboardlist(memKey);
		 return board;
	 }
	
	 //replelist 쿼리문
	 public List<Reple> setreplelist(int memKey) {
		 List<Reple> rep = null;
		 rep = memberRepository.setreplelist(memKey);
		 return rep;
	 }
	 
	 //reple 삭제 쿼리문
	@Override
	public void setdeleteReple(int repleKey) {
		memberRepository.setdeleteReple(repleKey);
		
	}
	
	//인기게시판 조회
	public List<Board> gethotboardlist(int memKey){
	 List<Board> hboard = null;
	 hboard = memberRepository.gethotboardlist(memKey);
		return hboard;
	}
	
	//게시글 삭제
	@Override
	public void setdelboard(Board delboard) {
		// TODO Auto-generated method stub
		memberRepository.setdelboard(delboard);
		
	}

	//인기댓글조회
	public List<Reple> getreplelist(int memKey){
		List<Reple> hreple = null;
		hreple = memberRepository.getreplelist(memKey);
		return hreple;
	}
	
}