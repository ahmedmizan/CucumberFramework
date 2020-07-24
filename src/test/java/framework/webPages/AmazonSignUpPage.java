package framework.webPages;

import org.openqa.selenium.By;

public class AmazonSignUpPage extends BasePage {
    //    Locators
    private By seeMoreLink = By.xpath("//a[@aria-label='Low-price gifts - See more']");
    private By pageSignIn = By.className("nav-action-inner");
    private By emailInputBox = By.id("ap_email");
    private By continueButton = By.id("continue");
    private By errorMsg = By.className("a-list-item");
    private By clickLoginAndSecurity = By.className("ya-card-cell");
    private By createAccount = By.id("createAccountSubmit");
    private By enterFirstName = By.id("ap_customer_name");
    private By enterEmail = By.id("ap_email");
    private By enterPassword = By.id("ap_password");
    private By checkPassword = By.id("ap_password_check");
    private By clickOnAccount = By.className("a-button-input");
    private By errorMessage = By.className("a-alert-content");



    //    Method
    public void clickOnSeeMore(){
        waitForClickable(seeMoreLink);
        clickOn(seeMoreLink);
    }

    public  void signInPage(){
        clickOn(pageSignIn);
    }

    public void enterSignInEmail(String value){
        setValue(emailInputBox,value);
    }
    public void clickContinueButton(){
        clickOn(continueButton);
    }


    public void loginAndSecurity(){
        waitForClickable(clickLoginAndSecurity);
        clickOn(clickLoginAndSecurity);
    }
    public void clickOnCreateAccount(){
        waitForClickable(createAccount);
        clickOn(createAccount);
    }
    public void enterName(String value){
        setValue(enterFirstName,value);
    }
    public void enterPersonalEmail(String email){
        setValue(enterEmail,email);
    }
    public void enterUniquePassword(String password){
        setValue(enterPassword,password);
    }
    public void verifyPassword(String cofirmPassword){
        setValue(checkPassword,cofirmPassword);
    }
    public void createAccount(){
        waitForClickable(clickOnAccount);
        clickOn(clickOnAccount);
    }
//    public String errorMsgVerify(){
//        return getValue(errorMessage);
//    }

}
