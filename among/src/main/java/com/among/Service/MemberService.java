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
   
   List<Member> getAllMemberList(); //member db ��ȸ�� //listOfMember
   
   List<Member> getmflist(String keyField);//member db �˻��� //mflist
   
   void setupmem(Member member); //member db ������  //upmem
   
   Member getmemlist(int memKey);//member db memKey�� ��ȸ�� method //memlist
   
   Member getlogin(String memId, String memPw); //member db login �޼ҵ� //getlogin
   
   void getjoin(Member mem); //member ȸ������ �޼ҵ�
   
   Member getcheckId(String memId); //member id �ߺ�üũ
   
   Member getchecknName(String nName); //member nName �ߺ�üũ
   
   Member getMemberById(String memId);//getBookById() �޼��� �߰�
   
   Member getfindId(String memId, String memEmail1, String memEmail2); //member db id ã�� method
   
   void setUpdateInfo(Member member); //������ ȸ���������� �޼��� �߰�
}