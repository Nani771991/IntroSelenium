package Unidad1.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) throws InterruptedException{
        // Paso 1 - Configurar el driver de Google Chrome
        WebDriverManager.chromedriver().setup();
        // Paso 2 - Creación de objeto Web Driver para manipular el browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        System.out.println("Titulo Pagina Web:"+driver.getTitle());
        // Paso 3 - Maximizar el sitio
        driver.manage().window().maximize();

        Thread.sleep(5000);

        // Paso 4 - Localizar el Login.Login
        By locatorLinkLogin = By.linkText("Log in");

        WebElement btnLogin = driver.findElement(locatorLinkLogin);

        btnLogin.click();

        //Paso 5 - Ingresar el Email
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("dania@algo.com");

        //Paso 6 - Ingresar Clave
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");

        //Paso 7 - Presionar el botón Login.Login
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }
}
