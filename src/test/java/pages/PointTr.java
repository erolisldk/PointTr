package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class PointTr {

    public PointTr() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='hs-cta-wrapper']")
    public WebElement getStartedButton;


    @FindBy(xpath = "//a[@id='cta_button_5493376_c70fc929-fc65-425c-887d-d2835cd35180']")
    public WebElement talkToSalesButton;

    @FindBy(name = "firstname")
    public WebElement firstNameBox;
    @FindBy(xpath = "//a[@href='javascript:void(0);']")
    public WebElement acceptButton;
}