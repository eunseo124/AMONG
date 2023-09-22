package com.among.repository;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.among.domain.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

	private List<Member> listOfMember = new ArrayList<Member>();
	
	public MemberRepositoryImpl() {
		
		//멤버 테이블 데이터 저장소
		//ex) memKey가 1인  admin(아이디) / admin1234(비밀번호) / 관리자(이름) / 등급:2(관리d자) 등등
		//기본생성자 memKey/memId/memPw/memName/memGrade설정시 
		//예시 -> Member member1 = new Member("id1234", "pwd1234" , "이름홍길동", "1")
	}
	
	
	@Override
	public List<Member> getAllMemberList() {
		// TODO Auto-generated method stub
		return listOfMember;
	}
	

}
