package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class Register_Page {
    WebDriver driver;

    @FindBy(xpath = "//input[@ng-model='FirstName']") WebElement firstNameField;
    @FindBy(xpath = "//input[@ng-model='LastName']") WebElement lastNameField;
    @FindBy(xpath = "//textarea[@ng-model='Adress']") WebElement addressField;
    @FindBy(xpath = "//input[@ng-model='EmailAdress']") WebElement emailField;
    @FindBy(xpath = "//input[@ng-model='Phone']") WebElement phoneField;

    @FindBy(xpath = "//div[@id='msdd']") WebElement languagesField;

    @FindBy(xpath = "//select[@placeholder='Year']") WebElement dobYearField;
    @FindBy(xpath = "//select[@placeholder='Month']") WebElement dobMonthField;
    @FindBy(xpath = "//select[@placeholder='Day']") WebElement dobDayField;

    @FindBy(xpath = "//input[@id='firstpassword']") WebElement passwordField;
    @FindBy(xpath = "//input[@id='secondpassword']") WebElement confirmPasswordField;
    @FindBy(xpath = "//button[@id='submitbtn']") WebElement submitButton;





    public Register_Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void enterAddress(String address){
        addressField.sendKeys(address);
    }

    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterPhoneNumber(String phoneNumber){
        phoneField.sendKeys(phoneNumber);
    }

    public void selectGender(String gender){
        String genderXPath = "//input[@ng-model='radiovalue' and @value='" + gender + "']";
        WebElement genderField = driver.findElement(By.xpath(genderXPath));
        genderField.click();
    }

    public void selectHobby(String hobby){
        String hobbyXPath = "//input[@type='checkbox' and @value='" + hobby + "']";
        WebElement hobbyField = driver.findElement(By.xpath(hobbyXPath));
        hobbyField.click();
    }

    public  void selectLanguage(List<String> languages){
        Actions actions = new Actions(driver);
        actions.moveToElement(languagesField).click().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //iterar sobre os idiomas desejados
        for (String language : languages) {
        WebElement languageOption = driver.findElement(By.xpath("//li[a/text()='" + language + "']"));
        languageOption.click();
        }
    }

    public void selectSkills(String skill){

        Select selectSkillDropdown = new Select((driver.findElement(By.id("Skills"))));
                selectSkillDropdown.selectByVisibleText(skill);
    }

    public void selectCountry(String country) {

       WebElement dropdown = driver.findElement(By.cssSelector(".select2-selection__arrow"));
       dropdown.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espere até 10 segundos
        String countryXpath = "//ul[@id='select2-country-results']/li[text()='" + country +"']";
        WebElement countryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(countryXpath)));


        countryElement.click();
    }

    public void selectCountry1(String country) {
        Select countryDropdown = new Select(driver.findElement(By.id("countries")));
        countryDropdown.selectByVisibleText(country);
    }


    public void selectDateOfBirthDay(String dob) {
        String[] dobParts = dob.split("-");

        Select yearDropdown = new Select(dobYearField);
        yearDropdown.selectByVisibleText(dobParts[0]);

        Select monthDropdown = new Select(dobMonthField);
        monthDropdown.selectByVisibleText(dobParts[1]);

        Select dayDropdown = new Select(dobDayField);
        dayDropdown.selectByVisibleText(dobParts[2]);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void confirmPassword(String password){
        confirmPasswordField.sendKeys(password);
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public void FormValidation(){
        String expectedUrl = "https://demo.automationtesting.in/login.html";
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.equals(expectedUrl)) {
            System.out.println("Formulário enviado com sucesso!");
        } else {
            System.out.println("O envio do formulário falhou. Verifique os campos incorretos ou inválidos.");
        }

    }
}

