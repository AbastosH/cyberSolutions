package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Slider_Page {
    WebDriver driver;
    private By slider = By.id("slider");
    private By sliderHandle = By.cssSelector(".ui-slider-handle");

    public Slider_Page(WebDriver driver){
        this.driver = driver;
    }


    public void moveSliderToPercent(double percent){
        WebElement sliderElement = driver.findElement(sliderHandle);
        int sliderWidth =  driver.findElement(slider).getSize().getWidth();
        int moveTo = (int)(sliderWidth * (percent / 100.0));

        Actions actions  = new Actions(driver);
        actions.dragAndDropBy(sliderElement, moveTo ,0).perform();
    }

    public void sliderPostionValidation(double percent){
        double position = getSliderPosition();

        try {
            Assert.assertEquals(percent, position, 1.0); //Margem de rro de 1%
            System.out.println("O Slider hanlde esta na posicao esperada. O teste passou ");
        } catch (AssertionError e) {
            System.out.println("Teste falhou ! Slider nao esta na posicao esperada");
        }

    }

    private double getSliderPosition(){
        WebElement sliderElement = driver.findElement(sliderHandle);
        String style = sliderElement.getAttribute("style");
        String[] splitStyle = style.split(": ");
        double position =  Double.parseDouble(splitStyle[1].replace("%;",""));
        return position;
    }
}
