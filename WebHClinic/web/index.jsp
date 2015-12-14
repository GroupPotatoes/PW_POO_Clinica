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
        <link rel="icon" type="image/png" href="images/logo_oficial.png" />
    </head>
    <body>
        <div id="page-container">
            <form action="Validate" method="post">
                    <div class="form-group">
                        <label for="login">Login</label>
                        <input type="text" name="login" id="login" class="form-control" placeholder="Digite seu login" required value>
                    </div>
                    <div class="form-group">
                        <label for="cpf">Senha</label>
                        <input class="form-control" placeholder="Digite sua senha" type="password" name="senha" id="senha" required value>
                    </div>
                    <input type="submit" class="btn btn-default" value="Logar">
                    <br>
                    <br>
                    <p><a href="register.html">Não tem cadastro? Clique aqui!</a></p>
            </form>
        </div>
    </body>
</html>
