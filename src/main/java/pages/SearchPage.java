package pages;
import org.openqa.selenium.*;import org.openqa.selenium.support.FindBy;
public class SearchPage extends BasePage { @FindBy(css="input[type='search'], input[name='q']") private WebElement searchInput; @FindBy(css="button[type='submit']") private WebElement searchButton; @FindBy(css=".result-count") private WebElement resultCount;
  public SearchPage(WebDriver driver){ super(driver); } public SearchPage search(String term){ type(searchInput,term,"Search input"); click(searchButton,"Search button"); return this; } public String resultCountText(){ return getText(resultCount,"Result count"); }
}
