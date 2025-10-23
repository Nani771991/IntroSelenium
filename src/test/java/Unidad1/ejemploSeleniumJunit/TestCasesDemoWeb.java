package Unidad1.ejemploSeleniumJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestCasesDemoWeb {
    private static int numberOfCase = 0;
    private WebDriver driver;

    @BeforeAll
    public static void beforeSuite() {
        //PRECONDICIONES A NIVEL DE SUITE
        System.out.println("EJECUCIÓN SUITE DE PRUEBAS CURSO SECURITY");
        System.out.println("-----------------------------------------");
        System.out.println("PREPARANDO DATA DE PRUEBAS, CONEXIONES, ACCESOS y BLA BLA BLA.....");
        //CONFIGURAR EL DRIVER DE GOOGLE CHROME
        WebDriverManager.chromedriver().setup();

    }

    //ANTES DEL TEST
    @BeforeEach
    public void beforeTests() {
        numberOfCase++;
        System.out.println("EJECUTANDO TEST: " + numberOfCase);
        //PRECONDICIONES A NIVEL DE PASOS PREVIOS EN CADA TEST

        driver = new ChromeDriver();

        //Manejar con hasta 30 segundos el tiempo de espera para manipular un elemento web
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Tiempo de carga de las paginas
        //driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);

        //Tiempo de carga de los elementos asincronos (javascript)
        //driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);

        driver.get("https://demowebshop.tricentis.com");
        System.out.println("Titulo Pagina Web: " + driver.getTitle());

        // Maximizar el sitio manage()
        driver.manage().window().maximize();

        //Thread.sleep(5000); //espera si o si 5 segundos - FIJO
    }

    @AfterEach
    public void postTests() {
        System.out.println("Pos condiciones test nro: " + numberOfCase);
        //driver.close();
    }

    @AfterAll
    public static void afterSuite() {
        System.out.println("SE FINALIZA SUITE DE PRUEBAS.....IMPRIMIENDO REPORTE......");
    }

    //TEST
    @Order(1)
    @Test
    public void CP_001_Create_Account() throws InterruptedException {

        //Creación de objeto WebDriver para manipular el browser

        By locatorLinkRegister = By.linkText("Register");

        //Web element (instancia boton de codigo)

        WebElement btnRegister = driver.findElement(locatorLinkRegister);

        btnRegister.click();

        By locatorGeneroslocatorGeneros = By.xpath("//input[@type='radio']");

        List<WebElement> generos = driver.findElements(locatorGeneroslocatorGeneros);

        generos.get(0).click();
        Thread.sleep(2000);

        //Primer nombre
        driver.findElement(By.id("FirstName")).sendKeys("Danielin");
        //Last Name
        driver.findElement(By.id("LastName")).sendKeys("Valenzuelas");
        //email
        driver.findElement(By.xpath("//input[@data-val-required='Email is required.']")).sendKeys("daneedo2@algo.com");

        //password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");

        //Confirm password
        driver.findElement(By.name("ConfirmPassword")).sendKeys("123456");

        //click en register
        driver.findElement(By.id("register-button")).click();

        Assertions.assertEquals("Your registration completed", driver.findElement(By.xpath("//div[@class='result' and normalize-space(text())='Your registration completed']")).getText());

    }

    //TEST
    @Order(2)
    @Test
    public void CP_002_Error_Create_Account_Mail_Exist() throws InterruptedException {

        By locatorLinkRegister = By.linkText("Register");

        //Web element (instancia boton de codigo)

        WebElement btnRegister = driver.findElement(locatorLinkRegister);

        btnRegister.click();

        By locatorGeneroslocatorGeneros = By.xpath("//input[@type='radio']");

        List<WebElement> generos = driver.findElements(locatorGeneroslocatorGeneros);

        generos.get(0).click();
        Thread.sleep(2000);

        //Primer nombre
        driver.findElement(By.id("FirstName")).sendKeys("Danielito");
        //Last Name
        driver.findElement(By.id("LastName")).sendKeys("Valenzuela");
        //email
        driver.findElement(By.xpath("//input[@data-val-required='Email is required.']")).sendKeys("dania@algo.com");

        //password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");

        //Confirm password
        driver.findElement(By.name("ConfirmPassword")).sendKeys("123456");

        //click en register
        driver.findElement(By.id("register-button")).click();

        Assertions.assertEquals("The specified email already exists", driver.findElement(By.xpath("//li[text()='The specified email already exists']")).getText());

    }

    //TEST
    @Order(3)
    @Test
    public void CP_003_Search_Gift_Card() throws InterruptedException {

        driver.findElement(By.xpath("(//input[@id='small-searchterms'])[1]")).sendKeys("giftcard");

        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();

    }

    //TEST
    @Order(4)
    @Test
    public void CP_004_Order_By_minor_price() throws InterruptedException {

        driver.findElement(By.xpath("(//input[@id='small-searchterms'])[1]")).sendKeys("computer");

        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();

        WebElement dropdownElement = driver.findElement(By.id("products-orderby"));
        Select dropdown = new Select(dropdownElement);

        // Selección por texto visible
        dropdown.selectByVisibleText("Price: Low to High");

    }

    //TEST
    @Order(5)
    @Test
    public void CP_005_Sign_up_Newsletter() throws InterruptedException {   //PREGUNTAR MAÑANA A DOMINGO
        driver.findElement(By.name("NewsletterEmail")).sendKeys("dania@algo.com");

        driver.findElement(By.id("newsletter-subscribe-button")).click();

        Thread.sleep(2000);

        Assertions.assertEquals("Thank you for signing up! A verification email has been sent. We appreciate your interest.", driver.findElement(By.xpath("//div[@id='newsletter-result-block']")).getText());

    }

    @Order(6)
    @Test
    public void CP_006_Order_By_mayor_price() throws InterruptedException {

        driver.findElement(By.xpath("(//input[@id='small-searchterms'])[1]")).sendKeys("computer");

        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();

        WebElement dropdownElement = driver.findElement(By.id("products-orderby"));
        Select dropdown = new Select(dropdownElement);

        // Selección por texto visible
        dropdown.selectByVisibleText("Price: High to Low");

    }

    @Order(7)
    @Test
    public void CP_007_Add_Product_to_cart() throws InterruptedException {

        driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[3]//div[1]//div[2]//div[3]//div[2]//input[1]")).click();

        Thread.sleep(2000);

        Assertions.assertEquals("The product has been added to your shopping cart", driver.findElement(By.xpath("//p[@class='content']")).getText());

    }

    @Order(8)
    @Test
    public void CP_008_Log_In_To_Buy() throws InterruptedException {

        driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[3]//div[1]//div[2]//div[3]//div[2]//input[1]")).click();

        Thread.sleep(2000);

        Assertions.assertEquals("The product has been added to your shopping cart", driver.findElement(By.xpath("//p[@class='content']")).getText());

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();

        WebElement checkbox = driver.findElement(By.id("termsofservice"));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("dania@algo.com");

        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");

        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }

    @Order(9)
    @Test
    public void CP_009_Log_Out() throws InterruptedException {
        By locatorLinkLogin = By.linkText("Log in");

        WebElement btnLogin = driver.findElement(locatorLinkLogin);

        btnLogin.click();

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("dania@algo.com");


        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");


        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();


    }

    }




