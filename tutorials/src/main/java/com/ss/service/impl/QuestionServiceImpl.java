package com.ss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.dao.QuestionDAO;
import com.ss.dao.impl.QuestionDAOImpl;
import com.ss.dto.QuestionDTO;
import com.ss.service.QuestionService;
import com.ss.util.DBResponse;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionDAO questionDAO;
	
	@Override
	public DBResponse addQuestion(QuestionDTO dto) throws Exception {
		return questionDAO.addQuestion(dto);
	}

	@Override
	public DBResponse getAllQuestionBySubjectId(QuestionDTO dto)
			throws Exception {
		return questionDAO.getAllQuestionBySubjectId(dto);
	}

	@Override
	public DBResponse getAllQuestionBySubjectId(int subId) throws Exception {
		QuestionDTO dto = new QuestionDTO();
		dto.setSub_id(subId);
		return questionDAO.getAllQuestionBySubjectId(dto);
	}



	
}
