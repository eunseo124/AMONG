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
		member.setMemKey(rs.getInt("memKey"));
		member.setMemId(rs.getString("memId"));
		member.setMemPw(rs.getString("memPw"));
		member.setMemEmail1(rs.getString("memEmail1"));
		member.setMemEmail2(rs.getString("memEmail2"));
		member.setMemName(rs.getString("memName"));
		member.setMemResident1(rs.getInt("memResident1"));
		member.setMemResident2(rs.getInt("memResident2"));
		member.setMemJoinDate(rs.getString("memJoinDate"));
		member.setDelYn(rs.getString("delYn"));
		member.setMemGrade(rs.getInt("memGrade"));
		member.setnName(rs.getString("nName"));
		
		return member;
	}

	
	
}
