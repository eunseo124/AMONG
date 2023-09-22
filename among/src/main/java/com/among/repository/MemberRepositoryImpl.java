package com.among.repository;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.among.domain.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

	private List<Member> listOfMember = new ArrayList<Member>();
	
	public MemberRepositoryImpl() {
		
		//��� ���̺� ������ �����
		//ex) memKey�� 1��  admin(���̵�) / admin1234(��й�ȣ) / ������(�̸�) / ���:2(����d��) ���
		//�⺻������ memKey/memId/memPw/memName/memGrade������ 
		//���� -> Member member1 = new Member("id1234", "pwd1234" , "�̸�ȫ�浿", "1")
	}
	
	
	@Override
	public List<Member> getAllMemberList() {
		// TODO Auto-generated method stub
		return listOfMember;
	}
	

}
