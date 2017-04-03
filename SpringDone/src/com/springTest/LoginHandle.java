package com.springTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springTest.Dao.impl.PersonDaoImpl;
import com.springTest.entity.Person;
import com.sun.org.apache.bcel.internal.generic.ObjectType;

public class LoginHandle extends HttpServlet{
	 private static final long serialVersionUID = 1L;
	 private PersonDaoImpl personDaoImpl;
	public LoginHandle(){
		
	}
	
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		 PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// 打印堆栈信息
			e.printStackTrace();
		}

	        out.print(request);
	        System.out.println(request);

	    
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		 response.setContentType("text/html");
		 List<Person> personInfo = personDaoImpl.queryAllPersonInfo();
//		 ObjectType;
		 PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//	        out.println("Beer Selection Advice<br>");
//	        String c = request.getParameter("color");
//	        out.println("<br> Got beer color"+c);
//	        
//	        System.out.println(c);

	}
	
}