<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<style>

    .wrapper{
      width:700px;
      margin-left: 20px;
      padding: 20px;
      justify-content: space-between;
    }

</style>
<body>
<div class="wrapper">
	<h1>All Books</h1>


	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Title</th>
	      <th scope="col">Description</th>
	      <th scope="col">Language</th>
	      <th scope="col">Number of Pages</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${books}" var="book">
	    <tr>
	      <td><a href="/books/${book.id}/show" <c:out value="${book.title}"/>><c:out value="${book.title}"/></a></td>
		  <td><c:out value="${book.description}"/></td>
		  <td><c:out value="${book.language}"/></td>
		  <td><c:out value="${book.numberOfPages}"/></td>
	    </tr>
	   </c:forEach> 
	  </tbody>
	</table>

	<a href="/books/new">New Book</a>
</div>
</body>
</html>