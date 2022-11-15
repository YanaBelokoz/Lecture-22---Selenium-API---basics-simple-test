import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestError {
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
        password.sendKeys("14112023");
        login.submit();
        WebElement error = driver.findElement(By.xpath("//div[@class='mw-message-box-error mw-message-box']"));
        Assert.assertEquals(error.getText(), "Incorrect username or password entered. Please try again.");
        driver.close();
    }
}
