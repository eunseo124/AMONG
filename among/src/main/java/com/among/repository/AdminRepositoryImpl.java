package com.among.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.among.domain.Member;

public class AdminRepositoryImpl implements AdminRepository {
	
	private JdbcTemplate template;

	@Override
	   //member db 조회문
	public List<Member> getAllMemberList() {
       // TODO Auto-generated method stub
     String SQL = "SELECT * FROM member";
     List<Member> listOfMember = template.query(SQL, new MemberRowMapper());
        return listOfMember;
    }

	@Override
	public List<Member> getmflist(String keyField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setupmem(Member member) {
		// TODO Auto-generated method stub
		
	}

    public Member getMemberById(String memId) {

        System.out.println("접근여부 확인");
        String SQL = "SELECT * FROM member where memId= '"+memId+"'";
        
        System.out.println("repository memId =" +memId);
        
        Member memberInfo = template.queryForObject(SQL, new MemberRowMapper());  
        
        System.out.println("데이터베이스 접근 성공");

        return memberInfo;

    }
    
}
