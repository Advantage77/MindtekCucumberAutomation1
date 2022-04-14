package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyAppSearchPage {

    public EtsyAppSearchPage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);

    }
    @FindBy(id="search-filter-button")
    public WebElement allFilterButton;

    @FindBy(xpath = "//label[@for='price-input-4']")
    public WebElement priceRadioButton;

    @FindBy(xpath = "//button[@class='wt-btn wt-btn--primary wt-width-full wt-mt-xs-3 wt-mb-xs-3 wt-mr-xs-3']")
    public WebElement applyButton;

    @FindBy(xpath = "//p[@class='wt-text-title-01']//span[@class='currency-value']")
    public List<WebElement> prices;

    @FindBy(xpath = "//div[@class='wt-bg-white wt-display-block wt-pb-xs-2 wt-mt-xs-0']//div//h3")
    public List<WebElement> itemNames;
}
