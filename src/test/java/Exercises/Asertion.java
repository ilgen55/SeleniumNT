package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Asertion extends TestBase {
    @Test
    public void asertionTesti() {
        //https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://www.kitapyurdu.com/");
        //Anasayfanın açıldığını doğrulayınız (Url, Title, Logo)
        String expectedUrl = "https://www.kitapyurdu.com/";
        String actulUrl = driver.getCurrentUrl();
        Assert.assertEquals(actulUrl, expectedUrl);

        String expectedTitle = "Kitapyurdu";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        WebElement logo = driver.findElement(By.cssSelector("[src*='wh:d8e078ec3']"));
        Assert.assertTrue(logo.isDisplayed());

        //Arama motorunda “java” kelimesini aratınız.
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='search-input']"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);

        //Ürün listesinin dolu olduğunu doğrulayınız.
        List<WebElement> urunListesi = driver.findElements(By.cssSelector("[class='name']"));
        Assert.assertNotNull(urunListesi);
        System.out.println(urunListesi.get(0).getText());
        //Arama sonuçlarının “java” kelimesini içerdiğini doğrulayınız.
        WebElement sonucBaslıgı = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(sonucBaslıgı.getText().contains("Java"));

        for (WebElement urun : urunListesi) {
            {
                Assert.assertTrue(urun.getText().contains("Java")
                        || urun.getText().contains("java")
                        || urun.getText().contains("JAVA"));
            }

        }
        //Arama sonuçlarının “javascript” kelimesini içermediğini doğrulayınız.
        Assert.assertFalse(sonucBaslıgı.getText().contains("javascript"));
        for (WebElement urun : urunListesi) {
            {
                Assert.assertFalse(urun.getText().contains("javascript")
                        || urun.getText().contains("java")
                        || urun.getText().contains("JAVASCRİPT"));
            }

        }
    }
}
