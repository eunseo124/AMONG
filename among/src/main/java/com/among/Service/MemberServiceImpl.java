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
   //member list method�ҷ�����
   public List<Member> getAllMemberList() {
      // TODO Auto-generated method stub
      List<Member> listOfMember = memberRepository.getAllMemberList();
      return listOfMember;
   }
   
   //member ��ȸ�� method�ҷ�����
   public List<Member> getmflist(String keyField) {
      return memberRepository.getmflist(keyField);
   }
   
   //member update method�ҷ�����
   public void setupmem(Member member) {
      memberRepository.setupmem(member);
   }
   
   //member ��ȸ method�ҷ�����
   public Member getmemlist(int memKey){
      Member memlist = memberRepository.getmemlist(memKey);
      return memlist;
   }
   
   //member db login �޼ҵ� 
   public Member getlogin(String memId, String memPw) {
      
    Member member = memberRepository.getlogin(memId, memPw);
      
      return member;
   }
   
   //member ȸ������ �޼ҵ�
   public void getjoin(Member mem) {
     
      memberRepository.getjoin(mem);
      
   }
 //member id �ߺ�üũ
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
    
    //member nName �ߺ�üũ
    public Member getchecknName(String nName) {
       Member result = null;
       result = memberRepository.getchecknName(nName);
       return result;
    }
    
    
    //member db id ã�� method
    public Member getfindId(String memName, String memEmail1, String memEmail2) {
       Member memi = memberRepository.getfindId(memName,memEmail1,memEmail2);
       return memi;
    }
    
	 //BookRepository Ŭ���� getBookById() �޼��� ȣ��
	 public Member getMemberById(String memId) {
		 	Member memberById = memberRepository.getMemberById(memId);
	        return memberById;
	 }
	 
	 //** ���� ���� �����޼��� �������̵� **
	 public void setUpdateInfo(Member member) {  
	        memberRepository.setUpdateInfo(member);
	 }

	@Override
	public Member getfindPw(String memId, String memName, String memEmail1, String memEmail2) {
		// TODO Auto-generated method stub
		Member mem = memberRepository.getfindPw(memId,memName,memEmail1,memEmail2);
		return mem;
	} 
	
	//** ȸ������ �����޼��� �������̵� **
	  public void setDeleteMember(String memId) { 
	        memberRepository.setDeleteMember(memId);
	 }	 
	 		
}