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
<jsp:include page="/common-css.html"></jsp:include>
<link type="text/css" rel="stylesheet"href="./assets/css/profil.css">

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
								<c:if test="${myPro.picture eq true}">
								<img style="margin-left: 2%; margin-right: 2%; float: left"
									src="assets/images/original/${myPro.nickname}.jpg">
								</c:if>
								<c:if test="${myPro.picture eq false}">
								<img style="margin-left: 2%; margin-right: 2%; float: left"
									src="assets/images/original/default.jpg">
								</c:if>
							</div>
							<fieldset class="fields1" style="margin-left: 5%">
								<form action="myaccount" method="POST" id="editAccountEmail">
									<dl>
										<dt>
											<label for="email">Email:</label>
										</dt>
										<dd>
											<input type="hidden" name="hemail" value="${profile.email}"/>
											<input type="text" tabindex="1" name="email" id="email"
												size="55" class="inputbox autowidth" placeholder="${profile.email}" required/>
										</dd>
									</dl>
									<dl>
										<dt>
											<label for="newemail">Nouveau email:</label>
										</dt>
										<dd>
											<input type="text" tabindex="1" name="newemail" id="newemail"
												size="55" class="inputbox autowidth" />
										</dd>
									</dl>
									<input type="submit" name="EditAccountEmail" tabindex="6"
											style="width: 55%" size="50" value="Sauvegarder"
											class="button1 autowidth" />
								</form>
								<br/><br/>
								<form action="myaccount" method="POST" id="editAccountMdp">
									<dl>
										<dt>
											<label for="pass">Mot de passe:</label>
										</dt>
										<dd>
											<input type="hidden" name="hemail" value="${profile.email}"/>
											<input type="password" tabindex="2" id="pass"
												name="pass" size="55" class="inputbox autowidth" placeholder="Mon mot de passe"/>
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
									<input type="submit" name="EditAccountMdp" tabindex="6"
											style="width: 55%" size="50" value="Sauvegarder"
											class="button1 autowidth" />
								</form>
								<br/><br/>
								<form action="myaccount" method="POST" id="editAccountAll">
									<dl>
										<dt><label for="prenom">Prenom:</label></dt>
										<dd>
											<input type="text" tabindex="1" name="prenom" id="prenom" 
												size="55" class="inputbox autowidth" placeholder="${profile.firstname}"/>
										</dd>
										<dl>
											<dt><label for="nom">Nom:</label></dt>
											<dd>
												<input type="text" tabindex="1" name="nom" id="nom" 
													size="55" class="inputbox autowidth" placeholder="${profile.lastname}"/>
											</dd>
										</dl>
										<dl>
											<dt><label for="pseudo">Pseudo:</label></dt>
											<dd>
												<input type="text" tabindex="1" name="pseudo" id="pseudo" 
													size="55" class="inputbox autowidth" value="${profile.nickname}" required/>
											</dd>
										</dl>
										<dl>
											<dt><label for="anniv">Anniversaire:</label></dt>
											<dd>
												<input type="text" tabindex="1" name="anniv" id="anniv" 
													size="55" class="inputbox autowidth"  placeholder="${profile.birthdate}"/>
											</dd>
										</dl>
										<dl>
											<dt><label for="telephone">Telephone:</label></dt>
											<dd>
												<input type="text" tabindex="1" name="telephone" title="Exemple: 0600000000" 
													id="telephone" size="55" class="inputbox autowidth" placeholder="${profile.phone}"/>
											</dd>
										</dl>
										<dl>
											<dt><label for="facebook">Facebook:</label></dt>
											<dd>
												<input type="text" tabindex="1" name="facebook" title="Exemple: jonathan.clus" 
													id="facebook" size="55" class="inputbox autowidth" placeholder="${profile.facebookPage}"/>
											</dd>
										</dl>
										<dl>
											<dt><label for="twitter">Twitter:</label></dt>
											<dd>
												<input type="text" tabindex="1" name="twitter" id="twitter" title="Exemple: majditoumi" 
													size="55" class="inputbox autowidth" placeholder="${profile.twitterPage}"/>
											</dd>
										</dl>
										<dl>
											<dt><label for="skype">Skype:</label></dt>
											<dd>
												<input type="text" tabindex="1" name="skype" id="skype"
													size="55" class="inputbox autowidth" placeholder="${profile.skypeContact}"/>
											</dd>
										</dl>
										<dl>
											<dt><label for="genre">Genre:</label></dt>
											<dd>
												<input type="radio" id="genre_femme" name="genre_femme" value="Femme">Femme
												<input type="radio" id="genre_homme" name="genre_homme" value="Garcon">Homme
											</dd>
										</dl>
										<dl>
											<dt><label for="ville">Ville:</label></dt>
											<dd>
												<input type="text" tabindex="1" name="ville" id="ville" title="Exemple: Paris" 
													size="55" class="inputbox autowidth" placeholder="${profile.city}"/>
											</dd>
										</dl>
										<dl>
											<dt><label for="description">Description:</label></dt>
											<textarea name="description" style="height: 96px; width: 97%"
												placeholder="${profile.description}" ></textarea>
										</dl>
										<dl>
											<dt><label for="signature">Signature:</label></dt>
											<textarea name="signature" style="height: 96px; width: 97%;"
												placeholder="${profile.signature}" ></textarea>
										</dl>
										<input type="submit" name="EditAccountAll" tabindex="6"
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