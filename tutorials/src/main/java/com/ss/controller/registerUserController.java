package com.ss.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.dto.UserDTO;
import com.ss.service.UserService;
import com.ss.service.impl.UserServiceImpl;
//import com.ns.util.MailController;
import com.ss.util.DBResponse;
import com.ss.util.MailController;
import com.ss.util.Message;
import com.ss.util.OpCode;

/**
 * Servlet implementation class AddDataController
 */
public class registerUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             System.out.println("Add User Data..");   
		String userName=request.getParameter("username");
        String firstrName=request.getParameter("firstname");
        String lastName=request.getParameter("lastname");
        String conactNo=request.getParameter("contactno");
        String emailId=request.getParameter("email");
        String  address=request.getParameter("address");
        String  role=request.getParameter("role");
     
        UserDTO dto=new  UserDTO();
        dto.setUserName(userName);
        dto.setFirstName(firstrName);
        dto.setLastName(lastName);
        dto.setContactNo(conactNo);
        dto.setAddress(address);
        dto.setEmailId(emailId);
        dto.setRole(role);
        System.out.println(dto);
       
        UserService service =new UserServiceImpl(); 
        DBResponse dbResponse=new DBResponse();
        try{ 
        	
             dbResponse=service.registerUser(dto);
             if(OpCode.SUCCESS==dbResponse.getOperationCode()){
        	 System.out.println(dbResponse.getMessage());
        	 MailController.mailMethod(dto);
             request.setAttribute("message",dbResponse.getMessage());
			 RequestDispatcher rd = request.getRequestDispatcher("/jsp/register.jsp");
			 rd.forward(request, response);
            }
            else if(OpCode.FAIL==dbResponse.getOperationCode()){
            	System.out.println(dbResponse.getMessage());
            	request.setAttribute("message",dbResponse.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/register.jsp");
				rd.forward(request, response);
            }else if(OpCode.EXECPTION==dbResponse.getOperationCode()){
            	request.setAttribute("message",dbResponse.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/register.jsp");
				rd.forward(request, response);
            }
        }catch(Exception e){
        	e.printStackTrace();
        	request.setAttribute("message","some thing went wrong!");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/register.jsp");
			rd.forward(request, response);
        }
        
	}

}
