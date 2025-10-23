package Unidad2.tests;

import Unidad2.pages.HomePage;
import Unidad2.pages.RegisterPage;
import Unidad2.pages.ResultadosBusquedaPage;
import Unidad2.pages.NewsletterPage;
import Unidad2.pages.NotificacionesPage;
import Unidad2.pages.HomeCatalogoPage;
import Unidad2.pages.CarroPage;
import Unidad2.pages.AuthPage;

import Unidad2.utils.DataDriven;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestCases {
    //Atributo
    WebDriver driver;
    HomePage home;
    RegisterPage register;
    ArrayList<String> datodePrueba;
    ResultadosBusquedaPage resultados;
    NewsletterPage newsletter;
    NotificacionesPage notif;
    HomeCatalogoPage homeCat;
    CarroPage carro;
    AuthPage auth;

    @BeforeAll
    public static void beforeSuite() {
        WebDriverManager.chromiumdriver().setup();

    }

    //ANTES DEL TEST
    @BeforeEach
    public void beforeTests() {
        datodePrueba = new ArrayList<>();
        driver = new ChromeDriver(); // Se instancia el driver de chrome
        home = new HomePage(driver); // Se instancian las pages
        register = new RegisterPage(home.getDriver());

        home.cargarUrl("https://demowebshop.tricentis.com/");
        home.maximizarBrowser();

        resultados = new ResultadosBusquedaPage(driver);
        newsletter = new NewsletterPage(driver);
        notif = new NotificacionesPage(driver);
        homeCat = new HomeCatalogoPage(driver);
        carro = new CarroPage(driver);
        auth = new AuthPage(driver);
    }

    @AfterEach
    public void postTests() {
        home.cerrarBrowser();

    }

    @AfterAll
    public static void afterSuite() {

    }

    //TEST
    @Order(1)
    @Test
    public void CP_001_Create_Account() throws InterruptedException {
        datodePrueba = DataDriven.getData("CP_001_Create_Account");
        home.irARegister();
        register.crearCuenta(Integer.parseInt(datodePrueba.get(1)),"Daniel", "Valenzuela", datodePrueba.get(4), "123456","123456");
        Assertions.assertEquals("Your registration completed",register.obtenerMensajeCtaOK());
    }

    //TEST
    @Order(2)
    @Test
    public void CP_002_Error_Create_Account_Mail_Exist() throws InterruptedException {
        home.irARegister();
        register.crearCuenta(0,"Daniel", "Valenzuela", "dania@algo.net","123456","123456");
        Assertions.assertEquals("The specified email already exists",register.getErrorMensajeCta_MailUsed());
    }


    //TEST
    @Order(3)
    @Test
    public void CP_003_Search_Gift_Card() throws InterruptedException {
        home.buscar("giftcard");
    }

    //TEST
    @Order(4)
    @Test
    public void CP_004_Order_By_minor_price() throws InterruptedException {
        home.buscar("computer");
        resultados.ordenarPor("Price: Low to High");
    }

    //TEST
    @Order(5)
    @Test
    public void CP_005_Sign_up_Newsletter() throws InterruptedException {   //PREGUNTAR MAÑANA A DOMINGO
        newsletter.suscribirse("dania@hotmail.com");
        Assertions.assertEquals(
                "",
                newsletter.obtenerMensaje()
        );
    }

    @Order(6)
    @Test
    public void CP_006_Order_By_mayor_price() throws InterruptedException {
        home.buscar("computer");
        resultados.ordenarPor("Price: High to Low");
    }

    @Order(7)
    @Test
    public void CP_007_Add_Product_to_cart() throws InterruptedException {
        homeCat.agregarPrimerProductoAlCarro();
        Assertions.assertEquals(
                "The product has been added to your shopping cart",
                notif.obtenerMensajeExito()
        );
    }

    @Order(8)
    @Test
    public void CP_008_Log_In_To_Buy() throws InterruptedException {
        homeCat.agregarPrimerProductoAlCarro();
        Assertions.assertEquals(
                "The product has been added to your shopping cart",
                notif.obtenerMensajeExito()
        );
        home.irAlCarro();
        carro.aceptarTerminos();
        carro.irACheckout();

        auth.iniciarSesion("dania@algo.com", "123456");
    }

    @Order(9)
    @Test
    public void CP_009_Log_Out() throws InterruptedException {
        auth.irALogin();
        auth.iniciarSesion("dania@algo.com", "123456");
        auth.cerrarSesion();
    }
}




