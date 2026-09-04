package base;
import config.ConfigReader;import listeners.TestListener;import org.apache.logging.log4j.*;import org.openqa.selenium.WebDriver;import org.testng.annotations.*;
@Listeners(TestListener.class)
public abstract class BaseTest { protected final Logger log=LogManager.getLogger(getClass());
  @BeforeMethod(alwaysRun=true) public void setUp(){ WebDriver driver=DriverFactory.createDriver(); DriverManager.setDriver(driver); driver.manage().window().maximize(); log.info("Navigating to {}", ConfigReader.getInstance().get("base.url")); driver.get(ConfigReader.getInstance().get("base.url")); }
  @AfterMethod(alwaysRun=true) public void tearDown(){ DriverManager.quitDriver(); }
  protected WebDriver driver(){ return DriverManager.getDriver(); }
}
