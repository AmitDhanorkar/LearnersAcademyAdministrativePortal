package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnersacademy.dao.TeacherClassSubjectMappingDao;
import com.learnersacademy.entity.ClassRoom;
import com.learnersacademy.entity.Subject;
import com.learnersacademy.entity.Teacher;
import com.learnersacademy.entity.TeacherClassSubjectMapping;

/**
 * Servlet implementation class TeacherClassSubjectMappingServlet
 */
public class TeacherClassSubjectMappingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TeacherClassSubjectMappingDao teacherClassSubjectMappingDao; 

	public TeacherClassSubjectMappingServlet() {
		super();
	}
	
	public void init() {
		teacherClassSubjectMappingDao = new TeacherClassSubjectMappingDao();
	}
	
	private List<TeacherClassSubjectMapping> getTeacherClassSubjectMappings(HttpServletRequest request, HttpServletResponse response, boolean delFlag) {
		List<TeacherClassSubjectMapping> teacherClassSubjectMappings = teacherClassSubjectMappingDao.getAllTeacherClassSubjectMapping();
		try {
			HttpSession session = request.getSession();
			session.setAttribute("teacherClassSubjectMappings", teacherClassSubjectMappings);
			session.setAttribute("delFlag", delFlag);
			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/listTeacherClassSubjectMapping.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherClassSubjectMappings;
	}
	
	private TeacherClassSubjectMapping createTeacherClassSubjectMapping(HttpServletRequest request, HttpServletResponse response) {
		int classId = Integer.parseInt(request.getParameter("classesNameCombo"));
		String className = request.getParameter("className");
		int subjectId = Integer.parseInt(request.getParameter("subjectsNameCombo"));
		String subjectName = request.getParameter("subjectName");
		int teacherId = Integer.parseInt(request.getParameter("teachersNameCombo"));
		String teacherName = request.getParameter("teacherName");
		
		TeacherClassSubjectMapping mappingModel = new TeacherClassSubjectMapping(classId, className, subjectId, subjectName, teacherId, teacherName);
		TeacherClassSubjectMapping newMapping = teacherClassSubjectMappingDao.saveTeacherClassSubjectMapping(mappingModel);
		getTeacherClassSubjectMappings(request, response, false);
		return newMapping;
	}
	
	private void deleteTeacherClassSubjectMapping(HttpServletRequest request, HttpServletResponse response) {
		int mappingId = Integer.parseInt(request.getParameter("id"));
		teacherClassSubjectMappingDao.deleteTeacherClassSubjectMapping(mappingId);
		getTeacherClassSubjectMappings(request, response, true);
	}

	private void getTeacherSubjectClassDetails(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher;
		try {
			dispatcher = request.getRequestDispatcher("classRoom?action=listClassName&servletName=mappingServlet");
			dispatcher.include(request, response);
			HttpSession session = request.getSession(false);

			dispatcher = request.getRequestDispatcher("subject?action=list&servletName=mappingServlet");
			dispatcher.include(request, response);
			
			dispatcher = request.getRequestDispatcher("teacher?action=list&servletName=mappingServlet");
			dispatcher.include(request, response);
			
			dispatcher = request.getRequestDispatcher("pages/addTeacherClassSubjectMapping.jsp");
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
				createTeacherClassSubjectMapping(request, response);
				break;

			case "list":
				getTeacherClassSubjectMappings(request, response, false);
				break;
				
			case "delete":
				deleteTeacherClassSubjectMapping(request, response);
				break;
				
			case "mappingDetails":
				getTeacherSubjectClassDetails(request, response);
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
