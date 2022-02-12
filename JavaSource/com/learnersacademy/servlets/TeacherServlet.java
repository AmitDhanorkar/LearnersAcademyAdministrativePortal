package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnersacademy.dao.TeacherDao;
import com.learnersacademy.entity.Teacher;

public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TeacherDao teacherDao;
	
    public TeacherServlet() {
        super();
    }

	public void init() {
		teacherDao = new TeacherDao();
	}
	
	private Teacher getTeacher(HttpServletRequest request, HttpServletResponse response) {
		String teacherId = request.getParameter("id");
		Teacher teacher = teacherDao.getTeacher(Integer.parseInt(teacherId));
		return teacher;
	}

	private List<Teacher> getTeachers(HttpServletRequest request, HttpServletResponse response, boolean delFlag) {
		List<Teacher> teachers = teacherDao.getAllTeachers();
		String flag = request.getParameter("servletName");
		try {
			HttpSession session = request.getSession();
			session.setAttribute("teachers", teachers);
			session.setAttribute("delFlag", delFlag);
			if(!"mappingServlet".equals(flag)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("pages/listTeacher.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}

	private Teacher createTeacher(HttpServletRequest request, HttpServletResponse response) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String contactNumber = request.getParameter("contactNumber");
		String emailId = request.getParameter("emailAddress");
		String qualification = request.getParameter("qualification");
		int age = Integer.parseInt(request.getParameter("age"));
		String martialStatus = request.getParameter("martialStatus");
		String gender = request.getParameter("gender");

		Teacher teacherModel = new Teacher(firstName, lastName, contactNumber, emailId, qualification, gender, age, martialStatus);
		Teacher newTeacher = teacherDao.saveTeacher(teacherModel);
		getTeachers(request, response, false);
		return newTeacher;
	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) {
		int teacherId = Integer.parseInt(request.getParameter("id"));
		teacherDao.deleteTeacher(teacherId);
		getTeachers(request, response, true);
	}
	
	private void redirectToAddJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/addTeacher.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {

			case "new":
				createTeacher(request, response);
				break;

			case "list":
				getTeachers(request, response, false);
				break;
			
			case "delete":
				deleteTeacher(request, response);
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
