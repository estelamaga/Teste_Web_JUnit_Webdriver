package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class informacoesUsuarioTest {
    //Expor a propriedade navegador a todos os métodos da classe
    private WebDriver navegador;
    @BeforeEach
    public void setUp(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","/home/estela/drivers/chromedriver");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // navegar para a página
        navegador.get("http://www.juliodelima.com.br/taskit");
    }
    @Test
    public void testAdicionarInformacaoDoUsuario(){
        //Clicar no link que possui o texto "sign in"
        navegador.findElement(By.linkText("Sign in")).click();
        //Identificando o formulário de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
        //Digitar no campo com nome "login" que está dentro do formulário de id "signhinbox" o texto "estelamaga"
        formularioSignInBox.findElement(By.name("login")).sendKeys("estelamaga");
        // Digitar no campo com o nome "password" que está dentro do formulário de id "signhinbox" o texto "maga0288"
        formularioSignInBox.findElement(By.name("password")).sendKeys("mag0288");
        //Clicar no link com o texto "SING IN"
        navegador.findElement(By.linkText("SIGN IN")).click();
        // Validar que dentro do elemento com class "me" está o texto "Hi, Estela Magalhaes"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        Assertions.assertEquals("Hi, Estela Magalhaes", textoNoElementoMe);
    }
    @AfterEach
    public void tearDown(){
        // Fechar o navegador
        navegador.quit();
    }
}
