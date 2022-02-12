<%@page import="com.learnersacademy.entity.TeacherClassSubjectMapping"%>
<%@page import="com.learnersacademy.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
    <%
		List<TeacherClassSubjectMapping> teacherClassSubjectMappings = (List<TeacherClassSubjectMapping>) session.getAttribute("teacherClassSubjectMappings");
    	List<Student> studentDetails = (List<Student>) session.getAttribute("studentDetails");
	%>
	<div class="container-fluid">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary"><a href="pages/dashboard.jsp">Home</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/LearnersAcademyAdministrativePortal/logout" style='float:right'>Logout</a></h6>
	</div>
		<div class="d-sm-flex align-items-center justify-content-between mb-4">
			<h1 class="h3 mb-0 text-gray-800">List Class Details Report</h1> </div>
		<div class="row">
			<div class="col-lg-12">
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Teachers and Handling Subjects</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered teachersHandlingSubjectsList" id="dataTable teachersHandlingSubjectsList" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
											<th>Teacher Name</th>
                                        	<th>Subject Name</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                           					<c:forEach var="teacherClassSubjectMapping" items="${teacherClassSubjectMappings}">
										       <tr>
													<td><c:out value="${teacherClassSubjectMapping.teacherName}" /></td>
													<td><c:out value="${teacherClassSubjectMapping.subjectName}" /></td>
										        </tr>
									        </c:forEach>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </div>
                    
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Students in the Class</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered studentsInTheClassList" id="dataTable studentsInTheClassList" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th>Student Name</th>
                                        	<th>Gender</th>
                                        	<th>Contact Number</th>
                                        	<th>Blood Group</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                        	<c:forEach var="student" items="${studentDetails}">
												<tr>
													<td><c:out value="${student.name}" /></td>
													<td><c:out value="${student.gender}" /></td>
													<td><c:out value="${student.emergencyContactNumber}" /></td>
													<td><c:out value="${student.bloodGroup}" /></td>
												</tr>
										    </c:forEach>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </div>
			</div>
		</div>
	</div>
	
	