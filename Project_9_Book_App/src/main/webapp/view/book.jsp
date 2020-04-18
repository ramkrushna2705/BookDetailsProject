<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<body>
	<h1 style="color: red; text-align: center;">BOOK HOME PAGE</h1>

	<h2 style="color: blue;">
		Enter Book Details below...
		</h>

		<h3 style="color: green;">${successMsg}</h3>
		<h3 style="color: green;">${errorMsg}</h3>

		<form:form action="/saveBook?bookId=${book.bookId}" modelAttribute="book" method="POST">
			<table border="1">
				<tr>
					<td>Enter Book Name ::</td>
					<td><input type="text" name="bookName"></td>
				</tr>
				<tr>
					<td>Enter Book Price ::</td>
					<td><input type="text" name="bookPrice"></td>
				</tr>
				<tr>
					<td>Enter Author Name ::</td>
					<td><input type="text" name="authorName"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>

			</table>
		</form:form>
		
		<a href="/getAllBook">View All Book</a>
		
</body>
</html>