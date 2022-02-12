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
		<h1 class="h3 mb-0 text-gray-800">Add Teachers</h1>
	</div>
	<div class="row">
		<div class="col-lg-12">
				<form class="addTeachers" action="/LearnersAcademyAdministrativePortal/teacher" method="POST">
				<div class="form-row">
					<div class="form-group col-md-5">
						<label for="firstName">First Name</label> <input type="text"
							class="form-control" id="firstName" name="firstName"
							placeholder="Enter First Name" required="required">
					</div>
					<div class="form-group col-md-5">
						<label for="lastName">Last Name</label> <input type="text"
							class="form-control" id="lastName" name="lastName"
							placeholder="Enter Last Name">
					</div>
					<div class="form-group col-md-5">
						<label for="Contact Number">Contact Number</label> <input
							type="text" class="form-control" id="contactNumber"
							name="contactNumber" placeholder="Enter Contact Number" required="required" maxlength="10">
					</div>
					<div class="form-group col-md-5">
						<label for="emailAddress">Email Address</label> <input
							type="email" class="form-control" id="emailAddress"
							name="emailAddress" aria-describedby="emailHelp"
							placeholder="Enter Email Address" required="required">
					</div>
					<div class="form-group col-md-5">
						<label for="qualification">Qualification</label> <input
							type="text" class="form-control" id="qualification"
							name="qualification" placeholder="Enter Qualification" required="required">
					</div>
					<div class="form-group col-md-5">
						<label for="age">Age</label> <input type="number"
							class="form-control" id="age" name="age" placeholder="Enter Age">
					</div>
					<div class="form-group col-md-5">
						<label for="martialStatus">Martial Status</label> <select
							class="form-control" id="martialStatus" name="martialStatus">
							<option selected>Enter Martial Status </option>
							<option value="Single">Single</option>
							<option value="Married">Married</option>
						</select>
					</div>
					<div class="form-group col-md-5">
						<label for="gender">Gender</label> <select class="form-control"
							id="gender" name="gender">
							<option selected>Enter Gender </option>
							<option value="male">Male</option>
							<option value="female">Female</option>
							<option value="others">Others</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<button type="reset" id="resetFormAddTeachers"
						name="resetFormAddTeachers" class="btn btn-danger">clear</button>
					<button type="submit" id="submitFormAddTeachers"
						name="submitFormAddTeachers" class="btn btn-primary">Submit</button>
				</div>
				<input type="hidden"  name="action" value="new"/>
			</form>
		</div>
	</div>
</div>
