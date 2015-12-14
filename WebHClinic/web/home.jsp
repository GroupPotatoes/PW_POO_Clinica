<%@page session = "true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- BOOTSTRAP CDN LINKS: Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <title>Welcome to your Health Clinic <3</title>
        <link rel="icon" type="image/png" href="images/logo_oficial.png" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <style>
            .carousel-inner > .item > img,
            .carousel-inner > .item > a > img {
                width: 70%;
                margin: auto;
            }
            
            .carousel-caption > h3, p{
                color: #CC0000;
            }
        </style>
        <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script type='text/javascript' src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script type='text/javascript'>      
        $(document).ready(function() {   
        });
        </script>
        <script>
          (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
          (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
          m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
          })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
          ga('create', 'UA-40413119-1', 'bootply.com');
          ga('send', 'pageview');
        </script>
        <div class="row">
            <div class="col-md-2">
                <div id='menu'>
                    <img src="images/logo_oficial.png" class="img-responsive" alt="Cinque Terre">
                    <ul class="nav nav-pills nav-stacked left-menu" id="stacked-menu">
                        <li id="active" class="active"><a href="#">Home</a></li>
                        <li>
                          <a href="#" data-target="#item1" data-toggle="collapse" data-parent="#stacked-menu">Editar perfil<span class="caret arrow"></span></a>
                          <ul class="nav nav-stacked collapse left-submenu" id="item1">
                            <li><a href="alterarcadastro.jsp">Alterar conta</a></li>
                            <li><a href="excluircadastro.jsp">Excluir conta</a></li>
                          </ul>
                        </li>
                        <li>
                          <a href="#" data-target="#item2" data-toggle="collapse" data-parent="#stacked-menu">Consultas<span class="caret arrow"></span></a>
                          <ul class="nav nav-stacked collapse left-submenu" id="item2">
                            <li><a href="criarconsulta_carregarespecializacao.jsp">Marcar consulta</a></li>
                            <li><a href="consultasanteriores.jsp">Consultas anteriores</a></li>
                            <li><a href="minhasconsultas.jsp">Proximas consultas</a></li>
                          </ul>
                        </li> 
                    </ul>
                </div>
            </div>
            <div class="col-md-10">  
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                          <li data-target="#myCarousel" data-slide-to="1"></li>
                          <li data-target="#myCarousel" data-slide-to="2"></li>
                          <li data-target="#myCarousel" data-slide-to="3"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                          <div class="item active">
                            <img src="images/carousel_4.jpg" alt="Chania" width="460" height="345">
                            <div class="carousel-caption">
                                <h3>Equipes especializadas</h3>
                                <p>Profissionais prontos para qualquer desafio.</p>
                            </div>
                          </div>

                          <div class="item">
                            <img src="images/carousel_1.jpg" alt="Chania" width="460" height="345">
                            <div class="carousel-caption">
                                <h3>Atendimento a qualquer momento</h3>
                                <p>Nosso hospital garante todos os tipos de profissionais 24h</p>
                            </div>
                          </div>

                          <div class="item">
                            <img src="images/carousel_3.jpg" alt="Flower" width="460" height="345">
                             <div class="carousel-caption">
                                <h3>Tecnologia de ponta</h3>
                                <p>Nosso hospital tem a melhor infraestrutura de Campinas e região.</p>
                            </div>
                          </div>
                            
                          <div class="item">
                            <img src="images/carousel_2.jpg" alt="Flower" width="460" height="345">
                            <div class="carousel-caption">
                                <h3>Acompanhamento único</h3>
                                <p>Aqui o atendimento é especial, porque valorizamos cada um dos nossos pacientes.</p>
                            </div>
                          </div>
                        </div>
                    </div>
            </div>
        </div>
    </body>
</html>
