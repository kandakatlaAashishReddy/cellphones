<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy MOBILES</title>
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 40%;
	margin: auto;
	height: 250px;
}

.carousel-control.left, .carousel-control.right {
	background-image: none;
	opacity:0.4;
}
</style>
</head>
<body>
	
	<%@ include file="navbarBeforlogin.jsp"%>
	<c:if test="${errormsg!=null}">
		<div class="container">

			<div col-sm-3></div>
			<div col-sm-6>
				<div class="alert alert-danger alert-dismissable fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					${errormsg}
				</div>
			</div>
		</div>
	</c:if>

	<c:if test="${signupmsg!=null}">
		<div class="container">

			<div col-sm-3></div>
			<div col-sm-6>
				<div class="alert alert-success alert-dismissable fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					${signupmsg}
				</div>
			</div>
		</div>
	</c:if>

	<div class="container" style="padding-top: 0px">
		<div class="col-sm-3"
			style="background-color: #0db9f2; border-radius: 15px; padding-bottom: 15px; padding-top: 5px;">
			<div align="center" style="font-size: 30px; color: green">
				<b>Login Page</b>
			</div>
			<form name="loginForm" action="<c:url value="/j_spring_security_check"></c:url>" method="POST">

				<div class="form-group">
					<b> User ID </b> <br><input type="text" name="j_username" /> <br> </div>
					
				<div class="form-group">
					<b>Password</b> <br><input type="password" name="j_password" /> <br> </div>
					
					Forgot Password?<a href=""> Click Here</a>
					<div align="right">
					<input type="submit" value="Login" />
					</div>
			</form>
		</div>

		<div class="col-sm-9">

			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>

				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					<div class="item active">
						<div align="center">
							<img src="resources/images/products/PRD00001.jpg" alt="Los Angeles"
								style="width: 30%; height: 250px"> <img
								src="resources/images/products/PRD00002.jpg" alt="Los Angeles"
								style="width: 30%; height: 250px"> <img
								src="resources/images/products/PRD00003.jpg" alt="Los Angeles"
								style="width: 30%; height: 250px">
						</div>
					</div>

					<div class="item">
						<div align="center">

							<img src="resources/images/products/PRD00004.jpg" alt="Los Angeles"
								style="width: 30%; height: 250px"> <img
								src="resources/images/products/PRD00005.jpg" alt="Los Angeles"
								style="width: 30%; height: 250px"> <img
								src="resources/images/products/PRD00006.jpg" alt="Los Angeles"
								style="width: 30%; height: 250px">
						</div>
					</div>


				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>

	</div>

	<div class="container">

		<div class="col-sm-3">
			<img src="resources/images/products/PRD00001.jpg" width="200px"
				height="150px" /> <br> LED TV
		</div>

		<div class="col-sm-3">
			<img src="resources/images/products/PRD00002.jpg" width="200px"
				height="150px" /> <br> LCD TV
		</div>

		<div class="col-sm-3">
			<img src="resources/images/products/PRD00003.jpg" width="200px"
				height="150px" /> <br> CURVE TV
		</div>

		<div class="col-sm-3">
			<img src="resources/images/products/PRD00004.jpg" width="200px"
				height="150px" /> <br> PLASMA TV
		</div>


	</div>

</body>
</html>