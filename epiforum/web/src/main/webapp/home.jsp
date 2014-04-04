<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description"
	content="Epiforum est un forum dévelopé principalement en JAVA">

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

<title>EpiForum</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- HOME CONTENT BEGIN -->

				<c:if test="${cats != null}">
				<c:forEach var="cat" items="${cats}">
				<div class="forabg">
					<ul class="topiclist">
						<li class="header">
							<dl class="icon">
								<dt title="${cat.description}">
									<a href="category?id=${cat.id}">${cat.title}</a>
								</dt>
								<dd class="lastpost">Dèrnière mise à jour</dd>
							</dl>
						</li>
					</ul>

					<c:if test="${cat.boards != null}">
					<c:forEach var="board" items="${cat.boards}">
					<ul class="topiclist forums">
						<li class="row">
							<dl class="icon">
								<dt title="${board.description}">
									<a class="forumtitle" href="board?id=${board.id}">${board.title}</a>
								</dt>
								<dd class="lastpost">${board.modified}
									<dfn>Dèrnière mise à jour</dfn>
								</dd>
							</dl>
						</li>
					</ul>
					</c:forEach>
					</c:if>
				</div>
				</c:forEach>
				</c:if>

				<!-- STATS -->
				<jsp:include page="/stats.jsp"></jsp:include>

			</div>
			<!-- HOME CONTENT END -->
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