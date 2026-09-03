package com.bonbonite.pages;

//Importamos las clases de Selenium y Java necesarias para interactuar con la página y manejar las esperas
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

// Clase base donde definimos las variables del driver y la espera
public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    // Constructor donde pasamos el driver para inicializar la clase y usar los métodos de espera
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    //Se crea la plantilla para dar click
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    //Se crea la plantilla para ingresar información
    public void typeSomething(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }
    //
    public boolean isDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}