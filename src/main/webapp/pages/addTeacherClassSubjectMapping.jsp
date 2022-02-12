<%@page import="com.learnersacademy.entity.ClassRoom"%>
<%@page import="com.learnersacademy.entity.Subject"%>
<%@page import="com.learnersacademy.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
	<%
		List<ClassRoom> classRooms = (List<ClassRoom>) session.getAttribute("classRooms");
		List<Subject> subjects =  (List<Subject>) session.getAttribute("subjects");
		List<Teacher> teachers =  (List<Teacher>) session.getAttribute("teachers");
	%>
	<div class="container-fluid">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary"><a href="pages/dashboard.jsp">Home</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/LearnersAcademyAdministrativePortal/logout" style='float:right'>Logout</a></h6>
	</div>
		<div class="d-sm-flex align-items-center justify-content-between mb-4">
			<h1 class="h3 mb-0 text-gray-800">Add Teachers Classes Subjects Mapping</h1> </div>
		<div class="row">
			<div class="col-lg-12">
				<form class="addTeachersClassesSubjectsMapping" action="/LearnersAcademyAdministrativePortal/teacherClassSubjectMapping" method="post">
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="teachersNameCombo">Teacher Name</label>
							<select class="form-control" id="teachersNameCombo" name="teachersNameCombo">
							<option value= 0 selected>Select Teacher Name </option>
								<% if(teachers != null && teachers.size()>0){%>
										<% for(Teacher teacher  : teachers){
										%>
											<option value="<%= teacher.getId()%>"><%= teacher.getFirstName()%></option>
										<%}
									}%>								
							</select>
						</div>
						<div class="form-group col-md-5" style="display : none;">
							<label for="teacherId">Teacher Id</label>
							<input type="text" class="form-control" id="teacherId" name="teacherId" placeholder="Enter Teacher Id"> </div>
						<div class="form-group col-md-5" style="display : none;">
							<label for="teacherName">Teacher Name</label>
							<input type="text" class="form-control" id="teacherName" name="teacherName" placeholder="Enter Teacher Name"> </div>
					</div>
					<div style="display: none" id="errorTea">
						<label><span style="color: red">Please Select Valid Teacher Name</span></label>
					</div>							
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="classesNameCombo">Class Name</label>
							<select class="form-control" id="classesNameCombo" name="classesNameCombo">
							<option value= 0 selected>Select Class Name </option>
									<% if(classRooms != null && classRooms.size()>0){%>
										<% for(ClassRoom cr  : classRooms){
										%>
											<option value="<%= cr.getId()%>"><%= cr.getClassName()%></option>
										<%}
									}%>
							</select>
						</div>
						<div class="form-group col-md-5" style="display : none;">
							<label for="classId">Class Id</label>
							<input type="text" class="form-control" id="classId" name="classId" placeholder="Enter Class Id"> </div>
						<div class="form-group col-md-5" style="display : none;">
							<label for="className">Class Name</label>
							<input type="text" class="form-control" id="className" name="className" placeholder="Enter Class Name"> </div>
						
					</div>
					<div style="display: none" id="errorClass">
							<label><span style="color: red">Please Select Valid Class Name</span></label>
					</div>					
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="subjectsNameCombo">Subject Name</label>
							<select class="form-control" id="subjectsNameCombo" name="subjectsNameCombo">
							<option value= 0 selected>Select Subject Name </option>
								<% if(subjects != null && subjects.size()>0){%>
									<%	for(Subject sub  : subjects){
										%>
											<option value="<%= sub.getId()%>"><%= sub.getSubjectName()%></option>
										<%}
								}%>
							</select>
						</div>
						<div class="form-group col-md-5" style="display : none;">
							<label for="subjectId">Subject Id</label>
							<input type="text" class="form-control" id="subjectId" name="subjectId" placeholder="Enter Subject Id"> </div>
						<div class="form-group col-md-5" style="display : none;">
							<label for="subjectName">Subject Name</label>
							<input type="text" class="form-control" id="subjectName" name="subjectName" placeholder="Enter Subject Name"> </div>
					</div>
					<div style="display: none" id="errorSub">
						<label><span style="color: red">Please Select Valid Subject Name</span></label>
					</div>						
					<div style="display: none" id="errorSubmit">
							<label><span style="color: red">Please Select Valid Option</span></label>
					</div>					
					<div class="form-group">
						<button type="reset" id="resetFormAddTeachersClassesSubjectsMapping" name="resetFormAddTeachersClassesSubjectsMapping" class="btn btn-danger">clear</button>
						<button type="submit" id="submitFormAddTeachersClassesSubjectsMapping" name="submitFormAddTeachersClassesSubjectsMapping" class="btn btn-primary">Submit</button>
					</div>
					<input type="hidden"  name="action" value="new"/>
				</form>
			</div>
		</div>
	</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#teachersNameCombo").click(function() {
			var teacherId = $("#teachersNameCombo option:selected").val();
			if (teacherId == 0) {
				document.getElementById("errorTea").style.display = "inline";
				document.getElementById("errorSub").style.display = "none";
				document.getElementById("errorClass").style.display = "none";
				document.getElementById("errorSubmit").style.display = "none";
				return false;
			} else {
				document.getElementById("errorTea").style.display = "none";
			}
		});

	});

	$(document).ready(function() {
		$("#subjectsNameCombo").click(function() {
			var subjectId = $("#subjectsNameCombo option:selected").val();
			if (subjectId == 0) {
				document.getElementById("errorSub").style.display = "inline";
				document.getElementById("errorTea").style.display = "none";
				document.getElementById("errorClass").style.display = "none";
				document.getElementById("errorSubmit").style.display = "none";
				return false;
			} else {
				document.getElementById("errorSub").style.display = "none";
			}
		});

	});

	$(document).ready(function() {
		$("#classesNameCombo").click(function() {
			var classId = $("#classesNameCombo option:selected").val();
			if (classId == 0) {
				document.getElementById("errorClass").style.display = "inline";
				document.getElementById("errorTea").style.display = "none";
				document.getElementById("errorSub").style.display = "none";
				document.getElementById("errorSubmit").style.display = "none";
				return false;
			} else {
				document.getElementById("errorClass").style.display = "none";
			}
		});

	});
	$(document).ready(function() {
		$("#submitFormAddTeachersClassesSubjectsMapping").click(function() {
			var subjectId = $("#subjectsNameCombo option:selected").val();
			var classId = $("#classesNameCombo option:selected").val();
			var teacherId = $("#teachersNameCombo option:selected").val();
			document.forms[0].elements["subjectName"].value = $("#subjectsNameCombo option:selected").text();
			document.forms[0].elements["className"].value = $("#classesNameCombo option:selected").text();
			document.forms[0].elements["teacherName"].value = $("#teachersNameCombo option:selected").text();
			if (subjectId == 0 || classId == 0 || teacherId == 0) {
				document.getElementById("errorSubmit").style.display = "inline";
				document.getElementById("errorTea").style.display = "none";
				document.getElementById("errorSub").style.display = "none";
				document.getElementById("errorClass").style.display = "none";
				return false;
			} else {
				document.getElementById("errorSubmit").style.display = "none";
			}
		});
	});
</script>