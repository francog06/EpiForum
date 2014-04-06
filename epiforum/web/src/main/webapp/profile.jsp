<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: page du profil utilisateur">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>
<link type="text/css" rel="stylesheet" href="assets/css/profil.css">

<title>Profil de ${profile.nickname}</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- PROFILE CONTENT BEGIN -->

				<div class="panel">
					<div class="inner">
						<span class="corners-top"><span></span></span>
						<div class="content">
							<h2>Profil de ${profile.nickname}</h2>
							<div class="img_profil">
								<c:if test="${profile.picture eq true}">
								<img class="img_profil_src" width="128px" height="128px" alt="Photo de profil de ${profile.nickname}"
									src="assets/images/original/${profile.nickname}.jpg">
								</c:if>
								<c:if test="${profile.picture eq false}">
								<img class="img_profil_src" width="128px" height="128px" alt="Photo de profil de ${profile.nickname}"
									src="assets/images/original/default.jpg">
								</c:if>
							</div>
							<div class="div_top_profil">
								<label class="profile_font"><i class="fa fa-user"></i></label>
									<strong class="profile_font">${profile.nickname}</strong>
								<c:if test="${profile.facebookPage ne null}">
									<a href="https://www.facebook.com/${profile.facebookPage}"
									title="www.facebook.com/${profile.facebookPage}" target="_blank">
									<i class="fa fa-facebook fa-3x social-icon facebook-color"></i></a>
								</c:if>
								<c:if test="${profile.facebookPage eq null}">
									<i title="Pas de profil facebook" class="fa fa-facebook fa-3x img_icon_grey social-icon"></i>
								</c:if>
								<c:if test="${profile.twitterPage ne null}">
									<a href="https://twitter.com/${profile.twitterPage}"
									title="twitter.com/${profile.twitterPage}" target="_blank">
									<i class="fa fa-twitter fa-3x social-icon twitter-color"></i></a>
								</c:if>
								<c:if test="${profile.twitterPage eq null}">
									<i title="Pas de profil twitter" class="fa fa-twitter fa-3x social-icon img_icon_grey"></i></a>
								</c:if>
								<c:if test="${profile.skypeContact ne null}">
								<a href="skype:${profile.skypeContact}?call" title="Skype: ${profile.skypeContact}">
									<i class="fa fa-skype fa-3x social-icon skype-color"></i></a>
								</c:if>
								<c:if test="${profile.skypeContact eq null}">
									<i title="Pas de compte skype" class="fa fa-skype fa-3x social-icon img_icon_grey"></i></a>
								</c:if>
								<br><br>
								<label class="profile_font">
									<c:if test="${profile.gender eq true}">
									<i class="fa fa-male"></i>
								</label>
								<strong class="profile_font">Homme</strong>
								</c:if>
								<c:if test="${profile.gender eq false}">
									<i class="fa fa-female"></i>
								</label>
								<strong class="profile_font">Femme</strong>
								</c:if>
								<br><br>
								<label class="profile_font">
									<i class="fa fa-map-marker"></i>
								</label>
								<a href="https://maps.google.com/?q=${profile.city}" target="_blank" style="font-size: 20px">${profile.city}</a>
								<br><hr>
							</div>
							<div class="div_bottom_left">
								<label>Rang:</label>
								<c:if test="${profile.type eq 'MEMBRE'}"><strong>Membre</strong>
								</c:if>
								<c:if test="${profile.type eq 'MODERATEUR'}"><strong>Modérateur</strong>
								</c:if>
								<c:if test="${profile.type eq 'ADMIN'}"><strong>Admin</strong>
								</c:if>
								<br><br>
								<label>Date d'inscription:</label><strong>${profile.created}</strong>
								<br><br>
								<label>Anniversaire:</label><strong>${profile.birthdate}</strong>
								<br><br>
								<label>Messages:</label><strong>${profile.nbPost}</strong>
								<br><br>
								<label>Remerciements recus:</label><strong>${profile.nbThank}</strong>
							</div>
							<fieldset class="fields1 div_bottom_right">
								<label class="profile_font">Prenom:</label>
									<strong class="profile_font">${profile.firstname}</strong>
								<br><br>
								<label class="profile_font">Nom:</label>
									<strong class="profile_font">${profile.lastname}</strong>
								<br><br>
								<label class="profile_font">Telephone:</label>
									<strong class="profile_font">${profile.phone}</strong>
								<br><br>
								<label class="profile_font">Description:</label>
									<strong class="profile_font">${profile.description}</strong>
								<br><br>
								<label class="profile_font">Signature:</label>
									<strong class="profile_font">${profile.signature}</strong>
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