package Unidad2.pages;

import Unidad2.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage extends BaseClass {
    private final By linkLogin = By.linkText("Log in");
    private final By linkLoginXp = By.xpath("//a[normalize-space()='Log in']");
    private final By linkLogout = By.linkText("Log out");
    private final By linkLogoutXp = By.xpath("//a[normalize-space()='Log out']");
    private final By txtEmail = By.id("Email");
    private final By txtEmailXp    = By.xpath("//input[@id='Email']");
    private final By txtPassword   = By.id("Password");
    private final By txtPasswordXp = By.xpath("//input[@id='Password']");
    private final By btnLogin      = By.cssSelector("input[value='Log in']");
    private final By btnLoginXp    = By.xpath("//input[@value='Log in']");

    public AuthPage(WebDriver driver){ super(driver); }

    public void irALogin(){
        try { click(linkLogin); }
        catch (Exception e){ click(linkLoginXp); }
    }

    public void iniciarSesion(String email, String pass){
        try { agregarTexto(txtEmail, email); }
        catch (Exception e){ agregarTexto(txtEmailXp, email); }
        try { agregarTexto(txtPassword, pass); }
        catch (Exception e){ agregarTexto(txtPasswordXp, pass); }
        try { click(btnLogin); }
        catch (Exception e){ click(btnLoginXp); }
    }

    public void cerrarSesion(){
        try { click(linkLogout); }
        catch (Exception e){ click(linkLogoutXp); }
    }
}