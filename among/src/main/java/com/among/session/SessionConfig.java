package com.among.session;

public class SessionConfig {
   
   private int memKey;
   private String MemId;
   private String memPw;
   private int memGrade;
   private String nName;
   
   /* 기본 생성자 */
   public SessionConfig() {
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
      return MemId;
   }
   public void setMemId(String memId) {
      MemId = memId;
   }
   public String getMemPw() {
      return memPw;
   }
   public void setMemPw(String memPw) {
      this.memPw = memPw;
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