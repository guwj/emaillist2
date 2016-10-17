package com.bit2016.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.emaillist.dao.EmaillistDao;
import com.bit2016.emaillist.vo.EmaillistVo;

@WebServlet("/el")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 		// UTF-8 형으로 인코딩하는 것
		
		// action name 가져오기
		String actionName = request.getParameter("a");
		if( "form".equals(actionName)){
			// form 요청에 대한 처리
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/form.jsp");
			rd.forward(request, response);
			
		}else if("insert".equals(actionName)){
			// insert 요청에 대한 처리
			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			String email = request.getParameter("email");
			
			EmaillistVo vo = new EmaillistVo();
			vo.setEmail(email);
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			
			EmaillistDao dao = new EmaillistDao();
			dao.insert(vo);
			
			// redirect
			response.sendRedirect("/emaillist2/el");
			
		}else{
			// default action 처리(리스트 처리)
			EmaillistDao dao = new EmaillistDao();
			List<EmaillistVo> list = dao.getList();
			
			//request 범위에 모델 데이터 저장
			request.setAttribute("list", list); 	// list를 list라는 이름으로 request객체에 넣는 작업, view에서 list를 사용할 수 있게 하기 위함
			
			//forwarding(request 연장, request dispatch), 어떤 view로 request를 연장하는지 여기서 설정
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			
			rd.forward(request, response); 		// 여기서 request 객체를 view로 옮기는 것
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
