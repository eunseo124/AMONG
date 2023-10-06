package com.among.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
    	String SQL = "SELECT boardTitle, member.nName, boardView, (SELECT COUNT(*) FROM reple WHERE board.boardKey) AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey ORDER BY boardRegDate";

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
    }
}