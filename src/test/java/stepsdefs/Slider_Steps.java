package stepsdefs;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Slider_Page;

public class Slider_Steps {
    private WebDriver driver;
    private Slider_Page sliderPage;


    @Before
    public void setup(){

        driver = BaseTest.getDriver();
        sliderPage = new Slider_Page(driver);
    }


    @Dado("que estou na aba de Slider")
    public void queEstouNaAbaDeSlider() {
        String endpoint = "Slider.html";
        BaseTest.navigateTo(endpoint);
        Assert.assertEquals(BaseTest.getDriver().getCurrentUrl(), BaseTest.getBaseUrl() + endpoint);
    }

    @Quando("movo o slider para {int}%")
    public void movoOSliderPara(double percent) {
        sliderPage.moveSliderToPercent(percent);
    }

    @Entao("o slider handle fica na posicao {int}% da barra")
    public void oSliderHandleFicaNaPosicaoIntDaBarra(double percent) {
        sliderPage.sliderPostionValidation(percent);
    }

    @After
    public void tearDown(){
        BaseTest.tearDown();
    }


}
