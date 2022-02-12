<%@page import="com.learnersacademy.entity.Teacher"%>
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
		List<Teacher> teachers = (List<Teacher>) session.getAttribute("teachers");
		boolean delFlag = (boolean)session.getAttribute("delFlag");
	%>
<div class="container-fluid">
	<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary"><a href="pages/dashboard.jsp">Home</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/LearnersAcademyAdministrativePortal/logout" style='float:right'>Logout</a></h6>
	</div>
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">List Teachers</h1>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="card shadow mb-4">
				<div class="card-header py-3">
					<h6 class="m-0 font-weight-bold text-primary">Teachers</h6>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered teachersList" id="dataTable"
							width="100%" cellspacing="0">
							<thead>
								<tr>
									<th>Teacher Name</th>
									<th>Contact Number</th>
									<th>Qualification</th>
									<th>Gender</th>
									<th>Created Dt</th>
									<th>Action</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<c:forEach var="teacher" items="${teachers}">
										<tr>
											<td><c:out value="${teacher.firstName}, ${teacher.lastName}" /></td>
											<td><c:out value="${teacher.contactNumber}" /></td>
											<td><c:out value="${teacher.qualification}" /></td>
											<td><c:out value="${teacher.gender}" /></td>
											<td><c:out value="${teacher.createdDt}" /></td>
											<td><a
												href="/LearnersAcademyAdministrativePortal/teacher?action=delete&id=<c:out value='${teacher.id}' />">Delete</a></td>
										</tr>
									</c:forEach>

								</tr>
							</tfoot>
						</table>
					</div>
				</div>
				<% if(delFlag){%>
				<div>
					<p>
						<span style="color: red;">Record deleted successfully!</span>
					</p>
				</div>
				<%}%>
			</div>
		</div>
	</div>
</div>

