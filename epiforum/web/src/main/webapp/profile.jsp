<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: page d'un profil">

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

<title>${pro.nickname}</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- PROFILE CONTENT BEGIN -->

				<form action="" method="post" id="login">
					<div class="panel">
						<div class="inner">
							<span class="corners-top"><span></span></span>
							<div class="content">
								<h2>Résumé</h2>
								<div>
									<img style="margin-left: 2%; margin-right: 2%; float: left"
										src="./assets/images/original/Guillomef06.jpg">
								</div>
								<fieldset class="fields1" style="margin-left: 5%">
									<dl>
										<dt>
											<label for="username">Prenom:</label>
										</dt>
										<dd>
											<input type="text" tabindex="1" name="username" id="username"
												size="55" value="Goku" disabled class="inputbox autowidth" />
										</dd>
										<dl>
											<dt>
												<label for="username">Nom:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="username"
													id="username" size="55" value="Son" disabled
													class="inputbox autowidth" />
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="username">Pseudo:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="username"
													id="username" size="55" value="Chichi" disabled
													class="inputbox autowidth" />
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="username">Type Membre:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="username"
													id="username" size="55" value="User" disabled
													class="inputbox autowidth" />
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="username">Date d'inscription:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="username"
													id="username" size="55" value="1 Mars 2014  " disabled
													class="inputbox autowidth" />
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="username">Anniversaire:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="username"
													id="username" size="55" value="25 Fevrier" disabled
													class="inputbox autowidth" />
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="username">Messages:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="username"
													id="username" size="55" value="10" disabled
													class="inputbox autowidth" />
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="username">Remerciements recus:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="username"
													id="username" size="55" value="100" disabled
													class="inputbox autowidth" />
											</dd>
										</dl>

										<dl>
											<dt>
												<label for="username">Telephone:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="username"
													id="username" size="55" value="+33647962578" disabled
													class="inputbox autowidth" />
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="username">Facebook:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="username"
													id="username" size="55"
													value="DBZ" disabled
													class="inputbox autowidth" />
											</dd>
										</dl>

										<dl>
											<dt>
												<label for="username">Twitter:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="username"
													id="username" size="55" value="GokySan_InDaPlace" disabled
													class="inputbox autowidth" />
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="username">Skype:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="username"
													id="username" size="55" value="GokuSan_Hardocre" disabled
													class="inputbox autowidth" />
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="username">Genre:</label>
											</dt>
											<dd>
												<input type="checkbox" name="option1" disabled value="Femme">
												Femme <input type="checkbox" name="option2" disabled
													value="Garcon" checked> Garcon
											</dd>
										</dl>

										<dl>
											<dt>
												<label for="username">Ville:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="username"
													id="username" size="55" value="Nice" disabled
													class="inputbox autowidth" />
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="username">Description:</label>
											</dt>
											<textarea value="" disabled size=""
												style="height: 59px; width: 97%" class=""> Salut je suis epitShiTien croise avec SupinfoShitance, manque d'amioru!!!</textarea>
										</dl>
										<dl>
											<dt>&nbsp;</dt>
											<dd>
												<!--	<input type="submit" name="login" tabindex="6" value="Login" class="button1" /></dd> -->
										</dl>
								</fieldset>
								<dl>
									<dt>
										<label for="password">Signature:</label>
									</dt>
									<textarea value="" disabled size=""
										style="height: 96px; width: 97%;" class=""> Ouech nique sa mere le maire!!!</textarea>
								</dl>
							</div>
							<span class="corners-bottom"><span></span></span>
						</div>
					</div>
				</form>

				<!-- STATS -->
				<jsp:include page="/stats.jsp"></jsp:include>

			</div>
			<!-- PROFILE CONTENT END -->
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