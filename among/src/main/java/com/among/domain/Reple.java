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
	

	private int repleKey; // �뜝�룞�삕�뜝占� �뜝�뙓�벝�삕
	private String repleContent; // �뜝�룞�삕�뜝�룞�삕
	private Date repleRegDate; // �뜝�뙗�눦�삕 �뜝�룞�삕吏�
	private int memKey;
	private int boardKey;// �뜝�뙃�룞�삕�뜝�룞�삕

	
	public Reple() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* �뜝�떦諭꾩삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 */
	

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

	
	
	
	private int memGrade;	//�쉶�썝 �벑湲� (�씪諛�/愿�由ъ옄)
	private String nName; 	//�땳�꽕�엫eredfad

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
	


}