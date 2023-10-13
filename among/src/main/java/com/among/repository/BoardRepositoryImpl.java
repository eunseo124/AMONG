package com.among.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.among.domain.Board;
import com.among.domain.Member;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
	
	//** JDBC템플릿 사용하기 위한 설정
	private JdbcTemplate template;
		
	//setJdbctemplate() 메서드는 데이터베이스 연동을 위해 작성합니다.
	@Autowired  
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	private List<Board> listOfBoards = new ArrayList<Board>();
	
    @Override
    public List<Board> getAllBoardList() { 
    	
    	//게시판 조회 쿼리 작성
    	String SQL = "SELECT boardImg, boardKey, boardTitle, member.nName, boardView, (SELECT COUNT(*) FROM reple WHERE board.boardKey) AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey ORDER BY boardRegDate";

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
    
    //member 회원가입 메소드
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
    
    //조회수 증가 메소드
    public void setbodView(int boardKey) {
    	
    	String SQL = "UPDATE board SET boardView = boardView + 1 WHERE boardKey = ?";
    	
    	this.template.update(SQL, boardKey);
    }
}