package day14_ScreenShot_ExtenReport;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
        // amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //sayfanin resmini alalim
        String dosyaYolu="src/test/java/utilities/ekranGörüntüleri.jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }

    @Test
    public void test02() throws IOException {
        // amazon sayfasina gidelim
        driver.get("https://facebook.com");

        //sayfanin resmini alalim
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyy").format(new Date());
        String dosyaYolu="target/ekranGoruntusu/screenShot"+tarih+".pnp";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }

    @Test
    public void test03() throws IOException {
        // amazon sayfasina gidelim
        driver.get("https://youtube.com");

        //sayfanin resmini alalim
        String tarih = new SimpleDateFormat("_HH_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/utilities/ekranGörüntüleri/youtube"+tarih+"jpeg";
       TakesScreenshot ts= (TakesScreenshot) driver;
       FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }

    @Test
    public void test04() throws IOException {
        // amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //sayfanin resmini alalim
        String tarih=new SimpleDateFormat("_HH_mm_ss_ddMMyyy").format(new Date());
        String dosyaYolu="src/test/java/utilities/ekranGörüntüleriFullscreen/amazon"+tarih+"jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }

    @Test
    public void test05() {
        // amazon sayfasina gidelim
        driver.get("https://facebook.com");

        //sayfanin resmini alalim
        ekranResmi();
    }
}
