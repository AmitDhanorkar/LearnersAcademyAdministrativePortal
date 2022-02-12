<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="/LearnersAcademyAdministrativePortal/css/menuNavigation.css" rel="stylesheet" type="text/css">
<header>
<div class="navbar">
	<div class="dropdown">
		<button class="dropbtn">Student<i class="fa fa-caret-down"></i></button>
		<div class="dropdown-content">
			<a href="/LearnersAcademyAdministrativePortal/classRoom?action=listClassName">Add Student</a> 
			<a href="/LearnersAcademyAdministrativePortal/student?action=list">List Students</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbtn">ClassRoom<i class="fa fa-caret-down"></i></button>
		<div class="dropdown-content">
			<a href="/LearnersAcademyAdministrativePortal/classRoom?action=addJsp">Add Class</a> 
			<a href="/LearnersAcademyAdministrativePortal/classRoom?action=list">List Classes</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbtn">Teacher<i class="fa fa-caret-down"></i></button>
		<div class="dropdown-content">
			<a href="/LearnersAcademyAdministrativePortal/teacher?action=addJsp">Add Teachers</a> 
			<a href="/LearnersAcademyAdministrativePortal/teacher?action=list">List Teachers</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbtn">Subject<i class="fa fa-caret-down"></i></button>
		<div class="dropdown-content">
			<a href="/LearnersAcademyAdministrativePortal/subject?action=addJsp">Add Subjects</a> 
			<a href="/LearnersAcademyAdministrativePortal/subject?action=list">List Subjects</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbtn">Classes Mapping<i class="fa fa-caret-down"></i></button>
		<div class="dropdown-content">
			<a href="/LearnersAcademyAdministrativePortal/classSubjectMapping?action=mappingDetails">Class Subject Mapping</a> 
			<a href="/LearnersAcademyAdministrativePortal/classSubjectMapping?action=list">List Mapped Class-Subject</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbtn">Teachers Mapping<i class="fa fa-caret-down"></i></button>
		<div class="dropdown-content">
			<a href="/LearnersAcademyAdministrativePortal/teacherClassSubjectMapping?action=mappingDetails">Teacher Class Mapping</a> 
			<a href="/LearnersAcademyAdministrativePortal/teacherClassSubjectMapping?action=list">List Mapped Teacher-Class</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbtn">Class Reports<i class="fa fa-caret-down"></i></button>
		<div class="dropdown-content">
			<a href="/LearnersAcademyAdministrativePortal/classRoom?action=list&reportFlag=Y">Class Report Details</a>
		</div>
	</div>
	<a href="/LearnersAcademyAdministrativePortal/logout">Log out</a>
</div>
</header>