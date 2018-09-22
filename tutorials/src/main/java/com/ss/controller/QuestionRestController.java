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
import com.ss.service.QuestionService;
import com.ss.service.SubjectService;
import com.ss.service.UserService;
import com.ss.util.DBResponse;
import com.ss.util.Message;
import com.ss.util.OpCode;

@RestController
@RequestMapping("question")
public class QuestionRestController {

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/get/{subId}", method = RequestMethod.GET,headers="Accept=application/json")
	public DBResponse getAllQuestion(@PathVariable int subId)
	{
		DBResponse dbResponse = new DBResponse();
		try {
			dbResponse = questionService.getAllQuestionBySubjectId(subId);
		} catch (Exception e) {
			dbResponse.setOperationCode(OpCode.EXECPTION);
			dbResponse.setMessage(Message.SOMETHING_WENT_WRONG);
			e.printStackTrace();
		}
		return dbResponse;
	}
	
	
//	@RequestMapping(value = "/countries", method = RequestMethod.GET,headers="Accept=application/json")
//	public List<Country> getCountries()
//	{
//		List<Country> listOfCountries = new ArrayList<Country>();
//		listOfCountries=createCountryList();
//		return listOfCountries;
//	}

//	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET,headers="Accept=application/json")
//	public Country getCountryById(@PathVariable int id)
//	{
//		List<Country> listOfCountries = new ArrayList<Country>();
//		listOfCountries=createCountryList();
//
//		for (Country country: listOfCountries) {
//			if(country.getId()==id)
//				return country;
//		}
//		
//		return null;
//	}

// Utiliy method to create country list.
//	public List<Country> createCountryList()
//	{
//		Country indiaCountry=new Country(1, "India");
//		Country chinaCountry=new Country(4, "China");
//		Country nepalCountry=new Country(3, "Nepal");
//		Country bhutanCountry=new Country(2, "Bhutan");
//
//		List<Country> listOfCountries = new ArrayList<Country>();
//		listOfCountries.add(indiaCountry);
//		listOfCountries.add(chinaCountry);
//		listOfCountries.add(nepalCountry);
//		listOfCountries.add(bhutanCountry);
//		return listOfCountries;
//	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST,headers = "Accept=application/json" ,consumes = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody DBResponse login(@RequestBody UserDTO dto ){
//		System.out.println("dto "+dto);
//		DBResponse dbResponse = new DBResponse();
//		try {
//			dbResponse = userService.authenticateUser(dto);
//		} catch (Exception e) {
//			dbResponse.setOperationCode(OpCode.EXECPTION);
//			dbResponse.setMessage(Message.SOMETHING_WENT_WRONG);
//			e.printStackTrace();
//		}
//		return dbResponse;
//	}
}
