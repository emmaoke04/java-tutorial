




import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Random;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import pageObjects.AddNewAddressPage;
import pageObjects.BeautyCarePage;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConsultPage;
import pageObjects.HomePage;
import pageObjects.NewUserCompOrderPage;
import pageObjects.OnboardingPage;
import pageObjects.SetAccountPage;

public class NewCustomerLoginTest extends ScriptDependency {
	
	@Test
	public void NewCustomerSignUp() throws MalformedURLException, InterruptedException {
	
		
		service = startServer();

		IOSDriver driver = DesiredCapabilities();
		


		


		HashMap<String, Object> scrollObject = new HashMap<>();

		scrollObject.put("direction", "down");

		scrollObject.put("name", "ORDER NOW");
		
		OnboardingPage OnboardingPage = new OnboardingPage(driver);

		OnboardingPage.startNow.click();

		OnboardingPage.allow.click();

		OnboardingPage.zipCodeField.sendKeys("00000");

		OnboardingPage.confirmZipCod.click();
		//Thread.sleep(5000);
		
		

		HomePage HomePage = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeImage[@name='categoryImage_1']")));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("xbeautyCareCategory")));
		
		//xbeautyCareCategory       
		//@iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[@value='9']")
		
		
	
		HomePage.beautyCareCategory.click();
		//Thread.sleep(2000);

		
		BeautyCarePage BeautyCarePage = new BeautyCarePage(driver);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeImage[@name='categoryImage_2']")));

		BeautyCarePage.hairCategory.click();
		//Thread.sleep(2000);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name='AddtoCart_0']")));
		driver.findElementByAccessibilityId("AddtoCart_0").click();
		//Thread.sleep(2000);
		
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name='AddtoCart_1']")));
		driver.findElementByAccessibilityId("AddtoCart_1").click();
		//Thread.sleep(2000);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name='AddtoCart_2']")));
		driver.findElementByAccessibilityId("AddtoCart_2").click();
		//Thread.sleep(2000);
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name='Cart']")));
		HomePage.cartButton.click();
		//Thread.sleep(2000);

		CartPage CartPage = new CartPage(driver);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeStaticText[@name='CHECKOUT']")));

		CartPage.checkoutButton.click();
		//Thread.sleep(2000);

		MobileElement e = (MobileElement) driver.findElementByAccessibilityId("childSwitch");

		IOSTouchAction touch = new IOSTouchAction(driver);

		touch.longPress(longPressOptions().withElement(element(e)).withDuration(ofSeconds(1))).release().perform();
		Thread.sleep(3000);

		ConsultPage ConsultPage = new ConsultPage(driver);

		ConsultPage.childAgePicker.sendKeys("5");

		ConsultPage.questionInputField.sendKeys("no question");

		driver.findElementByName("Done").click();

		ConsultPage.nextButton.click();
		Thread.sleep(3000);

		NewUserCompOrderPage CompOrderPage = new NewUserCompOrderPage(driver);
		CompOrderPage.mobileNoInput.sendKeys(generateNumber().toString());
		Thread.sleep(1000);

		CompOrderPage.enterNext.click();
		Thread.sleep(5000);
		CompOrderPage.enterOTP.sendKeys("0000");
		Thread.sleep(1000);

		SetAccountPage SetAccountPage = new SetAccountPage(driver);
		SetAccountPage.firstName.sendKeys("MAYD");
		SetAccountPage.lastName.sendKeys("Customer-App");
		SetAccountPage.email.sendKeys("testing@gmail.com");
		ConsultPage.nextButton.click();
		Thread.sleep(2000);

		CheckoutPage CheckoutPage = new CheckoutPage(driver);
		CheckoutPage.addAddressButton.click();
		Thread.sleep(1000);

		AddNewAddressPage AddNewAddressPage = new AddNewAddressPage(driver);

		PointOption pointOption = new PointOption().withCoordinates(105, 223);
		new TouchAction(driver).tap(pointOption).perform();
		Thread.sleep(1000);

		AddNewAddressPage.inputAddress.sendKeys("alexanderstraße5");
		Thread.sleep(2000);

		if (AddNewAddressPage.Alexanderstraße5.isDisplayed()) 
		{
			AddNewAddressPage.Alexanderstraße5.click();
			Thread.sleep(9000);
		}

		
		AddNewAddressPage.additionalAddInfo.sendKeys("4th floor");

		AddNewAddressPage.next.click();
		
		AddNewAddressPage.clickDone.click();
		
		driver.findElementByAccessibilityId("paymentMethodButton").click();

		driver.findElementByAccessibilityId("addCreditCardButton").click();

		driver.findElementByAccessibilityId("cardNumberFieldView").sendKeys("4242424242424242");

		driver.findElementByAccessibilityId("expiryDateNumberFieldView").sendKeys("0123");

		driver.findElementByAccessibilityId("cvcOrCvvTextFieldView").sendKeys("123");

		driver.findElementByName("Done").click();

		driver.findElementByAccessibilityId("SAVE AND APPLY").click();

		Thread.sleep(7000);

		driver.executeScript("mobile:scroll", scrollObject);

		driver.findElementByAccessibilityId("ORDER NOW").click();
		Thread.sleep(3000);

		driver.findElementByName("Proceed").click();
		
		service.stop();


	}

	public Integer generateNumber() {
		Random rand = new Random();
		return rand.nextInt(9999999);
	}

}
