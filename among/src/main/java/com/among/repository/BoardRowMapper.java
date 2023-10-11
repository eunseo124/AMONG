package com.among.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.among.domain.Board;

public class BoardRowMapper implements RowMapper<Board> {
	
	public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

		Board board = new Board();
		
		board.setBoardKey(rs.getInt(1));
		board.setBoardTitle(rs.getString(2));
		board.setnName(rs.getString(3));
		board.setBoardView(rs.getInt(4));
		board.setRepleCount(rs.getInt(5));
        board.setBoardRecommend(rs.getInt(6));
        board.setBoardRegDate(rs.getDate(7));
        board.setBoardModifyDate(rs.getDate(8));
        board.setMemGrade(rs.getInt(9));
        board.setBoardCategory(rs.getInt(10));
        
        return board;
	}
}