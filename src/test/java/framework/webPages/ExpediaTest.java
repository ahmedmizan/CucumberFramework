package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.List;

public class ExpediaTest extends BasePage{

    private By destinationField = By.id("hotel-destination-hp-hotel");
    private By listOfSuggestions = By.xpath("//div[@class='multiLineDisplay details']//strong");
    private By calanderDates = By.xpath("//button[@class='datepicker-cal-date']");
    private By flightOption = By.id("tab-flight-tab-hp");
    private By tripType = By.id("flight-type-one-way-label-hp-flight");

    public void writeDestination(String text){
        setValue(destinationField, text);
    }

    public void seletFromSuggestionList(String value){
        List<WebElement> cities = new ArrayList<>();
        cities = SharedSD.getDriver().findElements(listOfSuggestions);

        for (WebElement city: cities ){
            if(city.getText().toLowerCase().contains(value.toLowerCase())){
                city.click();
                break;
            }
        }
    }

    public void selectDate(String expextedDate){
        List<WebElement> dates = new ArrayList<>();
        dates = SharedSD.getDriver().findElements(calanderDates);

        for (WebElement date : dates){
            if(date.getText().contains(expextedDate)){
                date.click();
                break;
            }
        }
    }
    public void clickOnFlight(){
        clickOn(flightOption);
    }
    public void selectTrip(){
        clickOn(tripType);
    }




}
