<?php

if(isset($_POST['searchType'], $_POST['searchWord']))
{		
	include_once 'patientDAO.php';

	$patientDAO = new patientDAO("localhost", "healthclinicuser", "hcuser", "healthclinic");
	echo json_encode($patientDAO->searchPatient($_POST['searchType'], $_POST['searchWord']));
}

?>