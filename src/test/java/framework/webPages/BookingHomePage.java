package framework.webPages;

import org.openqa.selenium.By;
import stepdefinition.SharedSD;

public class BookingHomePage extends BasePage{

    private By languageButton = By.xpath( "//a[@data-title='Select your language']" );
    private By allLanguage = By.xpath( "//div[@class='select_foldout_wrap']//li" );
    private By destinationField = By.xpath( "//input[@id='ss']" );
    // private By suggestedCities = By.xpath( "//ul[@class='c-autocomplete__list sb-autocomplete__list sb-autocomplete__list-with_photos -visible']//li" );
    private By suggestedCities = By.xpath( "//ul[@class='c-autocomplete__list sb-autocomplete__list sb-autocomplete__list-with_photos -visible']//li" );
    private By calendar = By.xpath( "//div[contains(@class,'xp__dates-inner xp__dates__checkin')]//*[contains(@class,'bk-icon -experiments-calendar sb-date-picker_icon-svg')]" );
    //private By monthName = By.xpath( "//div[contains(text(),'June 2019')]" );
    private By monthName = By.xpath( "//*[@id='frm']/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/div" );
    private By arraySign = By.xpath( "//body[@id='b2indexPage']/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/*[1]" );

    String checkInDay = "31";
    String checkOutDay = "7";
    private By allDays = By.xpath( "//div[contains(@class,'bui-calendar__main')]//div[1]//table[1]//tbody[1]//tr//td[contains(text()," + checkInDay + ")]" );
    private By allDays1 = By.xpath( "//div[contains(@class,'bui-calendar__main')]//div[1]//table[1]//tbody[1]//tr//td[contains(text()," + checkOutDay + ")]" );
    private By dropDownButton = By.xpath( "//div[@class='xp__input-group xp__guests']" );
    private By plusButtonForAdult = By.xpath( "//div[@class='sb-group__field sb-group__field-adults']//span[@class='bui-button__text'][contains(text(),'+')]" );
    private By childrenButton = By.xpath( "//div[contains(@class,'sb-group__field sb-group-children')]//span[@class='bui-button__text'][contains(text(),'+')]" );
    private By roomsButton = By.xpath( "//div[@class='sb-group__field sb-group__field-rooms']//span[@class='bui-button__text'][contains(text(),'+')]" );


    private By adultsText = By.xpath( "//*[@id='frm']/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/span" );
    String expectedAdult = "4";
    private By expectedAdultsText = By.xpath( "//*[@id='frm']/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/span" );


    private By ChildrenText = By.xpath( "//*[@id='frm']/div[1]/div[3]/div[2]/div/div/div[2]/div/div[2]/span" );
    String expectedChildren = "3";
    private By plusButtonChildren = By.xpath( "//div[contains(@class,'sb-group__field sb-group-children')]//span[@class='bui-button__text'][contains(text(),'+')]" );


    private By firstAgeDropDown = By.xpath( "//select[@name='age' and @aria-label='Child 1 age']" );
    private By secondAgeDropDown = By.xpath( "//select[@name='age' and @aria-label='Child 2 age']" );
    private By thirdAgeDropDown = By.xpath( "//select[@name='age' and @aria-label='Child 3 age']" );



    public void clickOnLanguageButton(){
        clickOn( languageButton );

    }


    public void selectCountry(){
        selectFromMenuList( allLanguage, "English (US)" );
    }


    public void WhereToGo(){
        autoComplete( destinationField, "Texas", suggestedCities, "Houston, Texas, United States of America" );
    }


    public void clickOnCalendar() {
        clickOn( calendar );

    }



    public void selectCheckInDate(){
        selectFromCalendar( monthName,"December 2019",arraySign,allDays );
    }

    public void selectCheckOutDate(){
        selectFromCalendar( monthName,"January 2020",arraySign,allDays1 );
    }
    public void clickOnAdultsChildrenRoomsButtonDropDownButton(){
        clickOn( dropDownButton );

    }

    public void selectAdultNumber(){

        while (true) {

            String text = SharedSD.getDriver().findElement(adultsText).getText();

            if (text.equals(expectedAdult))
            {
                break;

            }
            else
            {
                SharedSD.getDriver().findElement(plusButtonForAdult).click();

            }
        }
    }

    public void selectChildrenNumber(){

        while (true) {

            String text = SharedSD.getDriver().findElement(ChildrenText).getText();

            if (text.equals(expectedChildren))
            {
                break;

            }
            else
            {
                SharedSD.getDriver().findElement(plusButtonChildren).click();

            }
        }
    }



    public void selectFirstAge(){
        selectFromDropdown( firstAgeDropDown,6 );

    }
    public void selectSeconAge(){
        selectFromDropdown( secondAgeDropDown,4 );

    }
    public void selectThirdAge(){
        selectFromDropdown( thirdAgeDropDown,2 );

    }

}
