package framework.webPages;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class FaceBookLendingPage extends BasePage {
    //Locators
    private By emailTextField = By.id("email");
    private By passTextField = By.id("pass");
    private By loginButton = By.id("u_0_b");

    private By firstname = By.xpath("//input[@name='firstname']");
    private By lastname = By.xpath("//input[@name='lastname']");
    private By mobileNum = By.xpath("//input[@name='reg_email__']");
    private By newPass = By.xpath("//input[@name='reg_passwd__']");
    private By submitButton = By.xpath("//button[@name='websubmit']");
    private By genderError = By.xpath("//div[starts-with(text(),'Please choose a gender')]");
    private By messengerLink = By.linkText("Messenger");
    private By maleLocator = By.xpath("//input[@type='radio' and @value='2']");
    private By monthDropdown = By.id("month");
    private By dayDropdown = By.name("birthday_day");
    private By yearDropdown = By.name("birthday_year");



    //Methods
    public void enterEmail(String value){
        setValue(emailTextField, value);
    }

    public void enterPassword(String value) {

        setValue(passTextField, value);
    }

    public void clickLoginButton() {
        waitForClickable(loginButton);
        clickOn(loginButton);
    }
    @Step
    public void enterFirstName(String userFname) {
        waitTobeVisible(firstname);
        setValue(firstname, userFname);
    }
    @Step
    public void enterLastname(String userLname) {
        waitTobeVisible(lastname);
        setValue(lastname, userLname);
    }
    @Step
    public void enterMobileorEmail(String userMobileorEmail) {
        waitTobeVisible(mobileNum);
        setValue(mobileNum, userMobileorEmail);
    }
    @Step
    public void enterNewPassword(String userNewPassword) {
        waitTobeVisible(newPass);
        setValue(newPass, userNewPassword);
    }
    @Step
    public void clickSignUpButton() {
        waitForClickable(submitButton);
        clickOn(submitButton);
    }
    @Step
    public String genderErrorMsg(){
        waitTobeVisible(genderError);
        return getTextFromElement(genderError);
    }
    @Step
    public void selectDobMonth(String month){
        selectFromDropdown(monthDropdown, month);
    }
    @Step
    public void selectDobDay(String day){
        selectFromDropdown(dayDropdown,day);
    }
    @Step
    public void selectDobYear(String year){
        selectFromDropdown(yearDropdown,year);
    }




}
