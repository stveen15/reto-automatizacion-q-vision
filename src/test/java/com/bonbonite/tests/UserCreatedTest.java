package com.bonbonite.tests;
//Se importan clases de sleenium, adicionalmente "utils" para la creación de los datos aleatorios
import com.bonbonite.pages.RegisterPage;
import com.bonbonite.utils.RandomData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCreatedTest extends BaseTest {

    @Test(description = "TC-001: Registro exitoso del usuario en la página web") //Test case definido en el documetno excel adjunto
    public void testUserRegistrationSuccessful() {
        RegisterPage registerPage = new RegisterPage(driver);
    //Se tra la información aletorio de Randomadata y se guarda en las variables de idNumber y email
        String idNumber = RandomData.getUniqueId();
        String email = RandomData.getUniqueEmail();
    //Se diligencia la información en los parametros
        registerPage.registerNewUser(
                idNumber,
                "Mairon",
                "Delgado",
                email,
                "mairontest*26"
        );
    //Se realiza la validación de que aparezca "Hola", de lo contrario se muestra el error asociado
        Assert.assertTrue(
                registerPage.isRegistrationSuccessful(),
                "Error: Welcome message was not displayed after registration."
        );
    }
}