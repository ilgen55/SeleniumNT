package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Locators extends TestBase {
    @Test
    public void locatersTesti() {
        // Kitap Yurdu sitesine gidilir
        driver.get("https://www.kitapyurdu.com/");

        // "En Çok Satılanlar" bölümündeki ilk ürün seçilir
        List<WebElement> enCoksatilanlarListesi = driver.findElements(By.className("pr-details"));
        String ilkKitapAdi = enCoksatilanlarListesi.get(0).getText().split("\n")[0];
        enCoksatilanlarListesi.get(0).click();

        // Seçilen ürüne ait sayfanın açıldığını doğrulayınız.
        WebElement kitapAdi = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(ilkKitapAdi, kitapAdi.getText());

        // "Devamını Oku…" butonuna basınız.
        WebElement devamLinki = driver.findElement(By.partialLinkText("Devam"));
        devamLinki.click();

        // Ürünü sepete ekleyiniz.
        WebElement sepeteEkleButonu = driver.findElement(By.id("button-cart"));
        sepeteEkleButonu.click();

        // Sepete gidiniz.
        WebElement sepeteGitButonu = driver.findElement(By.linkText("sepetinize"));
        sepeteGitButonu.click();

        // Ürüne ait kontrol kutusunu işaretleyiniz.
        WebElement kontrolKutusu = driver.findElement(By.name("cart_selection[]"));
        Assert.assertFalse(kontrolKutusu.isSelected());


        if(!kontrolKutusu.isSelected()){
            jsclick(kontrolKutusu);
        }

        // Ürün miktarını değiştiriniz.
        WebElement urunMiktari = driver.findElement(By.name("quantity"));
        urunMiktari.clear();
        urunMiktari.sendKeys("3");
        Assert.assertEquals("3", urunMiktari.getAttribute("value"));

    }
}
