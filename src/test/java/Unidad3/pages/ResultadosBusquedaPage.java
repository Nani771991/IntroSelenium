package Unidad3.pages;

import Unidad3.glue.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultadosBusquedaPage extends BaseClass {
    By ddlOrden      = By.id("products-orderby");
    By ddlOrdenXPath = By.xpath("//select[@id='products-orderby']");

    public ResultadosBusquedaPage() { super(); }

    public void ordenarPor(String textoVisible){
        try { seleccionarDDLPorTextoVisible(ddlOrden, textoVisible); }
        catch (Exception e){ seleccionarDDLPorTextoVisible(ddlOrdenXPath, textoVisible); }
    }
}
