<?php

/*** begin our session ***/
session_start();

/*** check if the users is already logged in ***/
if(isset( $_SESSION['user_id'] ))
{
    $message = 'Users is already logged in';
}
/*** check that both the email, password have been submitted ***/
if(!isset( $_POST['email'], $_POST['password']))
{
    $message = 'Please enter a valid e-mail and password';
}
/*** check the email is the correct length ***/
elseif (strlen( $_POST['email']) > 64 || strlen($_POST['email']) < 6)
{
    $message = 'Incorrect Length for Email';
}
/*** check the password is the correct length ***/
elseif (strlen( $_POST['password']) > 64 || strlen($_POST['password']) < 4)
{
    $message = 'Incorrect Length for Password';
}
/*** check the email has correct format ***/
elseif (filter_var($_POST['email'], FILTER_VALIDATE_EMAIL) === false)
{
    /*** if there is no match ***/
    $message = "email is not a valid email address";
}
/*** check the password has only alpha numeric characters ***/
elseif (ctype_alnum($_POST['password']) != true)
{
        /*** if there is no match ***/
        $message = "Password must be alpha numeric";
}
else
{
    /*** if we are here the data is valid and we can insert it into database ***/
    $phpro_username = filter_var($_POST['email'], FILTER_SANITIZE_STRING);
    $phpro_password = filter_var($_POST['password'], FILTER_SANITIZE_STRING);

    /*** now we can encrypt the password ***/
    /*** $phpro_password = sha1( $phpro_password ); ***/
    
    /*** connect to database ***/
    /*** mysql hostname ***/
    $mysql_hostname = 'localhost';

    /*** mysql username ***/
    $mysql_username = 'root';

    /*** mysql password ***/
    $mysql_password = '';

    /*** database name ***/
    $mysql_dbname = 'nacepin';

    try
    {
        $dbh = new PDO("mysql:host=$mysql_hostname;dbname=$mysql_dbname", $mysql_username, $mysql_password);
        /*** $message = a message saying we have connected ***/

        /*** set the error mode to excptions ***/
        $dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        /*** prepare the select statement ***/
        $stmt = $dbh->prepare("SELECT UserID, UserEmail, UserPass FROM accounts 
                    WHERE UserEmail = :phpro_username AND UserPass = :phpro_password");

        /*** bind the parameters ***/
        $stmt->bindParam(':phpro_username', $phpro_username, PDO::PARAM_STR);
        $stmt->bindParam(':phpro_password', $phpro_password, PDO::PARAM_STR, 40);

        /*** execute the prepared statement ***/
        $stmt->execute();

        /*** check for a result ***/
        $user_id = $stmt->fetchColumn();

        /*** if we have no result then fail boat ***/
        if($user_id == false)
        {
                $message = 'Incorrect e-mail or password';

        }
        /*** if we do have a result, all is well ***/
        else
        {
                /*** set the session user_id variable ***/
                $_SESSION['user_id'] = $user_id;

                /*** tell the user we are logged in ***/
                /*** $message = 'You are now logged in'; ***/
				
				header("location:HomePage_In.html");
				exit;
				
		}
    }
    catch(Exception $e)
    {
        /*** if we are here, something has gone wrong with the database ***/
        $message = 'We are unable to process your request. Please try again later"';
    }
}

$redirectUrl = 'Login.html';
echo '<script type="text/javascript">; alert("Login Failed!\n\n'.$message.'"); window.location.href = "'.$redirectUrl.'";</script>';

?>
