package Utlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void baslangicIslemler()
    {
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

        wait=new WebDriverWait(driver,
                Duration.ofSeconds(30));
        loginTest();
    }

    void loginTest()
    {
        System.out.println("Login Test");

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

       // WebElement login = driver.findElement(By.linkText("Log in"));
        //login.click();
       // WebElement email2 = driver.findElement(By.id("Email"));
        //email2.sendKeys("aersoz1340@outlook.com");
        //WebElement pass2 = driver.findElement(By.id("Password"));
        //pass2.sendKeys("ahmet233");
        //WebElement login2 = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
        //login2.click();

        //Assert.assertTrue(driver.getTitle().equals("My Account"));
        //Assert.assertEquals(driver.getTitle(),"My Account", "Login olamadı");
        //Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));
    }

    @AfterClass
    public void bitisIslemleri()
    {
        Tools.Bekle(5);
        driver.quit();
    }
}
