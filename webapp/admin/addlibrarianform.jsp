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
        <title>Add Librarian Form</title>
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
            <h3>Add Librarian</h3>
            <form action="/saveLibrarian" method="post" style="width:300px">
                <div class="form-group">
                    <label for="name1">Name</label>
                    <input type="text" class="form-control" name="name" id="name1" placeholder="Name" required/>
                </div>
                <div class="form-group">
                    <label for="email1">Email address</label>
                    <input type="email" class="form-control" name="email" id="email1" placeholder="Email" required/>
                </div>
                <div class="form-group">
                    <label for="password1">Password</label>
                    <input type="password" class="form-control" name="pass" id="password1" placeholder="Password" required/>
                </div>  
                <div class="form-group">
                    <label for="mobile1">Mobile Number</label>
                    <input type="number" class="form-control" name="number" id="mobile1" placeholder="Mobile" required/>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <h2>${msg}</h2>
        </div>
        
        <script src="design/jquery.min.js"></script>
        <script src="design/bootstrap.min.js"></script>
    </body>
</html>