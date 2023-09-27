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
       
	 private int repleKey; // 댓글 코드
	    private String repleContent; // 내용
	    private Date repleRegDate;      // 작성 날짜
		private int memKey;
		private int boardKey;// 게시판
	 
		/* 기본 생성자  */
		public Reple() {
			super();
			// TODO Auto-generated constructor stub
		}

		  /*일반 생성자 */
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
			return "Reply [ repleKey=" + repleKey + ", repleRegDate=" + repleRegDate
					+ ", repleContent=" + repleContent + ", memKey=" + memKey + "]";
		}		 
	    
	    
}	    