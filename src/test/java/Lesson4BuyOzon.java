import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lesson4BuyOzon extends TestCase{

    public void testConnectToGoogle() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.ozon.ru/");
        //Thread.sleep(5000); // Let the user actually see something!
        try {
            WebElement searchButtonBooks = driver.findElement(By.cssSelector("form#form1 div.bHeaderCategoryLinks > a:nth-child(1)"));
            searchButtonBooks.click();
        } catch (Exception e) {
            WebElement banner = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div"));
            WebElement closeBanner = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]"));
            closeBanner.click();
        }
        try {
            WebElement searchButtonBooks = driver.findElement(By.cssSelector("form#form1 div.bHeaderCategoryLinks > a:nth-child(1)"));
            searchButtonBooks.click();
        } catch (Exception e) {
            WebElement all = driver.findElement(By.xpath("//*[@id=\"form1\"]/div/div[3]/div[1]/span"));
            all.click();
            WebElement searchButtonBooks2 = driver.findElement(By.xpath("//*[@id=\"form1\"]/div/div[3]/div[1]/div/div[1]/div/a[1]/span"));
            searchButtonBooks2.click();
            //Thread.sleep(2000); // Let the user actually see something!
        }
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,750)", "");
        //Thread.sleep(2000); // Let the user actually see something!
        //driver.quit();*/
        WebElement searchBestsellers = driver.findElement(By.xpath("//*[@id=\"PageCenter\"]/div[6]/div/div[2]/div/div[2]/div/div[1]/a/div[1]/div/img"));
        searchBestsellers.click();
        WebElement addBasket = driver.findElement(By.xpath("//*[@id=\"PageCenter\"]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[5]/div"));
        addBasket.click();
        WebElement countBasket = driver.findElement(By.xpath("//*[@id=\"PageCenter\"]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[5]/div/a/span[2]"));
        WebElement addOne = driver.findElement(By.xpath("//*[@id=\"PageCenter\"]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[5]/div/div"));
        addOne.click();
        //WebElement countBasket1 = driver.findElement(By.cssSelector("div#PageCenter span.eSaleBlockButton_label"));
        WebElement wayToBasket = driver.findElement(By.xpath("//*[@id=\"PageCenter\"]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[5]/div"));
        //wayToBasket.click();  работает через раз
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.className("eSaleBlockButton_label"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        WebElement element1 = driver.findElement(By.className("jsMinus"));
        Thread.sleep(5000); // Let the user actually see something! // так делать плохо, но это работает
        //WebElement dynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("jsMinus"))); //не работает
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // почему то не работает
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element1);
        Thread.sleep(5000); // Let the user actually see something! // так делать плохо, но это работает
        //executor.executeScript("arguments[0].click();", dynamicElement);

        WebElement element2 = driver.findElement(By.className("jsMinus"));
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element2);
        Thread.sleep(5000); // Let the user actually see something! // так делать плохо, но это работает

        WebElement basketIsEmpty = driver.findElement(By.xpath("//*[@id=\"PageCenter\"]/div[2]/div[3]/div[1]/div[1]/div[1]/div/span"));
        String empty = basketIsEmpty.getText();
        System.out.println(empty + ", драйвер закрылся. Тест выполнен.");
        driver.quit();


        }
}






