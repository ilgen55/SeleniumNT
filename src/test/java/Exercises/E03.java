package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class E03 extends TestBase {
    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        // 2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        // 3. Ana sayfanın başarıyla göründüğünü doğrulayın
       WebElement anaSayfa= driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
       Assert.assertTrue(anaSayfa.isDisplayed());

        //4. Add products to cart
        // 4. Ürünleri sepete ekleyin
        WebElement sepet= driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]"));
        sepet.click();
        bekle(2);
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

           WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title text-center']")));
            Actions action=new Actions(driver);
            action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN);
            bekle(2);






     //  WebElement product4= driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[4]"));
     //  WebElement product5= driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[5]"));

     //  product4.click();
     //  driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
     //  bekle(2);
     //  product5.click();
     //  driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();



        //5. Click 'Cart' button
        //5. 'Sepet' düğmesine tıklayın

        //6. Verify that cart page is displayed
        // 6. Sepet sayfasının görüntülendiğini doğrulayın

        //7. Click Proceed To Checkout
        // 7. Ödeme İşlemine Devam Et'e tıklayın

        //8. Click 'Register / Login' button
        // 8. 'Kayıt Ol / Giriş Yap' butonuna tıklayın

        //9. Fill all details in Signup and create account
        // 9. Kayıt ol kısmındaki tüm detayları doldurun ve hesap oluşturun

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        // 10. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın ve 'Devam' düğmesini tıklayın

        //11. Verify ' Logged in as username' at top
        // 11. Üstteki 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın

        //12.Click 'Cart' button
        // 12.'Sepet' butonuna tıklayın

        //13. Click 'Proceed To Checkout' button
        // 13. 'Ödeme İşlemine Devam Et' düğmesine tıklayın


        //14. Verify Address Details and Review Your Order
        // 14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin

        //15. Enter description in comment text area and click 'Place Order'
        // 15. Yorum metni alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        // 16. Ödeme ayrıntılarını girin: Karttaki İsim, Kart Numarası, CVC, Son Kullanma Tarihi

        //17. Click 'Pay and Confirm Order' button
        // 17. 'Öde ve Siparişi Onayla' düğmesine tıklayın

        //18. Verify success message 'Your order has been placed successfully!'
        // 18. 'Siparişiniz başarıyla verildi!' başarı mesajını doğrulayın.

        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        // 19. 'Faturayı İndir' düğmesine tıklayın ve faturanın başarıyla indirildiğini doğrulayın.

        //20. Click 'Continue' button
        // 20. 'Devam' düğmesine tıklayın

        //21. Click 'Delete Account' button
        // 21. 'Hesabı Sil' düğmesine tıklayın

        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        // 22. 'HESAP SİLİNDİ!' seçeneğini doğrulayın ve 'Devam' düğmesini tıklayın
    }
}
