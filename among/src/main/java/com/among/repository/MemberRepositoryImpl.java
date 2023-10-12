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
   
   private List<Member> listOfMember = new ArrayList<Member>(); //Member ��ȸ ������
   
   public MemberRepositoryImpl() {
      
      //��� ���̺� ������ �����
      //ex) memKey�� 1��  admin(���̵�) / admin1234(��й�ȣ) / ������(�̸�) / ���:2(����d��) ���
      //�⺻������ memKey/memId/memPw/memName/memGrade������ 
      //���� -> Member member1 = new Member("id1234", "pwd1234" , "�̸�ȫ�浿", "1")
   }
   
   
   @Override
   //member db ��ȸ��
   public List<Member> getAllMemberList() {
      // TODO Auto-generated method stub
      String SQL = "SELECT * FROM member";
      List<Member> listOfMember = template.query(SQL, new MemberRowMapper());
      return listOfMember;
   }
   
   //member db �α��ν� memKey�� ��ȸ method
   public Member getmemlist(int memKey) {
      
      String SQL  = "SELECT * FROM member where memKey = "+ memKey;
      Member memlist = template.queryForObject(SQL, new MemberRowMapper());
      return memlist;
   }
   
   //member �˻��� db
   public List<Member> getmflist(String keyField) {
      
      List<Member> mflist = new ArrayList<Member>();
      String SQL = "SELECT * FROM member where '" + keyField + "'like ?"; 
      mflist = template.query(SQL, new MemberRowMapper());
      return mflist;
      
   }
   
   //member db ������
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
   
   //member db login �޼ҵ�
   public Member getlogin(String memId, String memPw) {
     
   
      String SQL = "select * from member where memId = '" + memId + "' and memPw = '" + memPw+"'";
      
      Member member = template.queryForObject(SQL, new MemberRowMapper());
     
      return member;
      
   }
   
   //member ȸ������ �޼ҵ�
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

       System.out.println("���ٿ��� Ȯ��");
       String SQL = "SELECT * FROM member where memId= '"+memId+"'";
       
       System.out.println("repository memId =" +memId);
       
       Member memberInfo = template.queryForObject(SQL, new MemberRowMapper());  
       
       System.out.println("�����ͺ��̽� ���� ����");

       return memberInfo;

   }
   
 //member db id ã�� method
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
   //member db Pw ã�� method
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
   
   //member id �ߺ�üũ
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
   
   //member nName �ߺ�üũ
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
   

   
   //** �������� ���� �޼��� �������̵� **
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
   
   //** ȸ������ ���� �޼��� �������̵� **
   //setDeleteMember() �޼���� memId�� ���� �ش� ȸ���� �����ͺ��̽� ���� �����մϴ�.
   public void setDeleteMember(String memId) {  
   	
       String SQL = "DELETE from member where memId = ? ";
       
       this.template.update(SQL, memId);
   }  	   
   
}