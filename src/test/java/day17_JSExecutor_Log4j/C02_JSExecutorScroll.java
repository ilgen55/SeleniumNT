package day17_JSExecutor_Log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecutorScroll extends TestBase {
    @Test
    public void test01() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

//Back to school webelementine kadar scroll yapalım
        WebElement backtoschoolWE = driver.findElement(By.xpath("//*[text()='Back to school']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",backtoschoolWE);
        bekle(2);

//Sayfanın en altına scroll yapalım
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bekle(2);
        /*
    Yukarıdaki method js executor ile sayfanın en altına scroll yapar. Spesifik olarak bir webelemente
scroll yapmadığımız için sayfayı scroll yaptığımız için script kodu window ile başlar scrollTo
methodu ile x ve y kordinatı belirtmemiz gerekir. x'e 0 y'ye bir değer verirsek verdiğimiz değer
kadar aşağıya doğru scroll yapar. Ama sayfanın en altına scroll yapmasını istersek y değeri yerine
'document.body.scrollHeight' script kodunu kullanırız.
 */

//Sayfanın en üstüne scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    @Test
    public void test02() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Back to school webelementine kadar scroll yapalım
        WebElement backtoschoolWE = driver.findElement(By.xpath("//*[text()='Back to school']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",backtoschoolWE);
        bekle(2);

        //Sayfanın en altına scroll yapalım
        jsScrollEnd();
        bekle(2);

        //Sayfanın en üstüne scroll yapalım
        jsScrollHome();
    }

    @Test
    public void test03() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");


     //Back To School Webelementine kadar scroll yapalım
        WebElement backToSchool= driver.findElement(By.xpath("//*[text()='Back to school']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",backToSchool);
    }

    @Test
    public void test04() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");


        //Back To School Webelementine kadar scroll yapalım
        WebElement backToSchool= driver.findElement(By.xpath("//*[text()='Back to school']"));
        jsscrool(backToSchool);
    }

    @Test
    public void test05() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        // sayfanın em altına ve en üstüne scrool yapalım
        jsScrollEnd();
        bekle(2);
        jsScrollHome();



    }
}
