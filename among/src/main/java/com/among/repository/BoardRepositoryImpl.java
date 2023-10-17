package com.among.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.among.domain.Board;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
	
	//** JDBC占쏙옙占시몌옙 占쏙옙占쏙옙歐占� 占쏙옙占쏙옙 占쏙옙占쏙옙
	private JdbcTemplate template;
		
	//setJdbctemplate() 占쌨쇽옙占쏙옙占� 占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쌜쇽옙占쌌니댐옙.
	@Autowired  
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	private List<Board> listOfBoards = new ArrayList<Board>();
	
    @Override
    public List<Board> getAllBoardList() { 
    	
    	//占쌉쏙옙占쏙옙 占쏙옙회 占쏙옙占쏙옙 占쌜쇽옙
    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, board.delYn, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey ORDER BY boardRegDate";

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
    //占싸깍옙督占쏙옙占� 占쏙옙회 
    public List<Board> getHotBoardList() { 
    	
    	//占싸깍옙督占쏙옙占� 占쏙옙회 占쏙옙占쏙옙 占쌜쇽옙
    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey WHERE boardRecommend >= 50 ORDER BY boardRecommend desc;";

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
    //member 회占쏙옙占쏙옙占쏙옙 占쌨소듸옙
    public void getboardWrite(Board board) {
 	   
 	   String SQL = "INSERT INTO board(memKey, boardContent, boardCategory, boardTitle, boardImg)"
 	   		+ " VALUES(?,?,?,?,?)";
 	   template.update(SQL, 
 	            board.getMemKey(),
 	            board.getBoardContent(),
 	            board.getBoardCategory(),
 	            board.getBoardTitle(),
 	            board.getBoardImg());
    }
    
    //占쏙옙회占쏙옙 占쏙옙占쏙옙 占쌨소듸옙
    public void setbodView(int boardKey) {
    	
    	String SQL = "UPDATE board SET boardView = boardView + 1 WHERE boardKey = ?";
    	
    	this.template.update(SQL, boardKey);
    }
    
    //寃뚯떆�뙋 �닔�젙(議고쉶)
    public Board getBoardmodi(int boardKey) {
    	Board board = new Board();
    	String SQL = "select * from board where boardKey = '"+boardKey+"'";
    	board = template.queryForObject(SQL, new RowMapper<Board>() {
    		@Override
    		public Board mapRow(ResultSet rs, int rowNum) {
    			Board bod = new Board();
    			try {
    				bod.setBoardTitle(rs.getString("boardTitle"));
    				bod.setBoardKey(rs.getInt("boardKey"));
    				bod.setBoardCategory(rs.getInt("boardCategory"));
    				bod.setBoardContent(rs.getString("boardContent"));
    				bod.setBoardImg(rs.getString("boardImg"));
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    			return bod;
    		}
    	});
    	return board;
    }
    
    //寃뚯떆�뙋 �닔�젙
    public void setBoardmodi(Board board) {
    	
    	String SQL = "UPDATE board SET boardTitle=?, boardContent=?, boardImg=? where boardKey=?";
    	
    	template.update(SQL,
    			board.getBoardKey(),
    			board.getBoardContent(),
    			board.getBoardTitle(),
    			board.getBoardImg());
    }
    
    
}