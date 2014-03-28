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
<link media="print" type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/print.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/normal.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/medium.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/large.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/common.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/common.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/links.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/content.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/buttons.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/cp.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/forms.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/tweaks.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/colours.css">
<link type="text/css" rel="stylesheet" href="./assets/metro_purple/theme/responsive.css">
<link type="text/css" rel="stylesheet" href='//fonts.googleapis.com/css?family=Open+Sans:300,400,600&subset=latin,cyrillic'
	 >

<!--   <link href="./assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="./assets/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="./assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="./assets/css/style.css" rel="stylesheet">
<link href="./assets/css/style-responsive.css" rel="stylesheet"> -->

<title>EpiForum</title>
</head>
<body>



	<div id="wrap">

		<div id="page-header">

    	<div id="above-headerbar">

			
					<ul class="user-links">
                <!-- IF S_REGISTER_ENABLED <li><a href="{U_REGISTER}">{L_REGISTER}</a>&nbsp;&nbsp;|</li>ENDIF -->
                <li><a href="#login-box" class="login-window" title="Login" accesskey="x">Login</a>
       			</ul>

			<div id="login-box" class="login-popup">
			    <a href="#" class="close"><img src="./assets/metro_purple/theme/images/close_popup.png" class="close-button" title="Close" alt="Close" /></a>
			    <div id="login-text">Login</div>

					<fieldset>
						<div class="navbar_username_outer">
							<label for="username">{L_USERNAME}:</label>&nbsp;<br /><input type="text" name="username" id="navbar_username" size="10" class="inputbox" title="{L_USERNAME}" />
						</div>

						<div class="navbar_password_outer">
							<label for="password">{L_PASSWORD}:</label>&nbsp;<br /><input type="password" name="password" id="navbar_password" size="10" class="inputbox" title="{L_PASSWORD}" />
						</div>




						<div class="login-buttons">
							<input type="submit" name="login" value="{L_LOGIN}" class="button2" />
							{S_LOGIN_REDIRECT}
							<!-- IF S_AUTOLOGIN_ENABLED -->
								<label id="autologin_label" for="autologin">{L_LOG_ME_IN} <input type="checkbox" name="autologin" id="autologin" /></label>
							<!-- ENDIF -->
						</div>
					</fieldset>
					<!-- IF S_REGISTER_ENABLED --><a class="register-link" href="{U_REGISTER}">{L_REGISTER}</a><!-- ENDIF -->
			        
			</div>
			
			
			<div class="search-box">
				<fieldset>
					<div class="search-box-inner">
						<input class="button2" type="submit" value="Search">
						 <input	id="keywords" class="inputbox search" type="text"
							onblur="if(this.value=='')this.value='Search…';"
							onclick="if(this.value=='Search…')this.value='';" value="Trouvez des topics ou des membres"
							title="Search for keywords" maxlength="350" name="keywords">
					</div>
					<input type="hidden" value="12" name="style">
				</fieldset>
			</div>
			</div>

        	<div id="header">
			
			<a id="logo" title="Board index" style="color:White; font-size:50px" href="./index.php?style=12">
			EpiForum
			<img width="125" height="31" title="" alt="" src="./assets/metro_purple/imageset/site_logo.png">
			</a>
			<div class="tabs-outer">
				<a class="toggleMenuButton" title="Menu" href="javascript:void(0);"></a>
				<ul class="tabs">
					<li id="news-link" style="width:150px">
						<a href="">
						<span style="width:150px">My profile</span>
						</a>
					</li>
					<li id="sample-link" style="width:150px">
						<a title="" href="#">
						<span style="width:150px">A propos de nous</span>
						</a>
					</li>
					<li id="contacts-link" style="width:150px">
						<a title="" href="#">
						<span style="width:120px">Contactez nous</span>
						</a>
					</li>	
					<li id="contacts-link" style="width:150px">
						<a title="" href="#">
						<span style="width:100px">Faire un don</span>
						</a>
					</li>
				</ul>
			</div>
			</div>
       		 <div id="subheader-menu">
	            <!-- IF S_DISPLAY_SEARCH or (S_USER_LOGGED_IN and not S_IS_BOT) -->
	            <ul class="links left">
	                <!-- IF not S_IS_BOT and U_MARK_FORUMS --><li id="submenu-mark-read"><a href="{U_MARK_FORUMS}" accesskey="m"> Hey</a></li><!-- ENDIF -->
	            </ul>
        	</div>		
		    <div id="breadcrumbs">
        		<a class="icon-home" href="{U_INDEX}" accesskey="h">Home</a> <img class="navbit-arrow" src="./assets/metro_purple/theme/images/navbit-arrow-right.png" alt="" />&nbsp; 
        	</div>
		</div> <!--  END HEADER -->
				
		<div id="page-body"> <!--  MAIN BODY -->
				
		
		<div id="page-body-inner">
			<div class="forabg">
				<ul class="topiclist">
				<li class="header">
					<dl class="icon">
						<dt>
						<a href="./viewforum.php?style=12&f=1">Voitures</a>
						</dt>
						<dd class="topics">Topics</dd>
						<dd class="posts">Posts</dd>
						<dd class="lastpost">
							<span>Last post</span>
						</dd>
					</dl>
				</li>
				</ul>
				<ul class="topiclist forums">
				<li class="row">
					<dl class="icon" style="background-image: url(./assets/metro_purple/imageset/forum_read.png); background-repeat: no-repeat;">
						<dt title="No unread posts">
							<a class="forumtitle" href="./viewforum.php?style=12&f=2">Mercedes</a>
							<br>
							Parlez des différentes classes de la célèbre marque.
						</dt>
						<dd class="topics">4
							<dfn>Topics</dfn>
						</dd>
						<dd class="posts">7 
							<dfn>Posts</dfn>
						</dd>
						<dd class="lastpost">
							<span>
								<dfn>Last post</dfn> by
								<a class="username-coloured" style="color: #AA0000;" href="./memberlist.php?style=12&mode=viewprofile&u=2">Franco</a>
								<a href="./viewtopic.php?style=12&f=2&p=17#p17">
								<img width="12" height="10" title="View the latest post" alt="View the latest post" src="./assets/metro_purple/imageset/icon_topic_latest.png">
								</a>
								Wed Mar 05, 2014 10:53 am
							</span>
						</dd>
					</dl>
				</li>
			
				<li class="row">
					<dl class="icon" style="background-image: url(./assets/metro_purple/imageset/forum_read.png); background-repeat: no-repeat;">
						<dt title="No unread posts">
							<a class="forumtitle" href="./viewforum.php?style=12&f=4">Your second forum</a>
							<br>
							Description of your second forum
						</dt>
						<dd class="topics">2
							<dfn>Topics</dfn>
						</dd>
						<dd class="posts">2
							<dfn>Posts</dfn>
						</dd>
						<dd class="lastpost">
						<span>
							<dfn>Last post</dfn>by
							<a class="username-coloured" style="color: #AA0000;" href="./memberlist.php?style=12&mode=viewprofile&u=2">Igy</a>
							<a href="./viewtopic.php?style=12&f=4&p=5#p5">
							<img width="12" height="10" title="View the latest post" alt="View the latest post" src="./assets/metro_purple/imageset/icon_topic_latest.png">
							</a>
							Mon Apr 15, 2013 7:31 pm
						</span>
						</dd>
					</dl>
				</li>
			</ul>
			</div><!--  END FIRST CATEGORY -->

		<div class="forabg">
				<ul class="topiclist">
				<li class="header">
					<dl class="icon">
						<dt>
						<a href="./viewforum.php?style=12&f=1">Sport</a>
						</dt>
						<dd class="topics">Topics</dd>
						<dd class="posts">Posts</dd>
						<dd class="lastpost">
							<span>Last post</span>
						</dd>
					</dl>
				</li>
				</ul>
				<ul class="topiclist forums">
				<li class="row">
					<dl class="icon" style="background-image: url(./assets/metro_purple/imageset/forum_read.png); background-repeat: no-repeat;">
						<dt title="No unread posts">
							<a class="forumtitle" href="./viewforum.php?style=12&f=2">Football</a>
							<br>
							Pronostics, commentaires, avant/apres match, parlez de tout!!
						</dt>
						<dd class="topics">4
							<dfn>Topics</dfn>
						</dd>
						<dd class="posts">7 
							<dfn>Posts</dfn>
						</dd>
						<dd class="lastpost">
							<span>
								<dfn>Last post</dfn> by
								<a class="username-coloured" style="color: #AA0000;" href="./memberlist.php?style=12&mode=viewprofile&u=2">PixelGoose</a>
								<a href="./viewtopic.php?style=12&f=2&p=17#p17">
								<img width="12" height="10" title="View the latest post" alt="View the latest post" src="./assets/metro_purple/imageset/icon_topic_latest.png">
								</a>
								Wed Mar 05, 2014 10:53 am
							</span>
						</dd>
					</dl>
				</li>
			
				<li class="row">
					<dl class="icon" style="background-image: url(./assets/metro_purple/imageset/forum_read.png); background-repeat: no-repeat;">
						<dt title="No unread posts">
							<a class="forumtitle" href="./viewforum.php?style=12&f=4">Your second forum</a>
							<br>
							Description of your second forum
						</dt>
						<dd class="topics">2
							<dfn>Topics</dfn>
						</dd>
						<dd class="posts">2
							<dfn>Posts</dfn>
						</dd>
						<dd class="lastpost">
						<span>
							<dfn>Last post</dfn>by
							<a class="username-coloured" style="color: #AA0000;" href="./memberlist.php?style=12&mode=viewprofile&u=2">PixelGoose</a>
							<a href="./viewtopic.php?style=12&f=4&p=5#p5">
							<img width="12" height="10" title="View the latest post" alt="View the latest post" src="./assets/metro_purple/imageset/icon_topic_latest.png">
							</a>
							Mon Apr 15, 2013 7:31 pm
						</span>
						</dd>
					</dl>
				</li>
			</ul>

			</div> <!--  end second category -->
		
		
			<h3 class="dark-header">Who is online</h3>
			<div class="dark-header-content">
				In total there are
				<strong>4</strong>
				users online :: 0 registered, 0 hidden and 4 guests (based on users active over the past 5 minutes)
				<br>
				Most users ever online was
				<strong>51</strong>
				on Wed Mar 05, 2014 2:21 pm
				<br>
				<br>
				Registered users: No registered users
				<br>
				<em>
				Legend:
				<a href="./memberlist.php?style=12&mode=group&g=5" style="color:#AA0000">Administrators</a>
				,
				<a href="./memberlist.php?style=12&mode=group&g=4" style="color:#00AA00">Global moderators</a>
				</em>
			</div>
		
		</div>
		
		<!-- SIDE BAR -->
			<div id="sidebar">
			<a href="http://themeforest.net/item/metro-a-responsive-theme-for-phpbb3/4559274?ref=PixelGoose" target="_blank" title="Buy Metro Theme for phpBB3 on themeforest.com" style="margin-bottom: 12px; display: block;">
			<img src="http://img.pixelgoose.com/metro-phpbb/metro-buy-252px.png" title="Buy Metro Theme on themeforest.com" alt="Buy Metro Theme for phpBB3 on themeforest.com">
			</a>
			<div class="sidebar-block">
				<h2 class="sidebar-block-header"> Top des membres</h2>
				<div class="sidebar-block-content">
					<p>Franco  10 thks</p> 
					<p>Igy  7 thks</p>
				</div>
			</div>
			</div>

		</div> <!--  END PAGE BODY -->

	</div>
	

<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript" src="./assets/metro_purple/template/styleswitcher.js" async></script>
<script type="text/javascript" src="./assets/metro_purple/template/forum_fn.js" async></script>
<script type="text/javascript" async>
	$(document).ready(function() {
		$('a.login-window').click(function() {

			// Getting the variable's value from a link 
			var loginBox = this.hash;

			//Fade in the Popup and add close button
			$(loginBox).fadeIn(300);

			//Set the center alignment padding + border
			var popMargTop = ($(loginBox).height() + 24) / 2;
			var popMargLeft = ($(loginBox).width() + 24) / 2;

			$(loginBox).css({
				'margin-top' : -popMargTop,
				'margin-left' : -popMargLeft
			});

			// Add the mask to body
			$('body').append('<div id="mask"></div>');
			$('#mask').fadeIn(300);

			return false;
		});

		// When clicking on the button close or the mask layer the popup closed
		$('a.close, #mask').live('click', function() {
			$('#mask , .login-popup').fadeOut(300, function() {
				$('#mask').remove();
			});
			return false;
		});

		$('#navbar_username').focus(function() {
			$('#navbar_username').parent().addClass('active');
		});
		$('#navbar_username').blur(function() {
			$('#navbar_username').parent().removeClass('active');
		});
		$('#navbar_password').focus(function() {
			$('#navbar_password').parent().addClass('active');
		});
		$('#navbar_password').blur(function() {
			$('#navbar_password').parent().removeClass('active');
		});

	});
</script>

<script type="text/javascript" async>
	$(document).ready(function() {
		$(".toggleMenuButton").click(function() {
			$(".tabs").slideToggle("fast");
			$(".toggleMenuButton").toggleClass("active");
		})

		$(window).resize(function() {
			//small-screen
			if (window.innerWidth < 767) {
				$(".tabs").css('display', '');
				$('.toggleMenuButton').removeClass('active');
			}
			//end small-screen
		}).resize(); // trigger resize event

	});
</script>

		<%-- <div class="container-fluid">
		 including header element 
		<jsp:include page="/header.jsp"></jsp:include>
		<main class="clearfix">
		<section class="clearfix centered">
			<div class="row">
				including leftcol element 
				<jsp:include page="/leftcol.jsp"></jsp:include>
				including rightcol element 
				<jsp:include page="/rightcol.jsp"></jsp:include>
				<div class="col-sm-8 maindiv">
					including homecontent element
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>First  Category</th>
									<th>Nb Topics</th>
									<th>Nb Posts</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><a target="_self" href="#"><span
											class="glyphicon glyphicon-folder-close"></span> First board</a>
										<i class="fa fa-info"></i></td>
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
									<td><a target="_self" href="#"><span
											class="glyphicon glyphicon-folder-open"></span> First board</a> <i
										class="fa fa-info"></i></td>
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
									<td><a target="_self" href="#"><span
											class="glyphicon glyphicon-folder-open"></span> First board</a> <i
										class="fa fa-info"></i></td>
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
					<div class="darkheadercontent">Administrator</div>
				</div>
			</div>
		</section>
		</main>
		 including footer element 
		<jsp:include page="/footer.html"></jsp:include>
	</div>
  	including common JS 
	<jsp:include page="/common-js.html"></jsp:include> --%>
</body>
</html>