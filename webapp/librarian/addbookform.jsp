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
        <title>Add Book Form</title>
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
            <h3>Add Book Form</h3>
            <form action="/saveBook" method="post" style="width:300px">
                <div class="form-group">
                    <label for="callno1">Ref. no</label>
                    <input type="text" class="form-control" name="bookRefNo" id="callno1" placeholder="Callno" required=""/>
                </div>
                <div class="form-group">
                    <label for="name1">Name</label>
                    <input type="text" class="form-control" name="bookName" id="name1" placeholder="Name" required=""/>
                </div>
                <div class="form-group">
                    <label for="author1">Author</label>
                    <input type="text" class="form-control" name="authorName" id="author1" placeholder="Author" required=""/>
                </div>
                <div class="form-group">
                    <label for="publisher1">Publisher</label>
                    <input type="text" class="form-control" name="publisher" id="publisher1" placeholder="Publisher" required=""/>
                </div>
                <div class="form-group">
                    <label for="quantity1">Quantity</label>
                    <input type="number" class="form-control" name="qunt" id="quantity1" placeholder="Quantity" required=""/>
                </div>
                <button type="submit" class="btn btn-primary">Save Book</button>
            </form>
            <h2>${msg}</h2>
        </div>

        <script src="design/jquery.min.js"></script>
        <script src="design/bootstrap.min.js"></script>
    </body>
</html>