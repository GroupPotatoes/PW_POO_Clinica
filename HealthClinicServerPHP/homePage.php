<?php
	include_once 'session.php';
?>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="healthClinic.css"/>
		<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
		<title>Health Clinic - Home</title>
	</head>
	<body>
			
		<?php
			
			$id = $_SESSION["patient_id"];
			include_once 'patientDAO.php';
				
			$patientDAO = new PatientDAO("localhost", "healthclinicuser", "hcuser", "healthclinic");
			$patient = $patientDAO->getPatientByID($id);
			
		?>
		
		<h3 id="patient"> Olá, <?php echo $patient->name; ?>! </h3>
		
		<div class="menu">
			<!-- <a href="delete.php"> Excluir conta </a> -->
			<a href="#" onclick="desactivateLogin()"> Excluir conta </a>
			
			<a href="searchPatientPage.php"> Pesquisar paciente </a>
			
			<!-- <a href="#" onclick="searchPatient()"> Pesquisar paciente </a>-->
			
			<a href="alterPatientPage.php">Alterar conta</a>
			
			<a href="destroySession.php">Sair</a>
	
		</div>
		
		<script>
		
			function desactivateLogin(){
				$.ajax("delete.php").done(function() {
					window.location.replace("destroySession.php");
				});				  
			}
			
		</script>
	</body>
</html>