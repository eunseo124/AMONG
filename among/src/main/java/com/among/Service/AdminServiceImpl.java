package com.among.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.among.domain.Board;
import com.among.domain.Member;
import com.among.repository.AdminRepository;
import com.among.repository.BoardRepository;
import com.among.repository.MemberRepository;

public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private MemberRepository AdminRepository;
	
	private AdminRepository adminRepository;
	


	public List<Member> getmflist(String keyField) {
		return AdminRepository.getmflist(keyField);
	}

	public void setupmem(Member member) {
		AdminRepository.setupmem(member);
	}

	public Board setboard(int boardKey) {
		Board board = null;
		board = adminRepository.setboard(boardKey);
		return board;
		
	}
 
}
