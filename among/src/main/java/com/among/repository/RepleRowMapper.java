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
		Reple.setRepleKey(rs.getInt(1));
		Reple.setRepleContent(rs.getString(2));
		Reple.setRepleRegDate(rs.getDate(3));
		Reple.setMemKey(rs.getInt(4));
		Reple.setBoardKey(rs.getInt(5));
		Reple.setnName(rs.getString("nName"));
		
//		System.out.println(Reple.toString());
		return Reple;
	}

	
	
}
