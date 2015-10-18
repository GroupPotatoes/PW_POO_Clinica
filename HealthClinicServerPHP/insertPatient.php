<?php

include_once 'patientDAO.php';
include_once 'patientVO.php';

$patient = new Patient();

$patient->name = $_POST['insertName'];
$patient->cpf = $_POST['insertCPF'];
$patient->complement = $_POST['insertComplement'];
$patient->cep =  $_POST['insertCEP'];
$patient->number = $_POST['insertNumber'];
$patient->login = $_POST['insertLogin'];
$patient->password = $_POST['insertPassword'];
			
$patientDAO = new patientDAO("localhost", "healthclinicuser", "hcuser", "healthclinic");	

echo $patientDAO->insertPatient($patient);
			
?>