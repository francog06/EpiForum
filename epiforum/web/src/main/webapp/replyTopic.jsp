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
	content="Epiforum: répondre à un sujet">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>

<title>Ajouter un message</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- REPLY CONTENT BEGIN -->
				
				<form action="replytopic" method="POST" id="reply">
					<div class="panel">
						<div class="inner"><span class="corners-top"><span></span></span>
							<div class="content">
								<fieldset class="fields1">
									<dl>
										<dt><label for="message">Message:</label></dt>
										<textarea name="message" style="min-height: 100px; width: 70%" required></textarea>
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
									<dl>
										<input type="hidden" name="topicId" value="${topicId}"/>
										<input type="submit" id="reply" name="reply" tabindex="6" value="Envoyer" class="button1"/>
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