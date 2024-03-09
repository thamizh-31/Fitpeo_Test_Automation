package org.fitpeo;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;

public class FitpeoAsses extends BaseClass {
	WebDriver driver;
	SelectProductPage selectProductPage;
	CheckOutPage checkOutPage;
	AddToCartPage addToCartPage;
	AddAddressPage addAddressPage;

	@Parameters("browser")
	@Test(priority = 1)

	// this method is to open the amazon web page
	public void validateURL(String browser) {
		driver = getDriver(browser);
		Assert.assertTrue(driver.getTitle().contains("Amazon"), "Homepage not loaded successfully");
	}

	@Parameters("browser")
	@Test(priority = 2)
	// To search the product and add to the cart
	public void searchAndAddToCart(String browser) throws InterruptedException {
		// Search for the product

		selectProductPage = new SelectProductPage();
		addToCartPage = new AddToCartPage();
		selectProductPage.getSearchInputTxt().sendKeys(SelectProductPage.ProductName);
		selectProductPage.getSearchInputTxt().submit();

		// Click on the first search result
		selectProductPage.getFirstResultClk().click();

		Set<String> ids = driver.getWindowHandles();
		java.util.Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);

		// Fetching the first product details

		String text = selectProductPage.getItemText().getText();

		System.out.println(text);
		
		addToCartPage.getAddToCartBtn().click();

		if (browser.equalsIgnoreCase("chrome")) {
			addToCartPage.getClickCartBtn().click();

		} else if (browser.equalsIgnoreCase("firefox")) {
			addToCartPage.getCartIconClk().click();

		}

	}

	@Test(priority = 3)
	// Proceed to checkout the cart with selected item
	public void proceedToCheckout() {
		checkOutPage = new CheckOutPage();
		// Navigate to the shopping cart page
		addToCartPage.getCartIconClk().click();
		checkOutPage.getProceedToCheckBtn().click();
	}

	@Test(priority = 4)
	// login into user account
	public void userAuthentication() {

		// Enter the login credentials and click continue
		checkOutPage.getUserNameTxt().sendKeys(CheckOutPage.UserName);
		checkOutPage.getClickContinueBtn().click();
		
		checkOutPage.getPassInputTxt().sendKeys(CheckOutPage.Password);
		checkOutPage.getClickSignInBtn().click();

	}

	@Parameters("browser")
	@Test(priority = 5)
	// To add the address for shipping
	public void ShippingInformation(String browser) throws AWTException, InterruptedException, IOException {
		addAddressPage = new AddAddressPage();
		// Enter valid shipping information
		if (browser.equalsIgnoreCase("chrome")) {

			addAddressPage.getAddNewAddressBtn().click();

			File f = new File(System.getProperty("user.dir") + "/Excel/Address.xlsx");
			FileInputStream file = new FileInputStream(f);
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet("Sheet1");
			Row row = sheet.getRow(1);

			String name = row.getCell(0).getStringCellValue();
			long mobile = (long) row.getCell(1).getNumericCellValue();
			String mobNo = String.valueOf(mobile);
			long postal = (long) row.getCell(2).getNumericCellValue();
			String postNo = String.valueOf(postal);
			long flat = (long) row.getCell(3).getNumericCellValue();
			String flatNo = String.valueOf(flat);
			long flat2 = (long) row.getCell(4).getNumericCellValue();
			String flatNo2 = String.valueOf(flat2);
			String street = row.getCell(5).getStringCellValue();
			String landMarkNear = row.getCell(6).getStringCellValue();
			String crctCity = row.getCell(7).getStringCellValue();


			addAddressPage.getFullNameTxt().sendKeys(name);

			addAddressPage.getMobileNumber().sendKeys(mobNo);

			addAddressPage.getPostalCodeTxt().clear();

			addAddressPage.getPostalCodeTxt().sendKeys(postNo);

			// 'yourAddress', 'yourCity', 'yourState', and 'yourZipCode' with actual
			// information

			if (browser.equalsIgnoreCase("chrome")) {
				addAddressPage.getFlatNoTxt().sendKeys(flatNo);
				
			} else if (browser.equalsIgnoreCase("firefox")) {
				addAddressPage.getFlatNoTxt().sendKeys(flatNo2);
			}

			addAddressPage.getAreaLocatorTxt().sendKeys(street);
			addAddressPage.getLandMarkLocatorTxt().sendKeys(landMarkNear);
			addAddressPage.getCityLocatorTxt().clear();
		

			addAddressPage.getCityLocatorTxt().sendKeys(crctCity);

			// click use this address
			addAddressPage.getUseThisAddressBtn().click();

		} else if (browser.equalsIgnoreCase("firefox")) {
			addAddressPage.getSelectAddress().click();
			addAddressPage.getUseAddressClick().click();

		}
	}

	@Test(priority = 6)
	// To select the payment method from the option
	public void PaymentInformation() {
		// Choose a payment method (credit card)
		addAddressPage.getSelectCardBtn().click();

	}

	@Test(priority = 7)
	// Verify the order summary
	public void ReviewOrder() {
		WebElement order = addAddressPage.getOrderSummary();
		Assert.assertTrue(order.isDisplayed(), "Order summary not displayed");
	}

}
