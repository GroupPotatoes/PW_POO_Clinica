<?php

include_once "session.php";
include_once 'patientDAO.php';
		
$patientDAO = new patientDAO("localhost", "healthclinicuser", "hcuser", "healthclinic");		
echo $patientDAO->inactivatePatient($_SESSION["patient_id"]);
	
?>
	