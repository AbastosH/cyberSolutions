package stepsdefs;


import base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import pages.Register_Page;
import pages.Slider_Page;

import java.util.Arrays;
import java.util.List;

public class Register_Steps {
    WebDriver driver;
    Register_Page registerPage;

    @Before
    public void setup(){
        driver = BaseTest.getDriver();
        registerPage = new Register_Page(driver);
    }

    @Dado("que eu esteja na pagina de Registro")
    public void que_eu_esteja_na_pagina_de_registro() {
        String endpoint = "Register.html";
        BaseTest.navigateTo(endpoint);
        Assert.assertEquals(BaseTest.getDriver().getCurrentUrl(), BaseTest.getBaseUrl() + endpoint);
    }
    @Quando("eu insiro {string} no campo Primeiro Nome")
    public void eu_insiro_no_campo_primeiro_nome(String string) {
        registerPage.enterFirstName(string);
    }

    @E("eu insiro {string} no campo Ultimo Nome")
    public void eu_insiro_no_campo_ultimo_nome(String string) {
        registerPage.enterLastName(string);
    }

    @E("eu insiro {string} no campo Endereco")
    public void eu_insiro_no_campo_endereco(String string) {
        registerPage.enterAddress(string);
    }

    @E("eu insiro {string} no campo Email")
    public void eu_insiro_no_campo_email(String string) {
        registerPage.enterEmail(string);
    }

    @E("eu insiro {string} no campo Telefone")
    public void eu_insiro_no_campo_telefone(String string) {
        registerPage.enterPhoneNumber(string);
    }

    @E("eu seleciono {string} no campo Genero")
    public void eu_seleciono_no_campo_genero(String string) {
        registerPage.selectGender(string);
    }

    @E("eu seleciono {string} no campo Hobbies")
    public void eu_seleciono_no_campo_hobbies(String string) {
        registerPage.selectHobby(string);
    }

    @E("eu escolho {string} no campo Languages")
    public void euEscolhoQueFalo(String language) {
        List<String> languages = Arrays.asList(language.split(","));
        registerPage.selectLanguage(languages);
    }

    @E("eu seleciono {string} no campo Habilidades")
    public void eu_seleciono_no_campo_habilidades(String string) {
        registerPage.selectSkills(string);
    }

    @E("eu seleciono {string} no campo country*")
    public void euSelecionoNoCampoCountry(String country) {
        registerPage.selectCountry1(country);

    }
    
    @E("eu seleciono {string} no campo Selecionar Pais")
    public void eu_seleciono_no_campo_selecionar_pais(String string) {
        registerPage.selectCountry(string);
    }

    @E("eu insiro {string} no campo Data de Nascimento")
    public void eu_insiro_no_campo_data_de_nascimento(String dob) {

        registerPage.selectDateOfBirthDay(dob);
    }

    @E("eu insiro {string} no campo Senha")
    public void eu_insiro_no_campo_senha(String password) {
        registerPage.enterPassword(password);
    }

    @E("eu insiro {string} no campo Confirmar Senha")
    public void eu_insiro_no_campo_confirmar_senha(String password) {
        registerPage.confirmPassword(password);
    }

    @E("eu devo clicar em Enviar")
    public void eu_devo_conseguir_clicar_em_enviar() {
        registerPage.clickSubmit();
    }


    @Entao("a aplicacao envia o formulario por falta de campos preenchidos")
    public void aAplicacaoNaoEnviaOFormularioPorFaltaDeCamposPreenchidos() {
        registerPage.FormValidation();
    }


}

