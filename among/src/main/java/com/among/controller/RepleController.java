package com.among.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.among.domain.Reple;

@RestController
@RequestMapping("/reply")
public class RepleController {

	@Autowired
	private RepleController replyController;
	
	/* ´ñ±Û µî·Ï */
	@PostMapping("/enroll")
	public void enrollReplyPOST(Reple dto) {
		replyController.enrollReply(dto);
	}

	private void enrollReply(Reple dto) {
		// TODO Auto-generated method stub
		
	}

	
	
}