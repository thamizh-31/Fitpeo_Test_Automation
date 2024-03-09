package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class AddToCartPage extends BaseClass {

	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")
	private WebElement clickCartBtn;
	
	@FindBy(xpath="//a[@href='https://www.amazon.in/gp/cart/view.html?ref_=nav_cart']")
	private WebElement cartIconClk;

	

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getClickCartBtn() {
		return clickCartBtn;
	}

	public WebElement getCartIconClk() {
		return cartIconClk;
	}
}
