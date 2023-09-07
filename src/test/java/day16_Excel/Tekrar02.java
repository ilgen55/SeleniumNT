package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Tekrar02 {
    @Test
    public void test01() throws IOException {
        //-1.satirdaki 2.hucreye gidelim ve yazdiralim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());
        //-1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String str1stn2=workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(str1stn2);
        //-2.satir 4.cell’in afganistan’in baskenti oldugunu test  edelim
       String str2stn4= workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        System.out.println(str2stn4);
        Assert.assertEquals("Kabil",str2stn4);

        //-Satir sayisini bulalim
        workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();

        //-Fiziki olarak kullanilan satir sayisini bulun
        workbook.getSheet("Sayfa1").getLastRowNum();
        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        for (int i = 0; i < workbook.getSheet("Sayfa1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j <workbook.getSheet("Sayfa1").getRow(0).getPhysicalNumberOfCells()-2; j++) {
                System.out.print(workbook.getSheet("Sayfa1").getRow(i).getCell(j)+"\t");

            }
            System.out.println();


        }
    }

    @Test
    public void test03() throws IOException {
        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook=WorkbookFactory.create(fis);

        Map<String,String> countryAndCity=new LinkedHashMap<>();
        for (int i = 0; i < workbook.getSheet("Sayfa1").getPhysicalNumberOfRows(); i++) {
            String country=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String city= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            countryAndCity.put(country,city+"\n");

        }
        System.out.println(countryAndCity);
    }
}
