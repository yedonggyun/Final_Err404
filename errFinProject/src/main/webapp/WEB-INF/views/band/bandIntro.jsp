<!DOCTYPE>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.efp.band.model.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "java.util.*"  %>
<%@ page import= "java.text.*"  %>
<html>
<head>
<meta charset="utf-8">
<!--[if lt IE 9]><meta http-equiv="X-UA-Compatible" content="IE=edge"><![endif]-->
<meta name="viewport" content=" width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Weekend Magazine</title>
<link rel="stylesheet" href="${ contextPath }/resources/Remodal-1.1.1/dist/remodal.css">
  <link rel="stylesheet" href="${ contextPath }/resources/Remodal-1.1.1/dist/remodal-default-theme.css">
<link href="${ contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ contextPath }/resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ contextPath }/resources/css/style.css" rel="stylesheet">
    <link href="${ contextPath }/resources/css/responsive.css" rel="stylesheet">
    <link href="${ contextPath }/resources/css/light-pink-blue.css" rel="stylesheet">
</head>
<body
	class="home page page-id-4 page-template page-template-template_home-php">
	<!-- TOP NAV -->
	<div class="navbar navbar-default top-nav-bar" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".topmenu">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse topmenu">
				<div class="menu-header-templates-menu-container">
					<ul class="nav navbar-nav">
						<li><a href="about.html">About</a></li>
						<li><a href="article.html">Article</a></li>
						<li><a href="article-review.html">Article Review</a></li>
						<li><a href="archives.html">Archives</a></li>
						<li><a href="category.html">Category</a></li>
						<li><a href="fullwidth.html">Full Width</a></li>
						<li><a href="shortcodes.html">Shortcodes</a></li>
						<li><a href="404.html">404</a></li>
						<li><a href="contact.html">Contact</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- LOGO AREA -->
	<div class="fullwidth bg-pink">
		<div class="container">
			<div class="col-md-6 col-xs-12">
				<div class="logo">
					<h1>
						<a href="index.html" title="Weekend Magazine">Weekend Magazine</a>
					</h1>
				</div>
			</div>
			<div class="col-md-6 col-xs-12">
				<div id="ads120_60-widget-2" class="ads120-60 ads-one">
					<div class="ad-cell">
						<a href="#" target="_blank"> <img src="img/ad-468x60.png "
							alt="">
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- MAIN NAV -->
	<div class="fullwidth navbar navbar-default main-nav-bar"
		role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".mainmenu">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse mainmenu">
				<div class="menu-primary-navigation-container">
					<ul id="menu-primary-navigation" class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">Home
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="index.html">Home</a></li>
								<li><a href="index2.html">Home 2</a></li>
								<li><a href="index3.html">Home Dark 1</a></li>
								<li><a href="index4.html">Home Dark 2</a></li>
								<li><a href="index5.html">Home Light 1</a></li>
								<li><a href="index6.html">Home Light 2</a></li>
							</ul></li>
						<li><a href="#">News</a></li>
						<li><a href="#">Economy</a></li>
						<li><a href="#">Sports</a></li>
						<li><a href="#">Shows</a></li>
						<li><a href="#">Culture &#038; Art</a></li>
						<li><a href="#">Gossips</a></li>
						<li><a href="#">Fashion</a></li>
						<li><a href="#">Health &#038; Body</a></li>
						<li><a href="#">Technology</a></li>
						<li><a href="#">Science</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="container">

		<div class="left-sidebar col-md-3" role="complementary">

			<div id="categort-posts-widget-2"
				class="widget fullwidth categort-posts">
				<h1 class="widget-title"></h1>
				<ul class="tvshows">
					<li><a href="#"> <!-- <span class="comment-count">11</span> -->
							<img src="http://placehold.it/209x128" alt="">
					</a>
						<h2
							style="color: #222; font-size: 21px; margin-bottom: 15px; font-weight: 600; margin-top: 20px;">밴드명</h2>
						<h4
							style="display: inline-block; font-size: 13px; font-weight: 400; color: #333;">
							멤버 4<a href="#"
								style="position: relative; padding-left: 12px; color: #fdb00d !important; font-size: 13px;">
								초대코드 </a>
						</h4>
						<h4
							style="margin-top: 14px; padding-top: 13px; border-top: 1px solid #e1e1e1;">
							<a href="#"
								style="font-size: 12px; font-weight: 400; color: #666; text-decoration: none;">*
								밴드 설정</a>
						</h4></li>
				</ul>
				<div class="clear"></div>
			</div>

		</div>

		<div class="main col-md-6 col-xs-12">

			<div class="widget fullwidth post-single" style="margin-bottom:1px;">
				<h4 class="widget-title" style="font-size:20px;">밴드 소개 설정 </h4>
			</div>
			
			<div id="widget-feedburner-2" class="widget fullwidth widget-feedburner" style="margin-bottom:1px;">
                <h1 class="widget-title">소개입력</h1>
                <div class="widget-feedburner-counter subscribe">
                    <p>밴드에 카테고리 분류에 사용될 태그를 입력해주세요</p>
                     <p>밴드 소개에 사용될 글을 입력해주세요</p>
                    <form action="#" method="post">
                        <input class="feedburner-email input-subscribe" type="text" name="email"
                               value="대표태그 추가"
                               onfocus="if (this.value == '대표태그 추가') {this.value = '';}"
                               onblur="if (this.value == '') {this.value = '대표태그 추가';}">
                        <input class="feedburner-subscribe input-button" type="submit" name="submit" value="추가">
                 
                 
                 		<p class="textarea clearfix">
              <label for="commentsText"><small>Your Message<span class="star">*</span></small></label>
              <textarea name="comments" id="commentsText" class="required requiredField"></textarea>
            </p>
                 
                 
                    </form>
                </div>
            </div>
			
            

		</div>
		
		

		<div class="right-sidebar col-md-3" role="complementary">


			<div id="categort-posts-widget-2"
				class="widget fullwidth categort-posts">
				<h1 class="widget-title">최근 사진</h1>
				<ul class="tvshows">
					<li><a href="#"> <img
							style="min-height: 100px; height: 100px; width: 100px;"
							src="http://placehold.it/209x128" alt="">
					</a> <a href="#"> <img
							style="min-height: 100px; height: 100px; width: 100px;"
							src="http://placehold.it/209x128" alt="">
					</a></li>
					<li><a href="#"> <img
							style="min-height: 100px; height: 100px; width: 100px;"
							src="http://placehold.it/209x128" alt="">
					</a> <a href="#"> <img
							style="min-height: 100px; height: 100px; width: 100px;"
							src="http://placehold.it/209x128" alt="">
					</a></li>



				</ul>



				<div class="clear"></div>




			</div>

			<div id="widget-survey" class="widget fullwidth widget-survey">
				<h1 class="widget-title">Survey</h1>
				<div class="widget-content">
					<p>What was the last time you slept on bed in your house?</p>
					<form action="#" method="post" class="mrgn-bottom-0">
						<div class="form-group mrgn-bottom-0">
							<div class="checkbox">
								<label> <input name="remember" value="1" type="checkbox">
									Today
								</label>
							</div>
						</div>
						<div class="form-group mrgn-bottom-0">
							<div class="checkbox">
								<label> <input name="remember" value="1" type="checkbox">
									Yesterday
								</label>
							</div>
						</div>
						<div class="form-group mrgn-bottom-0">
							<div class="checkbox">
								<label> <input name="remember" value="1" type="checkbox">
									The day after tomorrow
								</label>
							</div>
						</div>
						<div class="form-group mrgn-bottom-0">
							<div class="checkbox">
								<label> <input name="remember" value="1" type="checkbox">
									Tomorrow
								</label>
							</div>
						</div>
						<div class="row survey">
							<div class="col-md-6">
								<button class="button vote">Vote</button>
							</div>
							<div class="col-md-6">
								<button class="button">Results</button>
							</div>
						</div>
					</form>
				</div>
			</div>


			<div id="ads250_250-widget-2"
				class="widget fullwidth ads250_250-widget">
				<h1 class="widget-title">Advertisement</h1>
				<div class="ads250-250">
					<div class="ad-cell">
						<a href="#"><img src="img/ad-210x190.png" class="fullwidth"
							alt=""></a>
					</div>
				</div>
			</div>

		</div>

	</div>

	<div class="footer">
		<div class="footer-top">
			<div class="container">
				<div class="pull-left">
					<div id="text-6">
						<div class="textwidget">
							<a href="#">Weekend Magazine</a> &copy; 2015 All rights reserved
						</div>
					</div>
				</div>
				<div class="pull-right hidden-xs">
					<div id="text-7">
						<div class="textwidget">
							Theme by <a title="Email me now" href="#">JKthemes</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-bottom hidden-xs">
			<div class="container">
				<div id="nav_menu-2">
					<div class="menu-footer-menu-container">
						<ul id="menu-footer-menu" class="menu">
							<li><a href="#">Home</a></li>
							<li><a href="#">News</a></li>
							<li><a href="#">Economy</a></li>
							<li><a href="#">Sports</a></li>
							<li><a href="#">Shows</a></li>
							<li><a href="#">Culture &#038; Art</a></li>
							<li><a href="#">Gossips</a></li>
							<li><a href="#">Fashion</a></li>
							<li><a href="#">Health &#038; Body</a></li>
							<li><a href="#">Technology</a></li>
							<li><a href="#">Science</a></li>
						</ul>
					</div>
				</div>
				<a class="footer-nav-scroll pull-right"></a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.bxslider.min.js"></script>
	<script src="js/custom.js"></script>
</body>
</html>