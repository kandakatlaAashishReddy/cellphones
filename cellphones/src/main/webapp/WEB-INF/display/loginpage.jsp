<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<%@ include file="links.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="navbarBeforlogin.jsp"%>
	<c:if test="${errormsg!=null}">

		<div class="container">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="alert alert-danger alert-dismissable fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
					${errormsg}
				</div>
			</div>
		</div>
	</c:if>

	<c:if test="${signupmsg!=null}">
		<div class="container">
			<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<div class="alert alert-success alert-dismissable fade in">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
						${signupmsg}
					</div>
				</div>
			</div>
		
	</c:if>

	<br> ${msg}
	<br>
	<div class="container">

		<div class="col-sm-3"
			style="background-color: #00ffff; border-radius: 15px; padding-bottom: 15px; padding-top: 5px;">
			<div align="center" style="font-size: 30px; color: green">
				<b>lOGIN</b>
			</div>

			<xyz:form commandName="userObject" action="reqLoginCheck">
				<div class="form-group">
					<br>User ID
					<xyz:input class="form-control" placeholder="Enter User ID"
						path="userid" />
				</div>
				<div class="form-group">
					<br>Password
					<xyz:password class="form-control" placeholder="Enter Password"
						path="password" />
					<br>
				</div>

				<xyz:button>Submit</xyz:button>

			</xyz:form>


		</div>





		<div class="col-sm-9">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
					<li data-target="#myCarousel" data-slide-to="4"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">

					<div class="item active" align="center">
						<img src="resources\images\users\ph3.jpg" alt="Los Angeles"
							style="width: 30%; height: 250px">
					</div>


					<div class="item" align="center">
						<img src="resources\images\users\ph2.jpg" alt="Chicago"
							style="width: 30%; height: 250px">
					</div>

					<div class="item" align="center">

						<img src="resources\images\users\ph4.jpg" alt="New york"
							style="width: 30%; height: 250px">
					</div>


					<div class="item" align="center">
						<img src="resources\images\users\ph5.jpg" alt="New york"
							style="width: 30%; height: 250px">
					</div>

					<div class="item" align="center">
						<img src="resources\images\users\ph6.jpg" alt="New york"
							style="width: 30%; height: 250px">
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

	${username}



</body>
</html>