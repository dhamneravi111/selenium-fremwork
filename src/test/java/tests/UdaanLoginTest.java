package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UdaanLoginPage;

public class UdaanLoginTest extends BaseTest {
	@Test(groups = { "regression", "udaan" })
	public void userCanLoginToUdaanWithOtp() {
		String mobileNumber = System.getProperty("udaan.mobile", "1110000001");
		String otp = System.getProperty("udaan.otp", "420995");

		UdaanLoginPage loginPage = new UdaanLoginPage(driver());
		loginPage.openFromHome();
		loginPage.submitMobileNumber(mobileNumber);
		loginPage.submitOtp(otp);

		Assert.assertTrue(loginPage.isLoginAttemptComplete(), "Udaan login flow should continue after OTP submission");
	}
}
