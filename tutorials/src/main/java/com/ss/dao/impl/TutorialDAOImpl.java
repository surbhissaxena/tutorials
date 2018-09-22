package com.ss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ss.dao.ResultDAO;
import com.ss.dao.SubjectDAO;
import com.ss.dao.TutorialDAO;
import com.ss.dto.TutorialDTO;
import com.ss.util.DBResponse;
import com.ss.util.JDBCUtil;
import com.ss.util.Message;
import com.ss.util.OpCode;
import com.ss.vo.ResultVO;
import com.ss.vo.SubjectVO;
import com.ss.vo.TutorialVO;
@Repository("tutorialDAO")
public class TutorialDAOImpl implements TutorialDAO{

	@Autowired
	private ResultDAO resultDAO;
	@Autowired
	private SubjectDAO subjectDAO;
	@Override
	public DBResponse addTutorial(TutorialDTO dto) throws Exception {

		DBResponse dbResponse = new DBResponse();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = JDBCUtil.getInstance().getConnection();
			con.setAutoCommit(false);
			String query = "insert into tutorial_table (sub_id, heading, description) values(?,?,?)";
			st = con.prepareStatement(query);
			st.setInt(1, dto.getSub_id());
			st.setString(2, dto.getHeading());
			st.setString(3, dto.getDescription());
			int i = st.executeUpdate();
			if (i != 0 ) {
				dbResponse.setOperationCode(OpCode.SUCCESS);
				dbResponse.setMessage(Message.RECORD_SUCCESSFULLY_SAVED);
			} else {
				dbResponse.setOperationCode(OpCode.FAIL);
				dbResponse.setMessage(Message.RECORD_NOT_SAVED);
			}
			 con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// con.rollback();
			dbResponse.setOperationCode(OpCode.EXECPTION);
			dbResponse.setMessage(Message.SOMETHING_WENT_WRONG);
		} finally {
			if (con != null) {
				st.close();
				con.close();
			}
		}
		return dbResponse;
	
	}

	@Override
	public DBResponse getTutorial(int subId, int userId) throws Exception {
		Map<String, List<Object>> map = new HashMap<String, List<Object>>();
		List<Object> list = new ArrayList<Object>();
		DBResponse dbRespons = new DBResponse();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = JDBCUtil.getInstance().getConnection();
			
			ResultVO resultVO = resultDAO.getResultByUserIdAndSubId(userId, subId, con);
			if(resultVO!=null && resultVO.isIs_qualified()){
				String q = "SELECT * FROM  tutorial_table where sub_id = ?";
				st = con.prepareStatement(q);
				st.setInt(1, subId);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					TutorialVO vo = new TutorialVO(); 
					vo.setTutorial_id(rs.getInt("tutorial_id"));
					vo.setSubject(subjectDAO.getSubjectBySubjectId(subId, con));
					vo.setHeading(rs.getString("heading"));
					vo.setDescription(rs.getString("description"));
					vo.setSub_id(rs.getInt("sub_id"));
					list.add(vo);
				}
				System.out.println(list.isEmpty());
				if (!list.isEmpty()) {
					map.put("list", list);
					dbRespons.setOperationCode(OpCode.SUCCESS);
					dbRespons.setDataAvailable(true);
					dbRespons.setData(map);
					dbRespons.setMessage(Message.RECORD_FOUND);
				} else {
					dbRespons.setOperationCode(OpCode.FAIL);
					dbRespons.setMessage(Message.RECORD_NOT_FOUND);
				}
				rs.close();
				st.close();
			}else{
				dbRespons.setOperationCode(OpCode.FAIL);
				dbRespons.setMessage(Message.NOT_QUALIFIED);
			}

		} catch (Exception e) {
			e.printStackTrace();
			dbRespons.setOperationCode(OpCode.EXECPTION);
			dbRespons.setMessage(Message.SOMETHING_WENT_WRONG);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}

		}
		return dbRespons;
	}

}
