package base;
import config.ConfigReader;import java.nio.file.Path;
/** Browser run settings resolved from config, JVM args, or environment variables. */
public record BrowserConfig(String browser, boolean headless, boolean remote, String remoteUrl, String baseUrl, int timeout, Path downloadDir, String windowSize){
  public static BrowserConfig fromConfig(){ ConfigReader c=ConfigReader.getInstance(); return new BrowserConfig(c.get("browser","chrome"), c.getBoolean("headless"), c.getBoolean("remote"), c.get("remote.url"), c.get("base.url"), c.getInt("timeout.seconds",15), Path.of(c.get("download.dir","target/downloads")), c.get("window.size","1920,1080")); }
}
