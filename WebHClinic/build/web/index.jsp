<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Faça seu login para entrar no sistema</title>
    </head>
    <body>
        <div id="page-container">
            <form action="Validate" method="post">
                <fieldset>
                    <h3>Faça seu login:</h3>
                    Login:<br>
                    <input type="text" name="login" id="login"> <br>
                    <br>Senha:<br>
                    <input type="password" name="senha" id="senha"> <br>
                    <br>
                    <input type="submit" value="Logar">
                    <br>
                    <br>
                    <p><a href="register.html">Não tem cadastro? Clique aqui!</a></p>
                </fieldset>
            </form>
        </div>
    </body>
</html>
