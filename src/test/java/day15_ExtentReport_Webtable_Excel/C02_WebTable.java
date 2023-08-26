package day15_ExtentReport_Webtable_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTable extends TestBase {
    @Test
    public void test01() {
        /*
     Eğer bir sayfada içinde dataların bulunduğu bir tablo ile karşılaşırsak;
       1-<table> tag'ı ile başlıyorsa bu tag bize tüm tabloyu verir. xpath ile //table yazarak
       sayfada kaç tane tablo olduğunu tespit eder birden fazla tablo varsa (//table)[index] ile
       istediğimiz tabloyu bu şekilde locate edip getText() methodu ile yazdırabiliriz.
       2-<thead> table tag'ından sonra bu tag var ise, tablodaki başlıkları thead tag'ı ile alabiliriz
       <thead> tag'îndan sonra <tr>(table row) tag'ı başlıktaki satır'ı, <th> tag'i ise başlıktaki
       her bir hücreyi temsil eder.
       3-<tbody> thead tag'ından sonra tbody tag'ı ile tablodaki başlık altındaki verileri alabiliriz.
       tbody tag'ından sonra <tr> tag'i body içindeki satırları, <td> tag'ı ise body içindeki hücreleri
       temsil eder.

    */
        //https://the-internet.herokuapp.com/tables sayfasına gidelim
        driver.get("https://the-internet.herokuapp.com/tables");
        //Task 1 : Table1’i print edin
        WebElement tablo1= driver.findElement(By.xpath("(//table)[1]"));
        System.out.println(tablo1.getText());
        //Task 2 : 3. Row' datalarını print edin
        WebElement ucuncuSatir= driver.findElement(By.xpath("(//table)[1]//tbody//tr[3]"));
        System.out.println("ucuncusatır verileri : "+ucuncuSatir.getText());
        System.out.println("**********************************************");
        // Task 3 : Son row daki dataları print edin
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
        /*
     Xpath kullaniminda eger bir webtable'da son satir bilgisi istenirse yukaridaki ornekteki gibi
    satir icindeki index yerine last() function'i kullanabilirsiniz.
    */
        System.out.println("son satir datalari : "+sonSatir.getText());

        System.out.println("**********************************************");
        //Task 4 : 5. Column datalarini print edin
        WebElement besinciBaslik= driver.findElement(By.xpath("(//thead)[1]//tr//th[5]"));
        System.out.println("besinci sutun basliği :"+besinciBaslik.getText());
       List<WebElement> besinciSutunDatalari= driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
       besinciSutunDatalari.forEach(t-> System.out.println(t.getText()));
        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
        // Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin

        printData(2,3);
    }

    private void printData(int satir, int sutun) {
        System.out.println("**************************************");
        WebElement satirSutun= driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());

        /*
ÖDEV:
    3. Satırdaki 1. ve 2. sütun bilgilerini yazdırınız. //-->position()>=1 and position()<=2
 */
    }
}
