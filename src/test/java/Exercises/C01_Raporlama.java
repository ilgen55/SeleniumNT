package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_Raporlama extends TestBase {
    @Test
    public void test01() {
        rapor("Chorome","Smoke Test");
        extentTest=extentReport.createTest("Amazon Test","Test Raporu");
      // 'https://www.amazon.com' adresine gidin
        driver.get("https://www.amazon.com");
        extentTest.info("Amazon sayfasına gidildi");
      // arama kutusuna "Java" yazip aratın
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);

      // sonuc yazisinin "Java" icerdigini test edin
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisi.getText().contains("Java"));
        extentTest.info("Sonuç yazısının jjava içerdiğ testedildi");
      // kontrollu olarak yeni bir sayfa acın
        driver.switchTo().newWindow(WindowType.WINDOW);
        extentTest.info("Kontrollü yeni sayfa açıldı");
      // yeni acılan sayfada "Kitap" aratın
        driver.get("https://www.amazon.com");
       aramaKutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Kitap",Keys.ENTER);
        extentTest.info("Yeni açılan sayfada kitap aratıldı");

      // sonuc yazisinin Kitap icerdigini test edin
        sonucYazisi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisi.getText().contains("Kitap"));
        extentTest.pass("Sonuç yazısının kitap içerdiği test edildi");
        extentReport.flush();
      // sayfayı kapatınız

       // test raporu alınız
    }
}
