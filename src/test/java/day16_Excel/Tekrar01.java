package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tekrar01  {
    @Test
    public void test01() throws IOException {
           /*
    Bir "NÜFUS" sütunu oluşturup başkent nüfuslarını excel doyasına yazınız:
    (D.C: 712816, Paris: 2161000, London: 8982000, Ankara: 5663000 ...)
     */
        String dosyaYolu="src/test/java/resources/Capitals.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        workbook.getSheet("Sheet1").getRow(0).createCell(3).setCellValue("AKARSULAR");
        workbook.getSheet("Sheet1").getRow(1).createCell(3).setCellValue("KIZILIRMAK");
        workbook.getSheet("Sheet1").getRow(2).createCell(3).setCellValue("ASİ");
        workbook.getSheet("Sheet1").getRow(3).createCell(3).setCellValue("SEYHAN");
        workbook.getSheet("Sheet1").getRow(4).createCell(3).setCellValue("CEYHAN");
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }

    @Test
    public void test02() throws IOException {
        String dosyaYolu="src/test/java/resources/Capitals.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook=WorkbookFactory.create(fis);
        List<String> eklenecekVeriler=new ArrayList<>(Arrays.asList("BÖLGELER","DOĞU","BATI","KUZEY","GÜNEY"));
        for (int i = 0; i <eklenecekVeriler.size() ; i++) {
           workbook.getSheet("Sheet1").getRow(i).getCell(3).setCellValue(eklenecekVeriler.get(i));

            FileOutputStream fos=new FileOutputStream(dosyaYolu);
            workbook.write(fos);
            fos.close();
            workbook.close();
        }
        System.out.println(eklenecekVeriler);

    }
}
