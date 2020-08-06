package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.List;

public class HotelTest extends BasePage {
    private By destinationField = By.id("qf-0q-destination");
    private By listOfDestination = By.xpath("//div[@class='widget-query-group widget-query-dates']");
    private By checkInField = By.id("qf-0q-localised-check-in");
    private By selectInDate = By.xpath("//td[@class='widget-datepicker-selected widget-datepicker-highlight']");








    public void destinationTextField(String place){
        setValue(destinationField,place);
    }
    public void selectDestination(String text){
        List<WebElement>placeOfFlorida = new ArrayList<>();
        placeOfFlorida= SharedSD.getDriver().findElements(listOfDestination);
        for (WebElement place:placeOfFlorida){
           if(place.getText().toLowerCase().contains(text.toLowerCase())) {
               place.click();
               break;
           }
        }
    }
    public void checkInDate( String value){
        clickOn(checkInField);
    }
    public void fixedDate(){
        clickOn(selectInDate);
    }




}
