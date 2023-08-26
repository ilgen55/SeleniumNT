package day15_ExtentReport_Webtable_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtendReport extends TestBase {
    @Test
    public void test01() {
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
