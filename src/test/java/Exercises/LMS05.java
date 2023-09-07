package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class LMS05 extends TestBase {
    @Test
    public void test01() {
        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement yazıTahtası= driver.findElement(By.xpath("//canvas"));
        Actions actions=new Actions(driver).clickAndHold(yazıTahtası);

        for (int i = 0; i <10 ; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i <10 ; i++) {
            actions.moveByOffset(-5,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,0);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,0);
        }
        actions.release().build().perform();
        bekle(5);
        //- Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//*[@class='button clear']")).click();
        //- Sayfayi kapatiniz

    }
}
