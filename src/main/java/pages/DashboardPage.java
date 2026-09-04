package pages;
import org.openqa.selenium.*;import org.openqa.selenium.support.FindBy;import java.util.List;
public class DashboardPage extends BasePage { @FindBy(css=".title") private WebElement pageTitle; @FindBy(css=".inventory_item") private List<WebElement> items; @FindBy(css=".shopping_cart_link") private WebElement cartIcon;
  public DashboardPage(WebDriver driver){ super(driver); }
  public String heading(){ return getText(pageTitle,"Dashboard title"); } public int productCount(){ return items.size(); } public boolean cartVisible(){ return isDisplayed(cartIcon,"Cart icon"); }
}
