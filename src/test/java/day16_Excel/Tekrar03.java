package day16_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tekrar03 {
    @Test
    public void test01() throws IOException {
        //3)Adimlari takip ederek 1.satira kadar gidelim
        //4)5.hucreye yeni bir cell olusturalim
        //5)Olusturdugumuz hucreye “Nufus” yazdiralim
        //6)2.satir nufus kolonuna 1500000 yazdiralim
        //7)10.satir nufus kolonuna 250000 yazdiralim
        //8)15.satir nufus kolonuna 54000 yazdiralim 9)Dosyayi kaydedelim
        //10)Dosyayi kapatalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis =new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1500000");
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250000");
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54000");
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        fos.close();workbook.close();
    }
}
