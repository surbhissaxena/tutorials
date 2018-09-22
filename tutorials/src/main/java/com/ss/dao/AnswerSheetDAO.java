package com.ss.dao;

import java.sql.Connection;
import java.util.List;

import com.ss.dto.AnswerSheetDTO;
import com.ss.dto.QuestionDTO;
import com.ss.util.DBResponse;
import com.ss.vo.AnswerSheetVO;

public interface AnswerSheetDAO {
DBResponse updateAnswerSheet(AnswerSheetDTO dto)throws Exception;
AnswerSheetVO getAnswerSheet(AnswerSheetVO vo, Connection con)throws Exception;
List<AnswerSheetVO> getAnswerSheet(int subId, int userId, Connection con)throws Exception;
}
