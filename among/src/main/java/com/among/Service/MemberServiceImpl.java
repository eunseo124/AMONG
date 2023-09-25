package com.among.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.among.domain.Member;
import org.springframework.stereotype.Service;
import com.among.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository MemberRepository;
	
	@Override
	//member list method�ҷ�����
	public List<Member> getAllMemberList() {
		// TODO Auto-generated method stub
		List<Member> listOfMember = MemberRepository.getAllMemberList();
		return listOfMember;
	}
	//member ��ȸ�� method�ҷ�����
	public List<Member> getmflist(String keyField) {
		return MemberRepository.getmflist(keyField);
	}
	//member update method�ҷ�����
	public void setupmem(Member member) {
		MemberRepository.setupmem(member);
	}
}
