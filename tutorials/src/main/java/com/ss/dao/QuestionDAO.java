package com.ss.dao;

import java.sql.Connection;


import java.util.List;

import com.ss.dto.QuestionDTO;
import com.ss.util.DBResponse;
import com.ss.vo.QuestionVO;

public interface QuestionDAO {
DBResponse addQuestion(QuestionDTO dto)throws Exception;
DBResponse getAllQuestionBySubjectId(QuestionDTO dto)throws Exception;
List<QuestionVO> getAllQuestionBySubjectId(int subId, Connection con)throws Exception;
int getTotalQuestion(int subId, Connection con) throws Exception;
}
