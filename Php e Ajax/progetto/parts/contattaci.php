<?php
require_once 'dbConnect.php';

ob_start();
if ($_POST['act'] == 'invia') {
	
    $mail = $_POST["mail"];
    $messaggio = $_POST["messaggio"];
    print $mail;

    if ($mail == "" || $messaggio == "")
    {
        //Rispondo in modo negativo
        $ris = "KO";
    }
    else
    {
        $data = date("Y-m-d");
        $query = "INSERT INTO contattaci (mail, messaggio, data) VALUES ('$mail', '$messaggio', '$data')";
        $db->query($query);
        $ris = "OK";
    }
}
ob_end_clean();
print json_encode($ris);
?>
