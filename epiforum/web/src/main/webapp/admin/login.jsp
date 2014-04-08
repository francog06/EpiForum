<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- METAS -->
<jsp:include page="/admin/metas.html"></jsp:include>
	<meta name="description" content="Epiforum: Admin">
<!-- LINKS -->
<jsp:include page="/admin/common-css.html"></jsp:include>

	<title>EpiForum - Admin</title>
</head>
<body class="login-body">
	<section id="container">
		<header class="header white-bg">
			<a href="home" class="logo" style="font-size: 50px">Epi<span>Forum </span> - Admin</a>
		</header>
	</section>
	<hr>
	<div class="panel-body">
		<form class="form-signin" action="login" method="POST">
			<h2 class="form-signin-heading">Connectez pour gerer Votre Forum</h2>
			<div class="login-wrap">
				<input name="email" type="email" class="form-control" placeholder="Votre email" autofocus required/>
				<input name="password" type="password" class="form-control"	placeholder="Votre mot de passe" required/>
				<button class="btn btn-lg btn-login btn-block" type="submit">Se connecter</button>
			</div>
		</form>
	</div>
</body>
</html>