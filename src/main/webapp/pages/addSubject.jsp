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
		<h1 class="h3 mb-0 text-gray-800">Add Subjects</h1>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<form class="addSubjects "action="/LearnersAcademyAdministrativePortal/subject" method="POST">
				<div class="form-row">
					<div class="form-group col-md-5">
						<label for="subjectName">Subject Name</label> <input type="text"
							class="form-control" id="subjectName" name="subjectName"
							placeholder="Enter Subject Name" required="required">
					</div>
					<div class="form-group col-md-10">
						<label for="subjectDescription">Subject Description</label>
						<textarea class="form-control" id="subjectDescription"
							name="subjectDescription" rows="3" maxlength="500"></textarea>
					</div>
				</div>
				<div class="form-group">
					<button type="reset" id="resetFormAddSubjects"
						name="resetFormAddSubjects" class="btn btn-danger">clear</button>
					<button type="submit" id="submitFormAddSubjects"
						name="submitFormAddSubjects" class="btn btn-primary">Submit</button>
				</div>
				<input type="hidden"  name="action" value="new"/>
			</form>
		</div>
	</div>
</div>