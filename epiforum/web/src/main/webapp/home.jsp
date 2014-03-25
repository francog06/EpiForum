<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- METAS -->
<meta name="description"
	content="Epiforum est un forum dévelopé principalement en JAVA">
<!-- including common metas -->
<jsp:include page="/metas.html"></jsp:include>

<!-- LINKS -->
<link href="./assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="./assets/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="./assets/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="./assets/css/style.css" rel="stylesheet">
<title>EpiForum</title>
</head>
<body>
	<div class="container-fluid">
		<!-- including header element -->
		<jsp:include page="/header.jsp"></jsp:include>
	<main class="clearfix">
	<section class="clearfix centered">
		<div class="row">
			<jsp:include page="/leftcol.jsp"></jsp:include>
			<div class="col-sm-8 maindiv">
				<div class="table-responsive">
  					<table class="table">
  						<thead>
  							<tr>
  								<th>First Category</th>
  								<th>Nb Topics</th>
  								<th>Nb Posts</th>
  							</tr>
  						</thead>
  						<tbody>
  						<tr>
  							<td><a target="_self" href="#"><span class="glyphicon glyphicon-folder-close"></span> First board</a>
  								<i class="fa fa-info"></i>
  								</td>
  							<td>Nb topics</td>
  							<td>Nb Posts</td>
  						</tr>
  						<tr>
  							<td>Second board</td>
  							<td>Nb topics</td>
  							<td>Nb Posts</td>
  						</tr>
  						<tr>
  							<td>Third board</td>
  							<td>Nb topics</td>
  							<td>Nb Posts</td>
  						</tr>
  						</tbody>
  						<tfoot>
  							<tr>
  								<td colspan="3">View all boards</td>
  							</tr>
  						</tfoot>
  					</table>
  				</div>
  				<div class="table-responsive">
  					<table class="table">
  						<thead>
  							<tr>
  								<th>Second Category</th>
  								<th>Nb Topics</th>
  								<th>Nb Posts</th>
  							</tr>
  						</thead>
  						<tbody>
  						<tr>
  							<td><a target="_self" href="#"><span class="glyphicon glyphicon-folder-open"></span> First board</a>
  								<i class="fa fa-info"></i>
  							</td>
  							<td>Nb topics</td>
  							<td>Nb Posts</td>
  						</tr>
  						<tr>
  							<td>Second board</td>
  							<td>Nb topics</td>
  							<td>Nb Posts</td>
  						</tr>
  						<tr>
  							<td>Third board</td>
  							<td>Nb topics</td>
  							<td>Nb Posts</td>
  						</tr>
  						</tbody>
  						<tfoot>
  							<tr>
  								<td colspan="3">View all boards</td>
  							</tr>
  						</tfoot>
  					</table>
  				</div>
				<div class="table-responsive">
  					<table class="table">
  						<thead>
  							<tr>
  								<th>Third Category</th>
  								<th>Nb Topics</th>
  								<th>Nb Posts</th>
  							</tr>
  						</thead>
  						<tbody>
  						<tr>
  							<td><a target="_self" href="#"><span class="glyphicon glyphicon-folder-open"></span> First board</a>
  								<i class="fa fa-info"></i>
  							</td>
  							<td>Nb topics</td>
  							<td>Nb Posts</td>
  						</tr>
  						<tr>
  							<td>Second board</td>
  							<td>Nb topics</td>
  							<td>Nb Posts</td>
  						</tr>
  						<tr>
  							<td>Third board</td>
  							<td>Nb topics</td>
  							<td>Nb Posts</td>
  						</tr>
  						</tbody>
  						<tfoot>
  							<tr>
  								<td colspan="3">View all boards</td>
  							</tr>
  						</tfoot>
  					</table>
  				</div>
  				<h3 class="darkheader">Les membres en ligne</h3>
  				<div class="darkheadercontent">
  				Nickname1, Nickname2, Nickname3
  				</div>
  				<h3 class="darkheader">Statistiques</h3>
  				<div class="darkheadercontent">
  				Nombre de membres: <strong>1000</strong>
  				Nombre de posts: <strong>10000</strong>
  				Nombre de topics: <strong>100</strong>
  				</div>
  				<h3 class="darkheader">Qui fete son anniversaire ?</h3>
  				<div class="darkheadercontent">
  				Administrator
  				</div>
			</div>
			<jsp:include page="/rightcol.jsp"></jsp:include>
		</div>
	</section>
	</main>
	<!-- including footer element -->
	<jsp:include page="/footer.html"></jsp:include>
	</div>
	<!-- including common JS -->
	<jsp:include page="/common-js.html"></jsp:include>
</body>
</html>