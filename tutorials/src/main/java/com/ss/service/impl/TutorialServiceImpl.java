package com.ss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.dao.TutorialDAO;
import com.ss.dao.impl.TutorialDAOImpl;
import com.ss.dto.TutorialDTO;
import com.ss.service.TutorialService;
import com.ss.util.DBResponse;
@Service("tutorialService")
public class TutorialServiceImpl implements TutorialService{
	
	@Autowired
	private TutorialDAO tutorialDAO;
	
	@Override
	public DBResponse addTutorial(TutorialDTO dto) throws Exception {
		return tutorialDAO.addTutorial(dto);
	}

	@Override
	public DBResponse getTutorial(int subId, int userId) throws Exception {
		// TODO Auto-generated method stub
		return tutorialDAO.getTutorial(subId, userId);
	}

}
