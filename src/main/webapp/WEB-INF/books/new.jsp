<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add book</title>
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
<h1>New Book</h1>
<form:form action="/create" method="post" modelAttribute="book">
   
	    <label>Title	<input type="text" name="title"></label>
	    <p></p>
		<div class="form-group">
		    <label for="exampleFormControlTextarea1">Description</label>
		    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name = "description"></textarea>
		  </div>
		<p></p>
		<label>Language		<input type="text" name="language"></label>
		<p></p>
		<label>Number of pages	<input type="number" name="numberOfPages"></label>
		<p></p>
 		<button class="btn btn-primary">Add new book</button>
    
</form:form> 
</div>
</body>
</html>