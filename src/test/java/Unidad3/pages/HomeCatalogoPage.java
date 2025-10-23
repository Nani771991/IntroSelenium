package Unidad3.pages;


import Unidad3.glue.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeCatalogoPage extends BaseClass {
    // Primer "Add to cart" visible en la grilla del Home
    By btnAgregarPrimerProducto =
            By.xpath("(//div[contains(@class,'product-grid')]//input[@value='Add to cart'])[1]");

    public HomeCatalogoPage(){ super(); }

    public void agregarPrimerProductoAlCarro(){
        click(btnAgregarPrimerProducto);
    }
}
