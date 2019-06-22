package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class DarkSkyHomePage extends BasePage {

    private By darkSkyApi=By.xpath( "//div[@class='inner']//a[contains(text(),'Dark Sky API')]" );
    private By signUpButton = By.xpath( "//a[@class='button filled']" );
    private By registerButton = By.xpath( "//button[contains(text(),'Register')]" );

    private By currentTemperature = By.xpath("//span[@class='currently']//span[@class='summary swap']");
    private By currentTemperatureFromDailyTimeline = By.xpath( "//div[@class='temps']//span[@class='first']/span" );

    private By todayField = By.xpath( "//span[contains(text(),'Today')]" );
    //private By todaysTimelineButton = By.xpath( "//a[@data-day][1]" );
    private By todaysTimelineButton = By.xpath( "//a[1]//span[2]//span[2]" );


    private By times = By.xpath( "//*[@id='timeline']/div/div[3]/span/span" );

    private By todaysLowestTemp=By.xpath( "//a[@class='day revealed'][@data-day='0']//span[@class='minTemp']" );
    private By todaysHighestTemp=By.xpath( "//a[@class='day revealed'][@data-day='0']//span[@class='maxTemp']" );
    private By lowestTemperatureTimeline=By.xpath( "//div[@class='dayDetails revealed']//div[@class='dayExtras']//span[@class='highTemp swip']//span[@class='temp']" );
    private By higestTempTimeline=By.xpath( "//div[@class='dayDetails revealed']//div[@class='dayExtras']//span[@class='lowTemp swap']//span[@class='temp']" );

    private By allTempFromTimeline = By.xpath("//div[@class='temps']//span/span");
    private By currentTempFromTimline = By.xpath("//span[@class='summary swap']");





    public void clickOnDarkSkyApi(){
        clickOn( darkSkyApi );
    }

    public void clickOnSignUpButton(){
        clickOn( signUpButton );
    }
    public void clickOnRegisterButton(){
        clickOn( registerButton );
    }

    public String getCurrentTemperature(){
        return getTextFromElement( currentTemperature ).substring( 0,3 );

    }

    public String getCurrentTemperatureFromDailyTimeline(){
        return getTextFromElement( currentTemperatureFromDailyTimeline );
    }

    public void clickOnTodaysTimeline() throws InterruptedException{
            JavascriptExecutor js = (JavascriptExecutor)SharedSD.getDriver();
            WebElement today = SharedSD.getDriver().findElement( todayField );
            js.executeScript( "arguments[0].scrollIntoView();",today);
            Thread.sleep( 4000 );
            clickOn( todaysTimelineButton );

    }

    public String getTodaysLowestTemp()
    {
        return getTextFromElement( todaysLowestTemp );
    }

    public String getTodaysHighestTemp(){
        return getTextFromElement( todaysHighestTemp );
    }
    public String getLowestTemperatureTimeline(){
        return getTextFromElement( lowestTemperatureTimeline );
    }
    public String getHigestTempTimeline(){
        return getTextFromElement( higestTempTimeline );
    }


    public void currentTempBetweenHighAndLow(){

            String currentTimelineTemp = SharedSD.getDriver().findElement(currentTempFromTimline).getText().substring(0,2);
            int currentTemperature = Integer.parseInt(currentTimelineTemp);


            List<WebElement> allTemperatureFromTimeline = SharedSD.getDriver().findElements(allTempFromTimeline);

            List<String> tempList = new ArrayList<String>();
            for (WebElement timelineTemp : allTemperatureFromTimeline) {

                tempList.add(timelineTemp.getText().substring(0,2));

            }
            Collections.sort(tempList);

            String highestTemprature = Collections.max(tempList);
            int higestTemp = Integer.parseInt(highestTemprature);

            String lowestTemprature = Collections.min(tempList);
            int lowestTemp = Integer.parseInt(lowestTemprature);

            boolean isvalid = true;
            if ( currentTemperature>higestTemp || currentTemperature < lowestTemp) {
                isvalid = false;
            }
            Assert.assertTrue(isvalid);
        }




    public List systemTimes(){
        List<String> listOfLocalHours = new ArrayList<>(  );
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat( "ha" );
        calendar.getTime();

        int incrementHours = 11;
        for (int i = 1; i < incrementHours; ) {
            calendar.add( Calendar.HOUR_OF_DAY, 2 );
            String expectedHours = sdf.format( calendar.getTime() ).toLowerCase();
            listOfLocalHours.add( expectedHours );
            i++;

            System.out.println( expectedHours );

        }
        return listOfLocalHours;
    }


    public List timelineTimes(){
        List<WebElement> timelist= SharedSD.getDriver().findElements(times);
        List<String>  listOfTimeLineHours= new ArrayList<>(  );
        int i;
        for (i=1; i<11; i++){
            String str = timelist.get(i).getText().toLowerCase();
            listOfTimeLineHours.add( str );
            System.out.println(str);
        }


      return listOfTimeLineHours;
    }


    }



