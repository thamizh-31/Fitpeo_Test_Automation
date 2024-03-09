package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class AddAddressPage extends BaseClass {
	
	
	public AddAddressPage() {
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath = "(//a[@id='add-new-address-popover-link'])")
		private WebElement addNewAddressBtn;

		@FindBy(xpath = "//input[@data-testid='Address_selectShipToThisAddress']")
		private WebElement useAddressClick;
		
		@FindBy(name="address-ui-widgets-enterAddressFullName")
		private WebElement fullNameTxt;
			
		@FindBy(name="address-ui-widgets-enterAddressPhoneNumber")
		private WebElement mobileNumber;
		
		@FindBy(name="address-ui-widgets-enterAddressPostalCode")
		private WebElement postalCodeTxt;
		
	

		@FindBy(name="address-ui-widgets-enterAddressLine1")
		private WebElement flatNoTxt;
		
		@FindBy(name="address-ui-widgets-enterAddressLine2")
		private WebElement areaLocatorTxt;
		
		@FindBy(name="address-ui-widgets-landmark")
		private WebElement landMarkLocatorTxt;
		
		@FindBy(name="address-ui-widgets-enterAddressCity")
		private WebElement cityLocatorTxt;
		
		@FindBy(xpath="//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
		private WebElement useThisAddressBtn;
		
		@FindBy(xpath="//span[text()='Credit or debit card']")
		private WebElement selectCardBtn;
		
		@FindBy(xpath="//h3[@class='a-spacing-base a-spacing-top-micro']")
		private WebElement orderSummary;
		
		@FindBy(xpath="(//input[@type='radio'])[4]")
		private WebElement selectAddress;
		
		
	
		public WebElement getAddNewAddressBtn() {
			return addNewAddressBtn;
		}
	

		public WebElement getUseAddressClick() {
			return useAddressClick;
		}

		

		public WebElement getFullNameTxt() {
			return fullNameTxt;
		}


		public WebElement getMobileNumber() {
			return mobileNumber;
		}


		public WebElement getPostalCodeTxt() {
			return postalCodeTxt;
		}


		public WebElement getFlatNoTxt() {
			return flatNoTxt;
		}

		public WebElement getAreaLocatorTxt() {
			return areaLocatorTxt;
		}


		public WebElement getLandMarkLocatorTxt() {
			return landMarkLocatorTxt;
		}


		public WebElement getCityLocatorTxt() {
			return cityLocatorTxt;
		}


		public WebElement getUseThisAddressBtn() {
			return useThisAddressBtn;
		}


		public WebElement getSelectCardBtn() {
			return selectCardBtn;
		}


		public WebElement getOrderSummary() {
			return orderSummary;
		}


		public WebElement getSelectAddress() {
			return selectAddress;
		}
	}	
	
		
	
