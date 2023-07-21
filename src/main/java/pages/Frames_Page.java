package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Frames_Page {
    WebDriver driver;

    public Frames_Page(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@type='text']") List<WebElement> inputFields; // todos os campos de entrada na página


    public void switchToFrameWithInput(){
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        for (WebElement frame : frames) {
            driver.switchTo().frame(frame);

            // Verifique se o campo de entrada desejado está presente neste iframe
            List<WebElement> inputFields = driver.findElements(By.xpath("//input[@type='text']"));
            if (!inputFields.isEmpty()) {
                // Mudamos com sucesso para o iframe correto, então retornamos
                return;
            }

            // O campo de entrada não está neste iframe, volta para o contexto da página principal
            driver.switchTo().defaultContent();
        }

        // Não encontramos o campo de entrada em nenhum iframe
        throw new RuntimeException("Não foi possível encontrar o campo de entrada em nenhum iframe");
    }

    public void enterMessage(String message){
        // iframe correto, o primeiro campo de entrada é o que queremos
        WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));

        inputField.click();
        inputField.sendKeys(message);

        String enteredValue = inputField.getAttribute("value");

        // Usando JUnit para verificar se os valores correspondem
        assertEquals(message, enteredValue);
    }

    public void validadeMessage(String message){

    }

    public void switchBack(){
        driver.switchTo().defaultContent();
    }



}
