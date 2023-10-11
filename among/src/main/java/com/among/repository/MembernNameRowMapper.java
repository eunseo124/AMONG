package com.among.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.among.domain.Member;

public class MembernNameRowMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member mem = new Member();
		mem.setnName(rs.getString(1));
		return mem;
	}

}
