<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="links.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>

<body>
	<%@ include file="userNavBar.jsp"%>
	<br><br><br>
	<div class="container" style="padding-top:20px;">
		<div class="row row-eq-height" >
			<div class="col-sm-12" style="border-style:none;background-color:transparent;">
			<table border="0">
			<tr>
			<td style="vertical-align: middle; font-weight: bold; color: black;padding-right:20px">
				<c:url value="/resources/images/products/${product.productid}.jpg"  var="url"></c:url>
				<img src="${url}" height="400px" width="500px" style="border-radius:20px"/>			
				</td>
				<td style="vertical-align: middle; font-weight: bold; color: black">
		
				<b >${product.productname}
				<br>
				${product.productdesc}	
				</b>
				</td>
			</tr>	
			</table>				
			</div>				
		</div>	
		</div>
		
		<div class="container">
		
		<div class="row row-eq-height" >
			
		
		<div class="col-sm-12" style="text-align: left; vertical-align: middle;background-color:transparent;border-style: none">
		
		<c:url value="/reqAddProductRating/${ordhistroy.orderhistoryid}" var="url"></c:url>
		<xyz:form action="${url}" commandName="reviewobject" method="POST">
		
      	<b style="font-weight: bold; color: black;font-size:24">Rating   :   
      	<xyz:radiobutton path="rating" value="1"/>1
      	<xyz:radiobutton path="rating" value="2"/>2
      	<xyz:radiobutton path="rating" value="3"/>3
      	<xyz:radiobutton path="rating" value="4"/>4
      	<xyz:radiobutton path="rating" value="5"/>5
      	<br>
      	</b>
      
      
      	<b style="font-weight: bold; color: black;font-size:24;">Comment</b>
      	<br>
      	<xyz:input path="comment" />
      	
      	
    	<xyz:button class="btn-lg btn-success">Add Review</xyz:button>  	
      	</xyz:form> 
      	</div>
    

		
		</div>
				
	</div>

</body>
</html>