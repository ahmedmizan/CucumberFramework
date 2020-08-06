package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import framework.webPages.HotelTest;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class HotelBookingSD {
    HotelTest hotel = new HotelTest();
    @Given("^I am on hotels landing page$")
    public void iAmOnHotelsLandingPage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations");

    }
    @When("^I select (.*) as destination$")
    public void iSelectAnyPlaceNameAsDestination(String place){
        hotel.selectDestination(place);

    }
    @When("^I enter tomorrow as check in date$")
    public void iEnterTomorrowAsCheckInDate(){

    }
    @When("^I enter 4 days from tomorrow as checkout date$")
    public void iEnter4DaysFromTomorrowAsCheckoutDate(){

    }
    @T






















}
