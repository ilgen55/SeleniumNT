package day17_JSExecutor_Log4j;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecutorLocate extends TestBase {
    @Test
    public void test01() {

        //https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
       //Hello Shadow DOM elementini locate edelim
        /*
js executor ile bir webelementin locate'ini yukarıdaki örnekteki gibi "document.getElementById('content');"
sayfadan alırız. Bu locate'in çalışması için script kodunun önüne return yazmamız gerekir.
 */
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement helloShadowDone= (WebElement) js.executeScript("return document.getElementById(\"content\");");
        System.out.println(helloShadowDone.getText());
        Assert.assertEquals("Hello Shadow DOM",helloShadowDone.getText());

    }

    @Test
    public void test02() {
        //https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");

        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement helloShadowDone= (WebElement) js.executeScript("return document.getElementById(\"content\");");
        WebElement shadow=driver.findElement(By.xpath("(//h1)[2]"));
        js.executeScript("arguments[0].style.color='red';arguments[1].style.color='blue';",shadow,helloShadowDone);
    }

    @Test
    public void test03() {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //aramakutusunun atribüte değerlerini yazdıralım
        JavascriptExecutor js= (JavascriptExecutor) driver;
        String typeAttributeDegeri = js.executeScript("return document.getElementById('twotabsearchtextbox').type").toString();
        String nameAttributeDegeri = js.executeScript("return document.getElementById('twotabsearchtextbox').name").toString();
        String classAttributeDegeri = js.executeScript("return document.getElementById('twotabsearchtextbox').className").toString();
        System.out.println(typeAttributeDegeri);
        System.out.println(nameAttributeDegeri);
        System.out.println(classAttributeDegeri);

    }
}
