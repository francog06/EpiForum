<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description"
	content="Epiforum: page d'un sujet">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>
<link type="text/css" rel="stylesheet" href="assets/css/board.css">

<title>${topic.title}</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- TOPIC CONTENT BEGIN -->
				<div class="topic-actions">
					<div class="buttons">
						<div class="reply-icon">
							<c:if test="${topic.locked eq false or myPro.type ne 'MEMBRE'}">
								<a title="Répondre" target="_self" href="replytopic?tid=${topic.id}">
									<img width="114px" height="34px" src="assets/metro_purple/imageset/en/button_topic_reply.png"/>
								</a>
							</c:if>
							<c:if test="${topic.locked eq true and myPro.type eq 'MEMBRE'}">
								<img width="97px" height="35px" src="assets/metro_purple/imageset/en/button_topic_locked.png"/>
							</c:if>
						</div>
					</div>
					<div class="pagination">
						<c:if test="${page > 1}">
							<a href="topic?id=${topic.id}&page=${page - 1}" target="_self" title="Page precedente">
								<strong><i class="fa fa-arrow-left fa-2x"></i></strong>
							</a>
						</c:if>
						<c:if test="${lastpage ne true}">
						<a href="topic?id=${topic.id}&page=${page + 1}" target="_self" title="Page suivante">
							<strong><i class="fa fa-arrow-right fa-2x"></i></strong>
						</a>
						</c:if>
   					</div>
				</div>
				<div class="clear">
				</div>
				<c:forEach var="post" items="${topic.posts}">
				<div id="p3" class="post bg2">
					<div class="postbody">
						<h3 class="first">
							<span title="${topic.description}">${topic.title}</span>
							<c:if test="${post.tags ne null}">
							<c:forEach var="tag" items="${post.tags}">
								<span style="color: black; background-color: #AADDFF; margin-left: 20px">${tag}</span>
							</c:forEach>
							</c:if>
							<span style="color: #666; margin-left: 20px; float: right;">${post.modified}</span>
						</h3>
						<div class="content">
							<span>${post.content}</span>
						</div>
						<div class="content">
							<span>${post.profileSignature}</span>
						</div>
						<hr>
						<a title="Remercier ${post.profile.nickname}" href="thankprofile?nick=${post.profile.nickname}&tid=${topic.id}">
							<strong class="profile_font" style="color: black;">Remercier <i style="color:#603CBB" class="fa fa-thumbs-o-up fa-1x"></i></strong>
						</a>
						<c:if test="${topic.locked eq false or myPro.type ne 'MEMBRE'}">
						<strong class="profile_font" style="color: black; float: right; margin-left: 3%">Citer <i style="color:#603CBB" class="fa fa-quote-right fa-1x"></i></strong>
						<a title="Répondre" href="replytopic?tid=${topic.id}">
							<strong class="profile_font" style="color: black; float: right; margin-left: 3%">Répondre <i style="color:#603CBB" class="fa fa-reply fa-1x"></i></strong>
						</a>
						</c:if>
						<c:if test="${myPro.nickname eq post.profile.nickname}">
							<a title="Modifier" href="updatepost?pid=${post.id}">
								<strong class="profile_font" style="color: black; float: right; margin-left: 3%">Modifier <i style="color:#603CBB" class="fa fa-pencil-square-o fa-1x"></i></strong>
							</a>
							<a title="Supprimer" href="deletepost?pid=${post.id}">
								<strong class="profile_font" style="color: black; float: right; margin-left: 3%">Supprimer <i style="color:#603CBB" class="fa fa-times fa-1x"></i></strong>
							</a>
						</c:if>
					</div> 
					<dl id="profile3" class="postprofile">
						<dt style="float: right; max-width: 75px; margin-top:16px">
							<a class="username-coloured" href="profile?nick=${post.profile.nickname}">${post.profile.nickname}</a>
							<c:if test="${post.profile.picture eq true}">
							<img style="float: right;" width="64" height="64" alt="photo de profil de ${post.profile.nickname}"
								src="assets/images/medium/${post.profile.nickname}.jpg">
							</c:if>
							<c:if test="${post.profile.picture eq false}">
							<img style="float: right;" width="64" height="64" alt="photo de profil de ${post.profile.nickname}"
								src="assets/images/medium/default.jpg">
							</c:if>
						</dt>
						<br/>
						<div class="darkheadercontent" style="float: right; width: 100%">
							<span style="float: right;">Messages: <strong>${post.profile.nbPost}</strong></span>
							<br/>
							<span style="float: right;">Remerciements: <strong>${post.profile.nbThank}</strong></span>
						</div>
					</dl>
				</div>
				</c:forEach>
				<div class="topic-actions">
					<div class="buttons">
						<div class="reply-icon">
							<c:if test="${topic.locked eq false or myPro.type ne 'MEMBRE'}">
								<a title="Répondre" target="_self" href="replytopic?tid=${topic.id}">
									<img width="114px" height="34px" src="assets/metro_purple/imageset/en/button_topic_reply.png"/>
								</a>
							</c:if>
							<c:if test="${topic.locked eq true and myPro.type eq 'MEMBRE'}">
								<img width="97px" height="35px" src="assets/metro_purple/imageset/en/button_topic_locked.png"/>
							</c:if>
						</div>
					</div>
					<div class="pagination">
						<c:if test="${page > 1}">
							<a href="topic?id=${topic.id}&page=${page - 1}" title="Page precedente"><strong>
								<i class="fa fa-arrow-left fa-2x"></i></strong></a>
						</c:if>
						<c:if test="${lastpage ne true}">
						<a href="topic?id=${topic.id}&page=${page + 1}" title="Page suivante"><strong>
							<i class="fa fa-arrow-right fa-2x"></i></strong></a>
						</c:if>
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