package com.among.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.among.domain.Board;

public class BoardRowMapper implements RowMapper<Board> {
	
	public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

		Board board = new Board();
		
		board.setBoardImg(rs.getString("boardImg"));
		board.setBoardKey(rs.getInt("boardKey"));
		board.setBoardTitle(rs.getString("boardTitle"));
		board.setnName(rs.getString("nName"));
		board.setBoardView(rs.getInt("boardView"));
		board.setRepleCount(rs.getInt("repleCount"));
        board.setBoardRecommend(rs.getInt("boardRecommend"));
        board.setDelYn(rs.getString("delYn"));
        board.setBoardRegDate(rs.getDate("boardRegDate"));
        board.setBoardModifyDate(rs.getDate("boardModifyDate"));
        board.setMemGrade(rs.getInt("memGrade"));
        board.setBoardCategory(rs.getInt("boardCategory"));
        
        return board;
	}
}