package stepsdefs;

import base.BaseTest;

import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DatePicker_Page;



public class DatePicker_Steps {
    WebDriver driver;
    DatePicker_Page datePickerPage;

    @Before
    public void setup(){

        driver = BaseTest.getDriver();
        datePickerPage = new DatePicker_Page(driver);
    }

    @Dado("que estou na aba de Datepicker")
    public void que_estou_na_aba_de_datepicker() {
        String endpoint = "Datepicker.html";
        BaseTest.navigateTo(endpoint);
        Assert.assertEquals(BaseTest.getDriver().getCurrentUrl(), BaseTest.getBaseUrl() + endpoint);
    }
    @Quando("abro o calendario1")
    public void abro_o_calendario1() {
        datePickerPage.openDatePicker1Calendar();

    }
    @E("seleciono a {string}")
    public void seleciono_a(String data) {
        String[] partes = data.split("-");
        String dia = partes[0];
        String mes =  partes[1];
        String ano = partes[2];
        datePickerPage.datePicker1SetDate(dia, mes, ano);
    }
    @Entao("deve mostrar a {string} que selecionei")
    public void deve_mostrar_a_que_selecionei(String data) {
        datePickerPage.calendar1Validation(data);
    }


    @Quando("abro o calendario2")
    public void abroOCalendario() {
        datePickerPage.openDatePicker2Calendar();
    }

    @E("seleciono a {string} no segundo calendario")
    public void selecionoANoSegundoCalendario(String date) {
        datePickerPage.datePicker2SetDate(date);
    }

    @Entao("deve mostrar a {string} que selecionei no segundo calendario")
    public void deveMostrarAQueSelecioneiNoSegundoCalendario(String data) {
        datePickerPage.calendar2Validation(data);
    }
}
