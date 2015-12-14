<%@page session = "true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- BOOTSTRAP CDN LINKS: Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <title>Alterar cadastro</title>
        <link rel="icon" type="image/png" href="images/logo_oficial.png" />
        <meta charset="UTF-8">
    </head>
    <body>
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
                        <li><a href="home.jsp">Home</a></li>
                        <li>
                          <a href="#" data-target="#item1" data-toggle="collapse" data-parent="#stacked-menu">Editar perfil<span class="caret arrow"></span></a>
                          <ul class="nav nav-stacked collapse left-submenu" id="item1">
                            <li id="active" class="active"><a href="#">Alterar conta</a></li>
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
                <div id="page-container">
                    <form action="Alterar" method="get">
                       <fieldset>
                        <h2>Preencha seus dados:</h2>     
                        <div class="form-group">
                            <label for="nome">Nome</label>
                            <input type="text" maxlength="50" class="form-control" name="name" id="name" placeholder="Digite seu nome" required value>
                        </div>
                        <div class="form-group">
                            <label for="nome">CPF</label>
                            <input type="text" class="form-control" placeholder="Apenas números" name="cpf" id="cpf" maxlength="11" required value>
                        </div>
                        <div class="form-group">
                            <label for="nome">CEP</label>
                            <input type="text" class="form-control" placeholder="Apenas números" name="cep" maxlength="7" id="cep" required value>
                        </div>
                        <div class="form-group">
                            <label for="nome">Numero</label>
                            <input type="text" class="form-control" maxlength="4" placeholder="Apenas números" name="number" id="number" required value>
                        </div>
                        <div class="form-group">
                            <label for="nome">Complemento</label>
                            <input type="text" class="form-control" placeholder="Se nenhum, digite 0" name="complement" id="complement" required value>
                        </div>
                        <div class="form-group">
                            <label for="nome">Telefone</label>
                            <div class="radio">
                                <label><input type="radio" name="phone_type" id="phone_type" value="1" checked> Residencial </label>                             
                                <label><input type="radio" name="phone_type" id="phone_type" value="2"> Celular</label>
                                <label><input type="radio" name="phone_type" id="phone_type" value="3"> Trabalho</label>            
                            </div>
                            <div class="form-group">
                                    <label>
                                        <input type="text" class="form-control" size="2" maxlength="2" placeholder="xx" name="area_code" id="area_code">
                                    </label>
                                    <label>
                                        <input type="text" class="form-control" Size="9" maxlength="8" placeholder="xxxxxxxx" name="phone_number" id="phone_number" pattern="[0-9]{4,6}[0-9]{3,4}$">
                                    </label>
                            </div>
                        </div>
                        <br>
                        <div class="form-group">
                            <label for="login">Novo login</label>
                            <input type="text"  maxlength="6" class="form-control" placeholder="Digite seu novo login..." name="login" id="login" required value>
                        </div>
                        <div class="form-group">
                            <label for="password">Nova senha</label>
                            <input type="password"  maxlength="6" class="form-control" placeholder="Senha" name="password" id="password" required value>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-default" type="submit" value="Cadastrar">Alterar</button>
                        </div>
                          <!-- <p>Repita a senha:</p>
                           <input type="password" maxlength="6" placeholder="Confirme Senha" name="senha2" id="senha2" required value >
                           <br><br>

                           <p> Login: </p>
                           <input type="text"placeholder="" name="login" id="login" text="lala" readonly> <br>
                           <p>Senha:<br></p>
                           <input type="password"placeholder="" name="senha" id="senha" text="lala" readonly>    
                           <br><br>

                           <input class="btn btn-default" type="submit" value="Cadastrar">-->
                       </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
