package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnersacademy.dao.StudentDao;
import com.learnersacademy.entity.ClassRoom;
import com.learnersacademy.entity.Student;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDao studentDao;

	public StudentServlet() {
		super();
	}

	public void init() {
		studentDao = new StudentDao();
	}

	private Student getStudent(HttpServletRequest request, HttpServletResponse response) {
		String studentId = request.getParameter("id");
		Student student = studentDao.getStudent(Integer.parseInt(studentId));
		return student;
	}

	private List<Student> getStudents(HttpServletRequest request, HttpServletResponse response, boolean delFlag) {
		List<Student> students = studentDao.getAllStudents();
		try {
			HttpSession session = request.getSession();
			session.setAttribute("students", students);
			session.setAttribute("delFlag", delFlag);
			RequestDispatcher dispatcher = request.getRequestDispatcher("pages/list-students.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	private Student createStudent(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("studentName");
		String email = request.getParameter("email");
		String emergencyContactNumber = request.getParameter("emergencyContactNumber");
		String bloodGroup = request.getParameter("bloodGroup");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		int classId = Integer.parseInt(request.getParameter("classesNameCombo"));
		String address = request.getParameter("address");
		Student newStudent = null;
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("classRoom?action=classById&id="+classId);
			dispatcher.include(request, response);
			HttpSession session = request.getSession(false);
			ClassRoom classRoom = (ClassRoom) session.getAttribute("classRoom");
			String className = classRoom.getClassName() != null && !classRoom.getClassName().isEmpty()?classRoom.getClassName():"";
			Student studentModel = new Student(name, email, emergencyContactNumber, bloodGroup, gender, age, classId, className, address);
			newStudent = studentDao.saveStudent(studentModel);
			getStudents(request, response, false);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newStudent;
	}
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
		int studentId = Integer.parseInt(request.getParameter("id"));
		studentDao.deleteStudents(studentId);
		getStudents(request, response, true);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {

			case "new":
				createStudent(request, response);
				break;

			case "list":
				getStudents(request, response, false);
				break;
				
			case "delete":
				deleteStudent(request, response);
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
