<%-- 
    Document   : index
    Created on : 25 Sep, 2019, 10:57:22 PM
    Author     : shubham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Return Book Form</title>
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
            <h3>Return Book Form</h3>
            <form action="/returnBook" method="post" style="width:300px">
                <div class="form-group">
                    <label for="callno1">Ref. no</label>
                    <input type="text" class="form-control" name="bookRefNo" id="callno1" placeholder="Callno" required=""/>
                </div>
                <div class="form-group">
                    <label for="studentid1">Student Id</label>
                    <input type="text" class="form-control" name="studentId" id="studentid1" placeholder="StudentId" required=""/>
                </div>
                <button type="submit" class="btn btn-primary">Return Book</button>
            </form>
            <h2>${msg}</h2>
        </div>

        <script src="design/jquery.min.js"></script>
        <script src="design/bootstrap.min.js"></script>
    </body>
</html>