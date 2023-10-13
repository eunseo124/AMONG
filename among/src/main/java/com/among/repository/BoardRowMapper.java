package com.among.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.among.domain.Board;

public class BoardRowMapper implements RowMapper<Board> {
	
	public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

		Board board = new Board();
		
		board.setBoardImg(rs.getString(1));
		board.setBoardKey(rs.getInt(2));
		board.setBoardTitle(rs.getString(3));
		board.setnName(rs.getString(4));
		board.setBoardView(rs.getInt(5));
		board.setRepleCount(rs.getInt(6));
        board.setBoardRecommend(rs.getInt(7));
        board.setBoardRegDate(rs.getDate(8));
        board.setBoardModifyDate(rs.getDate(9));
        board.setMemGrade(rs.getInt(10));
        board.setBoardCategory(rs.getInt(11));
        
        return board;
	}
}