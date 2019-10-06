<%-- 
    Document   : index
    Created on : 25 Sep, 2019, 10:57:22 PM
    Author     : shubham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>View Book</title>
        <link rel="stylesheet" href="design/bootstrap.min.css"/>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/home">eLibrary</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="/home">Home</a></li>
                        <li><a href="/addBook">Add Book</a></li>
                        <li><a href="/viewBook">View Book</a></li>
                        <li><a href="/issueBookform">Issue Book</a></li>
                        <li><a href="/returnBookForm">Return Book</a></li>
                        <li><a href="/">Logout</a></li>
                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class='container'>
            <table class='table table-bordered table-striped'>
                <tr>
                    <th>CALLNO</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Publisher</th>
                    <th>Qun</th>
                    <th>Issed</th>
                </tr>
                <c:forEach items="${msg}" var="temp">
                   <tr>
                        <td>${temp.bookRefNo}</td>
                        <td>${temp.bookName}</td>
                        <td>${temp.authorName}</td>
                        <td>${temp.publisher}</td>
                        <td>${temp.qunt}</td>
                        <td>${temp.issuedBook}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <script src="design/jquery.min.js"></script>
        <script src="design/bootstrap.min.js"></script>
    </body>
</html>