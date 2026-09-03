package com.bonbonite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class ProductCatalogPage extends BasePage {

    // Selectores del flujo de compra
    public By linkLogoHome = By.cssSelector("header #header a#logo-header");
    public By productCard = By.cssSelector("div.swiper-slide-active a[href*='tenis-en-cuero-color-negro-onix']");
    public By btnSize = By.cssSelector("button.variation-button[data-value='37']");
    public By btnAddToCart = By.cssSelector("button.single_add_to_cart_button");
    public By iconCart = By.cssSelector("#header a.cart-contents");
    public By btnProceedToCheckout = By.cssSelector("a.checkout-button");
    public By btnContinueStep2 = By.cssSelector("button.cta-step[data-step='step2']");

    //Se crea selector de cookies para aceptarlas y no bloquee el flujo
    public By btnAcceptCookies = By.id("cookiescript_accept");

    //Constructor clase hija
    public ProductCatalogPage(WebDriver driver) {
        super(driver);
    }

    //Se crea método para cerrar mensaje de cookies en caso de que aparezcan, se ingresa método isDsiplayed para que solo se ejecute si aparece en la pantalla
    public void closeCookiesNoticeIfPresent() {
        if (isDisplayed(btnAcceptCookies)) {
            click(btnAcceptCookies);
        }
    }

    //Método para ir al home y seleccionar producto
    public void selectProductFromHome() {
        click(linkLogoHome);
        click(productCard);
    }

    //Método para seleccionar la talla y añadir al carrito
    public void addProductToCart() {
        click(btnSize);
        click(btnAddToCart);
    }

    //Método para la confirmación del pago
    public void proceedToCheckout() {
        // 1. Quita las cookies con un simple clic si están visibles
        closeCookiesNoticeIfPresent();
        // 2. Abre el carrito
        click(iconCart);
        // 3. Clik normal al botón de finalizar compra
        click(btnProceedToCheckout);
    }
    //Se valida que se valide que aparezca el botón de "Continuar"
    public boolean isCheckoutStepVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinueStep2));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}