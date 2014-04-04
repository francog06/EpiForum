<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="page-header">
	<div id="above-headerbar">
		<ul class="user-links">
			<c:if test="${Authorization != null}">
				<li><a href="unsubscribe" title="Se desinscrire" accesskey="x">Se desinscrire</a></li>
				<li><a href="logout" title="Se deconnecter" accesskey="x">Se deconnecter</a></li>
			</c:if>
			<c:if test="${Authorization == null}">
				<li><a href="subscribe" title="S'inscrire" accesskey="x">S'inscrire</a></li>
				<li><a href="login"	title="Se Connecter" accesskey="x">Se connecter</a></li>
			</c:if>
		</ul>
		<%-- <div id="login-box" class="login-popup">
			<a href="#" class="close">
			<img src="./assets/metro_purple/theme/images/close_popup.png"
				class="close-button" title="Close" alt="Close" /></a>
			<div id="login-text">Se connecter</div>
			<fieldset>
				<div class="navbar_username_outer">
					<label for="username">Email:</label>&nbsp;<br/>
					<input type="text" name="username" id="navbar_username" size="10"
						class="inputbox" title="Email" />
				</div>
				<div class="navbar_password_outer">
					<label for="password">Mot de passe:</label>&nbsp;<br/>
					<input type="password" name="password" id="navbar_password" size="10"
						class="inputbox" title="Mot de passe" />
				</div>
				<div class="login-buttons">
					<input type="submit" name="login" value="Se connecter" class="button2"/>
					<label id="autologin_label" for="autologin">Connexion Automatique
						<input type="checkbox" name="autologin" id="autologin"/>
					</label>
				</div>
			</fieldset>
			<a class="register-link" href="SubscribeView.html"> S'inscrire</a>
		</div> --%>
		<div class="search-box">
			<fieldset>
				<div class="search-box-inner">
					<input class="button2" type="submit" value="Search"> <input
						id="keywords" class="inputbox search" type="text"
						onblur="if(this.value=='')this.value='Search…';"
						onclick="if(this.value=='Search…')this.value='';"
						placeholder="Cherchez des messages ou des membres"
						title="Trouvez des messages ou des membres" maxlength="128" name="keywords">
				</div>
			</fieldset>
		</div>
	</div>
	<div id="header">
		<a id="logo" title="Accueil" style="color: White; font-size: 50px" href="home">EpiForum</a>
		<div class="tabs-outer">
			<a class="toggleMenuButton" title="Menu" href="javascript:void(0);"></a>
			<ul class="tabs">
				<li id="members-link"><a title="A propos de EpiForum" href="aboutus"><span>A propos</span>
				</a></li>
				<li id="faq-link"><a title="Retours utilisateur" href="feedback"><span>Feedback</span>
				</a></li>
				<li id="sample-link"><a title="Soutenez notre projet !" href="donate"><span>Faire un don</span>
				</a></li>
			</ul>
		</div>
	</div>
	<div id="subheader-menu">
		<ul class="links left">
			<li id="submenu-mark-read"><a href="home" accesskey="m">Welcome</a></li>
		</ul>
	</div>
	<div id="breadcrumbs">
		<a class="icon-home" href="home" accesskey="h">Home</a>
	</div>
</div>