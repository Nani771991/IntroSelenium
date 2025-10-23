package Unidad2.pages;

import Unidad2.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultadosBusquedaPage extends BaseClass {
    By ddlOrden      = By.id("products-orderby");
    By ddlOrdenXPath = By.xpath("//select[@id='products-orderby']");

    public ResultadosBusquedaPage(WebDriver driver) { super(driver); }

    public void ordenarPor(String textoVisible){
        try { seleccionarDDLPorTextoVisible(ddlOrden, textoVisible); }
        catch (Exception e){ seleccionarDDLPorTextoVisible(ddlOrdenXPath, textoVisible); }
    }
}
