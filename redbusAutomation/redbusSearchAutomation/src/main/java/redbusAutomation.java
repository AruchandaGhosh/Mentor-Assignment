

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class redbusAutomation extends baseUIclass {

    @Test
    public void busEnquiry()
    {

        //Launch browser and open url
        LaunchBrowser("Chrome");
        openURL("https://www.redbus.in/");
        waitForPageLoad();

        //accept alert
        clickLink("//button[@class='btn btn-primary']");
        waitForPageLoad();
        //	clickLink("//button[@class='btn btn-primary']");
        //Click on From
        List<WebElement> l=getElements("//span/input");
        sendData(l.get(0),"Bangalore");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        clickLink("//span[@class='db']");
        String str1=l.get(0).getAttribute("value");

        //click on TO
        sendData(l.get(1),"Hyderabad");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        clickLink("//li/span[contains(@class,'db')]");
        String str2=l.get(1).getAttribute("value");

        //Select Date
        clickLink("//*[@id='onward_cal']/span/input");
        String date=selectDate();


        //click on search buses button
        clickLink("//button[@id='search_btn']");
        waitForPageLoad();


        //Get Bus detail
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String str=getElementText("//*[@class='travels lh-24 f-bold d-color']/div/app-bus-list/div[4]/div/div[1]");
        String arr[]=str.split(" ");
        int numberOfAvailableBuses=Integer.parseInt(arr[0]);
        System.out.println("Num of Buses available : "+numberOfAvailableBuses);



        //List Of all available buses
        System.out.println("List Of Available Buses:-");
        for(int i=1;i<=numberOfAvailableBuses;i++)
        {

            System.out.println(getElemetText("//*[@class='travels lh-24 f-bold d-color']/div/app-bus-list/div[4]/div/div[5]/div["+i+"]/div[1]/app-bus-avl-enq/div[1]/div[1]/div[1]/strong"));
        }


        //validation with search credential
        String expectedTitle=source[0]+" "+destination[0]+" | "+date;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element=getElement("//*[@class='travels lh-24 f-bold d-color']/div/app-bus-list/div[4]/div/div[1]/span/strong");
        wait.until(ExpectedConditions.visibilityOf(element));
        String actualTitle=element.getText();

        Assert.assertEquals(actualTitle, expectedTitle);


        //Take ScrrenShot

        takeScreenShot();


        //Close Browser
        driver.close();

    }


}
