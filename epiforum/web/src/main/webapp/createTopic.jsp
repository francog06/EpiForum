<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					<div class="inner"><span class="corners-top"></span>
						<div class="content">
							<form action="createtopic" method="POST" id="create">
								<fieldset class="fields1">
									<dl>
										<dt><label for="title">Titre</label></dt>
										<dd><input type="text" tabindex="1" name="title" id="title" maxlength="64"
											size="65" class="inputbox autowidth" placeholder="Titre du sujet" required/></dd>
									</dl>
									<br/>
									<dl>
										<dt><label for="description">Description</label></dt>
										<textarea tabindex="2" id="description" name="description" maxlength="256"
											style="height: 96px; width: 68%" placeholder="Description du sujet"></textarea>
									</dl>
									<br/>
									<dl>
										<dt><label for="message">Message</label></dt>
										<textarea tabindex="3" id="message" name="message"
											style="height: 96px; width: 68%" placeholder="Votre message" required></textarea>
									</dl>
									<br>
									<dl>
										<dt><label>Tags</label></dt>
										<dd><input type="text" tabindex="4" name="tag_one" id="tag_one"
											size="15" maxlength="20" class="inputbox autowidth" />
										<input type="text" tabindex="5" name="tag_two" id="tag_two"
											size="15" maxlength="20" class="inputbox autowidth" />
										<input type="text" tabindex="6" name="tag_three" id="tag_three"
											size="15" maxlength="20" class="inputbox autowidth" /></dd>
									</dl>
									<br>
									<input type="hidden" name="boardId" value="${boardId}"/>
									<dl>
										<dd><input type="submit" id="create" name="create"
											tabindex="7" value="Valider" class="button1"/></dd>
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