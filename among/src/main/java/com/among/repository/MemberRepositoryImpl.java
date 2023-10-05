package com.among.repository;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.among.domain.*;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
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
   public List<Member> getmemlist(Integer memKey) {
      
      String SQL  = "SELECT * FROM member where memKey = "+ memKey;
      List<Member> memlist = template.query(SQL, new MemberRowMapper());
      
      return memlist;
   }
   
   //member 검색문 db
   public List<Member> getmflist(String keyField) {
      
      List<Member> mflist = new ArrayList<Member>();
      String SQL = "SELECT * FROM member where " + keyField + "like ?"; 
      mflist = template.query(SQL, new MemberRowMapper());
      return mflist;
      
   }
   
   //member db 수정문
   public void setupmem(Member member) {
      String SQL = "UPDATE member SET memId = ?, memPw = ?, memEmail1 = ?, memEmail2 = ?,"
               +"memName = ?, memResident1 = ?, memResident2 = ?, delYn = ?, "
               + "memGrade = ?, nNmae = ? where memKey = ?";
      template.update(SQL, 
            member.getMemId(),
            member.getMemPw(),
            member.getMemEmail1(),
            member.getMemEmail2(),
            member.getMemName(),
            member.getMemResident1(),
            member.getMemResident2(),
            member.getDelYn(),
            member.getMemGrade(),
            member.getnName());
   }
   
   //member db login 메소드
   public List<Member> getlogin(String memId, String memPw) {
      
      List<Member> getlogin = new ArrayList<Member>();
      String SQL = "select * from member where memId = ? and memPw = ?";
      getlogin = template.query(SQL, new MemberLoginRowMapper());
      return getlogin;
   }
   
   
   
   
}