<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description"
	content="Epiforum: modifier son message">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>

<title>Modifier son message</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- REPLY CONTENT BEGIN -->
				
				<form action="updatepost" method="POST" id="updatePost">
					<div class="panel">
						<div class="inner"><span class="corners-top"><span></span></span>
							<div class="content">
								<fieldset class="fields1">
									<dl>
										<dt><label for="message">Message:</label></dt>
										<textarea name="message" style="min-height: 100px; width: 70%" required>${post.content}</textarea>
									</dl>
									<dl>
										<input type="hidden" name="postId" value="${postId}"/>
										<input type="submit" id="updatePost" name="updatePost" tabindex="6" value="Valider" class="button1"/>
									</dl>
								</fieldset>
							</div>
							<span class="corners-bottom"></span>
						</div>
					</div>
				</form>
			
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