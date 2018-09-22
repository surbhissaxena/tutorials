package com.ss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.dao.AnswerSheetDAO;
import com.ss.dto.AnswerSheetDTO;
import com.ss.service.AnswerSheetService;
import com.ss.util.DBResponse;

@Service("answerSheetService")
public class AnswerSheetServiceImpl implements AnswerSheetService{

	@Autowired
	private AnswerSheetDAO answerSheetDAO;
	
	@Override
	public DBResponse updateAnswerSheet(AnswerSheetDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return answerSheetDAO.updateAnswerSheet(dto);
	}

}
