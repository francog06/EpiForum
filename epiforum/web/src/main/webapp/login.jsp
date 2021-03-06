<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description"
	content="Epiforum: page de connexion">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>

<title>Connexion</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
		
			<h2>Connexion</h2>
			<div class="panel">
				<div class="inner">
					<span class="corners-top"></span>
					<div class="content">
						<form action="login" method="POST" id="login">
							<fieldset class="fields1">
								<dl>
									<dt><label for="email">Email:</label></dt>
									<dd><input type="email" tabindex="1" name="email" id="email"
										size="25" placeholder="exemple@mail.com" class="inputbox autowidth" required/></dd>
								</dl>
								<dl>
									<dt><label for="password">Mot de passe:</label></dt>
									<dd><input type="password" tabindex="2" id="password" name="password"
										size="25" class="inputbox autowidth" required/></dd>
								</dl>
								<dl>
									<dd><input type="submit" name="login" tabindex="6" value="Login" class="button1"/></dd>
								</dl>
							</fieldset>
						</form>
						<a title="Oublie de mot de passe" href="forgotpassword">J'ai oublié mon mot de passe !</a>
					</div>
					<span class="corners-bottom"></span>
				</div>
			</div>
		</div>
		<!-- FOOTER -->
		<jsp:include page="/footer.html"></jsp:include>

	</div>
<!-- JAVASCRIPTS -->
<jsp:include page="/common-js.html"></jsp:include>

</body>
</html>