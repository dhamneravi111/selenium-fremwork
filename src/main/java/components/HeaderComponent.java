package components;
import org.openqa.selenium.*;import org.openqa.selenium.support.FindBy;import pages.BasePage;
public class HeaderComponent extends BasePage { @FindBy(css=".shopping_cart_link") private WebElement cart; @FindBy(id="react-burger-menu-btn") private WebElement menu; public HeaderComponent(WebDriver driver){ super(driver); } public void openMenu(){ click(menu,"Menu"); } public boolean isCartVisible(){ return isDisplayed(cart,"Cart"); } }
