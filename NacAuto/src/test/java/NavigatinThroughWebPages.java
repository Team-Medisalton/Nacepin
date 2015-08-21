import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

/**
 * Created by bkatsarski on 21.8.2015 ã..
 */
public class NavigatinThroughWebPages {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void navigateThroughWebPagesForNoReason() throws InterruptedException {
        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("http://localhost:63342/TeamMedisalton/HTML/HomePage.html");Thread.sleep(300);
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
        driver.get("http://localhost:63342/TeamMedisalton/HTML/Suplements.html");Thread.sleep(500);
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

@After
    public void tearDown(){
    driver.close();
}
}
