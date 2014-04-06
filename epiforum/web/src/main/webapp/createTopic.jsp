<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: créer un sujet">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>
<link type="text/css" rel="stylesheet" href="assets/css/board.css">

<title>Créer un sujet</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
			<!-- CREATE TOPIC CONTENT BEGIN -->
			
				<h2>Creation d'un sujet</h2>
				<div class="panel">
					<div class="inner"><span class="corners-top"><span></span></span>
						<div class="content">
							<form action="createtopic" method="POST" id="create">
								<fieldset class="fields1">
									<dl>
										<dt><label for="title">Titre</label></dt>
										<dd><input type="text" tabindex="1" name="title" id="title" maxlength="64"
											size="70" class="inputbox autowidth" placeholder="Titre du sujet" required/></dd>
									</dl>
									<br/>
									<dl>
										<dt><label for="description">Description</label></dt>
										<dd><input type="text" tabindex="2" id="description" name="description" maxlength="256"
											size="87" class="inputbox autowidth" placeholder="Description du sujet"/></dd>
									</dl>
									<br/>
									<dl>
										<dt><label for="message">Message</label></dt>
										<textarea id="message" name="message" style="height: 223px; width: 76%" required></textarea>
									</dl>
									<br>
									<dl>
										<dt><label>Tags</label></dt>
										<dd><input type="text" tabindex="1" name="tag_one" id="tag_one"
											size="15" maxlength="20" class="inputbox autowidth" />
										<input type="text" tabindex="1" name="tag_two" id="tag_two"
											size="15" maxlength="20" class="inputbox autowidth" />
										<input type="text" tabindex="1" name="tag_three" id="tag_three"
											size="15" maxlength="20" class="inputbox autowidth" /></dd>
									</dl>
									<br>
									<input type="hidden" name="boardId" value="${boardId}"/>
									<dl>
										<dt>&nbsp;</dt>
										<dd>
											<input type="submit" id="create" name="create" tabindex="6" value="Envoyer" class="button1"/>
										</dd>
									</dl>
								</fieldset>
							</form>
						</div>
						<span class="corners-bottom"><span></span></span>
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