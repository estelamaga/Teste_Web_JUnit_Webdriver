package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class informacoesUsuarioTest {
    @Test
    public void testAdicionarInformacaoDoUsuario(){
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver","/home/estela/drivers/chromedriver");
        WebDriver navegador = new ChromeDriver();

        // navegar para a página
        navegador.get("http://www.juliodelima.com.br/taskit");

    }
}
