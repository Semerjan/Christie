package Pages;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class BrowserByPage2 {
    ////p[@class='grid-link__title']

    public List<WebElement> allProducts(){
        return Driver.getDriver().findElements(By.xpath("//p[@class='grid-link__title']"));
    }

    // getting the select dropdown
    public Select browseByOption(){
       WebElement selectElement = Driver.getDriver().findElement(By.id("BrowseBy"));
        return new Select(selectElement);

    }

    // getting all the options from the select dropDown
          public List<WebElement> browseByList(){
        Select selectOption = browseByOption();
        return selectOption.getOptions();
}

// now get the text of all select options and store it in a list


    public List<String > selectOptionText(){
        return browseByList().stream().map(WebElement::getText).collect(Collectors.toList());
    }









}
