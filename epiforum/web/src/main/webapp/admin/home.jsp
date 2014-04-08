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
		<div class="row">
			<div class="col-lg-4">
				<aside class="profile-nav alt green-border">
					<section class="panel">
						<ul class="nav nav-pills nav-stacked">
							<li>
								<a href="category" title="Gérer les sections">
									<i class="icon-file"></i>Sections
									<span class="label label-primary pull-right r-activity">Créer/Modif/Supp</span>
								</a>
							</li>
							<li>
								<a href="board" title="Gérer les categories">
									<i class="icon-file"></i>Catégories 
									<span class="label label-info pull-right r-activity">Créer/Modif/Supp</span>
								</a>
							</li>
							<li>
								<a href="profil" title="Gérer les membres">
									<i class="icon-file"></i>Profils
									<span class="label label-warning pull-right r-activity">Modifier/Suppr</span>
								</a>
							</li>
						</ul>
					</section>
				</aside>
			</div>
		</div>
	<!-- FOOTER -->
	<jsp:include page="/admin/footer.html"></jsp:include>
	</section>
</body>
</html>