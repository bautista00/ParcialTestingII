import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class RegisterPage extends BasePage{
    private By titulo = By.xpath("//*[@id=\"content\"]/h1");

    private By nombre = By.id("input-firstname");
    private By apellido = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telefono = By.id("input-telephone");
    private By contrasena = By.id("input-password");
    private By recontrasena = By.id("input-confirm");

    private By subscribirse = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");

    private By politicas = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
    private By registrarseBtn = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
    private By exito = By.xpath("//*[@id=\"content\"]/p[1]");

    private By obligatorioNombre = By.xpath("(//*[@id=\"input-firstname\"])[1]");
    private By obligatorioApellido = By.xpath("(//*[@id=\"input-lastname\"])[2]");
    private By obligatorioMail = By.xpath("(//*[@id=\"input-email\"])[3]");
    private By obligatorioTelefono = By.xpath("(//*[@id=\"input-telephone\"])[4]");
    private By obligatorioContrasena = By.xpath("(//*[@id=\"input-password\"])[5]");
    private By obligatorioRecontrasena = By.xpath("(//*[@id=\"input-confirm\"])[6]");
    private By obligatorioPoliticas = By.xpath("(//*[@id=\"content\"]/form/div/div/input[1])[7]");


    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String obtenerTituloRegistro() throws InterruptedException {
        System.out.println("Me encuentro en la página de Registro: " + getText(titulo));
        return this.getText(titulo);
    }

    public void escribirNombre(String name) throws InterruptedException {
        sendText(name, nombre);
    }

    public void escribirApellido(String lastName) throws InterruptedException {
        sendText(lastName, apellido);
    }

    public void escribirMail(String mail) throws InterruptedException {
        sendText(mail, email);
    }

    public void escribirTelefono (String celular) throws InterruptedException {
        sendText(celular, telefono);
    }

    public void escribirContraseña(String clave) throws InterruptedException {
        sendText(clave, contrasena);
    }

    public void escribirConfirmarContraseña(String clave) throws InterruptedException {
        sendText(clave, recontrasena);
    }

    public void quieroSubscribirme() throws InterruptedException{
        click(subscribirse);
    }

    public void acuerdoPoliticas() throws InterruptedException{
        click(politicas);
    }

    public void clickRegistrarse() throws InterruptedException {
        click(registrarseBtn);
    }

    public String obtenerMensajeExito() throws InterruptedException {
        System.out.println("Cuenta creada con exito: " + getText(exito));
        return this.getText(exito);
    }

}
