<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: feedback">

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

<title>Feedback</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- FEEDBACK CONTENT BEGIN -->

				<h2>FeedBack: posez nous votre question</h2>
				<form action="" method="post" id="login">
					<div class="panel">
						<div class="inner">
							<span class="corners-top"><span></span></span>
							<div class="content">
								<h2>Veuillez completer les champs</h2>
								<fieldset class="fields1">
									<dl>
										<dt>
											<label for="username">Titre:</label>
										</dt>
										<dd>
											<input type="text" tabindex="1" name="username" id="username"
												size="55" value="" class="inputbox autowidth" />
										</dd>
									</dl>
									<br>
									<dl>
										<dt>
											<label for="username">Email ou Pseudo:</label>
										</dt>
										<dd>
											<input type="text" tabindex="1" name="username" id="username"
												size="55" value="" class="inputbox autowidth" />
										</dd>
									</dl>
									<br>
									<dl>
										<dt>
											<label for="password">Question:</label>
										</dt>
										<textarea value="" size=""
											style="height: 226px; width: 438px;" class=""> </textarea>
									</dl>
									<dl>
										<dt>&nbsp;</dt>
										<dd>
											<input type="submit" name="login" style="margin-left: 53%"
												tabindex="6" value="Envoyer" class="button1" />
										</dd>
									</dl>
								</fieldset>
							</div>
							<span class="corners-bottom"><span></span></span>
						</div>
					</div>
				</form>
				<!-- STATS -->
				<jsp:include page="/stats.jsp"></jsp:include>

			</div>
			<!-- CATEGORY CONTENT END -->
			<!--  SIDEBAR  -->
			<jsp:include page="/sidebar.jsp"></jsp:include>

		</div>
		<!-- FOOTER -->
		<jsp:include page="/footer.html"></jsp:include>

	</div>
	<!-- JAVASCRIPTS -->
	<jsp:include page="/common-js.html"></jsp:include>

</body>
</html>