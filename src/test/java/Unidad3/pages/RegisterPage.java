package Unidad3.pages;

import Unidad3.glue.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BaseClass {
    //Centralizar las estrategias de busqueda (By)
    By locatorGeneros = By.xpath("//input[@type='radio']");
    By locatorName = By.id("FirstName");
    By locatorLastName = By.name("LastName");
    By locatorEmail = By.xpath("//input[@data-val-required='Email is required.']");

    By locatorPassword = By.xpath("//input[@id='Password']");
    By locatorConfirmPassword = By.name("ConfirmPassword");
    By locatorBtnRegister = By.id("register-button");
    By locatorSussesfullMessage = By.xpath("//div[@class='result' and normalize-space(text())='Your registration completed']");
    By locatorErrorMessage = By.xpath("//li[text()='The specified email already exists']");


    public RegisterPage() {
        super();
    }

    public void crearCuenta(int genero, String nombre, String apellido, String mail, String pass, String confirmPass){
        esperarWebElements(locatorGeneros).get(genero); //0=1ero male 1=2do (Female)
        agregarTexto(locatorName,nombre);
        agregarTexto(locatorLastName,apellido);
        agregarTexto(locatorEmail,mail);
        agregarTexto(locatorPassword,pass);
        agregarTexto(locatorConfirmPassword,confirmPass);
        click(locatorBtnRegister);
    }

    public String obtenerMensajeCtaOK(){
        return obtenerTexto(locatorSussesfullMessage);
    }

    public String getErrorMensajeCta_MailUsed(){
        return obtenerTexto(locatorErrorMessage);
    }
}
