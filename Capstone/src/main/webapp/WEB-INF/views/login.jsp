<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <link href="webjars/bootstrap/5.0.0-beta1/css/bootstrap.min.css" rel="stylesheet">
        <meta charset="ISO-8859-1">
        <title>Login</title>
    </head>

    <body>
        <form method="POST" action="login">
            <div class="form-group">
                <label for="username">User Name</label>
                <input type="text" class="form-control" id="username" aria-describedby="userHelp"
                    placeholder="Enter username" name="username">
                <small id="userHelp" class="form-text text-muted">We'll never share your username with anyone
                    else.</small>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Password" name="password">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>

    </html>