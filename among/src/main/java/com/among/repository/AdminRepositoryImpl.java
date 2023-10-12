package com.among.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.among.domain.Board;
import com.among.domain.Member;

public class AdminRepositoryImpl implements AdminRepository {
	
	private JdbcTemplate template;
	
	//setJdbctemplate() �޼���� �����ͺ��̽� ������ ���� �ۼ��մϴ�.
	@Autowired  
	public void setJdbctemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}	

    @Override
    public List<Board> getAllBoardList() { 
    	
    	//�Խ��� ��ȸ ���� �ۼ�
    	String SQL = "SELECT boardKey, boardTitle, member.nName, boardView,"
    			+ " (SELECT COUNT(*) FROM reple WHERE board.boardKey) AS repleCount, "
    			+ "boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey ORDER BY boardRegDate";

    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
        
    	return listOfBoards;
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
	   
}
