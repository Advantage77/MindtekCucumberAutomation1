package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.EtsyAppHomePage;
import pages.EtsyAppSearchPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class EtsyAppSteps {
    WebDriver driver = Driver.getDriver();
    EtsyAppHomePage etsyAppHomePage = new EtsyAppHomePage();
    EtsyAppSearchPage etsyAppSearchPage = new EtsyAppSearchPage();

    @Given("user navigates to the Etsy application")
    public void user_navigates_to_the_Etsy_application() {
        driver.get(ConfigReader.getProperty("EtsyURL"));

    }

    @When("user searches for {string}")
    public void user_searches_for(String itemName) {
        etsyAppHomePage.searchBox.sendKeys(itemName + Keys.ENTER);

    }

    @When("user applies price filter over {int}")
    public void user_applies_price_filter_over(Integer price) {
        etsyAppSearchPage.allFilterButton.click();
        etsyAppSearchPage.priceRadioButton.click();
        etsyAppSearchPage.applyButton.click();

    }

    @Then("user validates the items price is equal or over {double}")
    public void user_validates_the_items_price_is_equal_or_over(Double price) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> prices = etsyAppSearchPage.prices;

        for (WebElement element : prices) { // it will loop as many times as the number of WebElement we have
            //      System.out.println(element.getText());
            String priceStr = element.getText().replace(",", ""); //"1,800.00"->"1800.00"
            double doublePrice = Double.parseDouble(priceStr);
            System.out.println(doublePrice);
            Assert.assertTrue(doublePrice >= price);

        }
    }

    @Then("user validates search result contain keyword {string} or{string}")
    public void userValidatesSearchResultContainKeywordOr(String item1, String item2) {
        List<WebElement> itemNames = etsyAppSearchPage.itemNames;
        for (int i = 0; i < itemNames.size(); i++) {
            String newItemNames = itemNames.get(i).getText();// looping through the list of WebElements and getting text from each WebElement
            boolean condition = newItemNames.toLowerCase().contains(item1) || newItemNames.toLowerCase().contains(item2);
            if (condition) {

                StringBuilder str = new StringBuilder(); // create an StringBuilder object
                str.append(newItemNames); // each time it will add one more string from newItemNames until the list of WebElements has elements

                System.out.println(str);
                Assert.assertTrue(str.toString().toLowerCase().contains(item1) || str.toString().toLowerCase().contains(item2));
            }
        }
    }

    @When("user clicks on {string} section")
    public void userClicksOnSection(String section) {
        if (section.equalsIgnoreCase("Mother's Day Gifts")) {
            etsyAppHomePage.mothersDayGift.click();
        } else if (section.equalsIgnoreCase("Jewelry and Accessories")) {
            etsyAppHomePage.jewelryAndAccessories.click();
        } else if (section.equalsIgnoreCase("Clothing and Shoes")) {
            etsyAppHomePage.clothingAndShoes.click();
        } else if (section.equalsIgnoreCase("Home and Living")) {
            etsyAppHomePage.homeAndLiving.click();
        } else if (section.equalsIgnoreCase("Wedding and Party")) {
            etsyAppHomePage.weddingAndParty.click();
        } else if (section.equalsIgnoreCase("Toys and Entertainment")) {
            etsyAppHomePage.toysAndEntertainment.click();
        } else if (section.equalsIgnoreCase("Art and Collectibles")) {
            etsyAppHomePage.artAndCollectibles.click();
        } else if (section.equalsIgnoreCase("Craft Supplies and Tools")) {
            etsyAppHomePage.craftAndSupplies.click();
        } else if (section.equalsIgnoreCase("Gifts and Gift Cards")) {
            etsyAppHomePage.giftsAbdGiftCards.click();
        }

    }

    @Then("user validates title is {string}")
    public void userValidatesTitleIs(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}