<?php
	
	include_once 'patientVO.php';

	class PatientDAO{
		
		protected $connect;
		protected $database;
		
		public function PatientDAO($host, $username, $password, $database){
			
			//$mysqli = new mysqli("localhost", "healthclinicuser", "hcuser", "healthclinic");
			//if($mysqli->connect_errno)
			
			$this->connect = new mysqli($host, $username, $password, $database);
			if($this->connect->connect_errno){
				echo "FALHA NA CONEXÃO!";
			}
			
			//$this->database = mysql_select_db($database);
		}
		
		private function execute($sql){
			return $this->connect->query($sql);
		}
		
		public function insertPatient($patientVO){			
			return $this->execute("INSERT INTO patient (name, cpf, login, password, number, complement, cep) VALUES ('{$patientVO->name}', '{$patientVO->cpf}', '{$patientVO->login}', '{$patientVO->password}', '{$patientVO->number}','{$patientVO->complement}','{$patientVO->cep}');");
		}
		
		public function verifyLogin($login, $password){
			
			$sqlCommand = "SELECT * FROM patient WHERE NOT inactive AND login = '{$login}' AND password = '{$password}';";			
			return $this->execute($sqlCommand);
		}
		
		public function deletePatient($id){
			
			$sqlCommand = "DELETE FROM patient WHERE idpatient = {$id};";
			if($this->execute($sqlCommand)){
				
			}
			else{
				
			}
			
		}
		
		public function inactivatePatient($id){
						
			$sqlCommand = "UPDATE patient SET inactive = 1 WHERE idpatient = {$id};";
			return $this->execute($sqlCommand);
			
		}
	
		public function alterPatient($patientVO){
			
			/*
					UPDATE patient
					SET name = '', cpf = '', number = '', complement = '', cep=''
					WHERE idpatient = 1;
			*/
			
			$sqlCommand = "UPDATE patient SET name = '{$patientVO->name}', cpf = '{$patientVO->cpf}', number = '{$patientVO->number}', complement = '{$patientVO->complement}', cep='{$patientVO->cep}' WHERE idpatient = {$patientVO->idpatient};";
			return $this->execute($sqlCommand);
		}
		
		public function getPatientByID($id){
			//$patient = $patientDAO->getPatientByID($_GET['id']);
			
			$sqlCommand = "SELECT * FROM patient WHERE idpatient={$id};";
			return $this->execute($sqlCommand)->fetch_object("Patient");
		}
	
		public function searchPatient($searchType, $searchWord){
			
			$resultList = array();
			
			$result = $this->execute("SELECT * FROM patient WHERE {$searchType} LIKE '%{$searchWord}%';");
			while($obj = $result->fetch_object("Patient"))
			{
				array_push($resultList, $obj);
			}
				
			return $resultList;
			
		}
	
	}
?>