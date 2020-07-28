package stepdefinition;

import cucumber.api.java.en.When;
import framework.webPages.ExpediaTest;

public class ExpediaSD {

    ExpediaTest expedia = new ExpediaTest();

    @When("^I write (.*) into Destination field$")
    public void writeIntoDestinationField(String value){
        expedia.writeDestination(value);
    }

    @When("^I select (.*) from suggestion list$")
    public void selectFromSuggestionList(String city){
        expedia.seletFromSuggestionList(city);
    }

}
