package day17_JSExecutor_Log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutorSetAttribute extends TestBase {
    @Test
    public void test01() {
        /*
    sendKeys() methodu ile <input> tagına sahip bir webelemente jsscript kodlarıyla yazılmış ise
   bir veri gönderemeyiz. Bu gibi durumlarda js executor ile çok veri gönderebiliriz
   */
    //amazon sayfasına gidelim
        driver.get("https://amazon.com");
    //arama kutusuna java yazdıralım
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='java'",aramaKutusu);
    }

    @Test
    public void test02() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //arama kutusuna java yazdıralım
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        jsSendKeys(aramaKutusu,"iphone");
    }

    @Test
    public void test03() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

      //arama Kutusu id attribut değerini ismimiz ile değiştirelim
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','kasım')",aramaKutusu);

        //Ve arama kutusunda değiştirdiğimiz attribute ile java aratalım
        driver.findElement(By.id("kasım")).sendKeys("java");


    }

    @Test
    public void test04() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        jsSendKeys(aramaKutusu,"iphone");
    }
}
