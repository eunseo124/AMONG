package com.among.domain;

public class Member {
	private int memKey; //����Ű
	private String memId;	//���̵�
	private String memPw; 	//��й�ȣ
	private String memEmail1;	//�̸���
	private String memEmail2;	//�̸���
	private String memName; 	//����
	private int memResident1;	//�ֹι�ȣ
	private int memResident2;	//�ֹι�ȣ
	private String memJoinDate;	//���Գ�¥
	private String delYn;	//���� ���� ����
	private int memGrade;	//ȸ�� ��� (�Ϲ�/������)
	private String nName; 	//�г���
	
	/* �⺻ ������ */
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getMemKey() {
		return memKey;
	}
	public void setMemKey(int memKey) {
		this.memKey = memKey;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemEmail1() {
		return memEmail1;
	}
	public void setMemEmail1(String memEmail1) {
		this.memEmail1 = memEmail1;
	}
	public String getMemEmail2() {
		return memEmail2;
	}
	public void setMemEmail2(String memEmail2) {
		this.memEmail2 = memEmail2;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getMemResident1() {
		return memResident1;
	}
	public void setMemResident1(int memResident1) {
		this.memResident1 = memResident1;
	}
	public int getMemResident2() {
		return memResident2;
	}
	public void setMemResident2(int memResident2) {
		this.memResident2 = memResident2;
	}
	public String getMemJoinDate() {
		return memJoinDate;
	}
	public void setMemJoinDate(String memJoinDate) {
		this.memJoinDate = memJoinDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public int getMemGrade() {
		return memGrade;
	}
	public void setMemGrade(int memGrade) {
		this.memGrade = memGrade;
	}
	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	
}
