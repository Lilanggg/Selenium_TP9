import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test_TP9 {

    WebDriver driver;


    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.get("http://www.toolsqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement demoSite = driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[8]/a/span[1]/span/span"));
        demoSite.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement iFramePage = driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[8]/ul/li[7]/a/span[1]/span/span"));
        wait.until(ExpectedConditions.visibilityOf(iFramePage));
        iFramePage.click();
    }
    @Test
    public void test1(){
        WebElement sampleIFrame = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        Assert.assertEquals("Sample Iframe page", sampleIFrame.getText());
    }

    @Test
    public void test2(){
        driver.switchTo().frame("IF1");
        WebElement iFrame1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/h1"));
        Assert.assertEquals("Practice Automation Form", iFrame1.getText());
    }

    @Test
    public void test3(){
        driver.switchTo().frame("IF2");
        WebElement iFrame2 = driver.findElement(By.xpath("//*[@id=\"post-9\"]/header/h1"));
        Assert.assertEquals("Home", iFrame2.getText());

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
