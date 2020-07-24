package framework.webPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import stepdefinition.SharedSD;

public class AmazonLandingPage extends BasePage {
    private By signInBox = By.id("nav-link-accountList");
    private By lowCostGiftLocator = By.xpath("//span[text()='Low-price gifts']");
    private By clickYourAccount = By.xpath("//span[text()='Your Account']");


    public void mouseOverOnSignIn(){
        waitTobeVisible(signInBox);
        mouseOver(signInBox);
    }

    public void verifyPageTitle(){
        String actualTitle =  SharedSD.getDriver().getTitle();
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public void mouseOverInTheMiddleOfPage(){
        // getXoffsetAndYoffset(lowCostGiftLocator);
        //mouseOver(49, 1861);
//            scrollDownOnPage(49,1861);
    }
    public void clickOnYourAccount(){
        waitForClickable(clickYourAccount);
        clickOn(clickYourAccount);
    }
























}
