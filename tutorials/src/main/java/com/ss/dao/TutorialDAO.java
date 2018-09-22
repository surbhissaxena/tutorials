package com.ss.dao;

import com.ss.dto.TutorialDTO;
import com.ss.util.DBResponse;

public interface TutorialDAO {
DBResponse addTutorial(TutorialDTO dto)throws Exception;
DBResponse getTutorial(int subId, int userId) throws Exception;
}
