package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HomePage;
import framework.webPages.MessengerLoginPage;
import framework.webPages.MessengerPage;
import org.testng.Assert;

public class MessengerSD {

    private HomePage homePage = new HomePage();
    private MessengerPage messengerPage = new MessengerPage();
    private MessengerLoginPage messengerLoginPage = new MessengerLoginPage();

    @Given("^I am on messenger page$")
    public void setMessengerPage() {
        homePage.clickOnMessengerLink();
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.messenger.com/");
    }

    //I enter mohammad@technosoft.io into username field on messenger page
    @When("^I enter(.+) into (username|password) field on messenger page$")
    public void dataIntoTextFields(String value,String textFields) {

        switch (textFields) {
            case "username":
                homePage.enterEmail( value );
                break;
            case "password":
                homePage.enterPassword( value );
                break;
        }
    }

        @And("^I click on signin button on messenger page$")
        public void clickOnSignInButton(){
                    homePage.clickOnLoginButton();

        }



        @Then( "^I verify invalid login message on signup page$" )
    public void verifyInvalidLoginMessage(){
        Assert.assertEquals( homePage.getErrorMessage(),"Incorrect Email" );
        }




}
