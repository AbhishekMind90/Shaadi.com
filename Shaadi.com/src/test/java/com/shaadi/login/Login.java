package com.shaadi.login;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Login {

	public static AppiumDriver<MobileElement> driver;		
	@BeforeMethod
	public static void shaadiInstall() throws Exception {			
		DesiredCapabilities cap = new DesiredCapabilities();		
		cap.setJavascriptEnabled(true);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(MobileCapabilityType.UDID,"emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.0.0");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"AppiumAndroidDevice");	       
		cap.setCapability(MobileCapabilityType.APP,"Add apk path");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"120");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability("appActivity","");
		cap.setCapability("appPackage","com.shaadi.android");       
		URL url =new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,cap);	        
	}
	@Test
	public static void loginShaadiA() throws InterruptedException{	
		driver.findElement(By.id("com.shaadi.android:id/btn_morph_login")).click();
		driver.findElement(By.id("com.shaadi.android:id/edt_username")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("com.shaadi.android:id/edt_password")).sendKeys("1234567");
		driver.findElement(By.id("com.shaadi.android:id/btn_login")).click();
	}
	@Test
	public void navigatingToMyShaadiB() {
		driver.findElement(By.id("com.shaadi.android:id/menu_skip")).click(); //skipping update to premium ad
		driver.findElement(By.id("com.shaadi.android:id/rlMyShaadi")).click();
	}
	@Test
	public void varifyingWidgetC() {	
		MobileElement premiumMatches = driver.findElement(By.id("com.shaadi.android:id/tv_title"));
		boolean premiumM = premiumMatches.isDisplayed();
		Assert.assertEquals(premiumM, true);

		MobileElement newMatches = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView("
						+ "new UiSelector().textContains(\"New Matches\"));"));

		boolean newM = newMatches.isDisplayed();
		Assert.assertEquals(newM, true);
	}
	public void sendingConnectD() {
		driver.findElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout")).click();

		MobileElement newMatches = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView("
						+ "new UiSelector().textContains(\"New Matches\"));"));
		newMatches.click();
		driver.findElement(By.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout")).click();
	}
	@AfterMethod 
	public static void teardown() {
		/*driver.removeApp(""); */
	} 
}