<?php

/*** begin our session ***/
session_start();

/*** check if the users is already logged in ***/
if(isset( $_SESSION['user_id'] ))
{
    $message = 'Users is already logged in';
}

/*** check that both the email, password have been submitted ***/
if(!isset( $_POST['email'], $_POST['password1'], $_POST['password']))
{
    $message = 'Please enter a valid e-mail and passwords';
}

/*** check the email is the correct length ***/
elseif (strlen( $_POST['email']) > 255 || strlen($_POST['email']) < 6)
{
    $message = 'Incorrect Length for Email';
}

/*** check the password's is the correct length ***/
elseif ((strlen( $_POST['password']) > 255 || strlen($_POST['password']) < 4) || (strlen( $_POST['password1']) > 255 || strlen($_POST['password1']) < 4))
{
    $message = 'Incorrect Length for Passwords';
}

/*** check the email has correct format ***/
elseif (filter_var($_POST['email'], FILTER_VALIDATE_EMAIL) === false)
{
    /*** if there is no match ***/
    $message = "email is not a valid email address";
}

/*** check the password's has only alpha numeric characters ***/
elseif ((ctype_alnum($_POST['password']) || ctype_alnum($_POST['password1'])) !== true)
{
        /*** if there is no match ***/
        $message = "Passwords must be alpha numeric";
}

/*** check if an password's are the same***/
elseif(strcmp($_POST['password'] , $_POST['password1']) !== 0 )
{
		/*** if there is no match ***/
        $message = "Passwords are not the same!";
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

        /*** prepare the insert ***/
        $stmt = $dbh->prepare("INSERT INTO accounts (UserEmail, UserPass ) VALUES (:phpro_username, :phpro_password )");

        /*** bind the parameters ***/
        $stmt->bindParam(':phpro_username', $phpro_username, PDO::PARAM_STR);
        $stmt->bindParam(':phpro_password', $phpro_password, PDO::PARAM_STR, 40);

        /*** execute the prepared statement ***/
        $stmt->execute();

        /*** unset the form token session variable ***/
        unset( $_SESSION['form_token'] );

        /*** if all is done, say thanks ***/
		$redirectUrl = 'HomePage.html';
		echo '<script type="text/javascript">; alert("Registration Succeed!"); window.location.href = "'.$redirectUrl.'";</script>';
		exit;
    }
    catch(Exception $e)
    {
        /*** check if the username already exists ***/
        if( $e->getCode() == 23000)
        {
            $message = 'Username already exists';
        }
        else
        {
            /*** if we are here, something has gone wrong with the database ***/
            $message = 'We are unable to process your request. Please try again later"';
        }
    }
}
$redirectUrl = 'Register.html';
echo '<script type="text/javascript">; alert("Registration Failed!\n\n'.$message.'"); window.location.href = "'.$redirectUrl.'";</script>';

?>