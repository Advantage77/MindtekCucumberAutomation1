package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PizzaAppPage {

    public PizzaAppPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="pizza1Pizza")
    public WebElement pizza1Box;

    @FindBy(className = "toppings1")
    public WebElement toppings1Box;

    @FindBy(className = "toppings2")
    public WebElement toppings2Box;

    @FindBy(id = "pizza1Qty")
    public WebElement pizza1QtyBox;

    @FindBy(id = "name")
    public WebElement nameBox;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "phone")
    public WebElement phoneBox;

    @FindBy(id="cashpayment")
    public WebElement cashPaymentRadio;

    @FindBy(id="ccpayment")
    public WebElement ccPaymentRadio;

    @FindBy(id="placeOrder")
    public WebElement placeOrderButton;

    @FindBy(id = "dialog")
    public WebElement dialogWindow;

    @FindBy(id="pizza1cost")
    public WebElement pizza1CostBox;

}
