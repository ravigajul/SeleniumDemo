import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtils {

    private WebDriver driver;
    private JavascriptExecutor js;

    public JSUtils(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    // Scroll into view
    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Click element
    public void clickElement(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    // Highlight element
    public void highlightElement(WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    // Get page title via JS
    public String getPageTitle() {
        return (String) js.executeScript("return document.title;");
    }
}
