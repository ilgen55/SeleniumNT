package day15_ExtentReport_Webtable_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_Excel {
    @Test
    public void test01() throws IOException {
        /*
    Eğer projemizde excel dosyasından veri almak istiyorsak öncelikle mvnrepository.com adresinden arama çubuğuna
poi yazarak apache poi ve poi_ooxml dependency'lerini pom.xml dosyamıza kopyalamamız gerekir. Her iki dependeny
nin de versiyonları aynı olmalı.
 */
//1- Projemize resources package'ı altına koyduğumuz excel dosyamızın yolunu alırız

        String dosyaYolu="src/test/java/resources/Capitals.xlsx";
        //2 dosyayı okuyabilmemiz icin javada akişa almamız gerekir
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //3 java ortamında bir excel dosyasi olusturabilmek için workbook objesi olustururuz
        Workbook workbook= WorkbookFactory.create(fis);

        // 4 olusturduğumuz excel de sayfa seçmemiz gerekir
        Sheet sheet=workbook.getSheet("Sheet1");

        // 5  belirttiğimizsayfasındaki satır bilgisini seçmemiz gerekir
        Row row=sheet.getRow(0);//==> index 0 dan başlar

        // 6 belirttiğimiz satirdaki hucre bilgisini secmemiz gerekir
        Cell cell=row.getCell(0);

        // souticinde cell bilgisini yazdirdiğimizda 1. satır 1. hucre bilgisini verir
        System.out.println(cell);

        /*
     Excel acikken calistirirsak hata alabiliriz
     Excel icinde degisiklik yaparsek cikarken kaydetme dememiz
    gerekir yoksa dosya hata verebilir.
   */

    }

    @Test
    public void test02() throws IOException {
        //1- Projemize resources package'ı altına koyduğumuz excel dosyamızın yolunu alırız
        String dosyaYolu="src/test/java/resources/Capitals.xlsx";

        //2 dosyayı okuyabilmemiz icin javada akişa almamız gerekir
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //3 java ortamında bir excel dosyasi olusturabilmek için workbook objesi olustururuz
        Workbook workbook=WorkbookFactory.create(fis);

        // 4 olusturduğumuz excel de sayfa seçmemiz gerekir
        Sheet sheet=workbook.getSheet("Sheet1");

        // 5  belirttiğimizsayfasındaki satır bilgisini seçmemiz gerekir
        Row row=sheet.getRow(0);

        // 6 belirttiğimiz satirdaki hucre bilgisini secmemiz gerekir
        Cell cell=row.getCell(0);

        // souticinde cell bilgisini yazdirdiğimizda 1. satır 1. hucre bilgisini verir
        System.out.println(cell);

    }

    @Test
    public void test03() throws IOException {
        // pratik çözüm
        // 1. satır ve 1. sutun bilgisini yazdıralım
        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook=WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));
    }
}
