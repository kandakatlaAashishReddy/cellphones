<html>
<head>
  <title>MOBILES</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <%@ include file="links.jsp" %>
 
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 30%;
      margin: auto;
      height:250px;
  }
   .carousel-control.left, .carousel-control.right {
  background-image: none;opacity=0.4;
}
body{
background-color: orange;
}
  </style>
 
</head>
<body>
<h2>WELCOME TO MOBILE WORLD!</h2>
<%@ include file="navbarBeforlogin.jsp" %>
  
<div class="container">
  <h3>BUY 1 GET 1 FREE</h3>
</div>
<div class="container">
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
        <img src="resources\images\users\i1.jpg" alt="Los Angeles" style="style="width:30%; height:250px">
      </div>

      <div class="item" align="center">
        <img src="resources\images\users\i2.jpg" alt="Chicago" style="style="width:30%; height:250px">
      </div>
    
      <div class="item" align="center">
        <img src="resources\images\users\i3.jpg" alt="New york" style=" style="width:30%; height:250px">
      </div>
      <div class="item" align="center">
        <img src="resources\images\users\i4.jpg" alt="New york" style=" style="width:30%; height:250px">
      </div>
      <div class="item" align="center">
        <img src="resources\images\users\i5.jpg" alt="New york" style=" style="width:30%; height:250px">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<br>
<div class="container">
<div class="zoomin">
<div class="col-sm-4">
<img src="resources/images/users/PRD00002.jpg" width="200px" height="150px"/>
<br>
ROLEX
</div>
</div>


<div class="zoomin">
<div class="col-sm-4">
<img src="resources/images/users/i4.jpg" width="200px" height="150px"/>
<br>
TISSOT
</div>
</div>


<div class="zoomin">
<div class="col-sm-4">
<img src="resources/images/users/i5.jpg" width="200px" height="150px"/>
<br>
TAGHEUR
</div>
</div>


</div>
${message }
</body>
</html>
