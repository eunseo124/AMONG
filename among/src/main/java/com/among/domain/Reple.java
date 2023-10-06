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
	

	private int repleKey; // 占쏙옙占� 占쌘듸옙
	private String repleContent; // 占쏙옙占쏙옙
	private Date repleRegDate; // 占쌜쇽옙 占쏙옙짜
	private int memKey;
	private int boardKey;// 占쌉쏙옙占쏙옙

	
	public Reple() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* 占싹뱄옙 占쏙옙占쏙옙占쏙옙 */
	

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

	@Override
	public String toString() {
		return "Reply [ repleKey=" + repleKey + ", repleRegDate=" + repleRegDate + ", repleContent=" + repleContent +nName
				+ ", memKey=" + memKey + "]";
	}
	
	
	private int memGrade;	//회원 등급 (일반/관리자)
	private String nName; 	//닉네임eredfad

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

	public Reple(int repleKey, String repleContent, Date repleRegDate, int memKey, int boardKey, int memGrade,
			String nName) {
		super();
		this.repleKey = repleKey;
		this.repleContent = repleContent;
		this.repleRegDate = repleRegDate;
		this.memKey = memKey;
		this.boardKey = boardKey;
		this.memGrade = memGrade;
		this.nName = nName;
	}

}