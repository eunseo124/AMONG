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

		// �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥堉볩옙�눀占쎈튂占쎄뎡 �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援� �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶占쎈쐻�뜝占�
		// ex) memKey�뜝�럥�맶�뜝�럥吏쀥뜝�럩援� 1�뜝�럥�맶�뜝�럥吏쀥뜝�럩援� admin(�뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥堉볟뜝�럥荑덂뜝�럩援�) / admin1234(�뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�렡占쎄섈占쎌맶�뜝�럥堉랃옙�쐻�뜝占�) / �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援�(�뜝�럥�맶�뜝�럥堉볡춯琉우뒩占쎄뎡) /
		// �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶占쎈쐻�뜝占�:2(�뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援쾑�뜝�럥�맶�뜝�럥吏쀥뜝�럩援�) �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶占쎈쐻�뜝占�
		// �뜝�럥�맶�뜝�럥�몘�솻洹Ｅ�占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援� memKey/memId/memPw/memName/memGrade�뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援�
		// �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥吏쀥뜝�럩援� -> Member member1 = new Member("id1234", "pwd1234" , "�뜝�럥�맶�뜝�럥堉볡춯琉우뒩占쎄뎡�뜝�럩�꺓�뜝�럥�맶�뜝�럥�몶�뜝�럥吏�", "1")
	}

	// �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럩�뤂
	@Override
	public List<Reple> getAllRepleList() {
		// TODO Auto-generated method stub
		String SQL = "select * from reple a inner join member b on a.memkey = b.memkey";
	
		List<Reple> listOfReple = template.query(SQL, new RepleRowMapper());
		return listOfReple;
	}

	// �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶占쎈쐻�뜝占�
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
	    	
	    	//占쎈쐻占쎈셾占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎌돳 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈솙占쎈닰占쎌굲
		   String SQL = "SELECT boardKey, boardTitle, member.nName, boardView,"
	    			+ " (SELECT COUNT(*) FROM reple WHERE board.boardKey) AS repleCount, "
	    			+ "boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey ORDER BY boardRegDate";


	    	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
	        
	    	return listOfBoards;
	    }

	 //boardlist 異쒕젰
	 public List<Board> setboardlist(int boardKey) {
		 List<Board> board = null;
		 System.out.println("setboardlist �꽆�뼱�샂 = "+boardKey);
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

	    //setDeleteReple() 메서드는 repleKey에 대한 해당 도서를 데이터베이스 에서 삭제합니다.
	    public void setDeleteReple(int repleKey) {  
	    	
	        String SQL = "DELETE from reple where repleKey = " +repleKey;
	        
	        this.template.update(SQL);
	    }	 
	
}