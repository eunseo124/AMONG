package com.among.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.among.domain.Board;

public class BoardRowMapper implements RowMapper<Board> {
	
	public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

		Board board = new Board();
		
		board.setBoardTitle(rs.getString(1));
		board.setnName(rs.getString(2));
		board.setBoardView(rs.getInt(3));
		board.setRepleCount(rs.getInt(4));
        board.setBoardRecommend(rs.getInt(5));
        board.setBoardRegDate(rs.getDate(6));
        board.setBoardModifyDate(rs.getDate(7));
        board.setMemGrade(rs.getInt(8));
        board.setBoardCategory(rs.getInt(9));
        
        return board;
	}
}