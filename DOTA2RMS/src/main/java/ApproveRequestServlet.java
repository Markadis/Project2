package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.RequestDAOImpl;
import com.revature.pojos.Request;

/**
 * Servlet implementation class ApproveRequestServlet
 */
public class ApproveRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqIDString = request.getParameter("reqID");
		int reqID = Integer.parseInt(reqIDString);
		String verb = request.getParameter("modReqRadio");
		
		if (verb.equals("approve")) {
			
			RequestDAOImpl rdao = new RequestDAOImpl();
			rdao.approveRequest(reqID);
		} else if (verb.equals("deny")) {
			
			RequestDAOImpl rdao = new RequestDAOImpl();
			rdao.denyRequest(reqID);
		}
		
		response.sendRedirect("ManagerHomepage.html");
	}

}
