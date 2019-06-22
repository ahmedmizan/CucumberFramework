package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.BookingHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class BookingSD {

    private BookingHomePage bookingHomePage = new BookingHomePage();

    @Given( "^I am on booking home page$" )
    public void IAmOnHomePage(){
        Assert.assertEquals( SharedSD.getDriver().getTitle(),"Booking.com: 28,713,914 hotel and property listings worldwide. 182+ million hotel reviews.","Invalid home page");
    }

    @When( "^I click on select your language$" )
    public void clickOnLanguageButton(){
        bookingHomePage.clickOnLanguageButton();
    }

    @When( "^I select English-US from the language list$" )
    public void selectEnglishFromList(){
        bookingHomePage.selectCountry();
    }

    @When( "^I enter Texas into Where are you going text Field and I select Houston, Texas, United States of America from list$" )
    public void enterTexasInWhereToGo(){
        bookingHomePage.WhereToGo();
    }

    @When( "^I click on calendar$" )
    public void clickOnCalendar(){
        bookingHomePage.clickOnCalendar();
    }

    @When( "^I click on check-in$" )
    public void clickOnCheckIn(){
        bookingHomePage.selectCheckInDate();
    }
    @When( "^I click on check-out date$" )
    public void clickOnCheckOut(){
        bookingHomePage.selectCheckOutDate();
    }

    @When( "^I click on adultsChildrenRoomsButton$" )
    public void clickOnAdultsChildrenRoomsButton(){
        bookingHomePage.clickOnAdultsChildrenRoomsButtonDropDownButton();
    }

    @When( "^I select 4 adults by clickin on adults$" )
    public void selectAdults(){
        bookingHomePage.selectAdultNumber();
    }
    @When( "^I select 3 children by clicking on Children$" )
    public void selectChildren(){
        bookingHomePage.selectChildrenNumber();
    }

    @Then( "^I Verify there are 5 dropdown displayed for age at checkout$" )
    public void verifyDropDownDisplayNumber(){
        List<WebElement> actualChildrenNumber = SharedSD.getDriver().findElements( By.xpath( "//option[contains(text(),'Age at check-out')]" ) );
        System.out.println(actualChildrenNumber.size());
        Assert.assertEquals( actualChildrenNumber.size(),3 );

    }







}
