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
	public List<Member> getAllMemberList() {
		// TODO Auto-generated method stub
		return MemberRepository.getAllMemberList();
	}

}
