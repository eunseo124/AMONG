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

		// 占쏙옙占� 占쏙옙占싱븝옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占�
		// ex) memKey占쏙옙 1占쏙옙 admin(占쏙옙占싱듸옙) / admin1234(占쏙옙橘占싫�) / 占쏙옙占쏙옙占쏙옙(占싱몌옙) /
		// 占쏙옙占�:2(占쏙옙占쏙옙d占쏙옙) 占쏙옙占�
		// 占썩본占쏙옙占쏙옙占쏙옙 memKey/memId/memPw/memName/memGrade占쏙옙占쏙옙占쏙옙
		// 占쏙옙占쏙옙 -> Member member1 = new Member("id1234", "pwd1234" , "占싱몌옙홍占썸동", "1")
	}

	// 占쏙옙占� 占쏙옙회
	@Override
	public List<Reple> getAllRepleList() {
		// TODO Auto-generated method stub
		String SQL = "select * from reple a inner join member b on a.memkey = b.memkey";
	
		List<Reple> listOfReple = template.query(SQL, new RepleRowMapper());
		return listOfReple;
	}

	// 占쏙옙占� 占쏙옙占�
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
