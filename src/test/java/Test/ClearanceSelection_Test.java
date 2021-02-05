package Test;

import Pages.Christie;
import Utilities.Driver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ClearanceSelection_Test {

    @BeforeTest
    public void setUp(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }




    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
    Christie christie;
    @Test
    public void checkUsedProjectors(){

        // getting the page
        Driver.getDriver().get("https://christieclearanceprojectors.com/collections/clearance-projectors");
        christie = new Christie();

        //christie.usedProjectors.click();
        Christie.hoverOver(christie.clearanceProjectors);
        christie.usedProjectors.click();

        // Check all items name contains used to make sure we get the right items
        Christie.getAllItemsReturn().stream().forEach(item ->{

            Assert.assertTrue(item.getText().contains("Used"));
        });

    }


    @Test
    public void checkUsedProjectors2(){

        Driver.getDriver().get("https://christieclearanceprojectors.com/collections/clearance-projectors");
        christie = new Christie();

        //christie.refurbished projectors click();
        christie.hoverOver(christie.clearanceProjectors);
        christie.refurnishedProjectors.click();
        christie.getAllItemsReturn().stream().forEach(item ->{
            System.out.println(item.getText());  // check the text to see the error
            Assert.assertTrue(item.getText().contains("Refurbished"));
        });
    }

    //@AfterTest
   //   public void tearDown(){
  //      Driver.getDriver().close();
  //     }
@Test

    public void lenses(){
        Driver.getDriver().get("https://christieclearanceprojectors.com/collections/clearance-projectors");
        christie = new Christie();
        christie.mouseHover(christie.clearanceProjectors);
        christie.lenses.click();

        christie.getAllItemsReturn().stream().forEach(item ->{
            System.out.println(item.getText());
            Assert.assertTrue(item.getText().toUpperCase().contains("lens"));
        });
    }


    @Test
    public void PaginationTest() throws InterruptedException {


            Driver.getDriver().get("https://christieclearanceprojectors.com/collections/clearance-projectors");
            christie = new Christie();
            christie.mouseHover(christie.clearanceProjectors);
            christie.usedProjectors.click();

        // scroll down so that we can see the arrow
        js.executeScript("window.scrollBy(0,1500)");

        Thread.sleep(3000);
        // creating a new list to store all the elements
        List<WebElement> allNames =christie.getAllItemsReturn().stream().collect(Collectors.toList());

        // finding the next arrow button is clickable
        String nextPage = christie.nextPageArrow.getAttribute("class");
        while(!nextPage.contains("disabled")) {
            christie.nextPageArrow.click();
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);

            js.executeScript("window.scrollBy(0,1500)");
            allNames = christie.getAllItemsReturn().stream().collect(Collectors.toList());
            continue;
        }


            // storing the next page items

//            allNames=christie.getAllItemsReturn().stream().collect(Collectors.toList());
            allNames=christie.getAllItemsReturn().stream().collect(Collectors.toList());





        // printing out all the object sin new list
        allNames.forEach(s-> System.out.println(s.getText()));



    }

}