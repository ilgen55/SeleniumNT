package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class LMS02 extends TestBase {
    @Test
    public void test01() {
        // -Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement dropDownMenü= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenü);
        List<WebElement> dropDownMenuList=select.getOptions();
        for (WebElement w : dropDownMenuList) {
            System.out.println(w.getText());
        }
         //   dropDownMenuList.forEach(t-> System.out.println(t.getText()));
            //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
            //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        System.out.println("************************************");

        int sayac=1;
        for (WebElement w: dropDownMenuList  ) {
            dropDownMenü= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
           Select select1=new Select(dropDownMenü);
           select1.selectByIndex(sayac);
           driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
           bekle(2);
           driver.navigate().back();
           bekle(2);

            sayac++;
            if(sayac>6){
                break;
            }
        }

        }









    @Test
    public void test02() {
        // -Amazon sayfasına gidelim
        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

        }
    }


