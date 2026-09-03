package com.bonbonite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    //Se mapean los localizadores necesarios del formulario
    public By linkShowRegister = By.id("show_register");
    public By inputIdCard = By.id("reg_username");
    public By inputFirstName = By.id("first_name");
    public By inputLastName = By.id("last_name");
    public By inputEmail = By.id("reg_email");
    public By inputPassword = By.id("reg_password");
    public By inputConfirmPassword = By.id("reg_password2");
    public By checkDataProcessingConsent = By.id("privacy_policy_reg");
    public By registerButton = By.name("register");

    //Se mapea localiazor del mensaje que aparece luego de que el registro es exitoso. Importante para el assert
    public By welcomeMessage = By.xpath("//*[contains(text(), 'Hola')]");

    //Constructor clase hija
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    //Se espera que el link que redirecciona el formulario esté disponible
    public void openRegistrationForm() {
        if (isDisplayed(linkShowRegister)) {
            click(linkShowRegister);
        }
    }
    //Se diligencia el formulario con los localizadores mencionados anteriormente
    public void registerNewUser(String idCard, String firstName, String lastName, String email, String password) {
        openRegistrationForm();

        typeSomething(inputIdCard, idCard);
        typeSomething(inputFirstName, firstName);
        typeSomething(inputLastName, lastName);
        typeSomething(inputEmail, email);
        typeSomething(inputPassword, password);
        typeSomething(inputConfirmPassword, password);
        click(checkDataProcessingConsent);
        click(registerButton); //Se da click y se continua a la siguiente página
    }
    //Valida que aparezca el mensaje de bienvenida
    public boolean isRegistrationSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}