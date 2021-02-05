package Test.christie;

import Pages.BrowseByPage;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Links_test {
    @Test
    public void setUp() {
        Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();


        String url = "https://christieclearanceprojectors.com/collections/clearance-projectors";
        BrowseByPage browseByPage = new BrowseByPage();
        Driver.getDriver().get(url);

        JavascriptExecutor js  = (JavascriptExecutor)Driver.getDriver();
      //js.executeScript("window.scrollBy(0,1000)");
       js.executeScript("window.scrollBy(0,1000)");

       //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
     //  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));


        //  List <WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
       // allLinks.stream().forEach(System.out::println);

        allLinks.stream().map(WebElement::getText).forEach(s-> System.out.println("Webelemet = " + s));

       // for (WebElement each : allLinks) {
         //   System.out.println(each.getText() + each.getAttribute("href"));


    }
}


