package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class LMS01 extends TestBase {
    @Test
    public void test01() {
        //- ebay sayfasına gidiniz
        driver.get("https://ebay.com");
        //- electronics bölümüne tıklayınız
        WebElement electronics= driver.findElement(By.xpath("(//*[@href='https://www.ebay.com/b/Electronics/bn_7000259124'])[2]"));
        electronics.click();
        WebElement x= driver.findElement(By.xpath("//*[@id='s0-28_1-9-0-1[0]-0-2-0-title']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(x));

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        //- Her sayfanın sayfa başlığını yazdıralım

         List<WebElement> pencereler= driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
      for (int i = 0; i <2 ; i++) {
         pencereler= driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
         pencereler.get(i).click();
          bekle(2);
         System.out.println(i+1 +".başlık " +driver.getTitle());
         bekle(2);
         driver.navigate().back();
     }
    }












    @Test
    public void test02() {
        //- ebay sayfasına gidiniz
        driver.get("https://ebay.com");
        //- electronics bölümüne tıklayınız
        WebElement electronics= driver.findElement(By.xpath("(//*[@href='https://www.ebay.com/b/Electronics/bn_7000259124'])[2]"));
        electronics.click();
        WebElement text= driver.findElement(By.xpath("//*[@id='s0-28_1-9-0-1[0]-0-2-0-title']"));
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(text));

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        //- Her sayfanın sayfa başlığını yazdıralım
       List<WebElement> resimler= driver.findElements(By.xpath("//*[@width='225' and @ height='225']"));
        for (int i = 0; i < resimler.size() ; i++) {
            resimler.get(i).click();
            System.out.println(driver.getTitle());
            bekle(2);
            driver.navigate().back();
            bekle(2);
        }


    }
}
