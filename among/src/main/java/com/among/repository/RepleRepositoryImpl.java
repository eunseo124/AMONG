package com.among.repository;

import java.util.List;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.among.domain.Board;
import com.among.domain.Reple;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class RepleRepositoryImpl implements RepleRepository {

	private JdbcTemplate template;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	private List<Reple> listOfReple = new ArrayList<Reple>();

	public RepleRepositoryImpl() {

		// 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占� 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈뼓�뇡�빘�굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�
		// ex) memKey占쎈쐻占쎈짗占쎌굲 1占쎈쐻占쎈짗占쎌굲 admin(占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈뼓占쎈쿈占쎌굲) / admin1234(占쎈쐻占쎈짗占쎌굲�뎲�꼪�쐻占쎈뼍�뜝占�) / 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲(占쎈쐻占쎈뼓筌뤿슣�굲) /
		// 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�:2(占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲d占쎈쐻占쎈짗占쎌굲) 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�
		// 占쎈쐻占쎈쑆癰귣ŀ�쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 memKey/memId/memPw/memName/memGrade占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲
		// 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 -> Member member1 = new Member("id1234", "pwd1234" , "占쎈쐻占쎈뼓筌뤿슣�굲占쎌냹占쎈쐻占쎈쑞占쎈짗", "1")
	}

	// 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占� 占쎈쐻占쎈짗占쎌굲占쎌돳
	@Override
	public List<Reple> getAllRepleList() {
		// TODO Auto-generated method stub
		String SQL = "select * from reple a inner join member b on a.memkey = b.memkey";
	
		List<Reple> listOfReple = template.query(SQL, new RepleRowMapper());
		return listOfReple;
	}

	// 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占� 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�
	public void setNewReple(Reple reple) {

		String SQL = "INSERT INTO reple (repleKey, repleContent, repleRegDate, memKey, boardKey) "
				+ "VALUES (?, ?, ?, ?,?,?)";
	
		template.update(SQL, reple.getRepleKey(), reple.getRepleContent(), reple.getRepleRegDate(), reple.getMemKey(),
				reple.getBoardKey());

		return;
	}
	
	public Integer saveReple(Reple reple) {
		
		String SQL = "INSERT INTO reple (repleContent, memKey, boardKey) VALUES (?,?,?)";
		
		template.update(SQL,reple.getRepleContent(), reple.getMemKey(),
				reple.getBoardKey());
		
		return 1;
	}

	@Override
	public List<Reple> getRepleList(Integer boardKey) {
//	String SQL0	"SELECT * FROM reple a inner join member b on a.memkey = b.memkey where boardKey = " + boardKey;
		String SQL = "SELECT * " +
						"FROM reple a " + 
						"INNER JOIN member b " +
						"ON a.memKey = b.memKey " +
						"WHERE a.boardKey = " + boardKey;
		
		
		
		return template.query(SQL, new RepleRowMapper());
	}

	
	 @Override
	    public List<Board> getAllBoardList() { 
	    	
	    	//�뜝�뙃�룞�삕�뜝�룞�삕 �뜝�룞�삕�쉶 �뜝�룞�삕�뜝�룞�삕 �뜝�뙗�눦�삕
		   String SQL = "SELECT boardKey, boardTitle, member.nName, boardView,"
	    			+ " (SELECT COUNT(*) FROM reple WHERE board.boardKey) AS repleCount, "
	    			+ "boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey ORDER BY boardRegDate";


	    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
	        
	    	return listOfBoards;
	    }

	 //boardlist 출력
	 public List<Board> setboardlist(int boardKey) {
		 List<Board> board = null;
		 System.out.println("setboardlist 넘어옴 = "+boardKey);
	      String SQL = "select * from board b inner join member m on b.memKey = m.memKey "
	            + "inner join reple r on b.repleKey = r.repleKey order by b.boardKey = " + boardKey;
	      board = template.query(SQL, new RowMapper<Board>() {
	            @Override
	            public Board mapRow(ResultSet rs, int rowNum) {
	               Board bo = new Board();
	               try {
	                  bo.setBoardTitle(rs.getString("boardTitle"));
	                  System.out.println("boardTitle =" + rs.getString("boardTitle"));
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