package components;
import org.openqa.selenium.*;import org.openqa.selenium.support.FindBy;import pages.BasePage;
public class ModalComponent extends BasePage { @FindBy(css=".modal") private WebElement modal; @FindBy(css=".modal .close") private WebElement close; public ModalComponent(WebDriver driver){ super(driver); } public boolean visible(){ return isDisplayed(modal,"Modal"); } public void close(){ click(close,"Modal close"); } }
