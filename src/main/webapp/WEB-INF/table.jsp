<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title>G E S T I O N - D E - C I N E M A</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
                <link rel="stylesheet"
                    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
                    integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
                    crossorigin="anonymous" referrerpolicy="no-referrer" />
            </head>

            <body>
               
             
            
                <div class="container">
                    <h1 class="mt-3 text-center text-danger" >
                        C    I    N    E     ma    N    A    G    E    R
                    </h1>
                     <c:if test="${!empty sessionScope.login && !empty sessionScope.mdp }">
                       <div class="text-text-secondary text-center">
                       <p> Bienvenue ${sessionScope.login}</p> 
                       </div>
   
                    </c:if>
                    
                       <!-- -------------------------------------------------- -->
                        <nav class="navbar navbar-expand-md navbar-light bg-dark">
                         <a href="#"><i  class="fas fa-dragon text-danger fa-2x"></i>         </a> 
                         <ul class="navbar-nav">
                           <li class="nav-item"><a class="nav-link text-light" href="#">Home</a> </li>
                           <li class="nav-item dropdown">
                              <a 
                                 class="nav-link text-light dropdown-troggle" 
                                 data-toggle ="dropdown" 
                                 href="#"
                                 >Film</a> 
                             <div class="dropdown-menu">
                               <a class="dropdown-item" href="#"> All films</a> 
                                <a class="dropdown-item" href="#">By id </a> 
                                 <a class="dropdown-item" href="#">By Title </a>
                             </div>
                           
                           </li>
                           <li class="nav-item"><a class="nav-link text-light" href="#">Salle</a> </li>
                           <li class="nav-item"><a class="nav-link text-light" href="#">Seance</a> </li>
                           <li class="nav-item"><a class="nav-link text-light" href="#">Reservation</a> </li>
                           <li class="nav-item"><a class="nav-link text-light" href="#">Client</a> </li>
                         </ul> 
                        </nav>      
                       <!-- -------------------------------------------------- -->
                       <br>
                    <div class="col-4">
                        <form action="" method="POST">
                            <div class="row">
                                <div class="col-11">
                                    <input id="item" class="form-control" placeholder="nomTable" name="nomTable">
                                </div>
                                <div class="col-1">
                                    <input type="submit" name="valider" value="Valider" class="btn btn-dark" />
                                </div>
                            </div>
                        </form>
                    </div>
               
                <div class="col-12">
                    <div class="mt-3">

                        <div class="alert alert-danger" role="alert">${tableErreur}</div>
                    </div>
                    <h3 style="color: red"></h3>
                    <div>
                        <h2>${nomTable}</h2>
                    </div>
                    <div class="Col-12">
                    <table class="table table-striped  mt-5">
                        <thead align="left">
                            <tr>
                                <th>
                                    <c:forEach items="${donnees.get(0).getColonnes()}" var="element">
                                <th scope="col">${element}</th>
                                </c:forEach>
                            </tr>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${donnees}" var="lignes">
                                <tr>
                                    <td>
                                        <c:forEach items="${lignes.donnee}" var="ligne">
                                    <td>${ligne}</td>
                            </c:forEach>
                            </td>
                            </th>
                            </c:forEach>

                        </tbody>
                    </table>
                    </div>
                    
                </div>
              </div>

            </body>

            </html>