package com.among.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.among.domain.Member;


public class MemberLoginRowMapper implements RowMapper<Member> {

      
   @Override
   public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
      // TODO Auto-generated method stub
      Member memlogin = new Member();
      memlogin.setMemKey(rs.getInt(1));
      memlogin.setMemId(rs.getString(2));
      memlogin.setMemPw(rs.getString(3));
      memlogin.setMemGrade(rs.getInt(4));
      memlogin.setnName(rs.getString(5));
      return memlogin;
   }

}