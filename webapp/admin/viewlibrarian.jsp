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
        <title>View Librarian</title>
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
                    <a class="navbar-brand" href="/homepage">eLibrary</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="/homepage">Home</a></li>
                        <li><a href="/addLibrarian">Add Librarian</a></li>
                        <li><a href="/viewLibrarian">View Librarian</a></li>
                        <li><a href="/">Logout</a></li>
                    </ul>

                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class='container'>
            <table class='table table-bordered table-striped'>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Mobile</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${msg}" var="temp">
                   <tr>
                        <td>${temp.name}</td>
                        <td>${temp.email}</td>
                        <td>${temp.pass}</td>
                        <td>${temp.number}</td>
                        <td><a class="btn btn-primary" href="/deleteLibrarian/${temp.email}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        
        <script src="design/jquery.min.js"></script>
        <script src="design/bootstrap.min.js"></script>
    </body>
</html>