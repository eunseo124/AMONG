package com.among.repository;

import java.util.List;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.among.domain.Board;
import com.among.domain.Member;
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

   
   }

   
   @Override
   public List<Reple> getAllRepleList(int startPage, int perPageNum) {
      // TODO Auto-generated method stub
      String SQL = "select * from reple a inner join member b on a.memkey = b.memkey limit "+ startPage+", " + perPageNum;
      List<Reple> listOfReple = template.query(SQL, new RepleRowMapper());
      return listOfReple;
   }

   public int countReplelist() {
	    
   	String SQL = "select count(*) from reple";
   	int countReplelist = template.queryForObject(SQL,Integer.class);
   	return countReplelist;
   }
   
   public List<Reple> getAllreplelist() {
	   String SQL = "select * from reple r inner join member b on a.memKey = b.memKey";
	   List<Reple> listOfReple = template.query(SQL, new RepleRowMapper());
	      return listOfReple; 
   }
   
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
//   String SQL0   "SELECT * FROM reple a inner join member b on a.memkey = b.memkey where boardKey = " + boardKey;
      String SQL = "SELECT * " +
                  "FROM reple a " + 
                  "INNER JOIN member b " +
                  "ON a.memKey = b.memKey " +
                  "WHERE a.boardKey = " + boardKey;
      
      
      
      return template.query(SQL, new RepleRowMapper());
   }

   
    @Override
       public List<Board> getAllBoardList() { 
          
       
         String SQL = "SELECT boardKey, boardTitle, member.nName, boardView,"
                + " (SELECT COUNT(*) FROM reple WHERE board.boardKey) AS repleCount, "
                + "boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory FROM board INNER JOIN member ON board.memKey = member.memKey ORDER BY boardRegDate";


          List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
           
          return listOfBoards;
       }

   
    public List<Board> setboardlist(int boardKey) {
       List<Board> board = null;
      
         String SQL = "SELECT boardKey, boardTitle, member.nName, boardView,(SELECT COUNT(*) FROM reple WHERE reple.boardKey= "+boardKey+") AS repleCount, "
         		+ "boardContent,boardImg,board.repleKey,board.memKey,boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory "
         		+ "FROM board INNER JOIN member ON board.memKey = member.memKey where board.boardKey = "+boardKey+" ORDER BY boardRegDate";
         board = template.query(SQL, new RowMapper<Board>() {
               
               public Board mapRow(ResultSet rs, int rowNum) {
                  Board bo = new Board();
                  try {
                     bo.setBoardTitle(rs.getString("boardTitle"));
                     System.out.println("boardTitle =" + rs.getString("boardTitle"));
                     bo.setnName(rs.getString("nName"));
                     bo.setBoardContent(rs.getString("boardContent"));
                     bo.setBoardImg(rs.getString("boardImg"));
                     bo.setBoardView(rs.getInt("boardView"));
                     bo.setBoardRecommend(rs.getInt("boardRecommend"));
                     bo.setMemGrade(rs.getInt("memGrade"));
                     bo.setBoardCategory(rs.getInt("boardCategory"));
                     bo.setRepleKey(rs.getInt("repleKey"));
                     bo.setBoardRegDate(rs.getDate("boardRegDate"));
                     bo.setBoardModifyDate(rs.getDate("boardModifyDate"));
                     bo.setMemKey(rs.getInt("memKey"));
                     bo.setBoardKey(rs.getInt("boardKey"));
                     bo.setRepleCount(rs.getInt("repleCount"));
                     
               } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
                  return bo;
               }
            });
         System.out.println("replecontroller = boardKey" +boardKey);
         return board;
      }

     
       public void setDeleteReple(int repleKey) {  
          
           String SQL = "DELETE from reple where repleKey = " +repleKey;
           
           this.template.update(SQL);
       }    
   
}