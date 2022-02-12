<%@page import="com.learnersacademy.entity.ClassRoom"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
	<%
		List<ClassRoom> classRooms = (List<ClassRoom>) session.getAttribute("classRooms");
	%>
<div class="container-fluid">
	<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary"><a href="pages/dashboard.jsp">Home</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/LearnersAcademyAdministrativePortal/logout" style='float:right'>Logout</a></h6>
	</div>
		<div class="d-sm-flex align-items-center justify-content-between mb-4">
			<h1 class="h3 mb-0 text-gray-800">Add Students</h1> </div>
		<div class="row">
			<div class="col-lg-12">
				<form class="addStudents" id="addStudents" action="/LearnersAcademyAdministrativePortal/student" method="POST">
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="studentName">Student Name</label>
							<input type="text" class="form-control" id="studentName" name="studentName" placeholder="Enter Student Name" required="required"> </div>
						<div class="form-group col-md-5">
							<label for="fathersName">Email Address</label>
							<input type="email" class="form-control" id="email" name="email" placeholder="Enter Email Address"> </div>
						<div class="form-group col-md-5">
							<label for="emergencyContactNumber">Emergency Contact Number</label>
							<input type="text" class="form-control" id="emergencyContactNumber" name="emergencyContactNumber" placeholder="Enter Emergency Contact Number" required="required" maxlength="10"> </div>
						<div class="form-group col-md-5">
							<label for="bloodGroup">Blood Group</label>
							<input type="text" class="form-control" id="bloodGroup" name="bloodGroup" placeholder="Enter Blood Group" required="required"> </div>
						<div class="form-group col-md-5">
							<label for="age">Age</label>
							<input type="number" class="form-control" id="age" name="age" placeholder="Enter Age"> </div>
						<div class="form-group col-md-5">
							<label for="gender">Gender</label>
							<select class="form-control" id="gender" name="gender">
								<option selected>Enter Gender </option>
								<option value="male">Male</option>
								<option value="female">Female</option>
								<option value="others">Others</option>
							</select>
						</div>
						<div class="form-group col-md-5">
							<label for="classesNameCombo">Class Name</label>
							<select class="form-control" id="classesNameCombo" name="classesNameCombo">
							<option value= 0 selected>Select Class Name </option>
									<% if(classRooms != null && classRooms.size()>0){
										for(ClassRoom cr  : classRooms){
										%>
											<option value="<%= cr.getId()%>"><%= cr.getClassName()%></option>
										<%}
									}%>
							</select>
						</div>
						<div style="display: none" id="errorClass">
							<label><span style="color: red">Please Select Valid Class Name</span></label>
					   </div>
						<div class="form-group col-md-5" style="display : none;">
							<label for="classId">Class Id</label>
							<input type="text" class="form-control" id="classId" name="classId" placeholder="Enter Class Id"> </div>
						<div class="form-group col-md-5" style="display : none;">
							<label for="className">Class Name</label>
							<input type="text" class="form-control" id="className" name="className" placeholder="Enter Class Name"> </div>
						<div class="form-group col-md-10">
							<label for="address">Address</label>
							<textarea class="form-control" id="address" name="address" rows="3"></textarea>
						</div>
					</div>
					<div class="form-group">
						<button type="reset" id="resetFormAddStudents" name="resetFormAddStudents" class="btn btn-danger">clear</button>
						<button type="submit" id="submitFormAddStudents" name="submitFormAddStudents" class="btn btn-primary">Submit</button>
					</div>
					<input type="hidden" name="action" value="new">
			</form>
			</div>
		</div>
	</div>
<script type="text/javascript">
$(document).ready(function() {
	$("#classesNameCombo").click(function() {
		var classId = $("#classesNameCombo option:selected").val();
		if(classId == 0){
			document.getElementById("errorClass").style.display="inline";
			return false;
		} else {
			document.getElementById("errorClass").style.display="none";
		}
	});

});
$(document).ready(function() {
	$("#submitFormAddStudents").click(function() {
		var classId = $("#classesNameCombo option:selected").val();
		if(classId == 0){
			document.getElementById("errorClass").style.display="inline";
			return false;
		} else {
			document.getElementById("errorClass").style.display="none";
		}
	});

});
</script>

