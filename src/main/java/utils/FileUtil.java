package utils;
import java.nio.file.*;import java.time.Duration;
public final class FileUtil { private FileUtil(){} public static void upload(org.openqa.selenium.WebElement input, Path file){ input.sendKeys(file.toAbsolutePath().toString()); } public static boolean isDownloaded(Path dir,String fileName,Duration timeout){ long end=System.currentTimeMillis()+timeout.toMillis(); while(System.currentTimeMillis()<end){ if(Files.exists(dir.resolve(fileName))) return true; WaitUtils.pauseForDebugOnly(250); } return false; } }
