package com.bonbonite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {

    //localizadores para la actualización de información del usuario creado.Improtante que sean únicos en el DOM
    public By iconUserAccount = By.cssSelector("#user-icon-wrap");
    public By linkAccountDetails = By.cssSelector("#header-account-menu a[href*='edit-account']");
    public By btnUpdateInfo = By.cssSelector("button.update-info-btn");
    public By inputFirstName = By.cssSelector("input[name='first_name']");
    public By btnSaveInfo = By.cssSelector("button.save-info-btn");

    //Constructor clase hija
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void updateAccountName(String newName) {
        // 1. Abre el menú flotante del usuario
        click(iconUserAccount);
        // 2. Navega a la sección de datos
        click(linkAccountDetails);
        // 3. Habilita el modo edición
        click(btnUpdateInfo);
        // 4. Limpia y escribe el nuevo nombre
        typeSomething(inputFirstName, newName);
        // 5. Guarda los cambios
        click(btnSaveInfo);
    }

    // Se verifica que luego de guardar aparezca de nuevo el botón de "Actualizar información"
    public boolean isUpdateInfoButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(btnUpdateInfo));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}