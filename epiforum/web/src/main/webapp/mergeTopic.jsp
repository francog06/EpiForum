<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: fusionner deux sujets">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>
<link type="text/css" rel="stylesheet" href="assets/css/board.css">

<title>Fusionner deux sujets</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- MERGE TOPIC CONTENT BEGIN -->

				<h2>Fusion de deux sujets</h2>
				<div class="panel">
					<div class="inner">
						<span class="corners-top"></span>
						<div class="content">
							<form action="mergetopic" method="POST" id="merge">
								<fieldset class="fields1">
									<dl>
										<dt><label for="stopic">Fusionner avec ce sujet</label></dt>
										<dd>
											<select autofocus required tabindex="1" id="stopic" name="stopic">
												<c:forEach var="topic" items="${topics}">
												<c:if test="${topic.postId ne topicId}">
													<option value="${topic.postId}">${topic.content}</option>
												</c:if>
												</c:forEach>
											</select>
										</dd>
									</dl>
									<input type="hidden" name="ftopic" value="${topicId}" />
									<dl>
										<dd>
											<input type="submit" id="merge" name="merge" tabindex="2"
												value="Valider" class="button1" />
										</dd>
									</dl>
								</fieldset>
							</form>
						</div>
						<span class="corners-bottom"></span>
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