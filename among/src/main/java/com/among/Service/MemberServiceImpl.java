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
   public List<Member> getmemlist(int memKey){
      List<Member> memlist = memberRepository.getmemlist(memKey);
      return memlist;
   }
   
   //member db login �޼ҵ� 
   public List<Member> getlogin(String memId, String memPw) {
      return memberRepository.getlogin(memId, memPw);
   }
}