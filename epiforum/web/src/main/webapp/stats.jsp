<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3 class="dark-header">Qui est en ligne ?</h3>
<div class="dark-header-content">
	<c:if test="${connectedMembers != null}">
		Il y a <strong>${cMemberSize}</strong> membres en ligne.<br>
		<c:forEach var="coMember" items="${connectedMembers}">
		<c:if test="${coMember.type eq 0}">
			<a style="color: #111199" href="profile?nick=${coMember.nickname}">${coMember.nickname}</a> 
		</c:if>
		<c:if test="${coMember.type eq 1}">
			<a style="color: #119911" href="profile?nick=${coMember.nickname}">${coMember.nickname}</a> 
		</c:if>
		<c:if test="${coMember.type eq 2}">
			<a style="color: #991111" href="profile?nick=${coMember.nickname}">${coMember.nickname}</a> 
		</c:if>
		</c:forEach>
	</c:if>
	<c:if test="${connectedMembers == null}">
		Il y a <strong>0</strong> membres en ligne.
	</c:if>
</div>

<h3 class="dark-header">Statistiques</h3>
<div class="dark-header-content">
	Nombre de messages <strong>${nbPosts}</strong> • Nombre de sujets <strong>${nbTopics}</strong> •
	Membres inscrits <strong>${nbMembers}</strong>
</div>

<h3 class="dark-header">Anniversaire</h3>
<div class="dark-header-content">
	<c:if test="${birthdayMembers != null}">
		Nous souhaitons un joyeux anniversaire à: 
		<c:forEach var="bMember" items="${birthdayMembers}">
			<a href="profile?nick=${bMember.nickname}">${bMember.nickname}</a>  
		</c:forEach>
	</c:if>
	<c:if test="${birthdayMembers == null}">
		Il n'y a pas d'anniversaire à feter aujourd'hui :(
	</c:if>
</div>