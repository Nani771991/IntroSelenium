package Unidad3.glue;

import Unidad3.glue.utils.BaseClass;
import Unidad3.pages.AuthPage;
import Unidad3.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    HomePage homePage;
    AuthPage authPage;

    @Given("el usuario se encuentra en el home")
    public void el_usuario_se_encuentra_en_el_home() {

        homePage = new HomePage();
        homePage.cargarUrl("https://demowebshop.tricentis.com/");
    }

    @Then("se visualiza modal de inicio de sesion")
    public void se_visualiza_modal_de_inicio_de_sesion() {
        Assertions.assertEquals("Returning Customer",authPage.obtenerTituloModalLogin());
    }

    @Then("caja de texto para el ingreso del mail")
    public void caja_de_texto_para_el_ingreso_del_mail() {
        Assertions.assertTrue(authPage.validarEmail());
    }

    @Then("caja de texto para el ingreso del password")
    public void caja_de_texto_para_el_ingreso_del_password() {
        Assertions.assertTrue(authPage.validarPassword());
    }

    @Then("boton iniciar sesion")
    public void boton_iniciar_sesion() {
        Assertions.assertTrue(authPage.validarLogin());
    }

    @Given("selecciona link log in")
    public void selecciona_link_log_in() {
        homePage.irALogin();
        authPage = new AuthPage();
    }

    @When("se ingresa mail {string}")
    public void se_ingresa_mail(String docString) {
        authPage.ingresarEmail(docString);
    }

    @When("se ingresa password {string}")
    public void se_ingresa_password(String docString) {
        authPage.ingresarPassword(docString);
    }


    @When("presiona boton Log in")
    public void presiona_boton_log_in() {
        authPage.iniciarSesion();
    }

    @Then("se visualiza mensaje de error {string}")
    public void se_visualiza_mensaje_de_error(String docString) {
        Assertions.assertEquals(docString,authPage.obtenerErrorLogin());
    }

    @Then("se visualiza el home del sitio")
    public void se_visualiza_el_home_del_sitio() {
        Assertions.assertEquals("Demo Web Shop", homePage.obtenerTituloPagina());
    }

    @Then("el usuario logeado")
    public void el_usuario_logeado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
