package Unidad3.pages;

import Unidad3.glue.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarroPage extends BaseClass {
    By chkTerminos  = By.id("termsofservice");
    By chkTerminosX = By.xpath("//input[@id='termsofservice']");
    By btnCheckout  = By.id("checkout");
    By btnCheckoutX = By.xpath("//button[@id='checkout']");

    public CarroPage(){ super(); }

    public void aceptarTerminos(){
        WebElement cb;
        try { cb = esperarWebElement(chkTerminos); }
        catch (Exception e){ cb = esperarWebElement(chkTerminosX); }
        if (!cb.isSelected()) cb.click();
    }

    public void irACheckout(){
        try { click(btnCheckout); }
        catch (Exception e){ click(btnCheckoutX); }
    }
}