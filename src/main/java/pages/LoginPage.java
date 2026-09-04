package pages;
import org.openqa.selenium.*;import org.openqa.selenium.support.FindBy;
/** Login page actions and locators. */
public class LoginPage extends BasePage { @FindBy(id="user-name") private WebElement username; @FindBy(id="password") private WebElement password; @FindBy(id="login-button") private WebElement loginButton; @FindBy(css="h3[data-test='error']") private WebElement error;
  public LoginPage(WebDriver driver){ super(driver); }
  public DashboardPage loginAs(String user,String pass){ type(username,user,"Username"); type(password,pass,"Password"); click(loginButton,"Login button"); return new DashboardPage(driver); }
  public String errorMessage(){ return getText(error,"Login error"); }
}
