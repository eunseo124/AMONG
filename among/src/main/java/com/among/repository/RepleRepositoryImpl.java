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

		// �뜝�룞�삕�뜝占� �뜝�룞�삕�뜝�떛釉앹삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝占�
		// ex) memKey�뜝�룞�삕 1�뜝�룞�삕 admin(�뜝�룞�삕�뜝�떛�벝�삕) / admin1234(�뜝�룞�삕艅섇뜝�떕占�) / �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕(�뜝�떛紐뚯삕) /
		// �뜝�룞�삕�뜝占�:2(�뜝�룞�삕�뜝�룞�삕d�뜝�룞�삕) �뜝�룞�삕�뜝占�
		// �뜝�뜦蹂멨뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 memKey/memId/memPw/memName/memGrade�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
		// �뜝�룞�삕�뜝�룞�삕 -> Member member1 = new Member("id1234", "pwd1234" , "�뜝�떛紐뚯삕�솉�뜝�뜽�룞", "1")
	}

	// �뜝�룞�삕�뜝占� �뜝�룞�삕�쉶
	@Override
	public List<Reple> getAllRepleList() {
		// TODO Auto-generated method stub
		String SQL = "select * from reple a inner join member b on a.memkey = b.memkey";
	
		List<Reple> listOfReple = template.query(SQL, new RepleRowMapper());
		return listOfReple;
	}

	// �뜝�룞�삕�뜝占� �뜝�룞�삕�뜝占�
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
	public List<Reple> getReplList(Integer boardKey) {
//		"SELECT * FROM reple a inner join member b on a.memkey = b.memkey where boardKey = " + boardKey;
		String SQL = "SELECT * " +
						"FROM reple a " + 
						"INNER JOIN member b " +
						"ON a.memKey = b.memKey " +
						"WHERE a.boardKey = " + boardKey;
		
		
		
		return template.query(SQL, new RepleRowMapper());
	}

}
