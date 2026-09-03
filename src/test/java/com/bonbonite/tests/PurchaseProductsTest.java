package com.bonbonite.tests;

import com.bonbonite.pages.ProductCatalogPage;
import com.bonbonite.pages.RegisterPage;
import com.bonbonite.utils.RandomData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseProductsTest extends BaseTest {

    @Test(description = "TC-005 Agregar compras al carrito exitosamente")

    //Instanciamos las páginas necesarias para ejecutar el flujo continuo de registro y actualizción
    public void testPurchaseProductE2E() {
        RegisterPage registerPage = new RegisterPage(driver);
        ProductCatalogPage catalogPage = new ProductCatalogPage(driver);

        // 1. Se registra usuario para tener sesión iniciada
        String idNumber = RandomData.getUniqueId();
        String email = RandomData.getUniqueEmail();
        registerPage.registerNewUser(idNumber, "Mairon", "Delgado", email, "TestingPass2026*");

        // 2. Ir al catálogo, elegir producto, talla y agregar a la bolsa
        catalogPage.selectProductFromHome();
        catalogPage.addProductToCart();

        // 3. Abrir la bolsa y finalizar compra
        catalogPage.proceedToCheckout();

        // 4. Verifica que la pantalla de Checkout cargue con el botón Continuar
        Assert.assertTrue(
                catalogPage.isCheckoutStepVisible(),
                "Error: No se cargó la pantalla de Checkout del pedido."
        );
    }
}