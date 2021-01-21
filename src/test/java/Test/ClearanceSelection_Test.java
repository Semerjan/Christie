package Test;

import Pages.Christie;
import Utilities.Driver;
import org.junit.After;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;

public class ClearanceSelection_Test {

    @BeforeTest
    public void setUp(){
        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }




    Christie christie;

    @Test
    public void checkUsedProjectors(){

        Driver.getDriver().get("https://christieclearanceprojectors.com/collections/clearance-projectors");
        christie = new Christie();
        christie.hoverOver(christie.clearanceProjectors);
        christie.usedProjectors.click();

        // Check all items name contains used to make sure we get the right items
        christie.getAllItemsReturn().stream().forEach(item ->{
            Assert.assertTrue(item.getText().contains("Used"));
        });

    }


    @Test
    public void checkUsedProjectors2(){

        Driver.getDriver().get("https://christieclearanceprojectors.com/collections/clearance-projectors");
        christie = new Christie();
        christie.hoverOver(christie.clearanceProjectors);

        //christie.usedProjectors.click();
        christie.refurnishedProjectors.click();
        christie.getAllItemsReturn().stream().forEach(item ->{
            System.out.println(item.getText());
            Assert.assertTrue(item.getText().contains("Refurbished"));
        });
    }

@AfterTest
    public void tearDown(){
        Driver.getDriver().close();
}

}