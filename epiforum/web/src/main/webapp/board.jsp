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
	content="Epiforum est un forum dévelopé principalement en JAVA">

<!-- LINKS -->
<link media="print" type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/print.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/normal.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/medium.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/large.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/common.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/common.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/links.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/content.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/buttons.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/cp.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/forms.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/tweaks.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/colours.css">
<link type="text/css" rel="stylesheet"
	href="./assets/metro_purple/theme/responsive.css">
<link type="text/css" rel="stylesheet"
	href='//fonts.googleapis.com/css?family=Open+Sans:300,400,600&subset=latin,cyrillic'>
<link type="text/css" rel="stylesheet"
	href="./assets/font-awesome/css/font-awesome.min.css">

<title>${board.title}</title>
</head>
<body>
	<div id="wrap">
		<!-- HEADER -->
		<jsp:include page="/header.jsp"></jsp:include>

		<div id="page-body">
			<div id="page-body-inner">
				<!-- BOARD CONTENT BEGIN -->

				<div class="topic-actions">
					<div class="buttons">
						<div class="post-icon" title="Post a new topic">
							<a href="CreateTopic.html"> <img
								src="./assets/metro_purple/imageset/en/button_pm_new.png">
							</a>
						</div>
					</div>
					<div class="search-box">
						<form id="forum-search" action="./search.php?style=2" method="get">
							<fieldset>
								<div class="search-box-inner">
									<input class="button2" type="submit" value="Search"> <input
										id="keywords" class="inputbox search tiny" type="text"
										onclick="" value="" size="20" name="keywords">
								</div>
							</fieldset>
						</form>
					</div>
					<div class="pagination">
						4 topics Page <strong>1</strong> of <strong>1</strong>
					</div>
				</div>
				<div class="forumbg">
					<ul class="topiclist">
						<li class="header">
							<dl class="icon">
								<dt>
									<span class="forum-name"> Topics <span></span>
									</span>
								</dt>
								<dd class="posts">Replies</dd>
								<dd class="views">Views</dd>
								<dd class="lastpost">
									<span>Last post</span>
								</dd>
							</dl>
						</li>
					</ul>
					<ul class="topiclist topics">
						<li class="row bg1">
							<dl class="icon"
								style="background-image: url(./styles/metro_blue/imageset/topic_read.png); background-repeat: no-repeat;">
								<dt title="No unread posts"
									style="background-image: url(./images/icons/misc/fire.gif); background-repeat: no-repeat;">
									<a class="topictitle" href="./TopicView.html">phpBB3 thread</a>
									<br> by <a class="username-coloured"
										style="color: #AA0000;"
										href="./memberlist.php?style=2&mode=viewprofile&u=2">PixelGoose</a>
									» Fri Apr 12, 2013 9:47 pm
								</dt>
								<dd class="posts">
									3
									<dfn>Replies</dfn>
								</dd>
								<dd class="views">
									13489
									<dfn>Views</dfn>
								</dd>
								<dd class="lastpost">
									<span> <dfn>Last post </dfn> by <a
										class="username-coloured" style="color: #AA0000;"
										href="./memberlist.php?style=2&mode=viewprofile&u=2">PixelGoose</a>
										<a href="./viewtopic.php?style=2&f=2&t=3&p=17#p17"> <img
											width="12" height="10" title="View the latest post"
											alt="View the latest post"
											src="./styles/metro_blue/imageset/icon_topic_latest.png">
									</a> <br> Wed Mar 05, 2014 10:53 am
									</span>
								</dd>
							</dl>
						</li>
					</ul>
				</div>
				<form action="./viewforum.php?style=2&f=2" method="post">
					<fieldset class="display-options">
						<label> Display topics from previous: <select id="st"
							name="st">
								<option selected="selected" value="0">All Topics</option>
								<option value="1">1 day</option>
								<option value="7">7 days</option>
								<option value="14">2 weeks</option>
								<option value="30">1 month</option>
								<option value="90">3 months</option>
								<option value="180">6 months</option>
								<option value="365">1 year</option>
						</select>
						</label> <label> Sort by <select id="sk" name="sk">
								<option value="a">Author</option>
								<option selected="selected" value="t">Post time</option>
								<option value="r">Replies</option>
								<option value="s">Subject</option>
								<option value="v">Views</option>
						</select>
						</label> <label> <select id="sd" name="sd">
								<option value="a">Ascending</option>
								<option selected="selected" value="d">Descending</option>
						</select> <input class="button2" type="submit" value="Go" name="sort">
						</label>
					</fieldset>
				</form>
				<hr>
				<form id="jumpbox" onsubmit="if(this.f.value == -1){return false;}"
					action="./viewforum.php?style=2" method="post">
					<fieldset class="jumpbox">
						<label accesskey="j" for="f">Jump to:</label> <select id="f"
							onchange="if(this.options[this.selectedIndex].value != -1){ document.forms['jumpbox'].submit() }"
							name="f">
							<option value="-1">Select a forum</option>
							<option value="-1">------------------</option>
							<option value="1">Your first category</option>
							<option selected="selected" value="2">Your first forum</option>
							<option value="4">Your second forum</option>
							<option value="5">Your third forum</option>
							<option value="3">Your second category</option>
							<option value="6">Your first forum</option>
							<option value="7">Your second forum</option>
							<option value="8">Buy the theme!</option>
							<option value="9">Buy the theme!</option>
						</select> <input class="button2" type="submit" value="Go">
					</fieldset>
				</form>
				<!-- STATS -->
				<jsp:include page="/stats.jsp"></jsp:include>

			</div>
			<!-- BOARD CONTENT END -->
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