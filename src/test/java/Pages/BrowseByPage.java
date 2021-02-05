package Pages;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class BrowseByPage {


    // get all items return
    public List<WebElement> getAllItemsReturn() {
        //p[@class='grid-link__title']
        return Driver.getDriver().findElements(By.xpath("//p[@class='grid-link__title']"));
    }


    public Select getBrowseBySelect() {
        WebElement element = getDriver().findElement(By.id("BrowseBy"));
        return new Select( element);
    }

    // get all the options from the select dropdown
    public List<WebElement> getBrowseByOption() {
        Select browseByOption = getBrowseBySelect();
        return browseByOption.getOptions();
    }

    public List<String> getBrowseByOptionText() {
        return getBrowseByOption().stream().map(WebElement::getText).collect(Collectors.toList());
    }







    //private List<String> getBrowseByOptionText() {
    // return getBrowseByOption().stream().map(WebElement::getText).collect(Collectors.toList());
    // }



    public WebDriver getDriver() {
        return Driver.getDriver();
    }



}
