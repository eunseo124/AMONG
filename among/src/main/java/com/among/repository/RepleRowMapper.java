package com.among.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.among.domain.Reple;



public class RepleRowMapper implements RowMapper<Reple> {

	@Override
	public Reple mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
//		System.out.println(rs.toString());
		
//		System.out.print(rs.getString("nName"));
		
		
		Reple Reple = new Reple();
		Reple.setRepleKey(rs.getInt("repleKey"));
		Reple.setRepleContent(rs.getString("repleContent"));
		Reple.setRepleRegDate(rs.getDate("repleRegDate"));
		Reple.setMemKey(rs.getInt("memKey"));
		Reple.setBoardKey(rs.getInt("boardKey"));
		Reple.setnName(rs.getString("nName"));
		Reple.setMemId(rs.getString("memId"));
		
		
//		System.out.println(Reple.toString());
		return Reple;
	}

	
	
}
