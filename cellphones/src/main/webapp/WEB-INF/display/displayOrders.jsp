<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 	pageEncoding="ISO-8859-1"%>
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
	

	<c:forEach items="${orders}" var="order">

		<div class="container"
			style="padding-top: 10">
			<table border="0" class="table table-stripped fixed_headers"
				style="font-weight: bold;">
				<tr
					style="background: rgba(60, 60, 40, 1); color: pink; table-layout: fixed;">
					<td style="text-align: center">Order Id : ${order.orderId}</td>
					<td style="text-align: center">Order Date : ${order.orderDate}</td>
					<td style="text-align: center">Shipped Address :
						${order.shippedAddress}</td>

				</tr>
			</table>
		</div>
		<div class="container" style="padding-top: 10"">
			<table border="0" class="table table-stripped fixed_headers"
				style="font-weight: bold">
				<thead>
					<tr
						style="color: blue; table-layout: fixed;">
						<th style="text-align: center">Product</th>
						<th style="text-align: center">Supplier</th>
						<th style="text-align: center">Price</th>
						<th style="text-align: center">Quantity</th>
						<th style="text-align: center">Review</th>

					</tr>
				</thead>
				<c:forEach items="${order.customerOrdersHistory}" var="orderhistory">
					<tr
						style=" color: black; table-layout: fixed;">
						<c:url
							value="/resources/images/products/${orderhistory.productid}.jpg"
							var="url"></c:url>
						<td
							style="text-align: center; vertical-align: middle; font-weight: bold; color: black"><img
							src="${url}" height="70" width="100" />
						</td>
						<c:url
							value="/resources/images/supplier/${orderhistory.supplierid}.jpg"
							var="url"></c:url>
						<td
							style="text-align: center; vertical-align: middle; font-weight: bold; color: black">
							<img src="${url}" height="70" width="100" />
						</td>
						<td
							style="text-align: center; vertical-align: middle; font-weight: bold; color: black">
							${orderhistory.price}</td>
						<td
							style="text-align: center; vertical-align: middle; font-weight: bold; color: black">
							${orderhistory.quantity}</td>
						<c:if test="${orderhistory.reviewgiven==false}">
							<td
								style="text-align: center; vertical-align: middle; font-weight: bold; color: black">
								<c:url
									value="/reqReviewProductPage/${orderhistory.orderhistoryid}"
									var="url"></c:url> <a href="${url}">Review Product</a>
							</td>
						</c:if>
						<c:if test="${orderhistory.reviewgiven==true}">
							<td style="text-align: center; vertical-align: middle; font-weight: bold; color: black">
								${orderhistory.rating} - ${orderhistory.comments}  
							</td>
						</c:if>


					</tr>


				</c:forEach>


			</table>

		</div>


	</c:forEach>
<hr>
</body>
</html>