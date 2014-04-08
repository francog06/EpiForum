<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: page d'oublie de mot de passe">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>

<title>Oublie de mot de passe</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>
		
		<div id="page-body">
			<form action="forgotpassword" method="POST" id="login">
				<div class="panel">
					<div class="inner"><span class="corners-top"><span></span></span>
						<div class="content">
							<h2>Veuillez saisir votre email</h2>
							<fieldset class="fields1">
								<dl>
									<dt><label for="email">Email:</label></dt>
									<dd><input type="text" tabindex="1" name="email" id="email"
										size="55" class="inputbox autowidth" required/></dd>
								</dl>
								<dl>
									<input type="submit" name="forgotPassword" tabindex="2" value="Valider" class="button1"/>
								</dl>
							</fieldset>
						</div>
						<span class="corners-bottom"></span>
					</div>
				</div>
			</form>
		</div>

		<!-- FOOTER -->
		<jsp:include page="/footer.html"></jsp:include>

	</div>
<!-- JAVASCRIPTS -->
<jsp:include page="/common-js.html"></jsp:include>

</body>
</html>