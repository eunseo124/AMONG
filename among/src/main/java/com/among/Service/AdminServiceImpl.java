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
	
	private BoardRepository boardRepository;
	 
	
	public List<Board> getAllBoardList() { 
	        // TODO Auto-generated method stub
		 return boardRepository.getAllBoardList();
	 } 	

	//member ��ȸ�� method�ҷ�����
	public List<Member> getmflist(String keyField) {
		return AdminRepository.getmflist(keyField);
	}
	//member update method�ҷ�����
	public void setupmem(Member member) {
		AdminRepository.setupmem(member);
	}

 
}
