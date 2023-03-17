package Proje2;

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class task7 extends BaseDriver {

    @Parameters("aranacakKelime")
    @Test
    void PametersSearch(String text) {

        WebElement searcStore = driver.findElement(By.cssSelector("[id='small-searchterms']"));
        searcStore.sendKeys(text);
        WebElement search = driver.findElement(By.cssSelector("[class='button-1 search-box-button']"));
        search.sendKeys(text);

        WebElement validation = driver.findElement(By.cssSelector("[class='product-title']>[href='/adobe-photoshop-cs4']"));
        Assert.assertTrue(validation.getText().contains("Adobe Photoshop CS4"));
    }
}