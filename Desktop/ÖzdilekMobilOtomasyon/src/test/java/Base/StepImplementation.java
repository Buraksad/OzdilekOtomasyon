package Base;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.awt.*;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static Constants.Constants.*;

/**
 * @author  Burak Sami ŞAD
 * @version 1.0
 * @since   2021-10-29
 */


public class StepImplementation extends BasePage{

    @Step("Uygulamanin acildigi kontrol edilir.")
    public void checkAnaSayfa () {
        check(CHECKANASAYFA, "Mağazadan Alışveriş");
    }

    @Step("Alisverise basla butonuna tiklanir")
    public void cliclAlisveris () throws InterruptedException {
        clickById(BASLA_BUTTON);
        waitForSecond(1);
    }

    @Step("Alisveris sayfasinin acildigi dogrulanir.")
    public void checkAlisveris () {
        checkXpath(CHECKALISVERIS, "Mağaza");
    }

    @Step("Katagoriler Sayfasi Acilir")
    public void clickKatagoriler () {
        clickById(KATEGORİ_BUTTON);
    }

    @Step("Katagoriler Sayfasinin acildigi dogrulanir")
    public void checkKatagoriler() {
        check(CHECK_KATEGORI, "Kategoriler");
    }

    @Step("Menuden 'Kadın' Secenegine tiklanir")
    public void clickKadin () {
        clickByXpath(KADIN_BUTTON);
    }

    @Step("'pantolon' kategorisi acilir")
    public void clickPantolon () throws InterruptedException {
        clickByXpath(PANTOLON_BUTTON);
        waitForSecond(2);
        
    }
    
    @Step(" Sayfa Scroll Edilir")
    public void ScrollDown() throws InterruptedException {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touch = new TouchAction(appiumDriver);
        touch.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();

        waitForSecond(3);

    }

    @Step("<Key> xpath'te bulunan sayfada görünen tüm ürünleri bul ve rastgele bir ürüne tıkla")
    public void findAllProducts(String Key){
        List<MobileElement> productList = appiumDriver.findElementsByXPath(Key);
        int size = productList.size();
        Random rnd = new Random();
        int randNum = rnd.nextInt(size);
        productList.get(randNum).click();

    }

    @Step(" Secilen ürün favorilere eklenir ")
    public void clickFavori() throws InterruptedException {
        clickById(FAVORI_EKLE);
        waitForSecond(1);


    }



    @Step("Giris yapma sayfasinin acildigi kontrol edilir.")
    public void checkGirisYap() {
        check(CHECKGIRISYAP, "Giriş Yap");
    }

    @Step("Kullanici adi girilir.")
    public void kullaniciAdiGir() {
        clickById(KULLANICI_ADI);
        sendKeys(KULLANICI_ADI,KULLANICI);
    }

    @Step("Sifre girilir")
    public void sifreGir() throws InterruptedException {
        clickById(PASSWORD);
        sendKeys(PASSWORD,SIFRE);
        clickById(GIRIS_YAP);
        waitForSecond(3);


    }

    @Step("geri butonuna 2 kez tiklanir ")
    public void clickGeri() throws InterruptedException {
        clickById(GERI_BUTTON);
        waitForSecond(2);
        clickById(GERI_BUTTON);

    }

    @Step("Secilen ürün sepete eklenir ")
    public void clickSepeteEkle(){
        clickById(SEPETE_EKLE);
    }



    @Step("Sepetim butonuna tiklanir")
    public void clickSepetim() {
        clickById(SEPETIM);
    }
}
