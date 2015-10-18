<?php

session_start();// Starting Session

if (isset($_SESSION['LAST_ACTIVITY']) && (time() - $_SESSION['LAST_ACTIVITY'] > 1800)) {
	// last request was more than 30 minutes ago
	session_unset();     // unset $_SESSION variable for the run-time
	session_destroy();   // destroy session data in storage
	
	header('Location: login.html'); // Redirecting To Home Page
}

if(isset($_SESSION['LAST_ACTIVITY']))
{
	$_SESSION['LAST_ACTIVITY'] = time(); // update last activity time stamp
}
else
{
	session_destroy();
	
	header('Location: login.html'); // Redirecting To Home Page
}
?>