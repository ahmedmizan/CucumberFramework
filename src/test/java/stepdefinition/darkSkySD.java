package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyHomePage;
import org.testng.Assert;

public class darkSkySD {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given( "^I am on darkSky home page$" )
    public void iAmOnDarkSkyHomePage(){
        Assert.assertEquals( SharedSD.getDriver().getTitle(),"Dark Sky - 260 Broadway, New York City, NY","invalid homepage" );
    }





    @Given( "^I am on the darkSky Register page$" )
    public void iAmOnDarkSkyRegisterPage(){
        darkSkyHomePage.clickOnDarkSkyApi();
        darkSkyHomePage.clickOnSignUpButton();
    }
    @When( "^I click on Register button$" )
    public void iClickOnRegisterButton(){
        darkSkyHomePage.clickOnRegisterButton();
    }
    @Then( "^I verify error message \"I am on register page\"$" )
    public void iVerifyErrorMessege(){
        Assert.assertEquals( SharedSD.getDriver().getTitle(),"Dark Sky API: Register" );
    }







    @Given( "^I am on DarkSky home page$" )
    public void DarkSkyHomePage(){
        Assert.assertEquals( SharedSD.getDriver().getTitle(),"Dark Sky - 260 Broadway, New York City, NY","invalid homepage" );
    }

    @Then( "^I verify timeline is displayed with two hours incremented$" )
    public void verifyTimelineDisplayedWithTwoHoursIncremented(){
       Assert.assertEquals( darkSkyHomePage.systemTimes(),darkSkyHomePage.timelineTimes(),"timeline is not displayed with two hours incremented" );

    }






    @Given( "^I am on Darksky Home Page$" )
    public void darkSkyHomePage(){
        Assert.assertEquals( SharedSD.getDriver().getTitle(),"Dark Sky - 260 Broadway, New York City, NY","invalid homepage" );
    }

    @Then( "^I verify current temp is not greater or less then temps from daily timeline$" )
    public void currentTempsIsNotGreaterOrLessThanDailyTem(){
        darkSkyHomePage.currentTempBetweenHighAndLow();
    }





    @When( "^I expand todays timeline$" )
    public void expendTodaysTimeline()throws InterruptedException{
        darkSkyHomePage.clickOnTodaysTimeline();
    }

    @Then( "^I verify lowest and highest temp is displayed correctly$" )
    public void verifyLowestHighestTempDiplayedCorrectly(){
        String lowestToday = darkSkyHomePage.getTodaysLowestTemp();
        String higestToday = darkSkyHomePage.getTodaysHighestTemp();
        String lowestTimeline = darkSkyHomePage.getLowestTemperatureTimeline();
        String highestTimeline = darkSkyHomePage.getHigestTempTimeline();

        Assert.assertEquals( lowestToday,lowestTimeline,"should be display correctly" );
        Assert.assertEquals( higestToday,highestTimeline,"should be display correctly" );

    }










}
