package com.among.repository;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.among.domain.Reple;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
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

		// ��� ���̺� ������ �����
		// ex) memKey�� 1�� admin(���̵�) / admin1234(��й�ȣ) / ������(�̸�) /
		// ���:2(����d��) ���
		// �⺻������ memKey/memId/memPw/memName/memGrade������
		// ���� -> Member member1 = new Member("id1234", "pwd1234" , "�̸�ȫ�浿", "1")
	}

	// ��� ��ȸ
	@Override
	public List<Reple> getAllRepleList() {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM reple";
		List<Reple> listOfReple = template.query(SQL, new RepleRowMapper());
		return listOfReple;
	}

	// ��� ���
	public void setNewReple(Reple reple) {

		String SQL = "INSERT INTO reple (repleKey, repleContent, repleRegDate, memKey, boardKey) "
				+ "VALUES (?, ?, ?, ?,?)";

		template.update(SQL, reple.getRepleKey(), reple.getRepleContent(), reple.getRepleRegDate(), reple.getMemKey(),
				reple.getBoardKey());

		return;
	}
	
	public Integer saveReple(Reple reple) {
		
		String SQL = "INSERT INTO reple (repleKey, repleContent, repleRegDate, memKey, boardKey) "
				+ "VALUES (?, ?, ?, ?,?)";

		template.update(SQL, reple.getRepleKey(), reple.getRepleContent(), reple.getRepleRegDate(), reple.getMemKey(),
				reple.getBoardKey());
		
		return 1;
	}

	@Override
	public List<Reple> getReplList(Integer boardKey) {
		String SQL = "SELECT * FROM reple where boardKey = " + boardKey;
		
		List<Reple> repleList = new ArrayList<>();
		
		
		return template.query(SQL, new RepleRowMapper());
	}

}
