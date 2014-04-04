<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: page d'inscription">

<!-- LINKS -->
<link media="print" type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/print.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/normal.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/medium.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/large.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/common.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/common.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/links.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/content.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/buttons.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/cp.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/forms.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/tweaks.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/colours.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/responsive.css">
<link type="text/css" rel="stylesheet"
	href='//fonts.googleapis.com/css?family=Open+Sans:300,400,600&subset=latin,cyrillic'>
<link type="text/css" rel="stylesheet"
	href="./assets/font-awesome/css/font-awesome.min.css">

<title>Inscription</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<form action="subscribe" method="post" id="login">
				<div class="panel">
					<div class="inner">
						<span class="corners-top"><span></span></span>
						<div class="content">
							<h2>Veuillez completer ce formulaire pour vous inscrire</h2>
							<fieldset class="fields1">
								<dl>
									<dt>
										<span style="color: red"> *<span><label
												for="email"> Email</label>
									</dt>
									<dd>
										<input type="text" tabindex="1" name="email" id="email"
											size="35" value="" class="inputbox autowidth" required/>
									</dd>
								</dl>
								<dl>
									<dt>
										<span style="color: red"> *<span><label
												for="password"> Mot de passe</label>
									</dt>
									<dd>
										<input type="password" tabindex="2" id="password"
											name="password" size="35" class="inputbox autowidth" required/>
									</dd>
								</dl>
								<dl>
									<dt>
										<span style="color: red"> *<span><label
												for="password"> Resaisisez le mot de passe</label>
									</dt>
									<dd>
										<input type="password" tabindex="2" id="password"
											name="password" size="35" class="inputbox autowidth" required/>
									</dd>
								</dl>
								<dl>
									<dt>
										<span style="color: red"> *<span><label
												for="nickname"> Pseudonyme</label>
									</dt>
									<dd>
										<input type="text" tabindex="1" name="nickname" id="nickname"
											size="35" value="" class="inputbox autowidth" required/>
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="firstname">Prenom:</label>
									</dt>
									<dd>
										<input type="text" tabindex="1" name="firstname"
											id="firstname" size="35" value="" class="inputbox autowidth" />
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="lastname">Nom:</label>
									</dt>
									<dd>
										<input type="text" tabindex="1" name="lastname" id="lastname"
											size="35" value="" class="inputbox autowidth" />
									</dd>
								</dl>
								<dl>
									<dt>&nbsp;</dt>
									<dd>
										<input type="submit" name="login" tabindex="6"
											value="Inscription" class="button1" />
									</dd>
								</dl>
							</fieldset>
						</div>
						<span class="corners-bottom"><span></span></span>
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