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
	private static final long serialVersionUID = 1L;

	private int repleKey; // ��� �ڵ�
	private String repleContent; // ����
	private Date repleRegDate; // �ۼ� ��¥
	private int memKey;
	private int boardKey;// �Խ���

	/* �⺻ ������ */
	public Reple() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* �Ϲ� ������ */
	public Reple(int repleKey, String repleContent, Date repleRegDate, int memKey, int boardKey) {
		super();
		this.repleKey = repleKey;
		this.repleContent = repleContent;
		this.repleRegDate = repleRegDate;
		this.memKey = memKey;
		this.boardKey = boardKey;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getBoardKey() {
		return boardKey;
	}

	public void setBoardKey(int boardKey) {
		this.boardKey = boardKey;
	}

	@Override
	public String toString() {
		return "Reply [ repleKey=" + repleKey + ", repleRegDate=" + repleRegDate + ", repleContent=" + repleContent
				+ ", memKey=" + memKey + "]";
	}

}