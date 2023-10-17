package com.among.domain;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;

/**
 * Servlet implementation class reple
 */
public class Reple extends HttpServlet {
	

	private int repleKey; // 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占� 占쎈쐻占쎈솓占쎈쿈占쎌굲
	private String repleContent; // 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲
	private Date repleRegDate; // 占쎈쐻占쎈솙占쎈닰占쎌굲 占쎈쐻占쎈짗占쎌굲筌욑옙
	private int memKey;
	private int boardKey;// 占쎈쐻占쎈셾占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲
	private String delYn;
	
	public Reple() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* 占쎈쐻占쎈뼣獄�袁⑹굲 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 */
	

	public int getRepleKey() {
		return repleKey;
	}

	public void setRepleKey(int repleKey) {
		this.repleKey = repleKey;
	}

	public String getRepleContent() {
		return repleContent;
	}

	public void setRepleContent(String repleContent) {
		this.repleContent = repleContent;
	}

	public Date getRepleRegDate() {
		return repleRegDate;
	}

	public void setRepleRegDate(Date repleRegDate) {
		this.repleRegDate = repleRegDate;
	}

	public int getMemKey() {
		return memKey;
	}

	public void setMemKey(int memKey) {
		this.memKey = memKey;
	}

	

	public int getBoardKey() {
		return boardKey;
	}

	public void setBoardKey(int boardKey) {
		this.boardKey = boardKey;
	}

	
	
	
	private int memGrade;	//占쎌돳占쎌뜚 占쎈쾻疫뀐옙 (占쎌뵬獄쏉옙/�꽴占썹뵳�딆쁽)
	private String nName; 	//占쎈빏占쎄퐬占쎌뿫eredfad

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

	
	
	
	
	private String memId;
	
	private int boardCategory;


	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(int boardCategory) {
		this.boardCategory = boardCategory;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	


}