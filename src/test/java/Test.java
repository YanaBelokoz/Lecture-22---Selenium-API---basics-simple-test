import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Test {

    @org.testng.annotations.Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\exe\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uk.wikipedia.org/");
        String title = "Ласкаво просимо до Вікіпедії";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@title='en'")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Log in']")).click();
        WebElement username = driver.findElement(By.id("wpName1"));
        WebElement password = driver.findElement(By.id("wpPassword1"));
        WebElement login = driver.findElement(By.id("wpLoginAttempt"));
        username.sendKeys("Yana2022UA");
        password.sendKeys("14112022");
        WebElement checkbox = driver.findElement(By.name("wpRemember"));
        for (int i=0; i<2; i++) {
            checkbox.click();
        }
        login.submit();
        WebElement confirmation = driver.findElement(By.xpath("//a/span[contains(text(),'Yana2022UA']"));
        Assert.assertEquals(confirmation.getText(), "Yana2022UA");
        WebElement search = driver.findElement(By.id("searchInput"));
        search.sendKeys("Ukraine");
        search.submit();
        WebElement ukrPage = driver.findElement(By.xpath("//span[@class='mw-page-title-main' and contains(text(), 'Ukraine')]"));
        Assert.assertEquals(ukrPage.getText(), "Ukraine");
        driver.close();
    }
}