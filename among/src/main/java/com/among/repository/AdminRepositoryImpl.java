package com.among.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.among.domain.Member;

public class AdminRepositoryImpl implements AdminRepository {
	
	private JdbcTemplate template;



	@Override
	public List<Member> getmflist(String keyField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setupmem(Member member) {
		// TODO Auto-generated method stub
		
	}

    
}
