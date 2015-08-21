import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by bkatsarski on 21.8.2015 ã..
 */
public class NavigatinThroughWebPages {
    private WebDriver driver;
    private String URLpath = "http://localhost:63342/TeamMedisalton/HTML/";
    //private String URLpath = "http://192.168.0.196/team/work/html/";

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void navigateThroughWebPagesForNoReason() throws InterruptedException {
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(URLpath + "HomePage.html");Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/nav/div/ul/li[2]/a")).click();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[2]/form/input[10]")).click();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/form/input[10]")).click();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]/form/input[10]")).click();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]/form/input[10]")).click();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[6]/td[2]/form/input[10]")).click();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[7]/td[2]/form/input[10]")).click();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[8]/td[2]/form/input[10]")).click();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[1]/div[2]/input")).clear();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[1]/div[2]/input")).sendKeys("2");Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[2]/div[2]/input")).clear();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[2]/div[2]/input")).sendKeys("4");Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[3]/div[2]/input")).clear();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[3]/div[2]/input")).sendKeys("5");Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[4]/div[2]/input")).clear();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[4]/div[2]/input")).sendKeys("7");Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[5]/div[2]/input")).clear();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[5]/div[2]/input")).sendKeys("3");Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[6]/div[2]/input")).clear();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[6]/div[2]/input")).sendKeys("6");Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[7]/div[2]/input")).clear();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[7]/div[2]/input")).sendKeys("0");Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/nav/div/ul/li[3]/a")).click();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/nav/div/ul/li[4]/a")).click();Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/fieldset/p[2]/input")).sendKeys("goshopeshev@abv.bg");Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div/form/fieldset/textarea")).sendKeys("My message goes in here blah blah blah i'm Gosho Peshev nice to meet you !!!");Thread.sleep(300);
    }
@Test
    public void shoppingCartTestCases() throws InterruptedException {
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(URLpath + "Suplements.html");Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[2]/form/input[10]")).click();Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/form/input[10]")).click();Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[1]/div[2]/input")).clear();Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[1]/div[2]/input")).sendKeys("2");Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[2]/div[2]/input")).clear();Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div/form/ul/li[2]/div[2]/input")).sendKeys("1");Thread.sleep(500);
        String sum = driver.findElement(By.xpath("/html/body/div/form/div/div")).getText();Thread.sleep(500);
        assertEquals("Subtotal: $38.78 USD", sum);Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/form/ul/li/div[3]/button")).click();Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div/form/ul/li/div[3]/button")).click();Thread.sleep(500);
    }

    @Test
    public void LogInValidCredentialsTestCases() {

        String ValidEmail = "test@gmail.com";
        String ValidPass = "test";

        // navigate to homepage
        driver.get(URLpath + "HomePage.html");

        //Click Sign In link
        driver.findElement(By.linkText("Sign in")).click();

        //login dialog are active ?
        assertEquals(URLpath + "Login.html", driver.getCurrentUrl());

        //fill email
        driver.findElement(By.name("email")).sendKeys(ValidEmail);
        //fill pass
        driver.findElement(By.name("password")).sendKeys(ValidPass);
        //click Sign In
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        //Welcome page chk
        assertEquals(URLpath + "Welcome.html", driver.getCurrentUrl());
        //Hello message chk
        assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Hello user you logged in successfully");
    }

    @Test
    public void RegisterNewEmailTestCases() {

        String UserEmail = "mail" + Long.toHexString(Double.doubleToLongBits(Math.random())) + "@gmail.com";
        String UserPass = "test";

        // navigate to homepage
        driver.get(URLpath + "HomePage.html");

        //Click Sign In link
        driver.findElement(By.linkText("Register")).click();

        //login dialog are active ?
        assertEquals(URLpath + "Register.html", driver.getCurrentUrl());

        //fill email
        driver.findElement(By.name("email")).sendKeys(UserEmail);
        //fill pass
        driver.findElement(By.name("password")).sendKeys(UserPass);
        //fill pass1
        driver.findElement(By.name("password1")).sendKeys(UserPass);

        //click Sign In
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        try{
            //Wait 10 seconds till alert is present
            WebDriverWait wait = new WebDriverWait(driver, 10);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            if (alert.getText().equals("Registration Succeed!")) {
                //Accepting alert.
                alert.accept();
            }
        }catch(Throwable e){
            System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
        }

        //Home page chk
        assertEquals(URLpath + "HomePage.html", driver.getCurrentUrl());
    }
    

    @After
    public void tearDown(){driver.close();}
}
