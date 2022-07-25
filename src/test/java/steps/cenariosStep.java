package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import static org.junit.Assert.*;

public class cenariosStep {
    private WebDriver navegador;

    @Dado("que acesse o site")
    public void que_acesse_o_site() {
        navegador = Web.createChrome()
        ;
    }
    @Dado("valido que estou na tela WEBJUMP")
    public void valido_que_estou_na_tela_webjump() {
        WebElement telaWebJump = navegador.findElement(By.id("heading_one"));
    }
    @Quando("clicar nos botoes {string}, {string} e {string}")
    public void clicar_nos_botoes_e(String One, String Two, String Four) {
        navegador.findElement(By.id("btn_one")).click();
        navegador.findElement(By.id("btn_two")).click();
        navegador.findElement(By.id("btn_link")).click();
    }

    @Entao("valido que nao apresenta botoes na tela")
    public void valido_que_nao_apresenta_botoes_na_tela() {
        WebElement mensagemOne = navegador.findElement(By.id("btn_one"));
        String mensagem1 = mensagemOne.getText();
        assertEquals("One", mensagem1);

        WebElement mensagemTwo = navegador.findElement(By.id("btn_two"));
        String mensagem2 = mensagemTwo.getText();
        assertEquals("Two", mensagem2);

        WebElement mensagemFour = navegador.findElement(By.id("btn_link"));
        String mensagem3 = mensagemFour.getText();
        assertEquals("Four", mensagem3);

        WebDriverWait aguardar = new WebDriverWait(navegador, Duration.ofSeconds(10));
        aguardar.until(ExpectedConditions.invisibilityOfElementLocated(By.id("btn_one")));

        aguardar.until(ExpectedConditions.invisibilityOfElementLocated(By.id("btn_two")));

        aguardar.until(ExpectedConditions.invisibilityOfElementLocated(By.id("btn_link")));

        Screenshot.tirar(navegador, "C:\\Users\\rfelicio\\test-report" + Generator.dataHoraParaArquivo() + "cenario1.png");


    }

    @Quando("clicar nos botoes {string}, {string} e {string} dentro do Iframe")
    public void clicar_nos_botoes_e_dentro_do_iframe(String One, String Two, String Four) {
        JavascriptExecutor jse = (JavascriptExecutor)navegador;
        jse.executeScript("scrollBy(0,1250)", "");
        navegador.switchTo().frame(navegador.findElement(By.xpath("//*[@id=\"iframe_panel_body\"]/iframe")));
        navegador.findElement(By.id("btn_one")).click();
        navegador.findElement(By.id("btn_two")).click();
        navegador.findElement(By.id("btn_link")).click();


    }
    @Entao("valido que nao apresenta mais nenhum desses botoes em tela")
    public void valido_que_nao_apresenta_mais_nenhum_desses_botoes_em_tela() {
        WebElement mensagemOneFrame = navegador.findElement(By.id("btn_one"));
        String mensagem4 = mensagemOneFrame.getText();
        assertEquals("One", mensagem4);

        WebElement mensagemTwoFrame = navegador.findElement(By.id("btn_two"));
        String mensagem5 = mensagemTwoFrame.getText();
        assertEquals("Two", mensagem5);

        WebElement mensagemFourFrame = navegador.findElement(By.id("btn_link"));
        String mensagem6 = mensagemFourFrame.getText();
        assertEquals("Four", mensagem6);

        WebDriverWait aguardar = new WebDriverWait(navegador, Duration.ofSeconds(10));
        aguardar.until(ExpectedConditions.invisibilityOfElementLocated(By.id("btn_one")));

        aguardar.until(ExpectedConditions.invisibilityOfElementLocated(By.id("btn_two")));

        aguardar.until(ExpectedConditions.invisibilityOfElementLocated(By.id("btn_link")));

        Screenshot.tirar(navegador, "C:\\Users\\rfelicio\\test-report" + Generator.dataHoraParaArquivo() + "cenario2.png");

    }
    @Quando("escrever texto no campo {string}")
    public void escrever_texto_no_campo(String string) {
        JavascriptExecutor jse = (JavascriptExecutor)navegador;
        jse.executeScript("scrollBy(0,1250)", "");
        navegador.switchTo().frame(navegador.findElement(By.xpath("//*[@id=\"iframe_panel_body_two\"]/iframe")));
        navegador.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Richard Felicio da Silva");
    }
    @Quando("clicar no botao {string}")
    public void clicar_no_botao(String string) {
        navegador.switchTo().frame(navegador.findElement(By.xpath("//*[@id=\"iframe_panel_body\"]/iframe")));
        navegador.findElement(By.id("btn_one")).click();

    }
    @Quando("clicar no cheque {string}")
    public void clicar_no_cheque(String string) {
        WebDriverWait aguardar = new WebDriverWait(navegador, Duration.ofSeconds(10));
        navegador.switchTo().frame(navegador.findElement(By.xpath("//*[@id=\"iframe_panel_body\"]/iframe")));
        navegador.findElement(By.id("opt_three")).click();
    }
    @Quando("selecionar a opcao  {string}")
    public void selecionar_a_opcao(String string) {
        navegador.switchTo().frame(navegador.findElement(By.xpath("//*[@id=\"iframe_panel_body\"]/iframe")));
        WebElement element = navegador.findElement(By.id("select_box"));
        Select combo = new Select(element);
        combo.selectByVisibleText("ExampleTwo");
    }
    @Entao("valido a imagem do logo do {string}")
    public void valido_a_imagem_do_logo_do(String string) {
        navegador.findElement(By.xpath("//*[@id=\"panel_body_three\"]/img[4]"));

        Screenshot.tirar(navegador, "C:\\Users\\rfelicio\\test-report" + Generator.dataHoraParaArquivo() + "cenario3.png");

    }
    @After
    public void tearDown() {
        navegador.quit();
    }
}
