package com.among.repository;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.among.domain.*;
import com.among.repository.*;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

   private JdbcTemplate template;
   
   @Autowired
   public void setJdbcTemplate(DataSource dataSource) {
      this.template = new JdbcTemplate(dataSource);
   }
   
   private List<Member> listOfMember = new ArrayList<Member>(); //Member ��ȸ ������
   
   public MemberRepositoryImpl() {

   }
   
   
   @Override

   public List<Member> getAllMemberList(int startPage, int perPageNum) {
      // TODO Auto-generated method stub
      String SQL = "SELECT * FROM member limit "+ startPage+", " + perPageNum ;
      List<Member> listOfMember = template.query(SQL, new MemberRowMapper());
      return listOfMember;
   }
   public int membercount( ) {
	   String SQL = "select count(*) from member where delYn = 'N' ";
	   int membercount = template.queryForObject(SQL, Integer.class);
	   return membercount;
   }

   public Member getmemlist(int memKey) {
      
      String SQL  = "SELECT * FROM member where memKey = "+ memKey;
      Member memlist = template.queryForObject(SQL, new MemberRowMapper());
      return memlist;
   }
   

   public List<Member> getmflist(String keyField) {
      
      List<Member> mflist = new ArrayList<Member>();
      String SQL = "SELECT * FROM member where '" + keyField + "'like ?"; 
      mflist = template.query(SQL, new MemberRowMapper());
      return mflist;
      
   }
   

   public void setupmem(Member member) {
       System.out.println("memKey = " + member.getMemKey());
	   String SQL = "UPDATE member SET memId = ?, memPw = ?, memEmail1 = ?, memEmail2 = ?,"
               +"memName = ?, memResident1 = ?, memResident2 = ?, "
               + "memGrade = ?, nName = ? where memKey = ?";
      template.update(SQL, 
            member.getMemId(),
            member.getMemPw(),
            member.getMemEmail1(),
            member.getMemEmail2(),
            member.getMemName(),
            member.getMemResident1(),
            member.getMemResident2(),
            member.getMemGrade(),
            member.getnName(),
            member.getMemKey());
   }
   

   public Member getlogin(String memId, String memPw) {
     
   
      String SQL = "select * from member where memId = '" + memId + "' and memPw = '" + memPw+"'";
      
      Member member = template.queryForObject(SQL, new MemberRowMapper());
     
      return member;
      
   }
   

   public void getjoin(Member mem) {
      
      String SQL = "INSERT INTO member (memId,memPw,memEmail1,memEmail2,memName,memResident1,memResident2,nName)"
            + " VALUES(?,?,?,?,?,?,?,?)";
      template.update(SQL, 
               mem.getMemId(),
               mem.getMemPw(),
               mem.getMemEmail1(),
               mem.getMemEmail2(),
               mem.getMemName(),
               mem.getMemResident1(),
               mem.getMemResident2(),
               mem.getnName());
      System.out.println("dfd");
   }
   
   
   
   
   public Member getMemberById(String memId) {


       String SQL = "SELECT * FROM member where memId= '"+memId+"'";
       
       System.out.println("repository memId =" +memId);
       
       Member memberInfo = template.queryForObject(SQL, new MemberRowMapper());  


       return memberInfo;

   }
   

   public Member getfindId(String memName, String memEmail1,String memEmail2) {
      System.out.println("memrepository getfindId ���ٿϷ� = "+memName +memEmail1+memEmail2);
      Member memi = null;
      String SQL = "select * from member where memName = '" + memName + "' and memEmail1 = '"+memEmail1+"' and memEmail2 = '"+ memEmail2+"'";
      memi = template.queryForObject(SQL, new MemberRowMapper());
      System.out.println("memberRepository memId = "+memi.getMemId());   
      return memi;
   }

   public Member getfindPw(String memId,String memName, String memEmail1,String memEmail2) {
         
         Member memp = null;
         String SQL = "select * from member where memId = '"+memId+"' and memName = '" + memName + "' and memEmail1 = '"+memEmail1+"' and memEmail2 = '"+ memEmail2+"'";
         memp = template.queryForObject(SQL, new MemberRowMapper());
         return memp;
      }

   public Member getcheckId(String memId) throws Exception {
      Member result = null;
      String SQL = "select count(*) from member where memId = '"+memId+"'";
      result = template.queryForObject(SQL,new RowMapper<Member>() {
         @Override
         public Member mapRow(ResultSet rs, int rowNum) {
            Member mem = new Member();
            try {
            mem.setMemId(rs.getString(1));
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
            return mem;
         }
      });
      System.out.println("memberRepository  = " +result.getMemId());
         return result;
      }
   

   public Member getchecknName(String nName) {
      Member result = null;
      String SQL = "select count(*) from member where nName = '"+nName+"'";
      result = template.queryForObject(SQL, new RowMapper<Member>() {
         @Override
         public Member mapRow(ResultSet rs, int rowNum) {
            Member mem = new Member();
            try {
            mem.setnName(rs.getString(1));
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
            return mem;
         }
      });
      System.out.println("memberRepository  = " +result.getnName());
         return result;
   }
   

   

   public void setUpdateInfo(Member member) {  
   	
       	String SQL = "UPDATE member SET memPw = ?, memEmail1 = ?, memEmail2 = ?,"
                +"memName = ?, memResident1 = ?, memResident2 = ?,"
                + "memGrade = ?, nName = ?, delYn = ? where memId = ?";
           
        template.update(SQL, 

                member.getMemPw(),
                member.getMemEmail1(),
                member.getMemEmail2(),
                member.getMemName(),
                member.getMemResident1(),
                member.getMemResident2(),
                member.getMemGrade(),
                member.getnName(),
                member.getDelYn(),
        		member.getMemId());
       
   }
   

   public void setDeleteMember(String memId) {  
   	
       String SQL = "DELETE from member where memId = ? ";
       
       this.template.update(SQL, memId);
   }  	   
   

   public List<Board> setboardlist(int memKey,int startPage, int perPageNum) {
	   List<Board> board = null;
	   String SQL = "select * from board b inner join member m on b.memKey = m.memKey "
	   		+ "where b.memKey = " + memKey + " and b.boardCategory = 1 and b.delYn = 'N' "
	   				+ "limit "+ startPage + ", " + perPageNum;
	   board = template.query(SQL, new RowMapper<Board>() {
	         @Override
	         public Board mapRow(ResultSet rs, int rowNum) {
	            Board bo = new Board();
	            try {
	            	bo.setBoardTitle(rs.getString("boardTitle"));
	            	bo.setBoardImg(rs.getString("boardImg"));
	            	bo.setnName(rs.getString("nName"));
	            	bo.setMemGrade(rs.getInt("memGrade"));
	            	bo.setBoardCategory(rs.getInt("boardCategory"));
	            	bo.setBoardRegDate(rs.getDate("boardRegDate"));
	            	bo.setBoardModifyDate(rs.getDate("boardModifyDate"));
	            	bo.setMemKey(rs.getInt("memKey"));
	            	bo.setBoardKey(rs.getInt("boardKey"));
	            	bo.setDelYn(rs.getString("b.delYn"));
	            	
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	            return bo;
	         }
	      });
	   return board;
   }
   
   public List<Board> setboardlist2(int memKey,int startPage, int perPageNum) {
	   List<Board> board = null;
	   String SQL = "select * from board b inner join member m on b.memKey = m.memKey "
	   		+ "where b.memKey = " + memKey + " and b.boardCategory = 2 and b.delYn = 'N' "
	   				+ "limit "+ startPage + ", " + perPageNum;
	   board = template.query(SQL, new RowMapper<Board>() {
	         @Override
	         public Board mapRow(ResultSet rs, int rowNum) {
	            Board bo = new Board();
	            try {
	            	bo.setBoardTitle(rs.getString("boardTitle"));
	            	bo.setBoardImg(rs.getString("boardImg"));
	            	bo.setnName(rs.getString("nName"));
	            	bo.setMemGrade(rs.getInt("memGrade"));
	            	bo.setBoardCategory(rs.getInt("boardCategory"));
	            	bo.setBoardRegDate(rs.getDate("boardRegDate"));
	            	bo.setBoardModifyDate(rs.getDate("boardModifyDate"));
	            	bo.setMemKey(rs.getInt("memKey"));
	            	bo.setBoardKey(rs.getInt("boardKey"));
	            	bo.setDelYn(rs.getString("b.delYn"));
	            	
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	            return bo;
	         }
	      });
	   return board;
   }
   
   public List<Board> setboardlist3(int memKey,int startPage, int perPageNum) {
	   List<Board> board = null;
	   String SQL = "select * from board b inner join member m on b.memKey = m.memKey "
	   		+ "where b.memKey = " + memKey + " and b.boardCategory = 3 and b.delYn = 'N' "
	   				+ "limit "+ startPage + ", " + perPageNum;
	   board = template.query(SQL, new RowMapper<Board>() {
	         @Override
	         public Board mapRow(ResultSet rs, int rowNum) {
	            Board bo = new Board();
	            try {
	            	bo.setBoardTitle(rs.getString("boardTitle"));
	            	bo.setBoardImg(rs.getString("boardImg"));
	            	bo.setnName(rs.getString("nName"));
	            	bo.setMemGrade(rs.getInt("memGrade"));
	            	bo.setBoardCategory(rs.getInt("boardCategory"));
	            	bo.setBoardRegDate(rs.getDate("boardRegDate"));
	            	bo.setBoardModifyDate(rs.getDate("boardModifyDate"));
	            	bo.setMemKey(rs.getInt("memKey"));
	            	bo.setBoardKey(rs.getInt("boardKey"));
	            	bo.setDelYn(rs.getString("b.delYn"));
	            	
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	            return bo;
	         }
	      });
	   return board;
   }
   
   public List<Board> setboardlist4(int memKey,int startPage, int perPageNum) {
	   List<Board> board = null;
	   String SQL = "select * from board b inner join member m on b.memKey = m.memKey "
	   		+ "where b.memKey = " + memKey + " and b.boardCategory = 4 and b.delYn = 'N' "
	   				+ "limit "+ startPage + ", " + perPageNum;
	   board = template.query(SQL, new RowMapper<Board>() {
	         @Override
	         public Board mapRow(ResultSet rs, int rowNum) {
	            Board bo = new Board();
	            try {
	            	bo.setBoardTitle(rs.getString("boardTitle"));
	            	bo.setBoardImg(rs.getString("boardImg"));
	            	bo.setnName(rs.getString("nName"));
	            	bo.setMemGrade(rs.getInt("memGrade"));
	            	bo.setBoardCategory(rs.getInt("boardCategory"));
	            	bo.setBoardRegDate(rs.getDate("boardRegDate"));
	            	bo.setBoardModifyDate(rs.getDate("boardModifyDate"));
	            	bo.setMemKey(rs.getInt("memKey"));
	            	bo.setBoardKey(rs.getInt("boardKey"));
	            	bo.setDelYn(rs.getString("b.delYn"));
	            	
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	            return bo;
	         }
	      });
	   return board;
   }

   public List<Board> gethotboardlist(int memKey,int startPage, int perPageNum) { 

   	String SQL = "SELECT boardImg, boardKey, boardTitle, member.nName, boardView, (SELECT COUNT(*) FROM reple WHERE boardKey=board.boardKey) "
   			+ "AS repleCount, boardRecommend, boardRegDate, boardModifyDate, member.memGrade, boardCategory, board.delYn FROM board "
   			+ "INNER JOIN member ON board.memKey = member.memKey "
   			+ "WHERE board.memKey= "+ memKey +" and boardRecommend >= 50 and board.delYn = 'N' "
   					+ "ORDER BY boardRecommend desc limit "+ startPage + ", " + perPageNum;

   	List<Board> listOfBoards = template.query(SQL, new BoardRowMapper());  
       
   	return listOfBoards;
   }

   public List<Reple> setreplelist(int memKey,int startPage, int perPageNum) {
	   List<Reple> rep = new ArrayList();
	   String SQL = "select * from reple r inner join member m on r.memKey = m.memKey "
	   		+ "inner join board b on r.boardKey = b.boardKey "
	   		+ "where r.memKey = "+memKey + " and b.boardCategory = 1 and b.delYn = 'N' "
	   				+ "limit "+ startPage + ", " + perPageNum;
	   RowMapper<Reple> rowMapper = new RowMapper<Reple>() {
		   @Override
			public Reple mapRow(ResultSet rs, int rowNum) throws SQLException {
			   Reple re = new Reple();
			   re.setRepleKey(rs.getInt("repleKey"));
			   re.setnName(rs.getString("nName"));
			   re.setRepleContent(rs.getString("repleContent"));
			   re.setRepleRegDate(rs.getDate("repleRegDate"));
			   re.setBoardCategory(rs.getInt("boardCategory"));
			   re.setBoardKey(rs.getInt("boardKey"));
			   re.setMemKey(rs.getInt("memKey"));
			   re.setDelYn(rs.getString("b.delYn"));
			   return re;
		   }
	   };
	   rep = template.query(SQL, rowMapper);
	   return rep;
   }
   
   public List<Reple> setreplelist2(int memKey,int startPage, int perPageNum) {
	   List<Reple> rep = new ArrayList();
	   String SQL = "select * from reple r inner join member m on r.memKey = m.memKey "
	   		+ "inner join board b on r.boardKey = b.boardKey "
	   		+ "where r.memKey = "+memKey + " and b.boardCategory = 2 and b.delYn = 'N' "
	   				+ "limit "+ startPage + ", " + perPageNum;
	   RowMapper<Reple> rowMapper = new RowMapper<Reple>() {
		   @Override
			public Reple mapRow(ResultSet rs, int rowNum) throws SQLException {
			   Reple re = new Reple();
			   re.setRepleKey(rs.getInt("repleKey"));
			   re.setnName(rs.getString("nName"));
			   re.setRepleContent(rs.getString("repleContent"));
			   re.setRepleRegDate(rs.getDate("repleRegDate"));
			   re.setBoardCategory(rs.getInt("boardCategory"));
			   re.setBoardKey(rs.getInt("boardKey"));
			   re.setMemKey(rs.getInt("memKey"));
			   re.setDelYn(rs.getString("b.delYn"));
			   return re;
		   }
	   };
	   rep = template.query(SQL, rowMapper);
	   return rep;
   }
   
   public List<Reple> setreplelist3(int memKey,int startPage, int perPageNum) {
	   List<Reple> rep = new ArrayList();
	   String SQL = "select * from reple r inner join member m on r.memKey = m.memKey "
	   		+ "inner join board b on r.boardKey = b.boardKey "
	   		+ "where r.memKey = "+memKey + " and b.boardCategory = 3 and b.delYn = 'N' "
	   				+ "limit "+ startPage + ", " + perPageNum;
	   RowMapper<Reple> rowMapper = new RowMapper<Reple>() {
		   @Override
			public Reple mapRow(ResultSet rs, int rowNum) throws SQLException {
			   Reple re = new Reple();
			   re.setRepleKey(rs.getInt("repleKey"));
			   re.setnName(rs.getString("nName"));
			   re.setRepleContent(rs.getString("repleContent"));
			   re.setRepleRegDate(rs.getDate("repleRegDate"));
			   re.setBoardCategory(rs.getInt("boardCategory"));
			   re.setBoardKey(rs.getInt("boardKey"));
			   re.setMemKey(rs.getInt("memKey"));
			   re.setDelYn(rs.getString("b.delYn"));
			   return re;
		   }
	   };
	   rep = template.query(SQL, rowMapper);
	   return rep;
   }
   
   public List<Reple> setreplelist4(int memKey,int startPage, int perPageNum) {
	   List<Reple> rep = new ArrayList();
	   String SQL = "select * from reple r inner join member m on r.memKey = m.memKey "
	   		+ "inner join board b on r.boardKey = b.boardKey "
	   		+ "where r.memKey = "+memKey + " and b.boardCategory = 4 and b.delYn = 'N' "
	   				+ "limit "+ startPage + ", " + perPageNum;
	   RowMapper<Reple> rowMapper = new RowMapper<Reple>() {
		   @Override
			public Reple mapRow(ResultSet rs, int rowNum) throws SQLException {
			   Reple re = new Reple();
			   re.setRepleKey(rs.getInt("repleKey"));
			   re.setnName(rs.getString("nName"));
			   re.setRepleContent(rs.getString("repleContent"));
			   re.setRepleRegDate(rs.getDate("repleRegDate"));
			   re.setBoardCategory(rs.getInt("boardCategory"));
			   re.setBoardKey(rs.getInt("boardKey"));
			   re.setMemKey(rs.getInt("memKey"));
			   re.setDelYn(rs.getString("b.delYn"));
			   return re;
		   }
	   };
	   rep = template.query(SQL, rowMapper);
	   return rep;
   }

   public List<Reple> gethotreplelist(int memKey,int startPage, int perPageNum) { 
   	

   	String SQL = "SELECT * from reple r INNER JOIN board b ON r.boardKey = b.boardKey "
   				+ "INNER JOIN member m ON r.memKey = m.memKey WHERE r.memKey = "+ memKey
   				+ " and b.boardRecommend >= 50  and b.delYn = 'N' "
   				+ "ORDER BY b.boardRecommend DESC limit "+ startPage + ", " + perPageNum;

   	List<Reple> hlistOfBoards = template.query(SQL, new RowMapper<Reple>() {

		@Override
		public Reple mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Reple re = new Reple();
			   re.setRepleKey(rs.getInt("repleKey"));
			   re.setnName(rs.getString("nName"));
			   System.out.println("nName = " + rs.getString("nName"));
			   re.setRepleContent(rs.getString("repleContent"));
			   re.setRepleRegDate(rs.getDate("repleRegDate"));
			   re.setBoardCategory(rs.getInt("boardCategory"));
			   re.setBoardKey(rs.getInt("boardKey"));
			   re.setMemKey(rs.getInt("memKey"));
			   re.setDelYn(rs.getString("b.delYn"));
			   re.setBoardRecommend(rs.getInt("boardRecommend"));
			return re;
		}
   		
   	});  
       
   	return hlistOfBoards;
   }
   //reple delete method
   public void setdeleteReple(int repleKey) {  
   	
       String SQL = "DELETE from reple where repleKey = " +repleKey;
       
       this.template.update(SQL);
   }
   

   public void setdelboard(Board delboard) {
	  
	   String SQL = "update board set delYn = ? where boardKey = ?";
	   template.update(SQL, delboard.getDelYn(), delboard.getBoardKey());
   }
   

   //board
   public Board boardcount(int memKey) {
	   Board countbo = new Board();
	   String SQL = "SELECT COUNT(*) from board b INNER JOIN member m ON b.memKey = m.memKey "
	   		+ "WHERE b.memKey = " + memKey;
	   countbo = template.queryForObject(SQL, new RowMapper<Board>() {
		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Board bod = new Board();
			bod.setBoardKey(rs.getInt(1));
			System.out.println("boardKey =" +rs.getInt(1));
			return bod;
		}
	   });
	   return countbo;	   
   }
   
   //reple
   public Reple replecount(int memKey) {
	   Reple countre = new Reple();
	   String SQL = "SELECT COUNT(*) from reple r INNER JOIN member m ON r.memKey = m.memKey "
	   		+ "WHERE r.memKey = " + memKey;
	   countre = template.queryForObject(SQL, new RowMapper<Reple>() {

		@Override
		public Reple mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Reple rep = new Reple();
			rep.setRepleKey(rs.getInt(1));
			System.out.println("repleKey =" +rs.getInt(1));
			return rep;
		}
	   });
	   return countre;	   
   }
 //board
   public int Boardcount(int memKey) {
	   
	   String SQL = "SELECT COUNT(*) from board b INNER JOIN member m ON b.memKey = m.memKey "
	   		+ "WHERE b.memKey = " + memKey + " and b.boardCategory = 1 and b.delYn = 'N' ";
	   int countbo = template.queryForObject(SQL, Integer.class);
	   return countbo;	   
   }
   
 //board
   public int Boardcount2(int memKey) {
	   
	   String SQL = "SELECT COUNT(*) from board b INNER JOIN member m ON b.memKey = m.memKey "
	   		+ "WHERE b.memKey = " + memKey + " and b.boardCategory = 2 and b.delYn = 'N' ";
	   int countbo = template.queryForObject(SQL, Integer.class);
	   return countbo;	   
   }
   
 //board
   public int Boardcount3(int memKey) {
	   
	   String SQL = "SELECT COUNT(*) from board b INNER JOIN member m ON b.memKey = m.memKey "
	   		+ "WHERE b.memKey = " + memKey + " and b.boardCategory = 3 and b.delYn = 'N' ";
	   int countbo = template.queryForObject(SQL, Integer.class);
	   return countbo;	   
   }
   
 //board
   public int Boardcount4(int memKey) {
	   
	   String SQL = "SELECT COUNT(*) from board b INNER JOIN member m ON b.memKey = m.memKey "
	   		+ "WHERE b.memKey = " + memKey + " and b.boardCategory = 4 and b.delYn = 'N' ";
	   int countbo = template.queryForObject(SQL, Integer.class);
	   return countbo;	   
   }
   
 //board
   public int hotBoardcount(int memKey) {
	   
	   String SQL = "SELECT COUNT(*) from board b INNER JOIN member m ON b.memKey = m.memKey "
	   		+ "WHERE b.memKey = " + memKey +" and b.delYn = 'N' and b.boardRecommend >= 50";
	   int countbo = template.queryForObject(SQL, Integer.class);
	   return countbo;	   
   }
   
   //reple
   public int Replecount(int memKey) {
	   
	   String SQL = "SELECT COUNT(*) from reple r INNER JOIN member m ON r.memKey = m.memKey "
	   		+ "inner join board b on r.boardKey = b.boardKey "
	   		+ "WHERE r.memKey = " + memKey + " and b.boardCategory = 1 "
	   				+ "and b.delYn = 'N' ";
	   int countre = template.queryForObject(SQL,Integer.class);
	   return countre;	   
   }
   
 //reple
   public int Replecount2(int memKey) {
	   
	   String SQL = "SELECT COUNT(*) from reple r INNER JOIN member m ON r.memKey = m.memKey "
	   		+ "inner join board b on r.boardKey = b.boardKey "
	   		+ "WHERE r.memKey = " + memKey + " and b.boardCategory = 2 "
	   				+ "and b.delYn = 'N'";
	   int countre = template.queryForObject(SQL,Integer.class);
	   return countre;	   
   }
   
 //reple
   public int Replecount3(int memKey) {
	   
	   String SQL = "SELECT COUNT(*) from reple r INNER JOIN member m ON r.memKey = m.memKey "
	   		+ "inner join board b on r.boardKey = b.boardKey "
	   		+ "WHERE r.memKey = " + memKey + " and b.boardCategory = 3 "
	   				+ "and b.delYn = 'N'";
	   int countre = template.queryForObject(SQL,Integer.class);
	   return countre;	   
   }
   
 //reple
   public int Replecount4(int memKey) {
	   
	   String SQL = "SELECT COUNT(*) from reple r INNER JOIN member m ON r.memKey = m.memKey "
	   		+ "inner join board b on r.boardKey = b.boardKey "
	   		+ "WHERE r.memKey = " + memKey + " and b.boardCategory = 4 "
	   				+ "and b.delYn = 'N'";
	   int countre = template.queryForObject(SQL,Integer.class);
	   return countre;	   
   }
   
 //reple
   public int hotReplecount(int memKey) {
	   
	   String SQL = "SELECT COUNT(*) from reple r INNER JOIN member m ON r.memKey = m.memKey "
	   		+ "inner join board b on r.boardKey = b.boardKey "
	   		+ "WHERE r.memKey = " + memKey + " and b.delYn = 'N' and b.boardRecommend >= 50";
	   int countre = template.queryForObject(SQL,Integer.class);
	   return countre;	   
   }
		
		
}