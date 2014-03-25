<header class="clearfix" style="padding: 0px; margin: 0px;">
	<a target="_self" href="home"><h2 style="margin-top: 10px; margin-bottom: 10px;">Bienvenue sur EpiForum</h2></a>
</header>
<nav class="navbar navbar-default navbar-static-top subheader" role="navigation">
	<div class="container-fluid">
		<div class="col-sm-3">
			<form class="navbar-form" role="search">
				<div class="input-group">
					<input type="text" class="form-control"
						placeholder="Trouvez des topics ou des membres"> <span
						class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div>
			</form>
		</div>
		<ul class="nav navbar-nav navbar-right list-inline">
			<li><a title="S'inscrire" target="_self" href="signup"><i
					class="fa fa-star  fa-2x"></i> S'inscrire</a></li>
			<li><a title="Se connecter" target="_self" href="login"><i
					class="fa fa-sign-in  fa-2x"></i> Se connecter</a></li>
			<li><a title="A propos de nous" target="_self" href="aboutus"><i
					class="fa fa-flag  fa-2x"></i> A propos de nous</a></li>
			<li><a title="Contactez nous" target="_self" href="contactus"><i
					class="fa fa-flag  fa-2x"></i> Contactez nous</a></li>
			<li><a title="Faire un don" target="_self" href="donate"><i
					class="fa fa-star  fa-2x"></i> Faire un don</a></li>
			<%-- <c:if test="${token != null}"> --%>
			<li><a title="Deconnection" target="_self" href="logout"><i
					class="fa fa-sign-out  fa-2x"></i> Deconnection</a></li>
			<li><a title="Mon compte" target="_self" href="account"><i
					class="fa fa-user  fa-2x"></i> Mon compte</a></li>
			<!-- </c:if> -->
		</ul>
	</div>
</nav>