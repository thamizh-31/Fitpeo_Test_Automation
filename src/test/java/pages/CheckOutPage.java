package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class CheckOutPage extends BaseClass {
	
	
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath = "(//span[@class='a-truncate-full a-offscreen'])[1]")
	private WebElement checkItem;

	@FindBy(name = "proceedToRetailCheckout")
	private WebElement proceedToCheckBtn;
	
	@FindBy(id="ap_email")
	private WebElement userNameTxt;
		
	@FindBy(id="continue")
	private WebElement clickContinueBtn;
	
	@FindBy(id="ap_password")
	private WebElement passInputTxt;
	

	public WebElement getCheckItem() {
		return checkItem;
	}

	public WebElement getProceedToCheckBtn() {
		return proceedToCheckBtn;
	}

	public WebElement getUserNameTxt() {
		return userNameTxt;
	}

	public WebElement getClickContinueBtn() {
		return clickContinueBtn;
	}

	public WebElement getPassInputTxt() {
		return passInputTxt;
	}

	public WebElement getClickSignInBtn() {
		return clickSignInBtn;
	}
	@FindBy(id="signInSubmit")
	private WebElement clickSignInBtn;
	
	public static final String UserName="+919361179271";
	public static final String Password="thamizh123";
	
}

