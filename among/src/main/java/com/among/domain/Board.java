package com.among.domain;

import java.sql.Date;

public class Board {

	private String boardTitle;
	private String nName;
	private String boardContent;
	private String boardImg;
	private int boardView;
	private int repleCount;
	private int boardRecommend;
	private int memGrade;
	private int boardCategory;
	private int repleKey;
	private Date boardRegDate;
	private Date boardModifyDate;
	private int memKey;
	private int boardKey;
	private String delYn;
	

	
	public int getRepleKey() {
		return repleKey;
	}

	public void setRepleKey(int repleKey) {
		this.repleKey = repleKey;
	}

	public String getBoardImg() {
		return boardImg;
	}

	public void setBoardImg(String boardImg) {
		this.boardImg = boardImg;
	}

	public int getBoardKey() {
		return boardKey;
	}

	public void setBoardKey(int boardKey) {
		this.boardKey = boardKey;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getMemKey() {
		return memKey;
	}



	public void setMemKey(int memKey) {
		this.memKey = memKey;
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

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
}
