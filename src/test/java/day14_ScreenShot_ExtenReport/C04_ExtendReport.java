package day14_ScreenShot_ExtenReport;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_ExtendReport extends TestBase {
    ExtentReports extentReport;//-->raporlamayı başlatır
    ExtentHtmlReporter extentHtmlReporter;//-->Html formatında rapor oluşturur
    ExtentTest extentTest;//-->Test adımlarına bilgi eklenir

    @Test
    public void test01() {
        /*
        EXTENTREPORT
            1-ExtentReport kullanabilmek için öncelikle mvn repository adresinden extentReport araması yapıp
            com.aventstack » extentreports seçip, 4.0.9 uncu versiyonu alıp pom.xml dosyamıza koymalıyız.
            2-ExtentReport class'ından raporlamayı başlatması için bir obje oluşturmamız gerekir.
            3-ExtentHtmlReporter class'ından raporları html formatında oluşturması için bir obje oluşturmalıyız
            4-ExtentTest class'ından test adımlarına bilgi ekleyebilmemiz için bir obje oluştururuz
         */
        extentReport = new ExtentReports();
        String tarih = new SimpleDateFormat("_HH_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/extentReport/report"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReport.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler
        extentReport.setSystemInfo("Tester","Ilgen");
        extentReport.setSystemInfo("Browser","Chrome");
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");
        extentHtmlReporter.config().setReportName("Smoke Test");

        extentTest=extentReport.createTest("AmazonTest","Test Raporu");

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Kullanici Amazon Sayfasina Gider");

        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Kullanici Amazon Sayfasindaki Arama Kutusunun Locate'ini Alir");
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        extentTest.info("Kullanici arama kutusunda iphone aratir");

        //ekran resmini alalım
        ekranResmi();
        extentTest.info("Kullanici ekran resmini alir");

        //sonuc yazısı webelementinin resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        extentTest.info("Kullanici arama kutusunda iphone araması sonrasi çıkan sonuc yazısının locate'ini alır");
        webElementResmi(sonucYazisi);
        extentTest.pass("Kullanici sonuc yazisinin resmini alır");
        extentReport.flush();



    }

    @Test
    public void test02() {
        extentReport=new ExtentReports();
        String tarih=new SimpleDateFormat("_HH_mm_ss_ddMMyyy").format(new Date());
        String dosyaYolu="target/extentReport/report1"+tarih+".html";
        ExtentHtmlReporter extentHtmlReporter=new ExtentHtmlReporter(dosyaYolu);
        extentReport.attachReporter(extentHtmlReporter);

        //Raporda gözükmesini istediğimiz bilgiler
        extentReport.setSystemInfo("Tester","Ilgen");
        extentReport.setSystemInfo("Browser","Chrome");
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");
        extentHtmlReporter.config().setReportName("Smoke Test");

        extentTest=extentReport.createTest("Amazon Test","Test Raporu");

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Kullanıcı amazon sayfasına gider");

        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Kullanıcı amazon sayfasında arama kutusunun locate ni alır");
        aramaKutusu.sendKeys("iphone",Keys.ENTER);
        extentTest.info("Kullanıcı arama kutusunda iphone aratır");

        //ekran resmini alalım
        ekranResmi();
        extentTest.info("Kullanıcı ekran resmini alır");

        //sonuc yazısı webelementinin resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        extentTest.info("Kullanıcı arama sonucunda çıkan sonuc yazısı webelementinin locat e ini alir");
        webElementResmi(sonucYazisi);
        extentTest.info("Kullanıcı sonuc yazısının resmini alır");
        extentReport.flush();
    }

    @Test
    public void test03() {
       extentReport=new ExtentReports();
       String tarih=new SimpleDateFormat("_HH_mm_ss_ddMMyyy").format(new Date());
       String dosyaYolu="target/extentReport/report"+tarih+".html";
       extentHtmlReporter=new ExtentHtmlReporter(dosyaYolu);
       extentReport.attachReporter(extentHtmlReporter);

       extentReport.setSystemInfo("Tester","Ilgen");
       extentReport.setSystemInfo("Browser","Chorome");

       extentHtmlReporter.config().setDocumentTitle("Test Report");
       extentHtmlReporter.config().setReportName("Smoke Test");

       extentTest=extentReport.createTest("Amazon Test","Test Raporu");

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Kullanıcı amazon sayfasına gider");

        //Arama kutusunda iphone aratalim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Kullanıcı amazon sayfası arama kutusuna iphne yazar");
        aramaKutusu.sendKeys("iphone",Keys.ENTER);
        extentTest.info("Kullanıcı arama kutusunda iphone aratır ");
        extentReport.flush();
    }

    @Test
    public void test04() {
        rapor("Chorome","Amazon Test");
        extentTest=extentReport.createTest("Extent Report","Test Raporu");

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Kullanıcı amazon sayfasına gider");

        //arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Arama Kutusu Locate Edildi");
        aramaKutusu.sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda Iphone aratildi");
        extentReport.flush();
    }
}
