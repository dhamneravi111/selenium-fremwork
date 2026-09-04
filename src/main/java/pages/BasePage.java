package pages;
import config.ConfigReader;import org.apache.logging.log4j.*;import org.openqa.selenium.*;import org.openqa.selenium.support.PageFactory;import utils.WaitUtils;
/** Base class for all POM pages; wraps common actions with waits and logs. */
public abstract class BasePage { protected final WebDriver driver; protected final Logger log=LogManager.getLogger(getClass()); protected BasePage(WebDriver driver){ this.driver=driver; PageFactory.initElements(driver,this); }
  protected void click(WebElement e,String name){ log.info("Clicking {}",name); WaitUtils.waitForClickable(e).click(); }
  protected void type(WebElement e,String value,String name){ log.info("Typing into {}",name); WaitUtils.waitForClickable(e).clear(); e.sendKeys(value); }
  protected String getText(WebElement e,String name){ log.info("Reading text from {}",name); return WaitUtils.waitForClickable(e).getText(); }
  protected boolean isDisplayed(WebElement e,String name){ try{ boolean b=e.isDisplayed(); log.info("{} displayed: {}",name,b); return b;}catch(NoSuchElementException ex){ return false; } }
  protected WebElement waitForElement(By locator){ return WaitUtils.waitForVisible(locator, ConfigReader.getInstance().getInt("timeout.seconds",15)); }
  public String title(){ return driver.getTitle(); } public String currentUrl(){ return driver.getCurrentUrl(); }
}
