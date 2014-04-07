<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: modifier un sujet">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>
<link type="text/css" rel="stylesheet" href="assets/css/board.css">

<title>Modifier un sujet</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- UPDATE TOPIC CONTENT BEGIN -->

				<h2>Modification du sujet</h2>
				<div class="panel">
					<div class="inner">
						<span class="corners-top"></span>
						<div class="content">
							<form action="updatetopic" method="POST" id="update">
								<fieldset class="fields1">
									<dl>
										<dt><label for="title">Titre</label></dt>
										<dd><input type="text" tabindex="1" name="title" id="title" maxlength="64"
												size="65" class="inputbox autowidth" value="${topic.title}" required/></dd>
									</dl>
									<br />
									<dl>
										<dt><label for="description">Description</label></dt>
										<textarea tabindex="2" id="description" name="description" maxlength="256"
											style="height: 96px; width: 68%" placeholder="${topic.description}"></textarea>
									</dl>
									<br> <input type="hidden" name="topicId" value="${topic.id}" />
									<dl>
										<dd>
											<input type="submit" id="update" name="update" tabindex="6"
												value="Envoyer" class="button1" />
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