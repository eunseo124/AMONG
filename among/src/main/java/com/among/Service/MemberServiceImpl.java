package com.among.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.among.domain.Member;
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
   public List<Member> getmemlist(int memKey){
      List<Member> memlist = memberRepository.getmemlist(memKey);
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
    
    
	 //BookRepository 클래스 getBookById() 메서드 호출
	 public Member getMemberById(String memId) {
		 	Member memberById = memberRepository.getMemberById(memId);
	        return memberById;
	 }
}