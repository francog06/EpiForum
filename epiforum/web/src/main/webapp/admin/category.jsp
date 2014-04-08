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
		<!-- CREER -->
		<header class="panel-heading"><strong>Créer</strong></header>
		<section class="panel" style="margin-bottom: 10px">
			<div class="panel-body">
				<form role="form" id="create" action="category" method="POST" class="form-horizontal tasi-form">
					<div class="form-group has-success">
						<label class="col-lg-2 control-label"><strong>Titre</strong></label>
						<input maxlength="64" name="title" type="text" class="form-control" required/>
					</div>
					<div class="form-group has-success">
						<label class="col-lg-2 control-label"><strong>Description</strong></label>
						<input maxlength="256" name="description" type="text" class="form-control"/>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button class="btn btn-danger" name="create" type="submit">Créer</button>
						</div>
					</div>
				</form>
			</div>
		</section>

		<!-- MODIF -->
		<header class="panel-heading"><strong>Modifier</strong></header>
		<section class="panel">
			<div class="panel-body">
				<form role="form" id="update" action="category" method="POST" class="form-horizontal tasi-form">
					<div class="form-group has-success">
						<label class="col-lg-2 control-label"><strong>Section</strong></label>
						<select name="categoryId" class="form-control">
							<c:forEach var="cat" items="${cats}">
							<option value="${cat.postId}">${cat.content}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group has-success">
						<label class="col-lg-2 control-label"><strong>Nouveau titre</strong></label>
						<input maxlength="64" name="title" type="text" class="form-control" required/>
					</div>
					<div class="form-group has-success">
						<label class="col-lg-2 control-label"><strong>Nouvelle description</strong></label>
						<input maxlength="256" name="description" type="text" class="form-control"/>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button class="btn btn-danger" name="update" type="submit">Modifier</button>
						</div>
					</div>
				</form>
			</div>
		</section>

		<header class="panel-heading"><strong>Supprimer</strong></header>
		<section class="panel">
			<div class="panel-body">
				<form role="form" id="delete " action="category" method="POST" class="form-horizontal tasi-form">
					<div class="form-group has-success">
						<label class="col-lg-2 control-label"><strong>Section</strong></label>
						<select name="categoryId" class="form-control">
							<c:forEach var="cat" items="${cats}">
							<option value="${cat.postId}">${cat.content}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button class="btn btn-danger" name="delete" type="submit">Supprimer</button>
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