package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnersacademy.dao.ClassReportDetailsDao;
import com.learnersacademy.entity.Student;
import com.learnersacademy.entity.TeacherClassSubjectMapping;

/**
 * Servlet implementation class ClassReportDetailsServlet
 */
public class ClassReportDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClassReportDetailsDao classReportDetailsDao;

	public ClassReportDetailsServlet() {
		super();
	}

	public void init() {
		classReportDetailsDao = new ClassReportDetailsDao();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		try {
			switch (action) {
			case "classReportDetails":
				generateClassReportDetails(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void generateClassReportDetails(HttpServletRequest request, HttpServletResponse response) {
		String classId = request.getParameter("classId");
		List<TeacherClassSubjectMapping> teacherClassSubjectMappings = classReportDetailsDao.getTeacherClassSubjectMappingsDetails(Integer.parseInt(classId));
		List<Student> studentDetails = classReportDetailsDao.getStudentDetails(Integer.parseInt(classId));
		try {
			HttpSession session = request.getSession();
			session.setAttribute("teacherClassSubjectMappings", teacherClassSubjectMappings);
			session.setAttribute("studentDetails", studentDetails);
			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/listClassDetailsReport.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
