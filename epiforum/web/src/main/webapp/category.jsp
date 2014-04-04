<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: page d'une categorie">

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

<title>${cat.title}</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- CATEGORY CONTENT BEGIN -->
				<div class="forabg">
					<ul class="topiclist">
						<li class="header">
							<dl class="icon">
								<dt title="${cat.description}"><p style="padding-left: 12px;">${cat.title}</p></dt>
								<dd class="lastpost">
									<span>Dèrnière mise à jour</span>
								</dd>
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
				<form id="jumpbox" onsubmit="if(this.f.value == -1){return false;}"
					action="./viewforum.php?style=2" method="post">
					<fieldset class="jumpbox">
						<label accesskey="j" for="f">Jump to:</label> <select id="f"
							onchange="if(this.options[this.selectedIndex].value != -1){ document.forms['jumpbox'].submit() }"
							name="f">
							<option value="-1">Select a forum</option>
							<option value="-1">------------------</option>
							<option selected="selected" value="1">Your first category</option>
							<option value="2">Your first forum</option>
							<option value="4">Your second forum</option>
							<option value="5">Your third forum</option>
							<option value="3">Your second category</option>
							<option value="6">Your first forum</option>
							<option value="7">Your second forum</option>
							<option value="8">Buy the theme!</option>
							<option value="9">Buy the theme!</option>
						</select> <input class="button2" type="submit" value="Go">
					</fieldset>
				</form>
				<!-- STATS -->
				<jsp:include page="/stats.jsp"></jsp:include>

			</div>
			<!-- CATEGORY CONTENT END -->
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