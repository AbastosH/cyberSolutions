package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePicker_Page {
    WebDriver driver;

    private static final By MONTH_XPATH = By.xpath("//span[@class='ui-datepicker-month']");
    private static final By YEAR_XPATH = By.xpath("//span[@class='ui-datepicker-year']");
    private static final By PREV_BUTTON_SELECTOR = By.xpath("//a[@title='Prev']");

    @FindBy (xpath = "//input[@id='datepicker2']") WebElement calendar2;
    @FindBy (xpath = "//input[@id='datepicker1']") WebElement calendar1;

    public DatePicker_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void openDatePicker1Calendar(){
        calendar1.click();
    }

    public void openDatePicker2Calendar(){
        calendar2.click();
    }

    public void datePicker2SetDate(String date){
        calendar2.sendKeys(date);
    }

    public void datePicker1SetDate(String day, String month, String year) {

        navigateToMonthAndYear(month , year);
        selectDay(day);
    }

    private void navigateToMonthAndYear(String month, String year) {
        // Navegar até o mês e ano desejados
        while (true) {
            WebElement monthElement = driver.findElement(MONTH_XPATH);
            WebElement yearElement = driver.findElement(YEAR_XPATH);

            String currentMonth = monthElement.getText();
            String currentYear = yearElement.getText();

            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break; // Sai do loop se o mês e o ano atuais são os desejados
            }
            // Se o mês e o ano atuais não são os desejados, clica no botão "Próximo"
            WebElement prevButton = driver.findElement(PREV_BUTTON_SELECTOR);
            prevButton.click();
        }
    }

    private void selectDay(String day){
        By daySelector = By.xpath("//a[contains(@class,'ui-state-default') and text()='"+day+"']");
        WebElement dayElement = driver.findElement(daySelector);
        dayElement.click();
    }


    public void calendar1Validation(String data){
        String selectedDate = driver.findElement(By.id("datepicker1")).getAttribute("value");

        System.out.println("a data selecionada foi " + selectedDate);
    }

    public void calendar2Validation(String data){
        String selectedDate = driver.findElement(By.id("datepicker2")).getAttribute("value");

        System.out.println("a data selecionada foi " + selectedDate);
    }
}