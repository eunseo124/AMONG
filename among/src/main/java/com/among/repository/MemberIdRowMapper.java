package com.among.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.among.domain.*;

public class MemberIdRowMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Member mem = new Member();
		mem.setMemId(rs.getString(1));
		return mem;
	}

	
	
}
