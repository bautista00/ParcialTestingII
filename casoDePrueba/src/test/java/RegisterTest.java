import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/RegisterTest.html");
    static ExtentReports extent;


    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        BasePage basePage = new BasePage(driver, wait);
        basePage.setUp();
        basePage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setUp();
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void RegistroExitosoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Crear Cuenta Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);
        BasePage basePage = new BasePage(driver,wait);

        try {
            basePage.clickMyAccount();
            basePage.clickRegistrar();

            Assertions.assertEquals(registerPage.obtenerTituloRegistro(), "Account");
            test.log(Status.PASS, "Ingreso a la página de Registro");

            registerPage.escribirNombre("Bautista");
            registerPage.escribirApellido("Quesada");
            registerPage.escribirMail("bautista1@gmail.com");
            registerPage.escribirTelefono("1212353245");
            registerPage.escribirContraseña("1234");
            registerPage.escribirConfirmarContraseña("1234");
            registerPage.quieroSubscribirme();
            registerPage.acuerdoPoliticas();
            test.log(Status.PASS, "Completo los datos de registro de forma correcta");

            registerPage.clickRegistrarse();
            test.log(Status.PASS, "Completo el registro");

            Assertions.assertEquals(registerPage.obtenerMensajeExito(), "Congratulations! Your new account has been successfully created!");
            test.log(Status.PASS, "Valido que el registro se haya hecho de forma exitosa");

            basePage.clickMyStore();
            test.log(Status.PASS, "Regreso a la home");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
