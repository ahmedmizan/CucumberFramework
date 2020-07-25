package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.FaceBookLendingPage;
import org.testng.Assert;

public class FaceBookSignUpSD {

    private FaceBookLendingPage fbLendingPage = new FaceBookLendingPage();

    @Given("^I am on facebook home page$")
    public void IAmOnFacebookHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Facebook - Log In or Sign Up");

    }
    @When("^I enter (.*) in name text field$")
    public void IEnterFirstNameInNameTextField(String firstName){
        fbLendingPage.enterFirstName(firstName);
    }
    @When("^I enter (.*) in text field$")
    public void IEnterLastNameInTextField(String lastName){
        fbLendingPage.enterLastname(lastName);
    }
    @When("^I enter (.*) in mobil no field$")
    public void IEnterMobileNumInMobilNoField(String mobile){
        fbLendingPage.enterMobileorEmail(mobile);
    }
    @When("^I enter (.*) in password field$")
    public void IEnterPasswordInPasswordField(String password){
        fbLendingPage.enterNewPassword(password);
    }
    @When("^I click on sign up button$")
    public void IClickOnSignUpButton(){
        fbLendingPage.clickSignUpButton();
    }
    @When("I select (.*) from month drop down, (.*) from date drop down and (.*) from year dropdown")
    public void ISelectAMonthfromMonthDropDown(String month,String dob, String year){
        fbLendingPage.selectDobMonth(month);
        fbLendingPage.selectDobDay(dob);
        fbLendingPage.selectDobYear(year);
    }
    @Then("^I receive a error msg$")
    public void IReceiveAErrorMsg(){
        String actualMsg=fbLendingPage.genderErrorMsg();
        String errorMsg = "Please choose a gender. You can change who can see this later.";
    }









}
