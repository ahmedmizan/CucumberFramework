package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.AmazonLandingPage;
import framework.webPages.AmazonSignUpPage;
import org.testng.Assert;

public class AmazonSignUpSD {
    private AmazonLandingPage lendingPage = new AmazonLandingPage();
    private AmazonSignUpPage signUpPage= new AmazonSignUpPage();

    @Given("^I am on amazon landing page$")
    public void IAmOnAmazonLendingPage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

    }
    @When("^I mouse over on sign in$")
    public void IMouseOverOnSignIn(){
        lendingPage.mouseOverOnSignIn();
    }
    @When("^I click on your account link$")
    public void IClickYourAccount(){
        lendingPage.clickOnYourAccount();

    }
    @When("^Click on login and security link$")
    public void ClickOnLoginAndSecurity(){
        signUpPage.loginAndSecurity();
    }
    @When("^I click on create your amazon account$")
    public void IClickCreateYourAmazonAccount() {
        signUpPage.clickOnCreateAccount();
    }

    @When("^Again click on create account$")
    public void AgainClickOnCreateAccount() {
        signUpPage.clickOnCreateAccount();

    }

    @When("^Enter (.*) into name field$")
    public void EnterTheFullName(String value) {
        signUpPage.enterName(value);
    }

    @When("^Enter (.*) into Email field$")
    public void EnterThePersonalEmail(String email) {
        signUpPage.enterPersonalEmail(email);
    }

    @When("^Enter (.*) into Password field$")
    public void EnterNewPassword(String password) {
        signUpPage.enterUniquePassword(password);
    }

    @When("^Enter (.*) into confirm Password field$")
    public void EnterConfirmPassword(String pass) {
        signUpPage.verifyPassword(pass);
    }

    @Then("^Click on create an account$")
    public void ClickOnCreateAccount() {
        signUpPage.createAccount();
    }


}
