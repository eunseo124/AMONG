package com.among.domain;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Board implements Serializable {

	private String boardTitle;
	private String nName;
	private int boardView;
	private int repleCount;
	private int boardRecommend;
	private int memGrade;
	private int boardCategory;
	private Date boardRegDate;
	private Date boardModifyDate;
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public int getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(int boardCategory) {
		this.boardCategory = boardCategory;
	}

	public int getMemGrade() {
		return memGrade;
	}
	public void setMemGrade(int memGrade) {
		this.memGrade = memGrade;
	}
	
	public int getBoardView() {
		return boardView;
	}
	public void setBoardView(int boardView) {
		this.boardView = boardView;
	}

	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}

	public int getRepleCount() {
		return repleCount;
	}
	public void setRepleCount(int repleCount) {
		this.repleCount = repleCount;
	}

	public int getBoardRecommend() {
		return boardRecommend;
	}
	public void setBoardRecommend(int boardRecommend) {
		this.boardRecommend = boardRecommend;
	}

	public Date getBoardRegDate() {
		return boardRegDate;
	}
	public void setBoardRegDate(Date boardRegDate) {
		this.boardRegDate = boardRegDate;
	}


	public Date getBoardModifyDate() {
		return boardModifyDate;
	}
	public void setBoardModifyDate(Date boardModifyDate) {
		this.boardModifyDate = boardModifyDate;
	}
	
}
