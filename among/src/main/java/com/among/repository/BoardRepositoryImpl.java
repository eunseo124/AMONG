package com.among.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.among.domain.Board;
import com.among.domain.Member;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
	

	private JdbcTemplate template;
	
	@Autowired  
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	private List<Board> listOfBoards = new ArrayList<Board>();
	
	public List<Board> getAllboardlist() {
	 List<Board> board = null;
	 String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, board.delYn, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) "
 			+ "AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey "
 			+ "where board.delYn = 'N' ORDER BY boardRegDate";
	 board = template.query(SQL, new BoardRowMapper());
		return board;	
	}
	
    @Override
    public List<Board> getAllBoardList(int startPage, int perPageNum) { 
    	
    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, board.delYn, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) "
    			+ "AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey "
    			+ "where board.delYn = 'N' and board.boardCategory = 1 ORDER BY boardRegDate limit "+ startPage+", " + perPageNum;

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
    public int countBoardList() {
    
    	String SQL = "select count(*) from board where delYn = 'N' AND boardCategory = 1 ";
    	int countBoardList = template.queryForObject(SQL,Integer.class);
    	return countBoardList;
    }
    @Override
    public List<Board> getAllBoardList2(int startPage, int perPageNum) { 
    	
    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, board.delYn, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) "
    			+ "AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey "
    			+ "where board.delYn = 'N' and board.boardCategory = 2 ORDER BY boardRegDate limit "+ startPage+", " + perPageNum;

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
    public int countBoardList2() {
    
    	String SQL = "select count(*) from board where delYn = 'N' AND boardCategory = 2 ";
    	int countBoardList = template.queryForObject(SQL,Integer.class);
    	return countBoardList;
    }
    @Override
    public List<Board> getAllBoardList3(int startPage, int perPageNum) { 
    	
    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, board.delYn, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) "
    			+ "AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey "
    			+ "where board.delYn = 'N' and board.boardCategory = 3 ORDER BY boardRegDate limit "+ startPage+", " + perPageNum;

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
    public int countBoardList3() {
    
    	String SQL = "select count(*) from board where delYn = 'N' AND boardCategory = 3 ";
    	int countBoardList = template.queryForObject(SQL,Integer.class);
    	return countBoardList;
    }
    @Override
    public List<Board> getAllBoardList4(int startPage, int perPageNum) { 
    	
    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, board.delYn, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) "
    			+ "AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey "
    			+ "where board.delYn = 'N' and board.boardCategory = 4 ORDER BY boardRegDate limit "+ startPage+", " + perPageNum;

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
    public int countBoardList4() {
    
    	String SQL = "select count(*) from board where delYn = 'N' AND boardCategory = 4 ";
    	int countBoardList = template.queryForObject(SQL,Integer.class);
    	return countBoardList;
    }
    public List<Board> getHotBoardList(int startPage, int perPageNum) { 
    	
    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) "
    			+ "AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory "
    			+ "FROM board INNER JOIN member ON board.memKey = member.memKey "
    			+ "WHERE boardRecommend >= 50 and board.delYn = 'N' "
    			+ "ORDER BY boardRecommend desc limit "+ startPage+", " + perPageNum;

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    

    public int counthotBoardList() {
    
    	String SQL = "select count(*) from board where delYn = 'N' AND boardRecommend >= 50 ";
    	int countBoardList = template.queryForObject(SQL,Integer.class);
    	return countBoardList;
    }
    
    @Override
    public List<Board> getFreeBoardList() { 
    	

    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, board.delYn, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) "
    	+"AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory "
    		+"	FROM board INNER JOIN member ON board.memKey = member.memKey AND board.boardCategory = 1"
    		+"	ORDER BY boardRegDate LIMIT 7";

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
    @Override					
    public List<Board> getGameBoardList() { 
    	

    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, board.delYn, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) "
    	+"AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory "
    		+"	FROM board INNER JOIN member ON board.memKey = member.memKey AND board.boardCategory = 2"
    		+"	ORDER BY boardRegDate LIMIT 7";
    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
    @Override
    public List<Board> getfoodBoardList() { 
    	
    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, board.delYn, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) "
    	+"AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory "
    		+"	FROM board INNER JOIN member ON board.memKey = member.memKey AND board.boardCategory = 3"
    		+"	ORDER BY boardRegDate LIMIT 7";

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
    @Override
    public List<Board> getTravleBoardList() { 
    	

    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, board.delYn, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) "
    	+"AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory "
    		+"	FROM board INNER JOIN member ON board.memKey = member.memKey AND board.boardCategory = 4"
    		+"	ORDER BY boardRegDate LIMIT 7";
    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
public List<Board> getHomeHotBoardList() { 
    	
    	String SQL = "SELECT board.delYn, boardImg, boardKey, boardTitle, member.nName, boardView, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) "
    			+ "AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory "
    			+ "FROM board INNER JOIN member ON board.memKey = member.memKey WHERE boardRecommend >= 50 ORDER BY boardRecommend desc  LIMIT 7;";

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    

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
    

    public void setbodView(int boardKey) {
    	
    	String SQL = "UPDATE board SET boardView = boardView + 1 WHERE boardKey = ?";
    	
    	this.template.update(SQL, boardKey);
    }
    

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
    
    public void setBoardmodify(Board board) {
    	
    	String SQL = "UPDATE board SET boardTitle = ?, boardContent=?, boardImg=? where boardKey=?";
    	
    	template.update(SQL,
    			board.getBoardTitle(),
    			board.getBoardContent(),
    			board.getBoardImg(),
    			board.getBoardKey());
    }
    

    public Board getBoardByBoardKey(int boardKey) {

    	Board boardInfo = new Board();
    	String SQL = "select * from board b inner join member m on b.memKey = m.memKey where b.boardKey = '"+boardKey+"'";
    	boardInfo = template.queryForObject(SQL, new RowMapper<Board>() {
    		@Override
    		public Board mapRow(ResultSet rs, int rowNum) {
    			Board bod = new Board();
    			try {
    				bod.setBoardTitle(rs.getString("boardTitle"));
    				bod.setBoardKey(rs.getInt("boardKey"));
    				bod.setBoardCategory(rs.getInt("boardCategory"));
    				bod.setBoardContent(rs.getString("boardContent"));
    				bod.setBoardImg(rs.getString("boardImg"));
    				bod.setBoardRecommend(rs.getInt("boardRecommend"));
    				bod.setnName(rs.getString("nName"));
    				bod.setDelYn(rs.getString("b.delYn"));
    				
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    			return bod;
    		}
    	});
    	return boardInfo;

    }
    
    
    //** 도서정보 수정 메서드 오버라이드 **
    public void setBoardUpdateInfo(Board board) {  
    	
        	String SQL = "UPDATE board SET boardContent = ?, boardTitle = ?,  delYn = ? where boardKey = ?";
            
         template.update(SQL, 
        		 
                 board.getBoardContent(),
                 board.getBoardTitle(),
                 board.getDelYn(),
                 board.getBoardKey()
                 );

        
    }    
    
    //議고쉶�닔利앷� 硫붿꽌�뱶
    public void setbodRecommend(int boardKey) {
    	
    	String SQL = "UPDATE board SET boardRecommend = boardRecommend + 1 WHERE boardKey = ?";
    	
    	this.template.update(SQL, boardKey);
    }
    
    
}