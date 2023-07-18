package stepsdefs;

import base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Frames_Page;


public class Frames_Steps {
    WebDriver driver;
    Frames_Page framesPage;


    @Before
    public void setup(){
        driver = BaseTest.getDriver();
        framesPage = new Frames_Page(driver);
    }

    @Dado("que estou na aba de Frames")
    public void queEstouNaAbaDeFrames() {
        String endpoint = "Frames.html";
        BaseTest.navigateTo(endpoint);
        Assert.assertEquals(BaseTest.getDriver().getCurrentUrl(), BaseTest.getBaseUrl() + endpoint);
    }

    @Quando("digito {string} input dentro do Frame")
    public void digito_input_dentro_do_frame(String string) {
        framesPage.switchToFrameWithInput();
        framesPage.enterMessage(string);
    }
    @Entao("aparece a {string}")
    public void aparece_a(String string) {
        framesPage.switchBack();

    }


}
