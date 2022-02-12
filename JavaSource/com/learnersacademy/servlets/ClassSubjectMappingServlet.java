package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnersacademy.dao.ClassSubjectMappingDao;
import com.learnersacademy.entity.ClassRoom;
import com.learnersacademy.entity.ClassSubjectMapping;
import com.learnersacademy.entity.Student;
import com.learnersacademy.entity.Subject;


/**
 * Servlet implementation class ClassSubjectMappingServlet
 */
public class ClassSubjectMappingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClassSubjectMappingDao classSubjectMappingDao; 

	public ClassSubjectMappingServlet() {
		super();
	}

	public void init() {
		classSubjectMappingDao = new ClassSubjectMappingDao();
	}

	private List<ClassSubjectMapping> getClassSubjectMappings(HttpServletRequest request, HttpServletResponse response, boolean delFlag) {
		List<ClassSubjectMapping> classSubjectMappings = classSubjectMappingDao.getAllClassSubjectMapping();
		try {
			HttpSession session = request.getSession();
			session.setAttribute("classSubjectMappings", classSubjectMappings);
			session.setAttribute("delFlag", delFlag);
			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/listClassSubjectMapping.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classSubjectMappings;
	}

	private ClassSubjectMapping createClassSubjectMapping(HttpServletRequest request, HttpServletResponse response) {
		int classId = Integer.parseInt(request.getParameter("classesNameCombo"));
		int subjectId = Integer.parseInt(request.getParameter("subjectsNameCombo"));
		String className = request.getParameter("className");
		String subjectName = request.getParameter("subjectName");

		ClassSubjectMapping mappingModel = new ClassSubjectMapping(classId, className, subjectId, subjectName);
		ClassSubjectMapping newMapping = classSubjectMappingDao.saveClassSubjectMapping(mappingModel);
		getClassSubjectMappings(request, response, false);
		return newMapping;
	}

	private void deleteClassSubjectMapping(HttpServletRequest request, HttpServletResponse response) {
		int mappingId = Integer.parseInt(request.getParameter("id"));
		classSubjectMappingDao.deleteClassSubjectMapping(mappingId);
		getClassSubjectMappings(request, response, true);
	}

	private void getSubjectClassDetails(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher;
		try {
			dispatcher = request.getRequestDispatcher("classRoom?action=listClassName&servletName=mappingServlet");
			dispatcher.include(request, response);
			HttpSession session = request.getSession(false);
			List<ClassRoom> classRooms=  (List<ClassRoom>) session.getAttribute("classRooms");

			dispatcher = request.getRequestDispatcher("subject?action=list&servletName=mappingServlet");
			dispatcher.include(request, response);
			List<Subject> subjects=  (List<Subject>) session.getAttribute("subjects");
			
			dispatcher = request.getRequestDispatcher("pages/addClassSubjectMapping.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {

			case "new":
				createClassSubjectMapping(request, response);
				break;

			case "list":
				getClassSubjectMappings(request, response, false);
				break;

			case "delete":
				deleteClassSubjectMapping(request, response);
				break;
			case "mappingDetails":
				getSubjectClassDetails(request, response);
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
