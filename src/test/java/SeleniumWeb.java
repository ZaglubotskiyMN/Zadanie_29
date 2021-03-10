import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumWeb {
    private WebDriver webDriver;

    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        webDriver=new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");
    }

    @Test
    public void happypass(){

        WebElement Name= webDriver.findElement(By.xpath("//input[@id='user-name']"));
        Name.sendKeys("standard_user");
        WebElement Password= webDriver.findElement(By.xpath("//input[@id='password']"));
        Password.sendKeys("secret_sauce");
        WebElement submit = webDriver.findElement(By.id("login-button"));
        submit.click();
        String value = webDriver.getCurrentUrl();
        Assert.assertTrue(value.contains("https://www.saucedemo.com/inventory.html"));
    }
    @Test
    public void Negativtest(){
        WebElement Name= webDriver.findElement(By.xpath("//input[@id='user-name']"));
        Name.sendKeys("123");
        WebElement Password= webDriver.findElement(By.xpath("//input[@id='password']"));
        Password.sendKeys("123");
        WebElement submit = webDriver.findElement(By.id("login-button"));
        submit.click();
        String value = webDriver.getCurrentUrl();
        Assert.assertFalse(value.contains("https://www.saucedemo.com/inventory.html"));
    }
    public void  setText(String id, String text){
        WebElement userName = webDriver.findElement(By.xpath("//input[@id='id']"));
        userName.sendKeys(text);

    }
    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        if (webDriver != null){
            webDriver.quit();
        }
    }


}
