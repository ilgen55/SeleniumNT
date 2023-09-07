package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        String dosyaYolu="src/test/java/resources/Capitals.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));
        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        System.out.println(workbook.getSheet("Sheet1").getRow(2).getCell(0));
       // String str3Stn1= String.valueOf(workbook.getSheet("Sheet1").getRow(2).getCell(0));
        String str3Stn1= (workbook.getSheet("Sheet1").getRow(2).getCell(0)).toString();
        /*
    Cell değişkenini String ile casting yaparsak belittiğimiz satır ve sütunda boş bir veri varsa null değer
    döndürür. Ama Cell değişkeninde toString() methodu kullanırsak boş bir veri varsa nullpointerException fırlatır.
    */
        //toString ve casting arasindaki fark;
        // .toString() eger hucrede bir deger olmazsa nullpointerExeption firlatir. casting yapilirsa "Null" deger dondurur.
        // Bu da bizim hatayi nerede aldigimizi bulmamizi kolaylastirir
        Assert.assertEquals("France",str3Stn1);
        // Kullanılan satır sayısın bulun
        System.out.println("Kullanılan satır " +workbook.getSheet("Sheet1").getPhysicalNumberOfRows());

        //Sayfadaki satır sayısını yazdırınız
        System.out.println("Satır Sayısı "+workbook.getSheet("Sheet1").getLastRowNum());
        //getPhysicalNumberOfRows() --> methodu dolu olan hucreleri sayarak satir sayisini verir.Index 1 den baslar.
        //getLastRowNum()-->methodu en son kullanilan hucreye kadar  dolu bos butun satirlari sayar.Index 0 den baslar.
        //Ülke-Başkent şeklinde verileri yazdırın
    }

    @Test
    public void test02() throws IOException {
        // 1. satır 1. sutundakı veriyi yazdır
        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook=WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));
    }

    @Test
    public void test03() throws IOException {
       // Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook=WorkbookFactory.create(fis);
        System.out.println("satır1sütun2 "+workbook.getSheet("Sheet1").getRow(0).getCell(1));
        //3.Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        System.out.println(workbook.getSheet("Sheet1").getRow(2).getCell(0));
        //String satır3Sutun1= String.valueOf(workbook.getSheet("Sheet1").getRow(0).getCell(1));
        String satır3Sutun1= (workbook.getSheet("Sheet1").getRow(2).getCell(0)).toString();
        Assert.assertEquals("France",satır3Sutun1);

        //Kullanılan satır sayısın bulun
        System.out.println("Kullanılan satır sayısı :"+workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        /*
     getPhysicalNumberOfRows() methodu içi dolu olan satirlarin sayısını verir. Index 1 den başlar
      */
        //Sayfadaki satır sayısını yazdırınız
        System.out.println("Sayfadaki satr sayısı :"+workbook.getSheet("Sheet1").getLastRowNum());
        /*
      getLastRowNum() methodu sayfadaki dolu boş farketmeksizin en son kullanılan satıra kadar olan satırların sayısını verir
     */
        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");

            }
            System.out.println();

        }
    }

    @Test
    public void test04() throws IOException {
        // Ülke-Başkent şeklinde verileri yazdırın (map ile)
        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook=WorkbookFactory.create(fis);

        Map<String,String> ulkeBaskent=new LinkedHashMap<>();
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            String ulke=workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String sehir=workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,sehir +"\n");

        }
        System.out.println(ulkeBaskent);

    }
}
