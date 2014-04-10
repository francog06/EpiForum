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
		<div class="search-box">
			<form action="search" method="POST" id="search">
				<fieldset>
					<div class="search-box-inner">
						<input class="button2" type="submit" name="Search" value="Search"/>
						<input id="keywords" class="inputbox search" type="text" name="tags"
							onblur="if(this.value=='')this.value='EpiForum';" placeholder="Tag"
							title="Trouvez des sujet grâce aux tags" maxlength="64" name="keywords"/>
					</div>
				</fieldset>
			</form>
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
			<li id="submenu-mark-read"><a href="home" accesskey="m">Home</a></li>
		</ul>
	</div>
</div>