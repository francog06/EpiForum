<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- METAS -->
<jsp:include page="/admin/metas.html"></jsp:include>
<meta name="description" content="Epiforum: Admin">
<!-- LINKS -->
<jsp:include page="/admin/common-css.html"></jsp:include>

<title>EpiForum - Admin</title>
</head>
<body>
	<!-- HEADER -->
	<jsp:include page="/admin/header.html"></jsp:include>

	<section class="wrapper">
	<header class="panel-heading"><strong>Bannir un membre</strong></header>
		<section class="panel">
			<div class="panel-body">
				<form role="form" id="delete " action="profile" method="POST" class="form-horizontal tasi-form">
					<div class="form-group has-success">
						<label class="col-lg-2 control-label"><strong>Membre</strong></label>
						<select name="nickname" class="form-control">
							<c:forEach var="pro" items="${pros}">
							<option value="${pro}">${pro}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button class="btn btn-danger" name="delete" type="submit">Finish Him !</button>
						</div>
					</div>
				</form>
			</div>
		</section>
	<!-- FOOTER -->
	<jsp:include page="/admin/footer.html"></jsp:include>
	</section>
</body>
</html>