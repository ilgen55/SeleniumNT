package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class LMS03 extends TestBase {
    @Test
    public void test01() {
        //-https://the-internet.herokuapp.com/windows sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/windows");
        String sayfa1=driver.getWindowHandle();
        //-Sayfada Elemental Selenium webelementinin görünür olduğunu test ediniz
        WebElement elementalSelenium= driver.findElement(By.xpath("(//*[@target='_blank'])[2]"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        //-Elemental Selenium linkine tıklayınız
        elementalSelenium.click();
      Set<String> pencereler=driver.getWindowHandles();
        for (String w:pencereler ) {
            if(!w.equals(sayfa1)){
                driver.switchTo().window(w);
            }
        }
        //-Açılan pencerede sayfa başlığının Elemental Selenium içerdiğini test ediniz
        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));

         //-Url'in https://elementalselenium.com/ olduğunu doğrulayınız
        Assert.assertEquals("https://elementalselenium.com/",driver.getCurrentUrl());

        //A free weekly email of tips to help make
        //Selenium one of the most robust browser
        //automation tools out there.

        //-Yukarıdaki text'in altındaki email bölümüne email'inizi yazınız
        WebElement email= driver.findElement(By.xpath("//*[@id='email']"));
        email.sendKeys("ksm@gmail");
        //-Language dropdown menuden java seçiniz
        WebElement language= driver.findElement(By.xpath("//*[@class='dropdown-language']"));
        Select  select=new Select(language);
        select.selectByIndex(2);
        //-Join the mailing list buttonuna tıklayınız
        driver.findElement(By.xpath("//*[@class='home-button']")).click();
        //-Sayfada Thank you! yazısının çıktığını doğrulayınız
    }
}
