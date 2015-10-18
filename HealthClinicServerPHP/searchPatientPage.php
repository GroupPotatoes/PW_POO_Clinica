<?php
	include_once 'session.php';
?>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="healthClinic.css">
		<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
		<title>Health Clinic - Pesquisar Paciente </title>
	</head>
	<body>	
		
		<div class="searchPatient">
			<input id="searchWord" type="text" name="searchWord"/>
			<select id="searchType" name="searchType">
				<!--<option value="rg"> RG </option>-->
				<option value="cpf"> CPF </option>
				<!--<option value="birthdate"> Data de Nascimento </option>-->
				<!--<option value="phone"> Telefone </option>-->
				<option value="name"> Nome </option>
			</select>
			<button id="searchButton" type="button" onclick="searchPatientMethod()"> Pesquisar </button>
		</div>	
						
		<div class="resultSearch">
			<table>
				<thead>
					<tr>
						<th>Nome</th>
						<th>CPF</th>
						<th>Login</th>
						<th>Número</th>
					</tr>
				</thead>
				<tbody id="resultSearchRow">			
				</tbody>
			</table>
		</div>
		
		<a href="homePage.php"> Voltar </a>
		
		<script>
			function searchPatientMethod()
			{			
				$.ajax({
					method: "POST",
					url: "searchPatient.php",
					data: {searchType: $("#searchType").val(), searchWord: $("#searchWord").val()},
					success: function(searchedPatientList)
					{	
						var row = "";
						var searchedJSON = $.parseJSON(searchedPatientList);
						for(var i = 0; i < searchedJSON.length; i++)
						{
							$("#resultSearchRow").append( '<tr>' + 
									'<td>' + searchedJSON[i].name + '</td>' +
									'<td>' + searchedJSON[i].cpf + '</td>' +
									'<td>' + searchedJSON[i].login + '</td>' +
									'<td>' + searchedJSON[i].number + '</td>' +
									'</tr>');
						}

						//$("#resultSearchRow").innerHTML = row;	
					}
				});		
			}
		</script>
		
		
	</body>
	
</html>