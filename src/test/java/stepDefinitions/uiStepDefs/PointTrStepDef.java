package stepDefinitions.uiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import pages.PointTr;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class PointTrStepDef {
    PointTr pointTr = new PointTr();
    Faker faker = new Faker();


    @Given("User goes to {string}")
    public void userGoesTo(String arg0) {
        Driver.getDriver().get(ConfigReader.getProperty("pointTrUrl"));
        ReusableMethods.waitFor(3);
    }

    @And("User clicks to get started button")
    public void userClicksToGetStartedButton() {
        pointTr.getStartedButton.click();

    }

    @And("User clicks talk to sales button")
    public void userClicksTalkToSalesButton() {
        pointTr.talkToSalesButton.click();
    }

    @And("USer enters first name, last name, email, country,company name, web site url informations")
    public void userEntersFirstNameLastNameEmailCountryCompanyNameWebSiteUrlInformations() {
        pointTr.firstNameBox.sendKeys(faker.address().firstName(), Keys.TAB, faker.address().lastName());
        ReusableMethods.waitFor(5);
    }

    @And("User accepts to cookies")
    public void userAcceptsToCookies() {
        ReusableMethods.jsExecutorClick(pointTr.acceptButton);
    }
}
