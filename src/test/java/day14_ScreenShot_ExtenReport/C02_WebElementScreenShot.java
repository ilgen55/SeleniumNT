package day14_ScreenShot_ExtenReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
        /*
    Eğer sadece bır webelementın resmını almak ıstersek
    o elementın locatını alıp WE.getScreenShotAs()
    methodu ıle webelementın resmını alabılırız.
 */
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        //ekran resmini alalım
        ekranResmi();
        //sonuc yazısı webelementinin resmini alalım
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/utilities/ekranGörüntüleriWE"+tarih+".png";
        WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }

    @Test
    public void test02() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        //ekran resmini alalım
        ekranResmi();
        //sonuc yazısı webelementinin resmini alalım
        WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
       webElementResmi(sonucYazisi);

    }

    @Test
    public void test03() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        //ekran resmini alalım
        ekranResmi();
        //sonuc yazısı webelementinin resmini alalım
        WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        webElementResmi(sonucYazisi);
    }

    @Test
    public void test04() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        //ekran resmini alalım
        String tarih=new SimpleDateFormat("_HH_mm_ss_ddMMyyy").format(new Date());
        String dosyaYolu="src/test/java/utilities/ekranGörüntüleriFullscreen/amazon"+tarih+"jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        //sonuc yazısı webelementinin resmini alalım
        String tarih1=new SimpleDateFormat("_HH_mm_ss_ddMMyyy").format(new Date());
        String dosyaYolu1="src/test/java/utilities/ekranGörüntüleriWebscreen/dosyaYolu"+tarih+"jpeg";
        WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        TakesScreenshot websc= (TakesScreenshot) driver;
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu1));

    }
}
