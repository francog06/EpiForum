<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${Authorization != null}">
	<div id="sidebar">
		<div class="sidebar-block">
			<h2 class="sidebar-block-header">Résumé</h2>
			<div class="sidebar-block-content">
				<div class="container-fluid">
					<div class="profilebox">
						<a><img width="32px" height="32px"
							style="float: left; margin-right: 5%"
							alt="${myPro.nickname} profile picture"
							src="http://localhost:8080/web/assets/images/small/${myPro.nickname}.jpg">
						</a>
						<div class="profileboxnick" style="margin-bottom: 5%">
							<a target="_self"
								href="http://localhost:8080/web/profile?nick=${myPro.nickname}">${myPro.nickname}</a>
							<br> <a target="_self" href="EditAccountView.html">Modifier mon compte</a>
						</div>
					</div>
					<div class="darkheadercontent">
						<p>${myPro.firstname} ${myPro.lastname}</p>
						<p>
							Date d'inscription: <strong>${myPro.created}</strong>
						</p>
						<p>
							Anniversaire: <strong>${myPro.birthdate}</strong>
						</p>
						<p>
							Messages: <strong>${myPro.nbPost}</strong>
						</p>
						<p>
							Remerciements recus: <strong>${myPro.nbThank}</strong>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:if>

<div id="sidebar">
	<div class="sidebar-block">
		<h2 class="sidebar-block-header">Top des membres</h2>
		<c:if test="${topMembers != null }">
			<c:forEach var="topMember" items="${topMembers}">
				<div class="sidebar-block-content">${topMember.nickname} - ${topMember.nbThank}</div>
			</c:forEach>
		</c:if>
		<c:if test="${topMembers == null }">
		<div class="sidebar-block-content">Aucun membres remercié</div>
		</c:if>
	</div>
</div>

<div id="sidebar">
	<div class="sidebar-block">
		<h2 class="sidebar-block-header">Top des Topics</h2>
		<c:if test="${topTopics != null }">
			<c:forEach var="topTopic" items="${topTopics}">
				<div class="sidebar-block-content">${topTopic.title} - ${topMember.nbPost}</div>
			</c:forEach>
		</c:if>
		<c:if test="${topTopics == null }">
		<div class="sidebar-block-content">Aucun sujets n'existe</div>
		</c:if>
	</div>
</div>