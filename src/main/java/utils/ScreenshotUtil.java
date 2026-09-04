package utils;
import base.DriverManager;import constants.FrameworkConstants;import org.openqa.selenium.*;import java.io.File;import java.nio.file.*;
public final class ScreenshotUtil { private ScreenshotUtil(){}
 public static String takeFullPageScreenshot(String name){ try{ Files.createDirectories(Path.of(FrameworkConstants.SCREENSHOT_DIR)); File src=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE); Path dest=Path.of(FrameworkConstants.SCREENSHOT_DIR,name+"-"+DateTimeUtil.timestamp()+".png"); Files.copy(src.toPath(),dest,StandardCopyOption.REPLACE_EXISTING); return dest.toString(); }catch(Exception e){ throw new RuntimeException(e);} }
 public static String takeElementScreenshot(WebElement element,String name){ try{ Files.createDirectories(Path.of(FrameworkConstants.SCREENSHOT_DIR)); File src=element.getScreenshotAs(OutputType.FILE); Path dest=Path.of(FrameworkConstants.SCREENSHOT_DIR,name+"-element-"+DateTimeUtil.timestamp()+".png"); Files.copy(src.toPath(),dest,StandardCopyOption.REPLACE_EXISTING); return dest.toString(); }catch(Exception e){ throw new RuntimeException(e);} }
}
