//package stepdefinition;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import framework.webPages.FaceBookLendingPage;
//import framework.webPages.HomePage;
//import framework.webPages.LoginPage;
//import org.testng.Assert;
//
//
//public class LoginSD {

//    private HomePage homePage = new HomePage();
//    private FaceBookLendingPage homePage = new FaceBookLendingPage();
//
//    private LoginPage loginPage = new LoginPage();
//
//    @Given("^I am on home page$")
//    public void iAmOnHomePage() {
//        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Facebook - Log In or Sign Up");
//    }
//
//    @When("^I enter (.+) into (username|password) text fields on home screen$")
//    public void enterDataIntoTextFields(String value, String textFields) {
//
//        switch (textFields) {
//            case "username":
//                homePage.enterEmail(value);
//                break;
//            case "password":
//                homePage.enterPassword(value);
//                break;
//        }
//    }
//
//    @When("^I click on (login|submit) button on home screen$")
//    public void clickOnLoginButton(String button) {
//
//        switch (button) {
//            case "login":
//                homePage.clickLoginButton();
//                break;
//            case "submit":
//                //Implement Create account object
//                break;
//        }
//    }
//
//    @Then("^I verify that i am on invalid login page$")
//    public void verifyInvalidLoginPage() {
//        Assert.assertEquals(loginPage.getPageHeader(), "Log Into Facebook");
//    }

//}
