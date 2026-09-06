package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

import java.util.List;

public class UdaanLoginPage extends BasePage {
	private static final String HOME_URL = "https://udaan.com";
	private static final String LOGIN_URL = "https://auth.udaan.com/oauth2/v1/authorize?client_id=udaan-web"
			+ "&redirect_uri=https%3A%2F%2Fudaan.com%2Fauth%2Fcb&response_type=code&show_tnc=true";

	private final By mobileInput = By.xpath("//input[@type='tel' or @type='text' or @inputmode='numeric']");
	private final By continueButton = By.xpath("(//*[normalize-space()='Get Verification Code'"
			+ " or normalize-space()='Get Verification'"
			+ " or normalize-space()='Continue'"
			+ " or normalize-space()='Sign In'"
			+ " or normalize-space()='Login'])[last()]");
	private final By otpInputs = By.xpath("//input[@type='tel' or @type='text' or @inputmode='numeric' or @autocomplete='one-time-code']");
	private String otpPageUrl;

	public UdaanLoginPage(WebDriver driver) {
		super(driver);
	}

	public void openFromHome() {
		driver.get(HOME_URL);
		try {
			waitForElement(By.xpath(
					"//*[self::a or self::button or @role='button'][contains(.,'Login') or contains(.,'Sign in') or contains(.,'Register')]"))
					.click();
		} catch (Exception ignored) {
			driver.get(LOGIN_URL);
		}
	}

	public void submitMobileNumber(String mobileNumber) {
		WebElement input = waitForElement(mobileInput);
		type(input, mobileNumber, "Udaan mobile number");
		WebElement button = waitForElement(continueButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);
		clickClickableArea(button, "Udaan continue button");
		otpPageUrl = driver.getCurrentUrl();
	}

	public void submitOtp(String otp) {
		List<WebElement> inputs = WaitUtils.waitForAllVisible(otpInputs, 20);
		if (inputs.size() >= otp.length()) {
			for (int i = 0; i < otp.length(); i++) {
				inputs.get(i).sendKeys(String.valueOf(otp.charAt(i)));
			}
		} else {
			WebElement input = inputs.get(inputs.size() - 1);
			input.sendKeys(Keys.CONTROL, "a");
			input.sendKeys(otp);
		}
	}

	public boolean isLoginAttemptComplete() {
		String currentUrl = otpPageUrl == null ? driver.getCurrentUrl() : otpPageUrl;
		return WaitUtils.waitForUrlChangesFrom(currentUrl, 30) || driver.getPageSource().toLowerCase().contains("invalid")
				|| driver.getPageSource().toLowerCase().contains("incorrect");
	}

	private void clickClickableArea(WebElement element, String name) {
		try {
			click(element, name);
		} catch (Exception e) {
			log.info("Clicking {} with JavaScript fallback", name);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}
}
