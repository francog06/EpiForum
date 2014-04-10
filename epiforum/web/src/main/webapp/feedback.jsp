<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: feedback">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>

<title>Feedback</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- FEEDBACK CONTENT BEGIN -->

					<h2>FeedBack</h2>
					<div class="panel">
						<div class="inner">
							<span class="corners-top"></span>
							<div class="content">
								<form action="feedback" method="post" id="login">
									<fieldset class="fields1">
										<dl>
											<dt><label for="nickname">Pseudo:</label></dt>
											<dd><input type="text" tabindex="1" name="nickname" maxlength="64"
													class="inputbox autowidth" required autofocus/></dd>
										</dl>
										<dl>
											<dt><label for="message">Message:</label></dt>
											<dd><textarea tabindex="2" name="message" maxlength="256"
												style="height: 226px; width: 438px;"></textarea></dd>
										</dl>
										<dl>
											<dd><input type="submit" name="login" style="margin-left: 53%"
													tabindex="6" value="Envoyer" class="button1" /></dd>
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