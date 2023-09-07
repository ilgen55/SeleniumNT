package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class LMS04 extends TestBase {
    @Test
    public void test01() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        //driver.switchTo().alert();
        driver.switchTo().frame(0);
    //  driver.findElement(By.xpath("//*[@d='M3.25,3.25l8.5,8.5M11.75,3.25l-8.5,8.5']")).click();
    // Actions actions=new Actions(driver);
    //  actions.sendKeys(Keys.PAGE_DOWN);
       //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//div)[23]")).click();


       //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
       //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
       //New Tab butonunun görünür olduğunu doğrula
       //New Tab butonuna click yap
       //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
       //İlk Tab'a geri dön
       //New Tab butonunun görünür olduğunu doğrula
    }
}
