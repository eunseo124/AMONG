package com.among.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.among.domain.Member;

public class AdminRepositoryImpl implements AdminRepository {
	
	private JdbcTemplate template;

	@Override
	   //member db ��ȸ��
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

        System.out.println("���ٿ��� Ȯ��");
        String SQL = "SELECT * FROM member where memId= '"+memId+"'";
        
        System.out.println("repository memId =" +memId);
        
        Member memberInfo = template.queryForObject(SQL, new MemberRowMapper());  
        
        System.out.println("�����ͺ��̽� ���� ����");

        return memberInfo;

    }
    
}
