package Unidad2.pages;

import Unidad2.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {
    //Centralizar las estrategias de busqueda (By)
    By locatorRegister = By.linkText("Register");
    By txtBuscar = By.id("small-searchterms");
    By txtBuscarXPath = By.xpath("//input[@id='small-searchterms']");
    By btnBuscar = By.xpath("//input[contains(@class,'search-box-button')]");
    By linkCarro = By.cssSelector("a.ico-cart");               // icono carro
    By linkCarroXPath = By.xpath("//a[contains(@class,'ico-cart')]");// respaldo


    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Acciones
    public void irARegister(){
        click(locatorRegister);
    }
    // Acciones nuevas (header dentro del HomePage)
    public void buscar(String termino){
        try { agregarTexto(txtBuscar, termino); }
        catch (Exception e) { agregarTexto(txtBuscarXPath, termino); }
        click(btnBuscar);
    }

    public void irAlCarro(){
        try { click(linkCarro); }
        catch (Exception e) { click(linkCarroXPath); }
    }
}
