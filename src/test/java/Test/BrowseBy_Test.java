package Test;

import Pages.BrowseByPage;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BrowseBy_Test {

    @BeforeTest
    public void setUp() {
        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

    @Test
    public void Browser() {
        //Given user on the clearance projectors paBy_Testges
        String url = "https://christieclearanceprojectors.com/collections/clearance-projectors";
        BrowseByPage browseByPage = new BrowseByPage();
        Driver.getDriver().get(url);



        // listing all the options available under the Browser by option
        List<String> browseByOptionsText = browseByPage.getBrowseByOptionText();

        browseByOptionsText.remove("All");

        SoftAssert softAssert = new SoftAssert();

        for (String each : browseByOptionsText) {
            // When user select option [" + each + "] for browse by
            browseByPage.getBrowseBySelect().selectByVisibleText(each);

            //Then user should be able to see correct items returned.

            List<String> returnedItemsText = browseByPage.getAllItemsReturn().stream().map(WebElement::getText).collect(Collectors.toList());


            softAssert.assertTrue(returnedItemsText.stream().allMatch(eachItem -> eachItem.contains(each)));

        }
        softAssert.assertAll();
    }

    @AfterTest
    public void tearDown() {
        Driver.getDriver().close();
    }
}
