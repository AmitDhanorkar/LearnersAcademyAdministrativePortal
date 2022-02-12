<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
	<div class="container-fluid">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary"><a href="pages/dashboard.jsp">Home</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/LearnersAcademyAdministrativePortal/logout" style='float:right'>Logout</a></h6>
	</div>
		<div class="d-sm-flex align-items-center justify-content-between mb-4">
			<h1 class="h3 mb-0 text-gray-800">Add Classes</h1> </div>
		<div class="row">
			<div class="col-lg-12">
				<form class="addClasses" action="/LearnersAcademyAdministrativePortal/classRoom" method="post">
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="className">Class Name</label>
							<input type="text" class="form-control" id="className" name="className" placeholder="Enter Class Name" required="required"> </div>
						<div class="form-group col-md-5">
							<label for="sectionName">Section Name</label>
							<input type="text" class="form-control" id="sectionName" name="sectionName" placeholder="Enter Section Name"> </div>
						<div class="form-group col-md-5">
							<label for="totalNumberOfStudents">Total No of Students</label>
							<input type="number" class="form-control" id="totalNumberOfStudents" name="totalNumberOfStudents" placeholder="Enter Total Number of Students" required="required"> </div>
						<div class="form-group col-md-5">
							<label for="roomNo">Room Name</label>
							<input type="text" class="form-control" id="roomNo" name="roomNo" placeholder="Enter Room Name"> </div>
						<div class="form-group col-md-5">
							<label for="classTeacherName">Class Teacher Name</label>
							<input type="text" class="form-control" id="classTeacherName" name="classTeacherName" placeholder="Enter Class Teacher Name"> </div>
					</div>
					<div class="form-group">
						<button type="reset" id="resetFormAddClasses" name="resetFormAddClasses" class="btn btn-danger">clear</button>
						<button type="submit" id="submitFormAddClasses" name="submitFormAddClasses" class="btn btn-primary">Submit</button>
					</div>
					<input type="hidden"  name="action" value="new"/>
				</form>
			</div>
		</div>
	</div>
