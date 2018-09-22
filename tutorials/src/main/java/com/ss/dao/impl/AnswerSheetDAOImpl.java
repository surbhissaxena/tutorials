package com.ss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ss.dao.AnswerSheetDAO;
import com.ss.dto.AnswerSheetDTO;
import com.ss.util.DBResponse;
import com.ss.util.JDBCUtil;
import com.ss.util.Message;
import com.ss.util.OpCode;
import com.ss.vo.AnswerSheetVO;
@Repository("answerSheetDAO")
public class AnswerSheetDAOImpl implements AnswerSheetDAO{

	@Override
	public DBResponse updateAnswerSheet(AnswerSheetDTO dto) throws Exception{

		DBResponse dbResponse = new DBResponse();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = JDBCUtil.getInstance().getConnection();
			con.setAutoCommit(false);
			
			AnswerSheetVO vo = new AnswerSheetVO();
			vo.setQuestionId(dto.getQuestionId());
			vo.setSubId(dto.getSubId());
			vo.setUserId(vo.getUserId());
	
			vo = getAnswerSheet(vo, con);
			int i = 0;
			if(vo.getId()!=0){
				//update
				String query = "update answersheet_table set answer = ? where id = ?";
				st = con.prepareStatement(query);
				st.setString(1, dto.getAnswer());
				st.setInt(2, dto.getId());
				i = st.executeUpdate();
			}else{
				//add
				String query = "insert into answersheet_table (user_id,question_id,sub_id,answer) values(?,?,?,?)";
				st = con.prepareStatement(query);
				st.setInt(1, dto.getUserId());
				st.setInt(2, dto.getQuestionId());
				st.setInt(3, dto.getSubId());
				st.setString(4, dto.getAnswer());
				i = st.executeUpdate();
			}
			
			if (i != 0 ) {
				dbResponse.setOperationCode(OpCode.SUCCESS);
				dbResponse.setMessage(Message.RECORD_SUCCESSFULLY_SAVED);
			} else {
				dbResponse.setOperationCode(OpCode.FAIL);
				dbResponse.setMessage(Message.RECORD_NOT_SAVED);
			}
			 con.commit();
			 st.close();
		} catch (Exception e) {
			e.printStackTrace();
			// con.rollback();
			dbResponse.setOperationCode(OpCode.EXECPTION);
			dbResponse.setMessage(Message.SOMETHING_WENT_WRONG);
		} finally {
			if (con != null) {
			//	st.close();
				con.close();
			}
		}
		return dbResponse;
	
	}

	@Override
	public AnswerSheetVO getAnswerSheet(AnswerSheetVO vo, Connection con)throws Exception{
		PreparedStatement st = null;
		String q = "SELECT * FROM  answersheet_table where sub_id = ? and user_id =? and question_id = ?";
		st = con.prepareStatement(q);
		st.setInt(1, vo.getSubId());
		st.setInt(2, vo.getUserId());
		st.setInt(3, vo.getQuestionId());
		
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			vo.setId(rs.getInt("id"));
		}
		rs.close();
		st.close();
		return vo;
	}

	@Override
	public List<AnswerSheetVO> getAnswerSheet(int subId, int userId,
			Connection con) throws Exception {
		PreparedStatement st = null;
		List<AnswerSheetVO>  list = new ArrayList();
		String q = "SELECT * FROM  answersheet_table where sub_id = ? and user_id = ?";
		st = con.prepareStatement(q);
		st.setInt(1, subId);
		st.setInt(2, userId);
		
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			AnswerSheetVO vo = new AnswerSheetVO();
			vo.setId(rs.getInt("id"));
			vo.setAnswer(rs.getString("answer"));
			vo.setQuestionId(rs.getInt("question_id"));
			vo.setSubId(rs.getInt("sub_id"));
			vo.setUserId(rs.getInt("user_id"));
			list.add(vo);
		}
		rs.close();
		st.close();
		return list;
	}

}
