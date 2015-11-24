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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <nav class="navbar navbar-fixed-top"><ul class="topMenu">
                <li> <a href="home.jsp" class="current">Home</a>
                <li> <a href="#">Administrar conta</a>
                    <ul class="subMenu">
                        <li><a href="alterar.html">Alterar</a></li>
                        <li><a href="excluir.html">Excluir</a></li>
                    </ul>
                </li>
                <li> <a href="#">Consultas</a>
                    <ul class="subMenu">
                        <li><a href="criarconsulta_carregarespecializacao.jsp">Marcar consulta</a></li>
                        <li><a href="consultasanteriores.jsp">Consultas anteriores</a></li>
                        <li><a href="minhasconsultas.jsp">Proximas consultas</a></li>
                    </ul>
                </li>
            </ul>
        </nav>

        <div id="page-container">
            <h4>Login efetuado com sucesso!<br>
                Seja bem vindo(a), <%= session.getAttribute("patientID")%>!</h4>
            <div>

            </div>
        </div>
    </body>
</html>
