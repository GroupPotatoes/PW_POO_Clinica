<?php

include_once "session.php";	
include_once 'patientVO.php';
include_once 'patientDAO.php';

$patientDAO = new PatientDAO("localhost", "healthclinicuser", "hcuser", "healthclinic");
$patient = new Patient();

$patient->idpatient = $_SESSION["patient_id"];
$patient->name = $_POST['name'];
$patient->cpf = $_POST['cpf'];
$patient->complement = $_POST['complement'];
$patient->number = $_POST['number'];
$patient->cep = $_POST['cep'];

echo $patientDAO->alterPatient($patient);
	
?>