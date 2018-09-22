package com.ss.service;

import java.sql.Connection;

import com.ss.dto.AnswerSheetDTO;
import com.ss.dto.QuestionDTO;
import com.ss.util.DBResponse;
import com.ss.vo.AnswerSheetVO;

public interface AnswerSheetService {
DBResponse updateAnswerSheet(AnswerSheetDTO dto)throws Exception;
}
