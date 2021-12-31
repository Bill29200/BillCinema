<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title>Authentification</title>

                <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
                    id="bootstrap-css">
                <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
                <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <!------ Include the above in your HEAD tag ---------->
            </head>

            <body>

                <div class="container login-container">

                    <h1 class="mt-3">
                        <div class="text-center">
                            <div class="text-light bg-dark">
                                G E S T I O N - D E - C I N E M A
                            </div>

                        </div>

                    </h1>

                    <div class="row">
                        <div class="col-md-6 ">
                            <h3>Authentification</h3>
                            <form>
                                <div class="form-group">
                                    <input type="text" name="login" class="form-control" placeholder="Your login" value="" />
                                        
                                </div>
                                <div class="form-group">
                                    <input type="password" name="mdp" class="form-control" placeholder="Your Password" value="" />
                                     
                                </div>

                                <div class="form-group">
                                    <input type="submit" class="btn btn-dark" name="login" value="Login" />
                                </div>


                                <div class="form-group">
                                    <a href="#" class="ForgetPwd">Forget Password?</a>
                                </div>

                            </form>
                            <div class="col-12">
                                <div class="mt-3">

                                    <div class="alert alert-danger" role="alert">${erreur}</div>
                                </div>
                                <h3 style="color: red"></h3>
                                <div>
                                </div>
                            </div>
                        </div>
            </body>

            </html>