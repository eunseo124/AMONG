package com.among.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.among.domain.Reple;
import org.springframework.stereotype.Service;
import com.among.repository.RepleRepository;



@Service
public class RepleServiceImpl implements RepleService{

	@Autowired
	private RepleServiceImpl replyMapper;
	private RepleRepository RepleRepository;
	
	/* ��۵��	@Override
	public int enrollReply(Reply dto) {
		
		int result = replyMapper.enrollReply(dto);
		
		setRating(dto.getBookId());		
		
		return result;
	} */


	@Override
	public int enrollReply(Reple Reply) {
		// TODO Auto-generated method stub
		return 0;
	}	
}