package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel extends TestBase {
    @Test
    public void test01() throws IOException {
        //BlueRentalCar sayfasına gidelim
        // src/test/java/resources/mysmoketestdata.xlsx
        driver.get("https://www.bluerentalcars.com/");
        bekle(2);
        //Login butonuna basalım
        driver.findElement(By.xpath("(//*[@role='button'])[1]")).click();

        //Excel dosyasından aldığımız herhangi bir kullanıcı adı ve password ile login olalim
        FileInputStream fis=new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook= WorkbookFactory.create(fis);
        String userEmail=workbook.getSheet("customer_info").getRow(1).getCell(0).toString();
        String password= workbook.getSheet("customer_info").getRow(1).getCell(1).toString();
        WebElement email= driver.findElement(By.xpath("//*[@id='formBasicEmail']"));
        email.sendKeys(userEmail, Keys.TAB,password,Keys.ENTER);

        //Login olduğumuzu doğrulayalım
        driver.findElement(By.xpath("//*[@id='dropdown-basic-button']")).click();
        bekle(2);
        driver.findElement(By.xpath("(//*[@class='dropdown-item'])[2]")).click();
        String emailText=driver.findElement(By.xpath("//em")).getText();
        Assert.assertEquals(userEmail,emailText);
    }
}
