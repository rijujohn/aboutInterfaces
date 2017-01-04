import java.io.File;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//System.setProperty("webdriver.chrome.driver", "C://Eclipse_Luna//Selenium//chromedriver.exe");
//Making new Changes
public class TestsOnGrid {
	private WebDriver driver = null;
    String  BaseURL,NodeURL;

@BeforeTest
public void before() throws Exception{
    BaseURL="http://www.google.com";
    NodeURL="http://localhost:4444/wd/hub";
    File file = new File("C://Eclipse_Luna//Selenium//chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    DesiredCapabilities capa =DesiredCapabilities.chrome();
    capa.setBrowserName("chrome");
    capa.setPlatform(Platform.ANY);
    driver=new RemoteWebDriver(new URL(NodeURL),capa);
}

@Test
public void GoogleSearch() throws Exception {
    driver.get("http://www.google.com");
    WebElement searchBox = driver.findElement(By.xpath("//div[3]/div/input[1]"));
    hightlight(searchBox);
    driver.findElement(By.xpath("//div[3]/div/input[1]")).clear();
    driver.findElement(By.xpath("//div[3]/div/input[1]")).sendKeys("Test");
    driver.findElement(By.xpath("//button")).click();

}

public void hightlight(WebElement webElement) throws InterruptedException {
    for (int i = 0; i < 2; i++) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].setAttribute('style', arguments[1]);",
                webElement, "color: red; border: 3px solid red;");
    }
}
}
