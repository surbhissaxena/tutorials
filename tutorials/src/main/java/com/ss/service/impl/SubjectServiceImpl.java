package com.ss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ss.dao.SubjectDAO;
import com.ss.dao.impl.SubjectDAOImpl;
import com.ss.dto.SubjectDTO;
import com.ss.service.SubjectService;
import com.ss.util.DBResponse;
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	private SubjectDAO subjectDAO;
	
	@Override
	public DBResponse addSubject(SubjectDTO dto) throws Exception {
		return subjectDAO.addSubject(dto);
	}

	@Override
	public DBResponse getAllsubject() throws Exception {
		return subjectDAO.getAllSubject();
	}

}
