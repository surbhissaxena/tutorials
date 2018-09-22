package com.ss.service;

import com.ss.dto.TutorialDTO;
import com.ss.util.DBResponse;

public interface TutorialService {
DBResponse addTutorial(TutorialDTO dto)throws Exception;
DBResponse getTutorial(int subId, int userId) throws Exception;
}
