import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
    private final By searchPhone = By.xpath("//*[@id=\"search\"]/input");
    private final By searchBtn = By.xpath("//*[@id=\"search\"]/span/button");

    private final By searchMsj = By.xpath("//*[@id=\"content\"]/h1");

    private final By iphoneImg = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a");
    private final By carritoBtn = By.xpath("//*[@id=\"button-cart\"]");
    private final By addMsj = By.xpath("//*[@id=\"product-product\"]/div[1]");
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void seleccionarItem(String item) throws InterruptedException {
        Thread.sleep(1000);
        this.sendText(item, searchPhone);
        this.sendKey(Keys.ENTER, searchPhone);
    }

    public void anadirCesta () throws InterruptedException{
        Thread.sleep(1000);
        this.click(carritoBtn);
    }
    public void clickBuscar() throws InterruptedException {
        Thread.sleep(1000);
        this.click(searchBtn);
    }
    public String obtenerRecomendacion() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("RESULTADO DE LA BUSQUEDA: " + this.getText(searchMsj));
        return this.getText(searchMsj);
    }
    public void clickEnIphone () throws InterruptedException{
        Thread.sleep(1000);
        this.click(iphoneImg);
    }
    public String obtenerMsjCarrito() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-product\"]/div[1]")));
        System.out.println("RESULTADO DE AGREGAR A CARRITO " + this.getText(addMsj));
        return this.getText(addMsj);
    }
}
