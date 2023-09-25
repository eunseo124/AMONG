package com.among.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.among.domain.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Member member = new Member();
		member.setMemKey(rs.getInt(1));
		member.setMemId(rs.getString(2));
		member.setMemPw(rs.getString(3));
		member.setMemEmail1(rs.getString(4));
		member.setMemEmail2(rs.getString(5));
		member.setMemName(rs.getString(6));
		member.setMemResident1(rs.getInt(7));
		member.setMemResident2(rs.getInt(8));
		member.setMemJoinDate(rs.getString(9));
		member.setDelYn(rs.getString(10));
		member.setMemGrade(rs.getInt(11));
		member.setnName(rs.getString(12));
		return member;
	}

	
	
}
