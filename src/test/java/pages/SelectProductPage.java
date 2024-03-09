package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class SelectProductPage extends BaseClass {
	

	public SelectProductPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchInputTxt;

	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement firstResultClk;
	
	@FindBy(xpath="//span[@id='productTitle']")
	private WebElement itemText;

	

	public WebElement getSearchInputTxt() {
		return searchInputTxt;
	}

	public WebElement getFirstResultClk() {
		return firstResultClk;
	}

	public WebElement getItemText() {
		return itemText;
	}
	public static final String ProductName="Acer Aspire 5 Gaming Laptop Intel Core i5 12th gen";
	public static final String URL="https://www.amazon.in/";
	
	}
