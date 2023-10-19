package com.among.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.among.domain.Board;
import com.among.domain.Member;
import com.among.domain.Reple;
import com.among.repository.MemberRepository;
import com.among.repository.MemberRowMapper;


@Service
@Controller
public interface MemberService {
   
   /*public static final MemberRepository memberRepository = null;*/
   
   List<Member> getAllMemberList(); //member db 조회문 //listOfMember
   
   List<Member> getmflist(String keyField);//member db 검색문 //mflist
   
   void setupmem(Member member); //member db 수정문  //upmem
   
   Member getmemlist(int memKey);//member db memKey로 조회문 method //memlist
   
   Member getlogin(String memId, String memPw); //member db login 메소드 //getlogin
   
   void getjoin(Member mem); //member 회원가입 메소드
   
   Member getcheckId(String memId); //member id 중복체크
   
   Member getchecknName(String nName); //member nName 중복체크
   
   Member getMemberById(String memId);//getBookById() 메서드 추가
   
   Member getfindId(String memName, String memEmail1, String memEmail2); //member db id 찾기 method
   
   void setUpdateInfo(Member member); //관리자 회원정보수정 메서드 추가

   Member getfindPw(String memId, String memName, String memEmail1, String memEmail2);
   
	//** 회원정보 삭제 메서드 추가 **
	void setDeleteMember(String memId);	   
	
	List<Board> setboardlist(int memKey);//boardlist 쿼리문

	List<Reple> setreplelist(int memKey);//replelist 쿼리문

	void setdeleteReple(int repleKey); //reple 삭제 쿼리문
	
	List<Board> gethotboardlist(int memKey);//인기게시판 조회

	void setdelboard(Board delboard); //게시글 삭제
	
	List<Reple> getreplelist(int memKey);//인기댓글조회
	
	Board boardcount(int memKey); //index페이지 회원이 쓴 게시물, 댓글 개수 method
	
	Reple replecount(int memKey); //index페이지 회원이 쓴 게시물, 댓글 개수 method
}
	
	