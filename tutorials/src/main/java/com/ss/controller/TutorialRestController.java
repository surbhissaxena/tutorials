package com.ss.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.dto.UserDTO;
import com.ss.service.ResultService;
import com.ss.service.SubjectService;
import com.ss.service.TutorialService;
import com.ss.service.UserService;
import com.ss.util.DBResponse;
import com.ss.util.Message;
import com.ss.util.OpCode;

@RestController
@RequestMapping(value="/tutorial")
public class TutorialRestController {

	@Autowired
	private TutorialService tutorialDAO;
	
	@RequestMapping(value = "/get/{uId}/{subId}", method = RequestMethod.GET,headers="Accept=application/json")
	public DBResponse getResult(@PathVariable int uId, @PathVariable int subId)
	{
		DBResponse dbResponse = new DBResponse();
		try {
			dbResponse = tutorialDAO.getTutorial(subId, uId);
		} catch (Exception e) {
			dbResponse.setOperationCode(OpCode.EXECPTION);
			dbResponse.setMessage(Message.SOMETHING_WENT_WRONG);
			e.printStackTrace();
		}
		return dbResponse;
	}
	
}
