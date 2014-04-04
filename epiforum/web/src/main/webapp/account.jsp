<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: page du compte utilisateur">

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

<link type="text/css" rel="stylesheet" href="./assets/css/profil.css">

<title>Modifier mon compte</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- ACCOUNT CONTENT BEGIN -->

				<div class="panel">
					<div class="inner">
						<span class="corners-top"></span>
						<div class="content">
							<h2>Modifier mon compte</h2>
							<div>
								<img style="margin-left: 2%; margin-right: 2%; float: left"
									src="http://localhost:8080/web/assets/images/original/${myPro.nickname}.jpg">
							</div>
							<fieldset class="fields1" style="margin-left: 5%">
								<form action="myaccount" method="POST" id="editAccountEmail">
									<dl>
										<dt>
											<label for="email">Email:</label>
										</dt>
										<dd>
											<input type="text" tabindex="1" name="email" id="email"
												size="55" class="inputbox autowidth" placeholder="${profile.email}" required/>
										</dd>
									</dl>
									<input type="submit" name="EditAccount" tabindex="6"
											style="width: 55%" size="50" value="Sauvegarder"
											class="button1 autowidth" />
								</form>
								<form action="myaccount" method="POST" id="editAccountMdp">
									<dl>
										<dt>
											<label for="oldpass">Mot de passe:</label>
										</dt>
										<dd>
											<input type="password" tabindex="2" id="oldpass"
												name="oldpass" size="55" class="inputbox autowidth" placeholder="Mon mot de passe"/>
										</dd>
									</dl>
									<dl>
										<dt>
											<label for="newpass">Nouveau mot de passe:</label>
										</dt>
										<dd>
											<input type="password" tabindex="2" id="newpass"
												name="newpass" size="55" class="inputbox autowidth" />
										</dd>
									</dl>
									<input type="submit" name="EditAccount" tabindex="6"
											style="width: 55%" size="50" value="Sauvegarder"
											class="button1 autowidth" />
								</form>
								<form action="myaccount" method="POST" id="editAccountAll">
									<dl>
										<dt>
											<label for="prenom">Prenom:</label>
										</dt>
										<dd>
											<input type="text" tabindex="1" name="prenom" id="prenom"
												size="55" class="inputbox autowidth" placeholder="${profile.firstname}"/>
										</dd>
										<dl>
											<dt>
												<label for="nom">Nom:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="nom" id="nom"
													size="55" class="inputbox autowidth" placeholder="${profile.lastname}"/>
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="pseudo">Pseudo:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="pseudo" id="pseudo"
													size="55" class="inputbox autowidth" placeholder="${profile.nickname}" required/>
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="birth">Anniversaire:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="birth" id="birth"
													size="55" class="inputbox autowidth" placeholder="${profile.birthdate}"/>
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="telephone">Telephone:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="telephone"
													id="telephone" size="55" class="inputbox autowidth" placeholder="${profile.phone}"/>
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="facebook">Facebook:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="facebook"
													id="facebook" size="55" class="inputbox autowidth" placeholder="${profile.facebookPage}"/>
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="twitter">Twitter:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="twitter" id="twitter"
													size="55" class="inputbox autowidth" placeholder="${profile.twitterPage}"/>
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="skype">Skype:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="skype" id="skype"
													size="55" class="inputbox autowidth" placeholder="${profile.skypeContact}"/>
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="genre">Genre:</label>
											</dt>
											<dd>
												<input type="checkbox" id="genre_femme" name="genre_femme" value="Femme">Femme
												<input type="checkbox" id="genre_male" name="genre_male" value="Garcon" checked> Garcon
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="city">Ville:</label>
											</dt>
											<dd>
												<input type="text" tabindex="1" name="city" id="city"
													size="55" class="inputbox autowidth" placeholder="${profile.city}"/>
											</dd>
										</dl>
										<dl>
											<dt>
												<label for="description">Description:</label>
											</dt>
											<textarea name="description" style="height: 96px; width: 97%"
												placeholder="${profile.description}"></textarea>
										</dl>
										<dl>
											<dt>
												<label for="password">Signature:</label>
											</dt>
											<textarea name="signature" style="height: 96px; width: 97%;"
												placeholder="${profile.signature}"></textarea>
										</dl>
										<input type="submit" name="EditAccount" tabindex="6"
											style="width: 55%" size="50" value="Sauvegarder"
											class="button1 autowidth" />
								</form>
							</fieldset>
						</div>
						<span class="corners-bottom"><span></span></span>
					</div>
				</div>
				
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