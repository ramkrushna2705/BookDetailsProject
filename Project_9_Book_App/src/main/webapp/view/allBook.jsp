<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function myFunction() {
		return confirm("Are you sure ? you want to delete..!!");
	}
</script>
</script>
</head>
<body bgcolor="F6B8CF">
	<center>
		<h2 style="color: blue; text-align: center;">
			<marquee>View All Contact Page...!!</marquee>
		</h2>
		<a href="/home" style="text-align: right;">+Add New Book</a> <br>
		<h1></h1>
		<font color="green">${successMessage}</font><br>

		<c:choose>
			<c:when test="${allBook.size()>0}">
				<table border="1" bgcolor="yellow">
					<tr background="yellow">
						<th>BOOK ID</th>
						<th>BOOK NAME</th>
						<th>BOOK PRICE</th>
						<th>AUTHOR NAME</th>
						<th>ACTION</th>
					</tr>
					<c:forEach items="${allBook}" var="bok">
						<tr bgcolor="cyan">
							<td><c:out value="${bok.bookId}" /></td>
							<td><c:out value="${bok.bookName}" /></td>
							<td><c:out value="${bok.bookPrice}" /></td>
							<td><c:out value="${bok.authorName}" /></td>
							<td><a href="/updateBook/${bok.bookId}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="/deleteBook?bookId=${bok.bookId}"
								onclick="return myFunction()">Delete</a></td>
						</tr>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td><h2 style="color: black; text-align: center;">No
									Data Found Go to add Contact...!!</h2></td>
						</tr>
					</c:otherwise>
					</c:choose>
				</table>
				<br>
				<a href="/home">Home</a>
</body>
</center>
</html>
