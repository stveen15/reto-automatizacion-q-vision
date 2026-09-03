# Pruebas Automatizadas E2E - Tienda Bon-bonite

Proyecto de automatización de pruebas web para la plataforma de comercio electrónico de **Bon-bonite** (https://www.bon-bonite.com/). Desarrollado como parte de la prueba técnica de aseguramiento de calidad (QA) para **Q-Vision Technologies**.

---

## 1. Tecnologías Utilizadas

* **Lenguaje:** Java 17
* **Herramienta de construcción:** Apache Maven
* **Automatización:** Selenium WebDriver
* **Patrón de Diseño:** Page Object Model (POM)

---

## 2. Casos de Prueba Automatizados

* **TC-001 (Registro exitoso del usuario en la página web):** Registro exitoso de un nuevo cliente y validación del saludo de bienvenida "Hola".
* **TC-003 (Actualización exitosa de datos de usuario):** Modificación y guardado exitoso de los datos personales en la cuenta.
* **TC-005 (Agregar compras al carrito exitosamente):** Selección de producto con talla, adición a la bolsa y navegación fluida por el checkout.

*(La documentación detallada de casos negativos y de borde se encuentra en el archivo Excel entregable).*

---

## 3. Instrucciones para Ejecutar las Pruebas

### Desde IntelliJ IDEA:
1. Abrir el proyecto en IntelliJ IDEA.
2. Ir a la pestaña **Maven** en el lateral derecho.
3. Desplegar **reto_automatizacion_q_vision** > **Lifecycle**.
4. Hacer doble clic en **test**.

*(Alternativa: Clic derecho sobre `src/test/resources/testng.xml` y presionar **Run '.../testng.xml'**).*

### Desde Terminal con Maven:
mvn test
