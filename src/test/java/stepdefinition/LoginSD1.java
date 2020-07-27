package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.FaceBookLendingPage;
import framework.webPages.LoginPage;
import org.testng.Assert;

public class LoginSD1 {

//    private HomePage homePage = new HomePage();
    private FaceBookLendingPage homePage = new FaceBookLendingPage();
    private LoginPage loginPage = new LoginPage();

    @Given("^I am on home page$")
    public void iAmOnHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Facebook - Log In or Sign Up");
    }

    @When("^I enter(.*)into user name text fields on home screen$")
    public void IEnterEmailIntoUsernameTextFieldsOnHomeScreen(String value) {
       homePage.enterEmail(value);

    }
    @When("^I enter(.*) into text fields on home screen$")
    public void IEnterPasswordIntoPasswordTextFieldsOnHomeScreen(String value){
      homePage.enterPassword(value);
    }



    @When("^I click on (.*) button on home screen$")
    public void clickOnLoginButton(String button) {
        homePage.clickLoginButton();

    }
    @Then("^I verify that i am on invalid login page$")
     public void verifyInvalidLoginPage() {
        Assert.assertEquals(loginPage.getPageHeader(), "The email you’ve entered doesn’t match any account. Sign up for an account.");
    }









}
