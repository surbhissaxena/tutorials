package com.ss.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.dto.AnswerSheetDTO;
import com.ss.dto.UserDTO;
import com.ss.service.AnswerSheetService;
import com.ss.service.UserService;
import com.ss.util.DBResponse;
import com.ss.util.Message;
import com.ss.util.OpCode;

@RestController
@RequestMapping("/answersheet")
public class AnswerSheetRestController {

	@Autowired
	private AnswerSheetService answerSheetService;
	
	
	@RequestMapping(value = "/update/answer/", method = RequestMethod.POST,headers = "Accept=application/json" ,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DBResponse login(@RequestBody AnswerSheetDTO dto ){
		DBResponse dbResponse = new DBResponse();
		try {
			dbResponse = answerSheetService.updateAnswerSheet(dto);
		} catch (Exception e) {
			dbResponse.setOperationCode(OpCode.EXECPTION);
			dbResponse.setMessage(Message.SOMETHING_WENT_WRONG);
			e.printStackTrace();
		}
		return dbResponse;
	}
}
