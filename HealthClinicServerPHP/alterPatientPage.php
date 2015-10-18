<?php
	include_once 'session.php';
?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="healthClinic.css">
		<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
		<title>Health Clinic - Alterar conta </title>
	</head>
	<body>
	<?php
	
		$id = $_SESSION["patient_id"];
		include_once 'patientDAO.php';
		
		$patientDAO = new patientDAO("localhost", "healthclinicuser", "hcuser", "healthclinic");
		$patient = $patientDAO->getPatientByID($id);
			
	?>
	<div class="alterPatientClass">
			
			<h3> Editar dados: </h3>
						
				<div>
					<label for="alterName">Nome:</label>
					<input id="alterName" type="text" name="alterName" value="<?php echo $patient->name; ?>"/>
				</div>
				<div>
					<label for="alterCPF">CPF:</label>
					<input id="alterCPF" type="text" maxLength="11" name="alterCPF" value="<?php echo $patient->cpf; ?>"/>
				</div>
				<div>
					<label for="alterComplement">Complemento:</label>
					<input id="alterComplement" type="text" name="alterComplement" value="<?php echo $patient->complement; ?>"/>
				</div>
				<div>
					<label for="alterNumber">Numero:</label>
					<input id="alterNumber" type="text" name="alterNumber" value="<?php echo $patient->number; ?>"/>
				</div>
				<div>
					<label for="alterCEP">CEP:</label>
					<input id="alterCEP" type="text" maxLength="8" name="alterCEP" value="<?php echo $patient->cep; ?>"/>
				</div>
				
				<div>
					<button id="alterButton" type="button" onclick="alterPatient()"> Salvar </button>
				</div>	
	</div>
	
	<script>
		
			function validadeField(field){
				return field != null && field != "";
			}
		
			function validateForm() {
							
				return validadeField($("#alterName").val()) && 
						validadeField($("#alterCPF").val()) && 
						validadeField($("#alterComplement").val()) &&
						validadeField($("#alterNumber").val()) &&  
						validadeField($("#alterCEP").val());
				
			}

			function alterPatient(){

				if(validateForm()){
					$.ajax({
							method: "POST",
							url: "alterPatient.php",
							data: {name: $("#alterName").val(), cpf: $("#alterCPF").val(), complement: $("#alterComplement").val(), number: $("#alterNumber").val(), cep: $("#alterCEP").val()},
							success: function(){
								alert("Dados atualizados!");
								window.location.replace("homePage.php");
							}
						});
				}
				else {
					alert("Dados incorretos!");
				}
			}
			
		</script>		
		
		
	</body>
	
</html>