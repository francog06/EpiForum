<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: page d'inscription">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>

<title>Inscription</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">

			<h2>Inscription</h2>
			<div class="panel">
				<div class="inner">
					<span class="corners-top"></span>
					<div class="content">
						<c:if test="${error != null}">
						<p style="color: red">${error}</p>
						</c:if>
						<form action="subscribe" method="POST" id="subscribe">
							<fieldset class="fields1">
								<dl>
									<dt>
										<span style="color: red"> *<span>
										<label for="email"> Email</label>
									</dt>
									<dd>
										<input type="text" tabindex="1" name="email" id="email" size="35"
											class="inputbox autowidth" placeholder="example@company.com" required autofocus/>
									</dd>
								</dl>
								<dl>
									<dt>
										<span style="color: red"> *<span>
										<label for="password"> Mot de passe</label>
									</dt>
									<dd>
										<input type="password" tabindex="2" id="password" name="password"
											size="35" class="inputbox autowidth" required/>
									</dd>
								</dl>
								<dl>
									<dt>
										<span style="color: red"> *<span>
										<label for="password"> Resaisisez le mot de passe</label>
									</dt>
									<dd>
										<input type="password" tabindex="3" id="password" name="password"
											size="35" class="inputbox autowidth" required/>
									</dd>
								</dl>
								<dl>
									<dt>
										<span style="color: red"> *<span>
										<label for="nickname"> Pseudonyme</label>
									</dt>
									<dd>
										<input type="text" tabindex="4" name="nickname" id="nickname"
											size="35" class="inputbox autowidth" required/>
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="firstname">Prenom:</label>
									</dt>
									<dd>
										<input type="text" tabindex="5" name="firstname" id="firstname"
											size="35" class="inputbox autowidth"/>
									</dd>
								</dl>
								<dl>
									<dt>
										<label for="lastname">Nom:</label>
									</dt>
									<dd>
										<input type="text" tabindex="6" name="lastname" id="lastname"
											size="35" class="inputbox autowidth"/>
									</dd>
								</dl>
								<dl>
									<dd>
										<input type="submit" name="subscribe" tabindex="7"
											value="Inscription" class="button1"/>
									</dd>
								</dl>
							</fieldset>
						</form>
					</div>
					<span class="corners-bottom"></span>
				</div>
			</div>
		</div>
		<!-- FOOTER -->
		<jsp:include page="/footer.html"></jsp:include>

	</div>
	<!-- JAVASCRIPTS -->
	<jsp:include page="/common-js.html"></jsp:include>

</body>
</html>