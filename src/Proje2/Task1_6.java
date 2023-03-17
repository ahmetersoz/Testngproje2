package Proje2;

import Utlity.BaseDriver;
import Utlity.Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class son extends BaseDriver {

    @Test(priority = 1)
    public void Case1() {

        WebElement register = driver.findElement(By.id("register-button"));
        register.click();


        WebElement gender = driver.findElement(By.id("gender-male"));
        gender.click();

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Ahmet");
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Ersoz");


        WebElement dateOfBirthday = driver.findElement(By.cssSelector("[name='DateOfBirthDay']"));
        Select dateofBirtDay1 = new Select(dateOfBirthday);
        dateofBirtDay1.selectByValue("2");
        WebElement dateOfBirtMonth = driver.findElement(By.cssSelector("[name='DateOfBirthMonth']"));
        Select dateOfMonth1 = new Select(dateOfBirtMonth);
        dateOfMonth1.selectByValue("2");
        WebElement dateOfBirdYear = driver.findElement(By.cssSelector("[name='DateOfBirthYear']"));
        Select dateOfYear1 = new Select(dateOfBirdYear);
        dateOfYear1.selectByValue("1981");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        email.sendKeys("aersoz1359@outlook.com");


        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("ahmet233");


        WebElement confirmpassword = driver.findElement(By.id("ConfirmPassword"));
        confirmpassword.sendKeys("ahmet233");

        WebElement register2 = driver.findElement(By.id("register-button"));
        register2.click();

        WebElement validation = driver.findElement(By.cssSelector("[class='result']"));

        Assert.assertTrue(validation.getText().contains("Your registration completed"));
        WebElement cont = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));
        cont.click();


    }

    @Test(priority = 2)
    void Logintest1() {

        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("aersoz1355@outlook.com");
        Tools.Bekle(1);
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("ahmet233");
        Actions actions = new Actions(driver);
        actions.moveToElement(email).click().sendKeys(email).build().perform();
        actions.moveToElement(password).click().sendKeys(password).build().perform();
        WebElement loginBtn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        loginBtn.click();
        WebElement validationlogin = driver.findElement(By.cssSelector("[class='ico-account']"));
        Assert.assertTrue(validationlogin.getText().contains("My account"));
        WebElement logout = driver.findElement(By.linkText("Log out"));
        logout.click();


    }


    @Test(priority = 3, dataProvider = "getData")
    void DataProviderLogin(String email1, String password1) {

        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();
        WebElement email = driver.findElement(By.id("Email"));
        //email.sendKeys("aersoz1355@outlook.com");


        WebElement password = driver.findElement(By.id("Password"));
        //password.sendKeys("ahmet233");

        Actions actions = new Actions(driver);
        actions.moveToElement(email).click().sendKeys(email1).build().perform();

        actions.moveToElement(password).click().sendKeys(password1).build().perform();


        WebElement loginBtn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        loginBtn.click();

        if (!email1.contains("email2@gmail.com") || !password1.contains("password2")) {
            WebElement errorMsg = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]/ul/li]"));
            Assert.assertTrue(errorMsg.getText().contains("Login was unsuccessful. Please correct the errors and try again."));
        } else {
            WebElement logOut = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
            logOut.click();
        }

    }

    @DataProvider
    public Object[][] getData() {
        Object[][] logins = {
                {"email2@gmail.com", "password2"},
                {"aersoz1355@outlook.com", "ahmet233"},

        };
        return logins;
    }

    @Test(priority = 3)
    void Tabmenu() {

        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();
        WebElement email2 = driver.findElement(By.id("Email"));
        email2.sendKeys("aersoz1355@outlook.com");
        WebElement pass2 = driver.findElement(By.id("Password"));
        pass2.sendKeys("ahmet233");
        WebElement login2 = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
        login2.click();

        List<WebElement> tabMenuList = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li/a"));
        List<String> menuExpectedList = new ArrayList<>();

        menuExpectedList.add("Computers");
        menuExpectedList.add("Electronics");
        menuExpectedList.add("Apparel");
        menuExpectedList.add("Digital downloads");
        menuExpectedList.add("Books");
        menuExpectedList.add("Jewelry");
        menuExpectedList.add("Gift Cards");
        for (int i = 0; i < menuExpectedList.size(); i++) {
            Assert.assertEquals(tabMenuList.get(i).getText(), menuExpectedList.get(i), "Menü Doğrulanamadı");

        }

    }


    @Test(priority = 4)
    void giftcarsd() {


        WebElement gifts = driver.findElement(By.cssSelector("ul[class='top-menu notmobile']>li:nth-child(7)"));
        gifts.click();

        int random = (int) Math.random() * 3;

        switch (random) {
            case 0:
                WebElement virtual25 = driver.findElement(By.linkText("$25 Virtual Gift Card"));
                virtual25.click();
                WebElement recipientsname1 = driver.findElement(By.id("giftcard_43_RecipientName"));
                recipientsname1.sendKeys("turgay");

                WebElement email = driver.findElement(By.id("giftcard_43_RecipientEmail"));
                email.sendKeys("aers777@gmail.com");

                WebElement yournm1 = driver.findElement(By.id("giftcard_43_SenderName"));
                yournm1.sendKeys("Tuna");
                WebElement yourmail = driver.findElement(By.id("giftcard_43_SenderEmail"));
                yourmail.sendKeys("aersoz1340@outlook.com");
                WebElement message = driver.findElement(By.cssSelector("textarea[id='giftcard_43_Message"));
                message.sendKeys("hi");


                WebElement addcart1 = driver.findElement(By.cssSelector("button[id='add-to-cart-button-43']"));
                addcart1.click();

                WebElement validation1 = driver.findElement(By.cssSelector("p[class='content']>a"));

                Assert.assertTrue(validation1.getText().contains("shopping cart"));
                break;

            case 1:
                WebElement physicalcard = driver.findElement(By.linkText("$50 Physical Gift Card"));
                physicalcard.click();

                WebElement recipientsname2 = driver.findElement(By.id("giftcard_44_RecipientName"));
                recipientsname2.sendKeys("ahmet");
                WebElement yourname2 = driver.findElement(By.id("giftcard_44_SenderName"));
                yourname2.sendKeys("enes");
                WebElement messsage2 = driver.findElement(By.cssSelector("textarea[id='giftcard_44_Message"));
                messsage2.sendKeys("selamlar");

                WebElement addtocart2 = driver.findElement(By.cssSelector("button[id='add-to-cart-button-44']"));
                addtocart2.click();

                WebElement validation2 = driver.findElement(By.cssSelector("p[class='content']>a"));

                Assert.assertTrue(validation2.getText().contains("shopping cart"));
                break;

            case 2:
                WebElement physicalnext = driver.findElement(By.linkText("$100 Physical Gift Card"));
                physicalnext.click();
                WebElement recipientsname3 = driver.findElement(By.id("giftcard_45_RecipientName"));
                recipientsname3.sendKeys("ahmet");
                WebElement yourname3 = driver.findElement(By.id("giftcard_45_SenderName"));
                yourname3.sendKeys("ömer faruk");
                WebElement messsage3 = driver.findElement(By.cssSelector("textarea[id='giftcard_45_Message']"));
                messsage3.sendKeys("merhaba");

                WebElement addtocart3 = driver.findElement(By.cssSelector("button[id='add-to-cart-button-45']"));
                addtocart3.click();

                WebElement validation3 = driver.findElement(By.cssSelector("p[class='content']>a"));

                Assert.assertTrue(validation3.getText().contains("shopping cart"));

                break;
        }


    }

    @Test(priority = 5)
    void Ordercomputer() {

        WebElement computers = driver.findElement(By.cssSelector("ul[class='top-menu notmobile']>li:nth-child(1)"));

        new Actions(driver).moveToElement(computers).build().perform();

        WebElement desktops = driver.findElement(By.cssSelector("[href='/desktops']"));
        desktops.click();
        WebElement buildownComputer = driver.findElement(By.xpath("//button[@class='button-2 product-box-add-to-cart-button']"));
        buildownComputer.click();

        List<WebElement> list = driver.findElements(By.cssSelector("select[id='product_attribute_2']>option"));
        int random2 = Tools.RandomNumberGenerator(list.size());
        list.get(random2).click();


        List<WebElement> list2 = driver.findElements(By.cssSelector("input[name='product_attribute_3']"));
        int random3 = Tools.RandomNumberGenerator(list2.size());

        list2.get(random3).click();
        WebElement addToCart = driver.findElement(By.cssSelector("[id='add-to-cart-button-1']"));
        addToCart.click();
        if (list.size() == 0) {
            WebElement validation = driver.findElement(By.cssSelector("p[class='content']"));
            Assert.assertTrue(validation.getText().contains("RAM"));

        } else {
            WebElement validation2 = driver.findElement(By.cssSelector("p[class='content']>a"));
            Assert.assertTrue(validation2.getText().contains("shopping cart"));

        }
        /*@Parameters("aranacakKelime")
        @Test
        void PametersSearch(String text) {

            WebElement searcStore = driver.findElement(By.cssSelector("[id='small-searchterms']"));
            searcStore.sendKeys(text);
            WebElement search = driver.findElement(By.cssSelector("[class='button-1 search-box-button']"));
            search.sendKeys(text);

            WebElement validation = driver.findElement(By.cssSelector("[class='product-title']>[href='/adobe-photoshop-cs4']"));
            Assert.assertTrue(validation.getText().contains("Adobe Photoshop CS4"));

        }
         */
    }
    }
