package Test;

import Pages.SortByPage;
import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SortBy_Test {
    @BeforeTest
    public void setUp(){
        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

    @Test
    public void test02_validate_sortBy() {

      //"Given user on the clearance projectors pages.
        String url = "https://christieclearanceprojectors.com/collections/clearance-projectors";
        SortByPage sortByPage = new SortByPage();
        Driver.getDriver().get(url);


        List<String> sortByOptionsText = sortByPage.getSortByOptionText();

        for (String each : sortByOptionsText) {

           //When user select option [" + each + "] for sort by.

            sortByPage.getSortBySelect().selectByVisibleText(each);

            //"Then user should be able to see correct items returned.");
            if (each.contains("A-Z")) {

                List<String> expectedSortedList = null;
                List<String> sortedByInterfaceList = null;

                sortedByInterfaceList = sortByPage.getAllItemsTitles().stream().map(WebElement::getText).collect(Collectors.toList());
                expectedSortedList = new ArrayList<>(sortedByInterfaceList);
                Collections.sort(expectedSortedList);
                Assert.assertEquals( expectedSortedList, sortedByInterfaceList);

            }

            if (each.contains("Z-A")) {

                List<String> expectedSortedList = null;
                List<String> sortedByInterfaceList = null;

                sortedByInterfaceList = sortByPage.getAllItemsTitles().stream().map(WebElement::getText).collect(Collectors.toList());
                expectedSortedList = new ArrayList<>(sortedByInterfaceList);
                Collections.sort(expectedSortedList, Collections.reverseOrder());
                Assert.assertEquals( expectedSortedList, sortedByInterfaceList);

            }

            if (each.contains("high to low")) {

                List<String> expectedSortedList = null;
                List<String> sortedByInterfaceList = null;

                sortedByInterfaceList = sortByPage.getAllItemsPricesTexts();
                expectedSortedList = new ArrayList<>(sortedByInterfaceList);
                Collections.sort(expectedSortedList, sortByPage.NumberComparatorAsc);
                Assert.assertEquals( expectedSortedList, sortedByInterfaceList);

            }

            if (each.contains("low to high")) {

                List<String> expectedSortedList = null;
                List<String> sortedByInterfaceList = null;

                sortedByInterfaceList = sortByPage.getAllItemsPricesTexts();
                expectedSortedList = new ArrayList<>(sortedByInterfaceList);
                Collections.sort(expectedSortedList, sortByPage.NumberComparatorDsc);
                Assert.assertEquals( expectedSortedList, sortedByInterfaceList);

            }


        }
    }

    @AfterTest
    public void tearDown(){
        Driver.getDriver().close();
    }
}