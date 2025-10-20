package EjemploClase1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumClase1 {
    public static void main(String[] args) throws InterruptedException {
        //CONFIGURAR EL DRIVER DE GOOGLE CHROME
        WebDriverManager.chromedriver().setup();
        //Creación de objeto WebDriver para manipular el browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        System.out.println("Titulo Pagina Web: "+driver.getTitle());

        // Maximizar el sitio manage()
        driver.manage().window().maximize();

        Thread.sleep(5000); //espera si o si 5 segundos - FIJO

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
        driver.findElement(By.xpath("//input[@data-val-required='Email is required.']")).sendKeys("daniedo@algo.com");

        //password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");

        //Confirm password
        driver.findElement(By.name("ConfirmPassword")).sendKeys("123456");

        //click en register
        driver.findElement(By.id("register-button")).click();

        
    }
}
