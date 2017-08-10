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

  </style>
 
</head>
<body>
<h2>WELCOME TO MOBILE WORLD!</h2>
<%@ include file="navbarBeforlogin.jsp" %>
  
<div class="container">
  <h3>DIWALI BONUS GIFTS AND OFFERS UPTO 50%</h3>
</div>
<div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active" align="center">
        <img src="resources\images\users\ph2.jpg" alt="SAMSUNG" style="style="width:50%; height:400px">
      </div>

      <div class="item" align="center">
        <img src="resources\images\users\ph3.jpg" alt="NOKIA" style="style="width:50%; height:400px">
      </div>
    
      <div class="item" align="center">
        <img src="resources\images\users\ph5.jpg" alt="I-PHONE" style=" style="width:50%; height:400px">
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
<img src="resources/images/users/ph4.jpg" width="200px" height="150px"/>
<br>
SMART PHONE
</div>
</div>


<div class="zoomin">
<div class="col-sm-4">
<img src="resources/images/users/ph6.jpg" width="200px" height="150px"/>
<br>
SAMSUNG
</div>
</div>


<div class="zoomin">
<div class="col-sm-4">
<img src="resources/images/users/ph7.jpg" width="200px" height="150px"/>
<br>
ONE PLUS3
</div>
</div>


</div>
${message }
</body>
</html>
