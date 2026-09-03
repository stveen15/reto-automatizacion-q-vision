package com.bonbonite.tests;

//Se importan clases de sleenium, adicionalmente "utils" para la creación de los datos aleatorios
import com.bonbonite.pages.MyAccountPage;
import com.bonbonite.pages.RegisterPage;
import com.bonbonite.utils.RandomData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateUserTest extends BaseTest {

    @Test(description = "TC-003 Actualización exitosa de datos de usuario")
    public void testUpdateUserInformation() {
        //Instanciamos las páginas necesarias para ejecutar el flujo continuo de registro y actualizción
        RegisterPage registerPage = new RegisterPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        // Se registra usuario para tener sesión iniciada
        String idNumber = RandomData.getUniqueId();
        String email = RandomData.getUniqueEmail();
        registerPage.registerNewUser(
                idNumber,
                "Mairon",
                "Delgado",
                email,
                "TestingPass2026*");

        //Se ingresa la información que se desea actualizar como parametro
        myAccountPage.updateAccountName("MaironActualizado");

        //Se valida que de nuevo aparezca el mensaje de "Actualizar información"
        Assert.assertTrue(
                myAccountPage.isUpdateInfoButtonDisplayed(),
                "Error: El botón 'Actualizar Información' no reapareció tras guardar los cambios."
        );
    }
}