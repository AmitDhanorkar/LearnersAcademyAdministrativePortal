package com.learnersacademy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnersacademy.dao.ClassRoomDao;
import com.learnersacademy.entity.ClassRoom;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ClassRoomServlet
 */
public class ClassRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClassRoomDao classRoomDao;

	public ClassRoomServlet() {
		super();
	}

	public void init() {
		classRoomDao = new ClassRoomDao();
	}

	private ClassRoom getClassRoom(HttpServletRequest request, HttpServletResponse response) {
		String classRoomId = request.getParameter("id");
		ClassRoom classRoom = classRoomDao.getClassRoom(Integer.parseInt(classRoomId));
		HttpSession session = request.getSession();
		session.setAttribute("classRoom", classRoom);
		return classRoom;
	}

	private List<ClassRoom> getClassRooms(HttpServletRequest request, HttpServletResponse response, boolean delFlag) {
		List<ClassRoom> classRooms = classRoomDao.getAllClassRooms();
		String reportFlag = request.getParameter("reportFlag");
		try {
			HttpSession session = request.getSession();
			session.setAttribute("classRooms", classRooms);
			session.setAttribute("delFlag", delFlag);
			if("Y".equals(reportFlag)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("pages/listClassReport.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("pages/list-classRooms.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classRooms;
	}

	public List<ClassRoom> getAllClassDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<ClassRoom> classRooms = classRoomDao.getAllClassRooms();
		String flag = request.getParameter("servletName");
		try {
			HttpSession session = request.getSession();
			session.setAttribute("classRooms", classRooms);
			if(!"mappingServlet".equals(flag)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("pages/addStudent.jsp");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return classRooms;
	}

	private ClassRoom createClassRoom(HttpServletRequest request, HttpServletResponse response) {
		String className = request.getParameter("className");
		String sectionName = request.getParameter("sectionName");
		int totalNumberOfStudents = Integer.parseInt(request.getParameter("totalNumberOfStudents"));
		String roomNo = request.getParameter("roomNo");
		String classTeacherName = request.getParameter("classTeacherName");

		ClassRoom classRoomModel = new ClassRoom(className, sectionName, totalNumberOfStudents, roomNo, classTeacherName);
		ClassRoom newClassRoom = classRoomDao.saveClassRoom(classRoomModel);
		getClassRooms(request, response, false);
		return newClassRoom;
	}

	private void deleteClass(HttpServletRequest request, HttpServletResponse response) {
		int classId = Integer.parseInt(request.getParameter("id"));
		classRoomDao.deleteClass(classId);
		getClassRooms(request, response, true);
	}

	private void redirectToAddJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/addClass.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {

			case "new":
				createClassRoom(request, response);
				break;

			case "list":
				getClassRooms(request, response, false);
				break;

			case "delete":
				deleteClass(request, response);
				break;

			case "listClassName":
				getAllClassDetails(request, response);
				break;

			case "classById":
				getClassRoom(request, response);
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
