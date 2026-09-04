package utils;
import base.DriverManager;import config.ConfigReader;import org.openqa.selenium.*;import org.openqa.selenium.support.ui.*;import java.time.Duration;
/** Centralized explicit waits. Thread.sleep is isolated in pauseForDebugOnly. */
public final class WaitUtils { private WaitUtils(){} private static WebDriverWait wait(int sec){ return new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(sec)); }
  public static WebElement waitForVisible(By locator,int timeoutSeconds){ return wait(timeoutSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator)); }
  public static WebElement waitForClickable(WebElement element){ return wait(ConfigReader.getInstance().getInt("timeout.seconds",15)).until(ExpectedConditions.elementToBeClickable(element)); }
  public static Boolean waitForTextPresent(By locator,String text){ return wait(ConfigReader.getInstance().getInt("timeout.seconds",15)).until(ExpectedConditions.textToBePresentInElementLocated(locator,text)); }
  public static Boolean waitForUrlContains(String partialUrl){ return wait(ConfigReader.getInstance().getInt("timeout.seconds",15)).until(ExpectedConditions.urlContains(partialUrl)); }
  public static Boolean waitForAjax(){ WebDriver d=DriverManager.getDriver(); return wait(ConfigReader.getInstance().getInt("timeout.seconds",15)).until(x -> Boolean.TRUE.equals(((JavascriptExecutor)d).executeScript("return window.jQuery ? jQuery.active === 0 : true"))); }
  public static void pauseForDebugOnly(long millis){ try{ Thread.sleep(millis); }catch(InterruptedException e){ Thread.currentThread().interrupt(); } }
}
