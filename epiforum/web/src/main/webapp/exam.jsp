<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- METAS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="This is the Courses exam page !">
<meta name="author" content="MORENO Igor &amp; FRANCOIS Guilaume">

<!-- LINKS -->
<link href="./assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="./assets/css/style.css" rel="stylesheet">
<link href="./assets/css/style-responsive.css" rel="stylesheet">
<link href="./assets/css/bootstrap-reset.css" rel="stylesheet">
<title>EpiOC - Exam page</title>
</head>
<body>
	<div class="container-fluid">
		<header class="clearfix">
		<a target="_self" href="Home">
			<h1>Bienvenuesur Epi Open Classroom</h1>
		</a>
		<div class="header-links">
			<a target="_self" href="Signup" class="btn btn-default" type="button">Inscription</a>
			<a target="_self" href="Login" class="btn btn-default" type="button">Connection</a>
			<c:if test="${token != null}">
				<a target="_self" href="Logout" class="btn btn-default" type="button">Deconnection</a>
				<a target="_self" href="Account" class="btn btn-default" type="button">Mon compte</a>
			</c:if>
		</div>
		</header>
		<main class="clearfix"> <section class="clearfix">
		<h2>Mon résultat a l'examen</h2>
		<div class="centered">
		<p>Cher utilisateur ${acr.lastName} ${acr.firstName}, à la date du ${exam.created}, 
		nous avons le plaisir de vous annoncer que vous avez reussit l'examen sur: 
		${exam.quizz.course.title} avec une note de ${exam.score} / 5</p>
		</div>
		</section> </main>
		<footer class="clearfix copyright">
		<p>Copyright © 2010-2014 - EpiOpenClassRoom</p>
		</footer>
	</div>

	<!-- common script for all pages-->
	<!-- js placed at the end of the document so the pages load faster -->
	<script language="JavaScript" type="text/javascript"
		src="./assets/js/jquery-1.11.0.js"></script>
	<script language="JavaScript" type="text/javascript"
		src="./assets/bootstrap/js/bootstrap.min.js" async></script>
	<script language="JavaScript" type="text/javascript"
		src="./assets/js/jquery.scrollTo.min.js" async></script>
	<script language="JavaScript" type="text/javascript"
		src="./assets/js/jquery.nicescroll.js" async></script>
	<script language="JavaScript" type="text/javascript"
		src="./assets/js/jquery.validate.min.js" async></script>
	<script language="JavaScript" type="text/javascript"
		src="./assets/js/common-scripts.js" async></script>
</body>
</html>