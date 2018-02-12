import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson3Habrahabr extends TestCase
{

    public void testConnectToGoogle() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://habrahabr.ru/");
        Thread.sleep(2000);  // Let the user actually see something!
        WebElement searchButton = driver.findElement(By.cssSelector("li:nth-child(4)"));
        searchButton.click();
        Thread.sleep(2000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.cssSelector("input#companies_suggest"));
        searchBox.sendKeys("Google");
        Thread.sleep(2000);  // Let the user actually see something!
        WebElement subscribers = driver.findElement(By.cssSelector("div#company_65 div.stats__counter.stats__counter_table-grid.stats__counter_subscribers"));
        String subs = subscribers.getAttribute("title");
        System.out.println(subs);
        WebElement rate = driver.findElement(By.cssSelector("div#company_65 div.stats__counter.stats__counter_table-grid.stats__counter_rating"));
        String rate1 = rate.getAttribute("title");
        System.out.println(rate1);
        driver.quit();
    }
}
