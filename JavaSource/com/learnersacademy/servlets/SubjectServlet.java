package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnersacademy.dao.SubjectDao;
import com.learnersacademy.entity.Subject;


/**
 * Servlet implementation class SubjectServlet
 */
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SubjectDao subjectDao;

	public SubjectServlet() {
		super();
	}

	public void init() {
		subjectDao = new SubjectDao();
	}

	private Subject getSubject(HttpServletRequest request, HttpServletResponse response) {
		String subjectId = request.getParameter("id");
		Subject subject = subjectDao.getSubject(Integer.parseInt(subjectId));
		return subject;
	}

	private List<Subject> getSubjects(HttpServletRequest request, HttpServletResponse response, boolean delFlag) {
		List<Subject> subjects = subjectDao.getAllSubjects();
		String flag = request.getParameter("servletName");
		try {
			HttpSession session = request.getSession();
			session.setAttribute("subjects", subjects);
			session.setAttribute("delFlag", delFlag);
			if(!"mappingServlet".equals(flag)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("pages/listSubjects.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjects;
	}

	private Subject createSubject(HttpServletRequest request, HttpServletResponse response) {
		String subjectName = request.getParameter("subjectName");
		String subjectDescription = request.getParameter("subjectDescription");

		Subject subjectModel = new Subject(subjectName, subjectDescription);
		Subject newSubject = subjectDao.saveSubject(subjectModel);
		getSubjects(request, response, false);
		return newSubject;
	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) {
		int subjectId = Integer.parseInt(request.getParameter("id"));
		subjectDao.deleteSubjects(subjectId);
		getSubjects(request, response, true);
	}

	private void redirectToAddJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/addSubject.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {

			case "new":
				createSubject(request, response);
				break;

			case "list":
				getSubjects(request, response, false);
				break;

			case "delete":
				deleteSubject(request, response);
				break;
				
			case "addJsp":
				redirectToAddJsp(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
