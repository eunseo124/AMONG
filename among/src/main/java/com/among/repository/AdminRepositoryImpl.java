package com.among.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.among.domain.Board;
import com.among.domain.Member;

public class AdminRepositoryImpl implements AdminRepository {
	
	private JdbcTemplate template;
	
	//setJdbctemplate() 메서드는 데이터베이스 연동을 위해 작성합니다.
	@Autowired  
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}	


	@Override
	public List<Member> getmflist(String keyField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setupmem(Member member) {
		// TODO Auto-generated method stub
					
	}

	 //boardlist 출력
	   public Board setboard(int boardKey) {
	      Board board = new Board();
	      String SQL = "select * from board b inner join member m on b.memKey = m.memKey "
	            + "inner join reple r on b.repleKey = r.repleKey where b.boardKey = " + boardKey;
	      board = template.queryForObject(SQL, new RowMapper<Board>() {
	            @Override
	            public Board mapRow(ResultSet rs, int rowNum) {
	               Board bo = new Board();
	               try {
	                  bo.setBoardTitle(rs.getString("boardTitle"));
	                  bo.setnName(rs.getString("nName"));
	                  bo.setBoardContent(rs.getString("boardContent"));
	                  bo.setBoardImg(rs.getString("boardImg"));
	                  bo.setBoardView(rs.getInt("boardView"));
	                  bo.setRepleCount(rs.getInt("repleCount"));
	                  bo.setBoardRecommend(rs.getInt("boardRecommend"));
	                  bo.setMemGrade(rs.getInt("memGrade"));
	                  bo.setBoardCategory(rs.getInt("boardCategory"));
	                  bo.setRepleKey(rs.getInt("repleKey"));
	                  bo.setBoardRegDate(rs.getDate("boardRegDate"));
	                  bo.setBoardModifyDate(rs.getDate("boardModifyDate"));
	                  bo.setMemKey(rs.getInt("memKey"));
	                  bo.setBoardKey(rs.getInt("boardKey"));
	                  
	            } catch (SQLException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            }
	               return bo;
	            }
	         });
	      return board;
	   }
	
}
