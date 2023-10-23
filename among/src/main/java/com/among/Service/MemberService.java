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
   
   List<Member> getAllMemberList(int startPage, int perPageNum); 
   
   List<Member> getmflist(String keyField);
   
   void setupmem(Member member); 
   
   Member getmemlist(int memKey);
   
   Member getlogin(String memId, String memPw); 
   
   void getjoin(Member mem); 
   
   Member getcheckId(String memId); 
   
   Member getchecknName(String nName); 
   
   Member getMemberById(String memId);
   
   Member getfindId(String memName, String memEmail1, String memEmail2); 
   
   void setUpdateInfo(Member member); 

   Member getfindPw(String memId, String memName, String memEmail1, String memEmail2);
   
	
	void setDeleteMember(String memId);	   
	
	List<Board> setboardlist(int memKey,int startPage, int perPageNum);

	List<Board> setboardlist2(int memKey,int startPage, int perPageNum);
	
	List<Board> setboardlist3(int memKey,int startPage, int perPageNum);

	List<Board> setboardlist4(int memKey,int startPage, int perPageNum);
	

	List<Reple> setreplelist(int memKey, int startPage, int perPageNum);
	
	List<Reple> setreplelist2(int memKey, int startPage, int perPageNum);
	
	List<Reple> setreplelist3(int memKey, int startPage, int perPageNum);
	
	List<Reple> setreplelist4(int memKey, int startPage, int perPageNum);

	void setdeleteReple(int repleKey); 
	
	List<Board> gethotboardlist(int memKey, int startPage, int perPageNum);

	void setdelboard(Board delboard); 
	
	List<Reple> gethotreplelist(int memKey, int startPage, int perPageNum);
	
	Board boardcount(int memKey); 
	
	Reple replecount(int memKey); 
	
	int membercount( );
	
	int Boardcount(int memKey); 
	
	int Boardcount2(int memKey); 
	
	int Boardcount3(int memKey); 
	
	int Boardcount4(int memKey); 

	int hotBoardcount(int memKey); 
	
	int Replecount(int memKey); 
	
	int Replecount2(int memKey); 
	
	int Replecount3(int memKey); 
	
	int Replecount4(int memKey); 
	
	int hotReplecount(int memKey); 
}
	
	