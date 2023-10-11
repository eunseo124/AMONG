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


import com.among.domain.Member;
import com.among.repository.MemberRepository;
import com.among.repository.MemberRowMapper;


@Service
@Controller
public interface MemberService {
   
   /*public static final MemberRepository memberRepository = null;*/
   
   List<Member> getAllMemberList(); //member db 조회문 //listOfMember
   
   List<Member> getmflist(String keyField);//member db 검색문 //mflist
   
   void setupmem(Member member); //member db 수정문  //upmem
   
   List<Member> getmemlist(int memKey);//member db memKey로 조회문 method //memlist
   
   Member getlogin(String memId, String memPw); //member db login 메소드 //getlogin
   
   void getjoin(Member mem); //member 회원가입 메소드
   
	//getBookById() 메서드 추가
	Member getMemberById(String memId);
}