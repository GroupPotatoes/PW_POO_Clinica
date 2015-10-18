<?php
include_once 'patientDAO.php';

$patientDAO = new patientDAO("localhost", "healthclinicuser", "hcuser", "healthclinic");			
$result = $patientDAO->verifyLogin($_POST['patientLogin'], $_POST['patientPassword']);
if($result->num_rows > 0)
{
	session_start();
	$_SESSION['patient_id'] = $result->fetch_object()->idpatient;
	$_SESSION['LAST_ACTIVITY'] = time();	
}

echo $result->num_rows > 0;
			
?>