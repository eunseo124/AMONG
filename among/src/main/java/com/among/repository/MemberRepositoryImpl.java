package com.among.repository;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.among.domain.Member;
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
	
	//member �˻��� db
	public List<Member> getmflist(String keyField) {
		
		List<Member> mflist = new ArrayList<Member>();
		String SQL = "SELECT * FROM member where " + keyField + "like ?"; 
		mflist = template.query(SQL, new MemberRowMapper());
		return mflist;
		
	}
	
	//member db ������
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
	

}
