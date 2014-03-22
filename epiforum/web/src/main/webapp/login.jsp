<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- METAS -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="This is the Courses login page !">
<meta name="author" content="MORENO Igor &amp; FRANCOIS Guilaume">

<!-- LINKS -->
<link href="./assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="./assets/css/style.css" rel="stylesheet">
<link href="./assets/css/style-responsive.css" rel="stylesheet">
<title>EpiOC - Login page</title>
</head>
<body>
	<div class="container-fluid">
		<form role="form" class="cmxform form-horizontal form-signin formWrap"
			id="loginForm" method="POST" action="Login">
			<h2 class="form-signin-heading">Connection</h2>
			<c:if test="${error == true}">
			<div id="loginError" class="alert alert-danger">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <strong>Oh snap!</strong> On a perdu un truc en route !
             </div>
             </c:if>
			<fieldset>
				<div class="form-group">
					<label for="email" class="control-label col-xs-2"> Email: </label>
					<div class="col-xs-10">
						<input class="form-control" id="email" name="email" type="email"
							placeholder="Mon email" autofocus required />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="control-label col-xs-2"> Mot de passe: </label>
					<div class="col-xs-10">
						<input class="form-control " id="password" name="password"
							type="password" placeholder="Mon mot de passe" required />
					</div>
				</div>
				<button class="btn btn-lg btn-block btn-login" type="submit">Je me connecte</button>
			</fieldset>
		</form>
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
    <!--  Only for this page-->
    <script language="JavaScript" type="text/javascript"
    	src="./assets/js/form-validation-script.js" async></script>
</body>
</html>