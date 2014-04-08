<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- METAS -->
<jsp:include page="/metas.html"></jsp:include>
<meta name="description" content="Epiforum: A propos de nous">

<!-- LINKS -->
<jsp:include page="/common-css.html"></jsp:include>

<title>A propos de nous</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>
		
		<div id="page-body">
			<h2>A propos de nous</h2>
			<div id="page-body-inner">
				<!-- ABOUT CONTENT BEGIN -->

			<h3 class="dark-header">
			<h3>Guillaume Francois</h3>
			<p>Birth: 14/02/91 </p>
			<p>School: Epitech - Supinfo</p> 
			<br>
			<h3>Igor Moreno Semedo</h3>
			<p>Birth: 23/04/87</p>
			<p>School: Eucalyptus - Epitech - Supinfo</p>
			</h3>
			</div>


		</div>
		<!-- FOOTER -->
		<jsp:include page="/footer.html"></jsp:include>

	</div>
<!-- JAVASCRIPTS -->
<jsp:include page="/common-js.html"></jsp:include>

</body>
</html>