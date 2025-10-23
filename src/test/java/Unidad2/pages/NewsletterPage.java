package Unidad2.pages;

import Unidad2.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsletterPage extends BaseClass {
    By txtEmail = By.id("newsletter-email"); // (en esa web también acepta NewsletterEmail por name)
    By txtEmailXPath = By.xpath("//input[@id='newsletter-email' or @name='NewsletterEmail']");
    By btnSuscribir = By.id("newsletter-subscribe-button");
    By btnSuscribirXp = By.xpath("//input[@id='newsletter-subscribe-button']");
    By lblResultado = By.id("newsletter-result-block");
    By lblResultadoXp = By.xpath("//div[@id='newsletter-result-block']");

    public NewsletterPage(WebDriver driver){ super(driver); }

    public void suscribirse(String email){
        try { agregarTexto(txtEmail, email); }
        catch (Exception e){ agregarTexto(txtEmailXPath, email); }
        try { click(btnSuscribir); }
        catch (Exception e){ click(btnSuscribirXp); }
    }

    public String obtenerMensaje(){
        try { return obtenerTexto(lblResultado); }
        catch (Exception e){ return obtenerTexto(lblResultadoXp); }
    }
}
