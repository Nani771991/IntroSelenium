package Unidad2.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseClass {
    // Atributos (browser)
    private WebDriver driver;

    //WebDriverWait (espera)
    private WebDriverWait espera;


    //Metodos (clics, ingresos de textos, obtención de textos, etc)


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement esperarWebElement(By locator){
        try {
            espera = new WebDriverWait(this.driver,10);
            //return driver.findElement(locator);
            return espera.until(ExpectedConditions.presenceOfElementLocated(locator));

            //obtener el elemento web a retornar

        }catch (Exception ex) {
            System.out.println("Ocurrio un error buscando el elemento web...");
            System.out.println(ex.getStackTrace());
            return null;
        }
    }

    //buscar Elemento web
    public List<WebElement> esperarWebElements(By locator){
        try {
            espera = new WebDriverWait(this.driver,20);
            //return driver.findElement(locator);
            return espera.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

            //obtener el elemento web a retornar

        }catch (Exception ex) {
            System.out.println("Ocurrio un error buscando el elemento web...");
            System.out.println(ex.getStackTrace());
            return null;
        }
    }


    //Click()
    public void click(By locator){
        esperarWebElement(locator).click();

    }

    //SendKeys()
    public void agregarTexto(By locator, String texto){
        esperarWebElement(locator).sendKeys(texto);
    }

    //getText()
    public String obtenerTexto(By locator){
        return esperarWebElement(locator).getText();
    }

    // Cerrar browser
    public void cerrarBrowser(){
        driver.close();
    }
    // Maximizar browser
    public void maximizarBrowser(){
        driver.manage().window().maximize();
    }

    // Cargar url
    public void cargarUrl(String url){
        driver.get(url);
    }
    // Manipular dropdown element
    public void seleccionarDDLPorTextoVisible(By locator, String textoVisible){
        Select ddl = new Select(esperarWebElement(locator));
        ddl.selectByVisibleText(textoVisible);
    }
}
