package Unidad2.pages;

import Unidad2.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificacionesPage extends BaseClass {
    By lblExito      = By.cssSelector("div.bar-notification.success p.content");
    By lblExitoXPath = By.xpath("//div[contains(@class,'bar-notification') and contains(@class,'success')]//p[@class='content']");

    public NotificacionesPage(WebDriver driver){ super(driver); }

    public String obtenerMensajeExito(){
        try { return obtenerTexto(lblExito); }
        catch (Exception e){ return obtenerTexto(lblExitoXPath); }
    }
}
