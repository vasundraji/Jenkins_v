package jengit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class sample {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver using WebDriverManager
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Updated WebDriverWait with Duration
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Maximize browser window and navigate to the URL
        driver.manage().window().maximize();
        driver.get("http://advantageonlineshopping.com/");
    }

    @Test(priority = 1)
    public void testSearchAndAddToCart() {
    	WebElement searchButton = driver.findElement(By.id("menuSearch"));
       wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        // Step 1: Search for a product
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"autoComplete\"]")));
        searchBox.sendKeys("laptop");

    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
        	
            driver.quit();
        }
    }
}
