package com.ss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSInput;

import com.ss.dao.AnswerSheetDAO;
import com.ss.dao.QuestionDAO;
import com.ss.dao.ResultDAO;
import com.ss.dao.SubjectDAO;
import com.ss.dto.ResultDTO;
import com.ss.util.DBResponse;
import com.ss.util.JDBCUtil;
import com.ss.util.Message;
import com.ss.util.OpCode;
import com.ss.vo.AnswerSheetVO;
import com.ss.vo.QuestionVO;
import com.ss.vo.ResultVO;
@Repository("resultDao")
public class ResultDAOImpl implements ResultDAO {
	@Autowired
	private SubjectDAO subjectDAO;
	@Autowired
	private QuestionDAO questionDAO;
	@Autowired
	private AnswerSheetDAO answerSheetDAO;
	// @Override
	// public DBResponse addResult(ResultDTO dto) throws Exception {
	// DBResponse dbResponse = new DBResponse();
	// Connection con = null;
	// PreparedStatement st = null;
	// try {
	// con = JDBCUtil.getInstance().getConnection();
	// int id=getNextProfileID();
	// con.setAutoCommit(false);
	// String query = " insert into result values(?,?,?,?,?,?,?)";
	// st = con.prepareStatement(query);
	// st.setString(1, dto.getEmail_Id());
	// st.setString(2, dto.getExam());
	// st.setString(3, dto.getPercent());
	// st.setString(4, dto.getStatus());
	// st.setInt(5, dto.getResult());
	// st.setString(6, dto.getResultDate());
	// st.setInt(7, id);
	// int i = st.executeUpdate();
	// if (i != 0) {
	// dbResponse.setOperationCode(OpCode.SUCCESS);
	// dbResponse.setMessage(Message.RECORD_SUCCESSFULLY_SAVED);
	// } else {
	// dbResponse.setOperationCode(OpCode.FAIL);
	// dbResponse.setMessage(Message.RECORD_NOT_SAVED);
	// }
	// con.commit();
	// } catch (Exception e) {
	// e.printStackTrace();
	// con.rollback();
	// dbResponse.setOperationCode(OpCode.EXECPTION);
	// dbResponse.setMessage(Message.SOMETHING_WENT_WRONG);
	// } finally {
	// if (con != null) {
	// st.close();
	// con.close();
	// }
	// }
	// return dbResponse;
	// }

	// public int getNextProfileID() throws Exception {
	// Connection con = null;
	// PreparedStatement st = null;
	// int id = 0;
	// try {
	// con = JDBCUtil.getInstance().getConnection();
	// String query = "SELECT max(id)resid FROM result";
	// st = con.prepareStatement(query);
	// ResultSet rs = st.executeQuery(query);
	// rs.next();
	// id = rs.getInt("resid");
	// ++id;
	// System.out.println("id = " + id);
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// if (con != null) {
	// st.close();
	// con.close();
	// }
	// }
	// return id;
	// }

	// @Override
	// public DBResponse viewReasult() throws Exception {
	// DBResponse dbResponse=new DBResponse();
	// Map<String , List<Object>> map=new HashMap<>();
	// List<Object> resultDTO=new ArrayList<Object>();
	// PreparedStatement st=null;
	// Connection con=null;
	// ResultSet rs=null;
	// try {
	// con=JDBCUtil.getInstance().getConnection();
	// String
	// query="select * from   login_table login, result rs where login.login_id= rs.id ";
	// st=con.prepareStatement(query);
	// rs=st.executeQuery();
	// while (rs.next()) {
	// ResultDTO dto1=new ResultDTO();
	// dto1.setName(rs.getString("user_name"));
	// dto1.setEmail_Id(rs.getString("email"));
	// dto1.setExam(rs.getString("exam"));
	// dto1.setPercent(rs.getString("percent"));
	// dto1.setStatus(rs.getString("status"));
	// dto1.setResult(rs.getInt("result"));
	// dto1.setResultDate(rs.getString("result_date"));
	// resultDTO.add(dto1);
	// }
	// if(!resultDTO.isEmpty()){
	// map.put("resultList", resultDTO);
	// dbResponse.setOperationCode(OpCode.SUCCESS);
	// dbResponse.setDataAvailable(true);
	// dbResponse.setData(map);
	// dbResponse.setMessage(Message.RECORD_FOUND);
	// }else{
	// dbResponse.setOperationCode(OpCode.FAIL);
	// dbResponse.setMessage(Message.RECORD_NOT_FOUND);
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// dbResponse.setOperationCode(OpCode.EXECPTION);
	// dbResponse.setMessage(Message.SOMETHING_WENT_WRONG);
	// } finally{
	// try {
	// if(con!=null){
	// con.close();
	// }
	// } catch (Exception e2) {
	// }
	// }
	// return dbResponse;
	// }

	// @Override
	// public DBResponse resultById(ResultDTO dto) throws Exception {
	// Map<String, List<Object>> map = new HashMap<String, List<Object>>();
	// List<Object> resultDTO = new ArrayList<Object>();
	// DBResponse dbRespons = new DBResponse();
	// Connection con = null;
	// PreparedStatement st = null;
	// try {
	// con = JDBCUtil.getInstance().getConnection();
	// String q =
	// "SELECT * FROM login_table login ,result result where login.login_id = result.id and user_name=? ";
	// st = con.prepareStatement(q);
	// st.setString(1, dto.getName());
	// ResultSet rs = st.executeQuery();
	// while (rs.next()) {
	// ResultDTO dto1 = new ResultDTO();
	// dto1.setEmail_Id(rs.getString("email"));
	// dto1.setExam(rs.getString("exam"));
	// dto1.setPercent(rs.getString("percent"));
	// dto1.setStatus(rs.getString("status"));
	// dto1.setResult(rs.getInt("result"));
	// dto1.setResultDate(rs.getString("result_date"));
	// resultDTO.add(dto1);
	// }
	// if (!resultDTO.isEmpty()) {
	// map.put("resultList", resultDTO);
	// dbRespons.setOperationCode(OpCode.SUCCESS);
	// dbRespons.setDataAvailable(true);
	// dbRespons.setData(map);
	// dbRespons.setMessage(Message.RECORD_FOUND);
	// } else {
	// dbRespons.setOperationCode(OpCode.FAIL);
	// dbRespons.setMessage(Message.RECORD_NOT_FOUND);
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// dbRespons.setOperationCode(OpCode.EXECPTION);
	// dbRespons.setMessage(Message.SOMETHING_WENT_WRONG);
	// } finally {
	// try {
	// if (con != null) {
	// st.close();
	// con.close();
	// }
	// } catch (Exception e) {
	//
	// }
	// }
	// return dbRespons;
	// }

	// @Override
	// public DBResponse searchResultByUsingPrePairdStatement(ResultDTO dto)
	// throws Exception {
	// DBResponse dbRespons = new DBResponse();
	// Map<String, List<Object>> map = new HashMap<>();
	// List<Object> resultDTO = new ArrayList<Object>();
	// Connection con = null;
	// PreparedStatement st = null;
	// try {
	// con = JDBCUtil.getInstance().getConnection();
	// String query =
	// "SELECT * FROM  login_table login ,result result where login.login_id=result.id where 1 = 1";
	// StringBuilder sb = new StringBuilder();
	// sb.append(query);
	//
	// List<String> params = new ArrayList<>();
	// if (dto.getName() != null) {
	// sb.append(" and user_name like ?");
	// params.add(dto.getName());
	// }
	// if (dto.getEmail_Id() != null) {
	// sb.append(" and email like ?");
	// params.add(dto.getEmail_Id());
	// }
	// if (dto.getExam() != null) {
	// sb.append(" and exam like ?");
	// params.add(dto.getExam());
	// }
	// if (dto.getPercent() != null) {
	// sb.append(" and percent like ?");
	// params.add(dto.getPercent());
	// }
	// if (dto.getResultDate() != null) {
	// sb.append(" and result_date like ?");
	// params.add(dto.getResultDate());
	// }
	//
	// st = con.prepareStatement(sb.toString());
	// Iterator<String> it = params.iterator();
	// int count = 1;
	// while (it.hasNext()) {
	// String e = (String) it.next();
	// st.setString(count, "%"+e.trim()+"%");
	// count++;
	// }
	// ResultSet rs = st.executeQuery();
	// while (rs.next()) {
	// ResultDTO dto1 = new ResultDTO();
	// dto1.setName(rs.getString("user_name"));
	// dto1.setEmail_Id(rs.getString("email"));
	// dto1.setExam(rs.getString("exam"));
	// dto1.setPercent(rs.getString("percent"));
	// dto1.setStatus(rs.getString("status"));
	// dto1.setResult(rs.getInt("result"));
	// dto1.setResultDate(rs.getString("result_date"));
	// resultDTO.add(dto1);
	// }
	// if (!resultDTO.isEmpty()) {
	// map.put("resultList", resultDTO);
	// dbRespons.setOperationCode(OpCode.SUCCESS);
	// dbRespons.setDataAvailable(true);
	// dbRespons.setData(map);
	// dbRespons.setMessage(Message.RECORD_FOUND);
	// } else {
	// dbRespons.setOperationCode(OpCode.FAIL);
	// dbRespons.setMessage(Message.RECORD_NOT_FOUND);
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// dbRespons.setOperationCode(OpCode.EXECPTION);
	// dbRespons.setMessage(Message.SOMETHING_WENT_WRONG);
	// } finally {
	// try {
	// if (con != null) {
	// st.close();
	// con.close();
	// }
	// } catch (Exception e) {
	// }
	// }
	// return dbRespons;
	//
	// }

	@Override
	public DBResponse addResult(ResultDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBResponse viewReasult() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBResponse resultById(ResultDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBResponse searchResultByUsingPrePairdStatement(ResultDTO dto)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DBResponse getResultByUserId(int userId, int subId) throws Exception {
		DBResponse dbRespons = new DBResponse();
		 Map<String, List<Object>> map = new HashMap<>();
		 List<Object> result = new ArrayList<Object>();
		Connection con = null;
		PreparedStatement st = null;
		ResultVO resultVO = null;
		try {
			con = JDBCUtil.getInstance().getConnection();
			String q = "SELECT * FROM result_table  where  user_id = ? and sub_id = ? ";
			st = con.prepareStatement(q);
			st.setInt(1, userId);
			st.setInt(2, subId);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				resultVO = new ResultVO();
				resultVO.setIs_verified(rs.getBoolean("is_verified"));
				resultVO.setIs_qualified(rs.getBoolean("is_qualified"));
				resultVO.setCode(rs.getString("code"));
				resultVO.setPercent(rs.getFloat("percent"));
				resultVO.setTotal(rs.getInt("total"));
				resultVO.setTimestamp(rs.getLong("timestamp"));
				resultVO.setResult_id(rs.getLong("result_id"));
				resultVO.setSubject(subjectDAO.getSubjectBySubjectId(rs.getInt("sub_id"), con));
				resultVO.setUser_id(rs.getInt("user_id"));
				result.add(resultVO);
			}
			 if (!result.isEmpty()) {
				 map.put("resultList", result);
				 dbRespons.setOperationCode(OpCode.SUCCESS);
				 dbRespons.setDataAvailable(true);
				 dbRespons.setData(map);
				 dbRespons.setMessage(Message.RECORD_FOUND);
				 } else {
				 dbRespons.setOperationCode(OpCode.FAIL);
				 dbRespons.setMessage(Message.RECORD_NOT_FOUND);
				 }
		} catch (Exception e) {
			 dbRespons.setOperationCode(OpCode.EXECPTION);
			 dbRespons.setMessage(Message.SOMETHING_WENT_WRONG);
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					st.close();
					con.close();
				}
			} catch (Exception e) {

			}
		}
		return dbRespons;
	}

	@Override
	public ResultVO getResultByUserIdAndSubId(int userId, int subId,
			Connection con) throws Exception {
		PreparedStatement st = null;
		ResultVO resultVO = null;
			con = JDBCUtil.getInstance().getConnection();
			String q = "SELECT * FROM result_table  where  user_id = ? and sub_id = ? ";
			st = con.prepareStatement(q);
			st.setInt(1, userId);
			st.setInt(2, subId);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				resultVO = new ResultVO();
				resultVO.setIs_verified(rs.getBoolean("is_verified"));
				resultVO.setIs_qualified(rs.getBoolean("is_qualified"));
				resultVO.setCode(rs.getString("code"));
				resultVO.setPercent(rs.getFloat("percent"));
				resultVO.setTotal(rs.getInt("total"));
				resultVO.setTimestamp(rs.getLong("timestamp"));
				resultVO.setResult_id(rs.getLong("result_id"));
				resultVO.setSubject(subjectDAO.getSubjectBySubjectId(rs.getInt("sub_id"), con));
				resultVO.setUser_id(rs.getInt("user_id"));
			}
			rs.close();
			st.close();
		return resultVO;
	}

	@Override
	public DBResponse calculateResult(int userId, int subId) throws Exception {
		DBResponse dbResponse = new DBResponse();
		 Map<String, List<Object>> map = new HashMap<>();
		 List<Object> result = new ArrayList<Object>();
		Connection con = null;
		PreparedStatement st = null;
		ResultVO resultVO = null;
		try {
			con = JDBCUtil.getInstance().getConnection();
			
			int totalQuestion = questionDAO.getTotalQuestion(subId, con);
			List<QuestionVO>  questionVOs = questionDAO.getAllQuestionBySubjectId(subId, con);
			List<AnswerSheetVO> answerSheetVOs = answerSheetDAO.getAnswerSheet(subId, userId, con);
			
			if(questionVOs!=null && !questionVOs.isEmpty() && answerSheetVOs!=null && !answerSheetVOs.isEmpty()){
					int count = 0;
				for (QuestionVO questionVO : questionVOs) {
					for (AnswerSheetVO answerSheetVO : answerSheetVOs) {
						if(answerSheetVO.getQuestionId()==questionVO.getQuestion_id()){
							if(questionVO.getAnswer().equals(answerSheetVO.getAnswer())){
								count++;
							}else{
								count--;
							}
						}
					}
				}
				int total = count;
				float percent = (total/totalQuestion)*100;
				boolean isQualified = false;
				if(percent>=40){
					isQualified = true;
				}
				long timestamp = new Date().getTime();
				PreparedStatement preparedStatement = con.prepareStatement("delete from result_table where sub_id = ? and user_id = ?");
				preparedStatement.setInt(1,subId);
				preparedStatement.setInt(2, userId);
				preparedStatement.executeUpdate();
				String query = "insert into result_table (sub_id, user_id, timestamp, total,attempt,percent,is_qualified) values(?,?,?,?,?,?,?)";
				st = con.prepareStatement(query);
				st.setInt(1,subId);
				st.setInt(2, userId);
				st.setLong(3, timestamp);
				st.setInt(4, totalQuestion);
				st.setInt(5, total);
				st.setFloat(6, percent);
				st.setBoolean(7,isQualified);
				int i = st.executeUpdate();
				if (i != 0 ) {
					dbResponse.setOperationCode(OpCode.SUCCESS);
					dbResponse.setMessage(Message.RECORD_SUCCESSFULLY_SAVED);
				} else {
					dbResponse.setOperationCode(OpCode.FAIL);
					dbResponse.setMessage(Message.RECORD_NOT_SAVED);
				}
				preparedStatement.close();
				 st.close();
			}else{
				dbResponse.setOperationCode(OpCode.FAIL);
				dbResponse.setMessage(Message.RECORD_NOT_FOUND);
			}
		} catch (Exception e) {
			 dbResponse.setOperationCode(OpCode.EXECPTION);
			 dbResponse.setMessage(Message.SOMETHING_WENT_WRONG);
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					st.close();
					con.close();
				}
			} catch (Exception e) {

			}
		}
		return dbResponse;
	}
}
