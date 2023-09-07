package day17_JSExecutor_Log4j;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecutorClick extends TestBase {
    @Test
    public void test01() {
        //  amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);
        //  sell linkine tılayalım
        driver.findElement(By.xpath("(//*[@class='nav-a  '])[5]")).click();
        /*
    ElementClickInterceptedException; sell webelementinin önünde bir pencere çıktığı için
    elemente click yapamadı
    */
            /*
            Js Executor kullanımında öncelikle JavascriptExecutor arayüzünden bir obje oluşturup, TakeScreenShot'taki
        gibi driver'a eşitleriz. Farklı arayüzler olduğu için casting yaparız. Oluşturduğumuz obje ile
        executeScript() methodunu kullanarak bu method içine script kodunu yazarız. Dolayısıyda webDriver ile
        click yapamadığımız webelementini aşağıdaki örnekteki gibi js executor ile click yapabildik.
         */

    }

    @Test
    public void test02() {
        //  amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);

        //  sell linkine tılayalım
        WebElement sellLinki= driver.findElement(By.xpath("(//*[@class='nav-a  '])[5]"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLinki);
    }

    @Test
    public void test03() {
        //  amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);

        //  sell linkine tılayalım
        WebElement sellLinki= driver.findElement(By.xpath("(//*[@class='nav-a  '])[5]"));
        jsclick(sellLinki);

    }

    @Test
    public void test04() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);
       //sayfadaki sell linkine tıklayalım
       WebElement sell= driver.findElement(By.xpath("(//*[@class='nav-a  '])[5]"));
       jsclick(sell);
    }
}
