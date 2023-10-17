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
	
	//** JDBC���ø� ����ϱ� ���� ����
	private JdbcTemplate template;
		
	//setJdbctemplate() �޼���� �����ͺ��̽� ������ ���� �ۼ��մϴ�.
	@Autowired  
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	private List<Board> listOfBoards = new ArrayList<Board>();
	
    @Override
    public List<Board> getAllBoardList() { 
    	
    	//�Խ��� ��ȸ ���� �ۼ�
    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey ORDER BY boardRegDate";

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
    //�α�Խ��� ��ȸ 
    public List<Board> getHotBoardList() { 
    	
    	//�α�Խ��� ��ȸ ���� �ۼ�
    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey WHERE boardRecommend >= 50 ORDER BY boardRecommend desc;";

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
    //member ȸ������ �޼ҵ�
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
    
    //��ȸ�� ���� �޼ҵ�
    public void setbodView(int boardKey) {
    	
    	String SQL = "UPDATE board SET boardView = boardView + 1 WHERE boardKey = ?";
    	
    	this.template.update(SQL, boardKey);
    }
    
    //게시판 수정(조회)
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
    
    //게시판 수정
    public void setBoardmodi(Board board) {
    	
    	String SQL = "UPDATE board SET boardTitle=?, boardContent=?, boardImg=? where boardKey=?";
    	
    	template.update(SQL,
    			board.getBoardKey(),
    			board.getBoardContent(),
    			board.getBoardTitle(),
    			board.getBoardImg());
    }
}