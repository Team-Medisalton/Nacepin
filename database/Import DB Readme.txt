
1.Sheck mySQL service status :
     1.1 Start 'XAMPP Controll Panel' from 'All programs - XAMPP' 
     1.2 Check mySQL text background color - should be green

2.Create database (if database not exist yet)
     2.1 Open OS command line console
     2.2 Navigate to MySQL installation folder (Exam. root:\XAMPP\mySQL\bin)
     2.3 Execute command line : mysql -u root -e "create database nacepin" 
         ('root' account has <empty> password by default)

3.Import database 
     3.1 Open OS command line console
     3.2 Navigate to MySQL installation folder (Exam. root:\XAMPP\mySQL\bin)
     3.3 Execute command line : mysql -u root -p nacepin < nacepin.sql
	 ('root' account has <empty> password by default)

Done!




