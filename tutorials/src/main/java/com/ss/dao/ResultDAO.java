package com.ss.dao;

import java.sql.Connection;

import com.ss.dto.ResultDTO;
import com.ss.util.DBResponse;
import com.ss.vo.ResultVO;


public interface ResultDAO {
	DBResponse addResult(ResultDTO dto )throws Exception;
    DBResponse viewReasult()throws Exception;
    DBResponse resultById(ResultDTO dto)throws Exception;
    DBResponse searchResultByUsingPrePairdStatement(ResultDTO dto)throws Exception;	
    DBResponse getResultByUserId(int userId, int subId)throws Exception;
    ResultVO getResultByUserIdAndSubId(int userId, int subId, Connection con)throws Exception;
    DBResponse calculateResult(int userId, int subId)throws Exception;
    
}
