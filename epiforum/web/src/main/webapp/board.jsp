<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: page d'une catégorie">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>
<link type="text/css" rel="stylesheet" href="assets/css/board.css">

<title>${board.title}</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- BOARD CONTENT BEGIN -->

				<div class="topic-actions">
					<div class="buttons">
						<div class="post-icon" title="Créer un nouveau sujet">
							<a title="Créer un sujet" target="_self" href="createtopic?bid=${board.id}">
								<img width="114px" height="36px" src="assets/metro_purple/imageset/en/button_topic_new.png">
							</a>
						</div>
					</div>
				</div>
				<div class="forumbg">
					<ul class="topiclist">
						<li class="header">
							<dl class="icon">
								<dt title="${board.description}"><span style="padding-left: 12px">${board.title}</span></dt>
								<dd class="posts"><span>Messages</span></dd>
								<dd class="lastpost"><span>Dèrnière mise à jour</span></dd>
							</dl>
						</li>
					</ul>
					
					<c:if test="${board.topics != null}">
					<c:forEach var="topic" items="${board.topics}">
					<ul class="topiclist topics">
						<li class="row bg1">
							<dl class="icon">
									<dt title="${topic.description}">
										<c:if test="${topic.locked eq true}">
										<i class="fa fa-lock fa-2x color_forum" title="Sujet vérrouillé" style="margin-right:1%"></i>
										</c:if>
										<a class="topictitle" href="topic?id=${topic.id}&page=1">${topic.title}</a>
										<br/>
										<c:if test="${myPro.type eq 'MODERATEUR'}">
										<form action="deletetopic" name="deleteTopic" method="GET" style="display: inline;">
											<input type="hidden" name="tid" id="tid" value="${topic.id}"/>
											<input type="submit" class="button1" title="Supprimer ce sujet" class="color_forum" value="Supprimer"/> 
										</form>
										<form action="updatetopic" name="updateTopic" method="GET" style="display: inline;">
											<input type="hidden" name="tid" id="tid" value="${topic.id}"/>
											<input type="submit" class="button1" title="Modifier ce sujet" class="color_forum" value="Modifier"/>
										</form>
										<form action="mergeopic" name="mergeTopic" method="GET" style="display: inline;">
											<input type="hidden" name="tid" id="tid" value="${topic.id}"/>
											<input type="submit" class="button1" title="Fusionner ce sujet" class="color_forum" value="Fusionner"/> 
										</form>
										<form action="movetopic" name="moveTopic" method="GET" style="display: inline;">
											<input type="hidden" name="tid" id="tid" value="${topic.id}"/>
											<input type="submit" class="button1" title="Déplacer ce sujet" class="color_forum" value="Déplacer"/> 
										</form>
										<form action="updatetopic" name="lockTopic" method="POST" style="display: inline;">
											<input type="hidden" name="topicId" id="topicId" value="${topic.id}"/>
											<c:if test="${topic.locked eq false}">
											<input type="submit" name="lockTopic" id="lockTopic" class="button1" title="Verrouiller ce sujet" value="Verrouiller"/>
											</c:if>
											<c:if test="${topic.locked eq true}">
											<input type="submit" name="unlockTopic" id="unlockTopic" class="button1" title="Deverrouiller ce sujet" value="Deverrouiller"/>
											</c:if>
										</form>
										</c:if>
									</dt>
								<dd class="posts"><span>${topic.nbPost}</span>
									<dfn>Messages</dfn>
								</dd>
								<dd class="lastpost"><span>${topic.modified}</span>
									<dfn>Dèrnière mise à jour</dfn>
								</dd>
							</dl>
						</li>
					</ul>
					</c:forEach>
					</c:if>
				</div>

				<!-- STATS -->
				<jsp:include page="/stats.jsp"></jsp:include>

			</div>
			<!-- BOARD CONTENT END -->
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