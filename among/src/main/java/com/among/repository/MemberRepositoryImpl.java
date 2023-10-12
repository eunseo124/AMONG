package com.among.repository;

import java.util.List;
import java.util.Map;
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
   
   private List<Member> listOfMember = new ArrayList<Member>(); //Member 조회 쿼리문
   
   public MemberRepositoryImpl() {
      
      //멤버 테이블 데이터 저장소
      //ex) memKey가 1인  admin(아이디) / admin1234(비밀번호) / 관리자(이름) / 등급:2(관리d자) 등등
      //기본생성자 memKey/memId/memPw/memName/memGrade설정시 
      //예시 -> Member member1 = new Member("id1234", "pwd1234" , "이름홍길동", "1")
   }
   
   
   @Override
   //member db 조회문
   public List<Member> getAllMemberList() {
      // TODO Auto-generated method stub
      String SQL = "SELECT * FROM member";
      List<Member> listOfMember = template.query(SQL, new MemberRowMapper());
      return listOfMember;
   }
   
   //member db 로그인시 memKey로 조회 method
   public Member getmemlist(int memKey) {
      
      String SQL  = "SELECT * FROM member where memKey = "+ memKey;
      Member memlist = template.queryForObject(SQL, new MemberRowMapper());
      return memlist;
   }
   
   //member 검색문 db
   public List<Member> getmflist(String keyField) {
      
      List<Member> mflist = new ArrayList<Member>();
      String SQL = "SELECT * FROM member where '" + keyField + "'like ?"; 
      mflist = template.query(SQL, new MemberRowMapper());
      return mflist;
      
   }
   
   //member db 수정문
   public void setupmem(Member member) {
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
   
   //member db login 메소드
   public Member getlogin(String memId, String memPw) {
     
   
      String SQL = "select * from member where memId = '" + memId + "' and memPw = '" + memPw+"'";
      
      Member member = template.queryForObject(SQL, new MemberRowMapper());
     
      return member;
      
   }
   
   //member 회원가입 메소드
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

       System.out.println("접근여부 확인");
       String SQL = "SELECT * FROM member where memId= '"+memId+"'";
       
       System.out.println("repository memId =" +memId);
       
       Member memberInfo = template.queryForObject(SQL, new MemberRowMapper());  
       
       System.out.println("데이터베이스 접근 성공");

       return memberInfo;

   }
   
 //member db id 찾기 method
   public Member getfindId(String memName, String memEmail1,String memEmail2) {
      
      Member mem = null;
      String SQL = "select count(*) from member where memName = '" + memName + "' and memEmail1 = '"+memEmail1+"' and memEmail2 = '"+ memEmail2+"'";
      mem = template.queryForObject(SQL, new RowMapper<Member>() {
          @Override
          public Member mapRow(ResultSet rs, int rowNum) {
             Member member = new Member();
             try {
             member.setMemId(rs.getString(1));
          } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
          }
             return member;
          }
       });
      return mem;
   }
   //member db Pw 찾기 method
   public Member getfindPw(String memId,String memName, String memEmail1,String memEmail2) {
         
         Member mem = null;
         String SQL = "select count(*) from member where memId = '"+memId+"' and memName = '" + memName + "' and memEamil1 = '"+memEmail1+"' and memEmail2 = '"+ memEmail2+"'";
         mem = template.queryForObject(SQL, new RowMapper<Member>() {
             @Override
             public Member mapRow(ResultSet rs, int rowNum) {
                Member member = new Member();
                try {
                member.setMemPw(rs.getString(1));
             } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
             }
                return member;
             }
          });
         return mem;
      }
   
   //member id 중복체크
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
   
   //member nName 중복체크
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
   

   
   //** 도서정보 수정 메서드 오버라이드 **
   public void setUpdateInfo(Member member) {  
   	
       	String SQL = "UPDATE member SET memPw = ?, memEmail1 = ?, memEmail2 = ?,"
                +"memName = ?, memResident1 = ?, memResident2 = ?,"
                + "memGrade = ?, nName = ? where memId = ?";
           
        template.update(SQL, 

                member.getMemPw(),
                member.getMemEmail1(),
                member.getMemEmail2(),
                member.getMemName(),
                member.getMemResident1(),
                member.getMemResident2(),
                member.getMemGrade(),
                member.getnName(),
        		member.getMemId());
       
   }
   
   //** 회원정보 삭제 메서드 오버라이드 **
   //setDeleteMember() 메서드는 memId에 대한 해당 회원를 데이터베이스 에서 삭제합니다.
   public void setDeleteMember(String memId) {  
   	
       String SQL = "DELETE from member where memId = ? ";
       
       this.template.update(SQL, memId);
   }  	   
   
}