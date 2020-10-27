package ksys.sales.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ksys.sales.action.EmpInsertAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/ksys")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse res)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse res)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String b_id = req.getParameter("B_ID");

		System.out.println(b_id);
		String page = null;
		if (b_id == null) {
			b_id = "M01";
		}

		switch (b_id) {
		case "M01":
			page = "/EmpInsert.jsp";
			break;

		case "M02":
			EmpInsertAction eAct = new EmpInsertAction();
			page = eAct.insertEmp(req);
			break;
		}

		RequestDispatcher rd = req.getRequestDispatcher(page);
		rd.forward(req, res);
	}

}
